package com.nazarii.shostachuk.tkhelper.data.portscanner;

import android.content.Context;
import android.text.TextUtils;

import com.nazarii.shostachuk.tkhelper.apirx.PortScanRxApi;
import com.nazarii.shostachuk.tkhelper.data.base.BasePresenter;
import com.nazarii.shostachuk.tkhelper.data.portscanner.PortScannerContract.Presenter;
import com.nazarii.shostachuk.tkhelper.data.portscanner.PortScannerContract.View;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;
import com.nazarii.shostachuk.tkhelper.networktools.PortScan;
import com.nazarii.shostachuk.tkhelper.utils.TKUtils;

import java.util.ArrayList;
import java.util.Collection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PortScannerPresenter extends BasePresenter<View> implements Presenter, PortScan.PortListener {
    private Context context;
    private CompositeDisposable compositeDisposable;

    public PortScannerPresenter(View view, Context context) {
        super(view);
        this.context = context;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void doScan(String address) {
        view.showLoading(true);
        compositeDisposable.add(PortScanRxApi.getInstance().doScan(address, this)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(this::onSuccess, this::onError, this::onComplete));
    }

    private void onComplete() {
        view.showLoading(false);
    }

    private void onError(Throwable throwable) {
        onUnknownHost(throwable);
    }

    private void onUnknownHost(Throwable e) {
        ArrayList<SimpleItem> simpleItems = new ArrayList<>();
        simpleItems.add(new SimpleItem(e.getMessage(), "", ""));

        view.setPortScanResults(simpleItems);
        view.showLoading(false);
    }

    private void onSuccess(PortHolder portHolder) {
        ArrayList<SimpleItem> simpleItems = new ArrayList<>();
        simpleItems.add(generateTitle(portHolder));

        simpleItems.addAll(generateItems(portHolder));

        view.setPortScanResults(simpleItems);
    }

    private Collection<? extends SimpleItem> generateItems(PortHolder portHolder) {
        ArrayList<SimpleItem> simpleItems = new ArrayList<>();
        for (int i : portHolder.getOpenPorts()) {
            simpleItems.add(new SimpleItem(i + " port is open", "", ""));
        }
        return simpleItems;
    }

    private SimpleItem generateTitle(PortHolder portHolder) {
        SimpleItem title = new SimpleItem();
        try {
            if (portHolder.getInetAddress().getHostName() != null && !TextUtils.isEmpty(portHolder.getInetAddress().getHostName())) {
                title.setTitle("Scanning: " + portHolder.getInetAddress().getHostName());
                title.setDescription(portHolder.getInetAddress().getHostAddress());
            }
        } catch (Throwable throwable) {
            TKUtils.log(throwable.getMessage());
            title.setTitle(throwable.getMessage());
        }

        return title;
    }


    @Override
    public void onResult(int portNo, boolean open) {
        view.setPortScanDevice(new SimpleItem(portNo + " port is open", "", ""));
    }

    @Override
    public void onFinished(ArrayList<Integer> openPorts) {

    }
}
