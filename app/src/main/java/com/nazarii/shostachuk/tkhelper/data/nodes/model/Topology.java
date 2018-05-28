package com.nazarii.shostachuk.tkhelper.data.nodes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Topology {

    @SerializedName("topology-id")
    @Expose
    private String topologyId;
    @SerializedName("link")
    @Expose
    private List<Link> link = null;
    @SerializedName("node")
    @Expose
    private List<Node> node = null;

    public String getTopologyId() {
        return topologyId;
    }

    public void setTopologyId(String topologyId) {
        this.topologyId = topologyId;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public List<Node> getNode() {
        return node;
    }

    public void setNode(List<Node> node) {
        this.node = node;
    }

}
