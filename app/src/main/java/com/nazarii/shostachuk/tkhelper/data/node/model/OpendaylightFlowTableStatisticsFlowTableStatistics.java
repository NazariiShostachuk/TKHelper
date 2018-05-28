
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpendaylightFlowTableStatisticsFlowTableStatistics {

    @SerializedName("packets-looked-up")
    @Expose
    private Integer packetsLookedUp;
    @SerializedName("active-flows")
    @Expose
    private Integer activeFlows;
    @SerializedName("packets-matched")
    @Expose
    private Integer packetsMatched;

    public Integer getPacketsLookedUp() {
        return packetsLookedUp;
    }

    public void setPacketsLookedUp(Integer packetsLookedUp) {
        this.packetsLookedUp = packetsLookedUp;
    }

    public Integer getActiveFlows() {
        return activeFlows;
    }

    public void setActiveFlows(Integer activeFlows) {
        this.activeFlows = activeFlows;
    }

    public Integer getPacketsMatched() {
        return packetsMatched;
    }

    public void setPacketsMatched(Integer packetsMatched) {
        this.packetsMatched = packetsMatched;
    }

}
