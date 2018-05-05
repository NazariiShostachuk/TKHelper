package com.nazarii.shostachuk.tkhelper.data.pingtool;

import android.content.Context;

import com.nazarii.shostachuk.tkhelper.apirx.PingToolRxApi;
import com.nazarii.shostachuk.tkhelper.data.base.BasePresenter;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;
import com.nazarii.shostachuk.tkhelper.networktools.PingHolder;
import com.nazarii.shostachuk.tkhelper.networktools.ping.PingResult;

import java.math.BigDecimal;
import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PingToolPresenter extends BasePresenter<PingToolContract.View> implements PingToolContract.Presenter {
    private CompositeDisposable compositeDisposable;
    private Context context;

    public PingToolPresenter(PingToolContract.View view, Context context) {
        super(view);
        this.compositeDisposable = new CompositeDisposable();
        this.context = context;
    }

    @Override
    public void doPing(String address, int times) {
        view.showLoading(true);

        compositeDisposable.add(PingToolRxApi.getInstance().doPingWithParams(address, times)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(this::onSuccess, this::onUnknownHost, this::onComplete));

    }

    private void onComplete() {
        view.showLoading(false);
    }

    private void onUnknownHost(Throwable e) {
        ArrayList<SimpleItem> simpleItems = new ArrayList<>();
        simpleItems.add(new SimpleItem(e.getMessage(), "", ""));

        view.setPingResults(simpleItems);
        view.showLoading(false);
    }

    private void onSuccess(PingHolder pingHolder) {
        ArrayList<SimpleItem> simpleItems = new ArrayList<>();
        int packetsReceived = 0;
        SimpleItem title = new SimpleItem();
        try {
            title.setTitle("Ping: " + pingHolder.getPingStats().getIa().getHostName());
            title.setDescription(pingHolder.getPingStats().getAddress().getHostAddress());
        } catch (Throwable throwable) {
            title.setTitle("Ping: " + pingHolder.getPingStats().getIa().getHostAddress());
        }


        simpleItems.add(title);


        ArrayList<PingResult> pingResults = pingHolder.getPingResults();
        for (int i = 0; i < pingResults.size(); i++) {
            PingResult pingResult = pingResults.get(i);
            if (pingResult.isReachable) packetsReceived++;
            SimpleItem item = new SimpleItem();
            item.setTitle(pingResult.isReachable ? "Answer from: " + pingHolder.getPingStats().getAddress().getHostAddress() : "No answer from: " + pingHolder.getPingStats().getAddress().getHostAddress());
            item.setDescription(pingResult.isReachable ? "Number " + i + ", successful connection" : "Number " + i + ", failed connection");
            item.setRightText(String.valueOf(BigDecimal.valueOf(pingResult.timeTaken).toBigInteger()) + " ms");
            simpleItems.add(item);
        }


        SimpleItem stats = new SimpleItem();
        stats.setTitle("Statistics:");
        stats.setDescription(String.valueOf(pingHolder.getPingStats().getNoPings()) + " shared, " +
                String.valueOf(packetsReceived) + " received," +
                " lost " + pingHolder.getPingStats().getPacketsLost());
        simpleItems.add(stats);

        SimpleItem times = new SimpleItem();
        times.setTitle("Time:");
        if (!BigDecimal.valueOf(pingHolder.getPingStats().getMinTimeTaken()).toBigInteger().equals(BigDecimal.valueOf(-1))) {
            times.setDescription("Min " + String.valueOf(BigDecimal.valueOf(pingHolder.getPingStats().getMinTimeTaken()).toBigInteger() + "  ")
                    + "max " + String.valueOf(BigDecimal.valueOf(pingHolder.getPingStats().getMaxTimeTaken()).toBigInteger()));

            simpleItems.add(times);
        }
        view.setPingResults(simpleItems);
    }

}
