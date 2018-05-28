
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("in-port")
    @Expose
    private String inPort;
    @SerializedName("ethernet-match")
    @Expose
    private EthernetMatch ethernetMatch;

    public String getInPort() {
        return inPort;
    }

    public void setInPort(String inPort) {
        this.inPort = inPort;
    }

    public EthernetMatch getEthernetMatch() {
        return ethernetMatch;
    }

    public void setEthernetMatch(EthernetMatch ethernetMatch) {
        this.ethernetMatch = ethernetMatch;
    }

}
