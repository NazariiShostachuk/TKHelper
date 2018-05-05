package com.nazarii.shostachuk.tkhelper.apirx;

import com.nazarii.shostachuk.tkhelper.networktools.Ping;
import com.nazarii.shostachuk.tkhelper.networktools.PingHolder;

import java.net.InetAddress;
import java.net.UnknownHostException;

import io.reactivex.Observable;

public class PingToolRxApi {
    public static PingToolRxApi getInstance() {
        return new PingToolRxApi();
    }

    public Observable<PingHolder> doPingWithParams(String address, int times) {

        return Observable.fromCallable(() -> PingToolRxApi.this.doPing(address, times));
    }


    private PingHolder doPing(String address, int times) throws UnknownHostException {
        PingHolder pingHolder;

        pingHolder = Ping.onAddress(InetAddress.getByName(address)).setTimes(times).doPingWithTimes();

        return pingHolder;
    }

}
