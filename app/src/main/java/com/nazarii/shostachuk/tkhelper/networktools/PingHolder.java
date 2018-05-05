package com.nazarii.shostachuk.tkhelper.networktools;

import com.nazarii.shostachuk.tkhelper.networktools.ping.PingResult;
import com.nazarii.shostachuk.tkhelper.networktools.ping.PingStats;

import java.util.ArrayList;

public class PingHolder {
    private ArrayList<PingResult> pingResults;
    private PingStats pingStats;

    public PingHolder(ArrayList<PingResult> pingResults, PingStats pingStats) {
        this.pingResults = pingResults;
        this.pingStats = pingStats;
    }

    public PingHolder() {
    }

    public ArrayList<PingResult> getPingResults() {
        return pingResults;
    }

    public void setPingResults(ArrayList<PingResult> pingResults) {
        this.pingResults = pingResults;
    }

    public PingStats getPingStats() {
        return pingStats;
    }

    public void setPingStats(PingStats pingStats) {
        this.pingStats = pingStats;
    }
}
