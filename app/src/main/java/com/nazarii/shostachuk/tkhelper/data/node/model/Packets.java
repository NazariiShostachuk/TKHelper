
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Packets {

    @SerializedName("transmitted")
    @Expose
    private Integer transmitted;
    @SerializedName("received")
    @Expose
    private Integer received;

    public Integer getTransmitted() {
        return transmitted;
    }

    public void setTransmitted(Integer transmitted) {
        this.transmitted = transmitted;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

}
