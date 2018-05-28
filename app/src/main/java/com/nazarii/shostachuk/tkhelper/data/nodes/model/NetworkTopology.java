package com.nazarii.shostachuk.tkhelper.data.nodes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NetworkTopology {

    @SerializedName("topology")
    @Expose
    private List<Topology> topology = null;

    public List<Topology> getTopology() {
        return topology;
    }

    public void setTopology(List<Topology> topology) {
        this.topology = topology;
    }

}
