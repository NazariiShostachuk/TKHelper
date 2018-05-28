
package com.nazarii.shostachuk.tkhelper.data.nodes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TerminationPoint {

    @SerializedName("tp-id")
    @Expose
    private String tpId;
    @SerializedName("opendaylight-topology-inventory:inventory-node-connector-ref")
    @Expose
    private String opendaylightTopologyInventoryInventoryNodeConnectorRef;

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    public String getOpendaylightTopologyInventoryInventoryNodeConnectorRef() {
        return opendaylightTopologyInventoryInventoryNodeConnectorRef;
    }

    public void setOpendaylightTopologyInventoryInventoryNodeConnectorRef(String opendaylightTopologyInventoryInventoryNodeConnectorRef) {
        this.opendaylightTopologyInventoryInventoryNodeConnectorRef = opendaylightTopologyInventoryInventoryNodeConnectorRef;
    }

}
