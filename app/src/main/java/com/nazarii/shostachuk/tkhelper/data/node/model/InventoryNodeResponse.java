
package com.nazarii.shostachuk.tkhelper.data.node.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nazarii.shostachuk.tkhelper.data.base.BaseResponse;

public class InventoryNodeResponse extends BaseResponse {

    @SerializedName("node")
    @Expose
    private List<Node> node = null;

    public List<Node> getNode() {
        return node;
    }

    public void setNode(List<Node> node) {
        this.node = node;
    }

}
