package com.nazarii.shostachuk.tkhelper.data.nodes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nazarii.shostachuk.tkhelper.data.base.BaseResponse;

public class NetworkTopologyResponse extends BaseResponse {

    @SerializedName("network-topology")
    @Expose
    private NetworkTopology networkTopology;

    public NetworkTopology getNetworkTopology() {
        return networkTopology;
    }

    public void setNetworkTopology(NetworkTopology networkTopology) {
        this.networkTopology = networkTopology;
    }

}
