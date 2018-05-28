
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpendaylightPortStatisticsFlowCapableNodeConnectorStatistics {

    @SerializedName("duration")
    @Expose
    private Duration duration;
    @SerializedName("receive-crc-error")
    @Expose
    private Integer receiveCrcError;
    @SerializedName("packets")
    @Expose
    private Packets packets;
    @SerializedName("transmit-drops")
    @Expose
    private Integer transmitDrops;
    @SerializedName("receive-frame-error")
    @Expose
    private Integer receiveFrameError;
    @SerializedName("transmit-errors")
    @Expose
    private Integer transmitErrors;
    @SerializedName("receive-errors")
    @Expose
    private Integer receiveErrors;
    @SerializedName("receive-drops")
    @Expose
    private Integer receiveDrops;
    @SerializedName("receive-over-run-error")
    @Expose
    private Integer receiveOverRunError;
    @SerializedName("bytes")
    @Expose
    private Bytes bytes;
    @SerializedName("collision-count")
    @Expose
    private Integer collisionCount;

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getReceiveCrcError() {
        return receiveCrcError;
    }

    public void setReceiveCrcError(Integer receiveCrcError) {
        this.receiveCrcError = receiveCrcError;
    }

    public Packets getPackets() {
        return packets;
    }

    public void setPackets(Packets packets) {
        this.packets = packets;
    }

    public Integer getTransmitDrops() {
        return transmitDrops;
    }

    public void setTransmitDrops(Integer transmitDrops) {
        this.transmitDrops = transmitDrops;
    }

    public Integer getReceiveFrameError() {
        return receiveFrameError;
    }

    public void setReceiveFrameError(Integer receiveFrameError) {
        this.receiveFrameError = receiveFrameError;
    }

    public Integer getTransmitErrors() {
        return transmitErrors;
    }

    public void setTransmitErrors(Integer transmitErrors) {
        this.transmitErrors = transmitErrors;
    }

    public Integer getReceiveErrors() {
        return receiveErrors;
    }

    public void setReceiveErrors(Integer receiveErrors) {
        this.receiveErrors = receiveErrors;
    }

    public Integer getReceiveDrops() {
        return receiveDrops;
    }

    public void setReceiveDrops(Integer receiveDrops) {
        this.receiveDrops = receiveDrops;
    }

    public Integer getReceiveOverRunError() {
        return receiveOverRunError;
    }

    public void setReceiveOverRunError(Integer receiveOverRunError) {
        this.receiveOverRunError = receiveOverRunError;
    }

    public Bytes getBytes() {
        return bytes;
    }

    public void setBytes(Bytes bytes) {
        this.bytes = bytes;
    }

    public Integer getCollisionCount() {
        return collisionCount;
    }

    public void setCollisionCount(Integer collisionCount) {
        this.collisionCount = collisionCount;
    }

}
