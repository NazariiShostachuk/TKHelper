
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EthernetMatch {

    @SerializedName("ethernet-type")
    @Expose
    private EthernetType ethernetType;

    public EthernetType getEthernetType() {
        return ethernetType;
    }

    public void setEthernetType(EthernetType ethernetType) {
        this.ethernetType = ethernetType;
    }

}
