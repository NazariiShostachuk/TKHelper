package com.nazarii.shostachuk.tkhelper.data.main;

import android.net.wifi.WifiManager;

public interface MainActivityPresenter {
    void getWifiInfo(WifiManager wifiManager);

    void getWifiSignal();

    void getDhcpInfo(WifiManager wifiManager);

    void getConnectedDevices();
}
