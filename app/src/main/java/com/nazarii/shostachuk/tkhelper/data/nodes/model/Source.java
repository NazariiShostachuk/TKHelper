
package com.nazarii.shostachuk.tkhelper.data.nodes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("source-node")
    @Expose
    private String sourceNode;
    @SerializedName("source-tp")
    @Expose
    private String sourceTp;

    public String getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(String sourceNode) {
        this.sourceNode = sourceNode;
    }

    public String getSourceTp() {
        return sourceTp;
    }

    public void setSourceTp(String sourceTp) {
        this.sourceTp = sourceTp;
    }

}
