
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutputAction {

    @SerializedName("output-node-connector")
    @Expose
    private String outputNodeConnector;
    @SerializedName("max-length")
    @Expose
    private Integer maxLength;

    public String getOutputNodeConnector() {
        return outputNodeConnector;
    }

    public void setOutputNodeConnector(String outputNodeConnector) {
        this.outputNodeConnector = outputNodeConnector;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

}
