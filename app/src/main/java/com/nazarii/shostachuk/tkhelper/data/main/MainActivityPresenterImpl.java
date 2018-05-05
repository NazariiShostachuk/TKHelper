package com.nazarii.shostachuk.tkhelper.data.main;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import com.github.pwittchen.reactivewifi.ReactiveWifi;
import com.nazarii.shostachuk.tkhelper.networktools.SubnetDevices;
import com.nazarii.shostachuk.tkhelper.networktools.subnet.Device;
import com.nazarii.shostachuk.tkhelper.utils.TKUtils;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private Context context;
    private MainView view;

    public MainActivityPresenterImpl(Context context, MainView view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getWifiInfo(WifiManager wifiManager) {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        view.setSSID(wifiInfo.getSSID());
        view.setFrequency(wifiInfo.getFrequency());
        view.setMacAddress(getMacAddress());
        view.setLinkSpeed(wifiInfo.getLinkSpeed());
        TKUtils.log(wifiInfo.toString());
    }

    private String getMacAddress() {
        try {
            // get all the interfaces
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            //find network interface wlan0
            for (NetworkInterface networkInterface : all) {
                if (!networkInterface.getName().equalsIgnoreCase("wlan0")) continue;
                //get the hardware address (MAC) of the interface
                byte[] macBytes = networkInterface.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }


                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    //gets the last byte of b
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public void getWifiSignal() {
        Disposable disposable = ReactiveWifi.observeWifiSignalLevel(context, 5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess);
    }

    @Override
    public void getDhcpInfo(WifiManager wifiManager) {
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        view.setDns1(Formatter.formatIpAddress(dhcpInfo.dns1));
        view.setDns2(String.valueOf(dhcpInfo.dns2));
        view.setGeteway(String.valueOf(Formatter.formatIpAddress(dhcpInfo.gateway)));
        view.setIpAddress(String.valueOf(Formatter.formatIpAddress(dhcpInfo.ipAddress)));
        view.setLeaseDuration(String.valueOf(dhcpInfo.leaseDuration));
        view.setNetMask(Formatter.formatIpAddress(dhcpInfo.netmask));
        view.setServerAddress(Formatter.formatIpAddress(dhcpInfo.serverAddress));
    }

    @Override
    public void getConnectedDevices() {
        SubnetDevices.fromLocalAddress().findDevices(new SubnetDevices.OnSubnetDeviceFound() {
            @Override
            public void onDeviceFound(Device device) {
            }

            @Override
            public void onFinished(ArrayList<Device> devicesFound) {
                view.setConnectedDevices(devicesFound);
                TKUtils.log(devicesFound.toString());
            }
        });
    }

    private void onSuccess(Integer level) {

    }
}
