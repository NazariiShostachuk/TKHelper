package com.nazarii.shostachuk.tkhelper.data.portscanner;

import java.net.InetAddress;
import java.util.ArrayList;

public class PortHolder {
    private ArrayList<Integer> openPorts;
    private InetAddress inetAddress;
    private int portsScanned;
    private String timeInMs;


    public PortHolder() {
    }

    public String getTimeInMs() {
        return timeInMs;
    }

    public void setTimeInMs(String timeInMs) {
        this.timeInMs = timeInMs;
    }

    public ArrayList<Integer> getOpenPorts() {
        return openPorts;
    }

    public void setOpenPorts(ArrayList<Integer> openPorts) {
        this.openPorts = openPorts;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public int getPortsScanned() {
        return portsScanned;
    }

    public void setPortsScanned(int portsScanned) {
        this.portsScanned = portsScanned;
    }
}
