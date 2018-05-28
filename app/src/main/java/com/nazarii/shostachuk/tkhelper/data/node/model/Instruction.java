
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Instruction {

    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("apply-actions")
    @Expose
    private ApplyActions applyActions;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public ApplyActions getApplyActions() {
        return applyActions;
    }

    public void setApplyActions(ApplyActions applyActions) {
        this.applyActions = applyActions;
    }

}
