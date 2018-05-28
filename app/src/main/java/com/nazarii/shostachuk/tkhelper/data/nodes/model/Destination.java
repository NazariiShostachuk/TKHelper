package com.nazarii.shostachuk.tkhelper.data.nodes.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Destination {

    @SerializedName("dest-tp")
    @Expose
    private String destTp;
    @SerializedName("dest-node")
    @Expose
    private String destNode;

    public String getDestTp() {
        return destTp;
    }

    public void setDestTp(String destTp) {
        this.destTp = destTp;
    }

    public String getDestNode() {
        return destNode;
    }

    public void setDestNode(String destNode) {
        this.destNode = destNode;
    }

}
