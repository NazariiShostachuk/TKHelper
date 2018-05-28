
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpendaylightFlowStatisticsAggregateFlowStatistics {

    @SerializedName("flow-count")
    @Expose
    private Integer flowCount;
    @SerializedName("byte-count")
    @Expose
    private Integer byteCount;
    @SerializedName("packet-count")
    @Expose
    private Integer packetCount;

    public Integer getFlowCount() {
        return flowCount;
    }

    public void setFlowCount(Integer flowCount) {
        this.flowCount = flowCount;
    }

    public Integer getByteCount() {
        return byteCount;
    }

    public void setByteCount(Integer byteCount) {
        this.byteCount = byteCount;
    }

    public Integer getPacketCount() {
        return packetCount;
    }

    public void setPacketCount(Integer packetCount) {
        this.packetCount = packetCount;
    }

}
