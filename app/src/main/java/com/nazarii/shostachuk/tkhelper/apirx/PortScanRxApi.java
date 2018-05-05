package com.nazarii.shostachuk.tkhelper.apirx;

import android.text.TextUtils;

import com.nazarii.shostachuk.tkhelper.data.portscanner.PortHolder;
import com.nazarii.shostachuk.tkhelper.networktools.PortScan;
import com.nazarii.shostachuk.tkhelper.utils.TKUtils;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

import io.reactivex.Observable;


public class PortScanRxApi {

    public static PortScanRxApi getInstance() {
        return new PortScanRxApi();
    }

    public Observable<PortHolder> doScan(String address) {
        return Observable.fromCallable((Callable) () -> doScanApi(address));
    }

    private PortHolder doScanApi(String address) throws UnknownHostException {
        final long startTimeMillis = System.currentTimeMillis();
        PortHolder portHolder = new PortHolder();
        InetAddress inetAddress = InetAddress.getByName(address);

        if (TextUtils.isEmpty(address)) {
            TKUtils.log("Invalid Ip Address");
            return null;
        }

        // Perform synchronous port scan
        TKUtils.log("PortScanning IP: " + inetAddress);
        portHolder.setInetAddress(inetAddress);

        portHolder.setOpenPorts(PortScan.onAddress(inetAddress).setPortsPrivileged().doScan());
        portHolder.setTimeInMs(String.valueOf(BigDecimal.valueOf(System.currentTimeMillis() - startTimeMillis / 1000.0f).toBigInteger()));

        return portHolder;
    }
}
