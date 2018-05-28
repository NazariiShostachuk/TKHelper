
package com.nazarii.shostachuk.tkhelper.data.nodes.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Node {

    @SerializedName("node-id")
    @Expose
    private String nodeId;
    @SerializedName("termination-point")
    @Expose
    private List<TerminationPoint> terminationPoint = null;
    @SerializedName("opendaylight-topology-inventory:inventory-node-ref")
    @Expose
    private String opendaylightTopologyInventoryInventoryNodeRef;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<TerminationPoint> getTerminationPoint() {
        return terminationPoint;
    }

    public void setTerminationPoint(List<TerminationPoint> terminationPoint) {
        this.terminationPoint = terminationPoint;
    }

    public String getOpendaylightTopologyInventoryInventoryNodeRef() {
        return opendaylightTopologyInventoryInventoryNodeRef;
    }

    public void setOpendaylightTopologyInventoryInventoryNodeRef(String opendaylightTopologyInventoryInventoryNodeRef) {
        this.opendaylightTopologyInventoryInventoryNodeRef = opendaylightTopologyInventoryInventoryNodeRef;
    }

}
