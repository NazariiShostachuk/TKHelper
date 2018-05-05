package com.nazarii.shostachuk.tkhelper.data.main;

import com.nazarii.shostachuk.tkhelper.networktools.subnet.Device;

import java.util.ArrayList;

public interface MainView {
    void setSSID(String ssid);

    void setFrequency(int frequency);

    void setMacAddress(String macAddress);

    void setLinkSpeed(int linkSpeed);

    void setWifiSignal(int signal_icon_uri);

    void setDns1(String dns1);

    void setDns2(String dns2);

    void setGeteway(String geteway);

    void setIpAddress(String ipAddress);

    void setLeaseDuration(String leaseDuration);

    void setNetMask(String netMask);

    void setServerAddress(String serverAddress);

    void setConnectedDevice(Device connectedDevice);

    void setConnectedDevices(ArrayList<Device> devices);
}
