
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Action {

    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("output-action")
    @Expose
    private OutputAction outputAction;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public OutputAction getOutputAction() {
        return outputAction;
    }

    public void setOutputAction(OutputAction outputAction) {
        this.outputAction = outputAction;
    }

}
