
package com.nazarii.shostachuk.tkhelper.data.node.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Node {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("node-connector")
    @Expose
    private List<NodeConnector> nodeConnector = null;
    @SerializedName("flow-node-inventory:switch-features")
    @Expose
    private FlowNodeInventorySwitchFeatures flowNodeInventorySwitchFeatures;
    @SerializedName("flow-node-inventory:description")
    @Expose
    private String flowNodeInventoryDescription;
    @SerializedName("flow-node-inventory:manufacturer")
    @Expose
    private String flowNodeInventoryManufacturer;
    @SerializedName("flow-node-inventory:hardware")
    @Expose
    private String flowNodeInventoryHardware;
    @SerializedName("flow-node-inventory:table")
    @Expose
    private List<FlowNodeInventoryTable> flowNodeInventoryTable = null;
    @SerializedName("flow-node-inventory:serial-number")
    @Expose
    private String flowNodeInventorySerialNumber;
    @SerializedName("flow-node-inventory:software")
    @Expose
    private String flowNodeInventorySoftware;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<NodeConnector> getNodeConnector() {
        return nodeConnector;
    }

    public void setNodeConnector(List<NodeConnector> nodeConnector) {
        this.nodeConnector = nodeConnector;
    }

    public FlowNodeInventorySwitchFeatures getFlowNodeInventorySwitchFeatures() {
        return flowNodeInventorySwitchFeatures;
    }

    public void setFlowNodeInventorySwitchFeatures(FlowNodeInventorySwitchFeatures flowNodeInventorySwitchFeatures) {
        this.flowNodeInventorySwitchFeatures = flowNodeInventorySwitchFeatures;
    }

    public String getFlowNodeInventoryDescription() {
        return flowNodeInventoryDescription;
    }

    public void setFlowNodeInventoryDescription(String flowNodeInventoryDescription) {
        this.flowNodeInventoryDescription = flowNodeInventoryDescription;
    }

    public String getFlowNodeInventoryManufacturer() {
        return flowNodeInventoryManufacturer;
    }

    public void setFlowNodeInventoryManufacturer(String flowNodeInventoryManufacturer) {
        this.flowNodeInventoryManufacturer = flowNodeInventoryManufacturer;
    }

    public String getFlowNodeInventoryHardware() {
        return flowNodeInventoryHardware;
    }

    public void setFlowNodeInventoryHardware(String flowNodeInventoryHardware) {
        this.flowNodeInventoryHardware = flowNodeInventoryHardware;
    }

    public List<FlowNodeInventoryTable> getFlowNodeInventoryTable() {
        return flowNodeInventoryTable;
    }

    public void setFlowNodeInventoryTable(List<FlowNodeInventoryTable> flowNodeInventoryTable) {
        this.flowNodeInventoryTable = flowNodeInventoryTable;
    }

    public String getFlowNodeInventorySerialNumber() {
        return flowNodeInventorySerialNumber;
    }

    public void setFlowNodeInventorySerialNumber(String flowNodeInventorySerialNumber) {
        this.flowNodeInventorySerialNumber = flowNodeInventorySerialNumber;
    }

    public String getFlowNodeInventorySoftware() {
        return flowNodeInventorySoftware;
    }

    public void setFlowNodeInventorySoftware(String flowNodeInventorySoftware) {
        this.flowNodeInventorySoftware = flowNodeInventorySoftware;
    }

}
