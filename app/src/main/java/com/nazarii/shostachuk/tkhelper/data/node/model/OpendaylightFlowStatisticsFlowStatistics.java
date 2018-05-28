
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpendaylightFlowStatisticsFlowStatistics {

    @SerializedName("duration")
    @Expose
    private Duration_ duration;
    @SerializedName("byte-count")
    @Expose
    private Integer byteCount;
    @SerializedName("packet-count")
    @Expose
    private Integer packetCount;

    public Duration_ getDuration() {
        return duration;
    }

    public void setDuration(Duration_ duration) {
        this.duration = duration;
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
