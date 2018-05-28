
package com.nazarii.shostachuk.tkhelper.data.node.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplyActions {

    @SerializedName("action")
    @Expose
    private List<Action> action = null;

    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }

}
