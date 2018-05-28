
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlowNodeInventoryState {

    @SerializedName("live")
    @Expose
    private Boolean live;
    @SerializedName("blocked")
    @Expose
    private Boolean blocked;
    @SerializedName("link-down")
    @Expose
    private Boolean linkDown;

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getLinkDown() {
        return linkDown;
    }

    public void setLinkDown(Boolean linkDown) {
        this.linkDown = linkDown;
    }

}
