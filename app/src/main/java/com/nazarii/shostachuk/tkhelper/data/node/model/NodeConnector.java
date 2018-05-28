
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NodeConnector {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("stp-status-aware-node-connector:status")
    @Expose
    private String stpStatusAwareNodeConnectorStatus;
    @SerializedName("opendaylight-port-statistics:flow-capable-node-connector-statistics")
    @Expose
    private OpendaylightPortStatisticsFlowCapableNodeConnectorStatistics opendaylightPortStatisticsFlowCapableNodeConnectorStatistics;
    @SerializedName("flow-node-inventory:port-number")
    @Expose
    private String flowNodeInventoryPortNumber;
    @SerializedName("flow-node-inventory:supported")
    @Expose
    private String flowNodeInventorySupported;
    @SerializedName("flow-node-inventory:advertised-features")
    @Expose
    private String flowNodeInventoryAdvertisedFeatures;
    @SerializedName("flow-node-inventory:configuration")
    @Expose
    private String flowNodeInventoryConfiguration;
    @SerializedName("flow-node-inventory:current-feature")
    @Expose
    private String flowNodeInventoryCurrentFeature;
    @SerializedName("flow-node-inventory:hardware-address")
    @Expose
    private String flowNodeInventoryHardwareAddress;
    @SerializedName("flow-node-inventory:peer-features")
    @Expose
    private String flowNodeInventoryPeerFeatures;
    @SerializedName("flow-node-inventory:name")
    @Expose
    private String flowNodeInventoryName;
    @SerializedName("flow-node-inventory:state")
    @Expose
    private FlowNodeInventoryState flowNodeInventoryState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStpStatusAwareNodeConnectorStatus() {
        return stpStatusAwareNodeConnectorStatus;
    }

    public void setStpStatusAwareNodeConnectorStatus(String stpStatusAwareNodeConnectorStatus) {
        this.stpStatusAwareNodeConnectorStatus = stpStatusAwareNodeConnectorStatus;
    }

    public OpendaylightPortStatisticsFlowCapableNodeConnectorStatistics getOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics() {
        return opendaylightPortStatisticsFlowCapableNodeConnectorStatistics;
    }

    public void setOpendaylightPortStatisticsFlowCapableNodeConnectorStatistics(OpendaylightPortStatisticsFlowCapableNodeConnectorStatistics opendaylightPortStatisticsFlowCapableNodeConnectorStatistics) {
        this.opendaylightPortStatisticsFlowCapableNodeConnectorStatistics = opendaylightPortStatisticsFlowCapableNodeConnectorStatistics;
    }

    public String getFlowNodeInventoryPortNumber() {
        return flowNodeInventoryPortNumber;
    }

    public void setFlowNodeInventoryPortNumber(String flowNodeInventoryPortNumber) {
        this.flowNodeInventoryPortNumber = flowNodeInventoryPortNumber;
    }

    public String getFlowNodeInventorySupported() {
        return flowNodeInventorySupported;
    }

    public void setFlowNodeInventorySupported(String flowNodeInventorySupported) {
        this.flowNodeInventorySupported = flowNodeInventorySupported;
    }

    public String getFlowNodeInventoryAdvertisedFeatures() {
        return flowNodeInventoryAdvertisedFeatures;
    }

    public void setFlowNodeInventoryAdvertisedFeatures(String flowNodeInventoryAdvertisedFeatures) {
        this.flowNodeInventoryAdvertisedFeatures = flowNodeInventoryAdvertisedFeatures;
    }

    public String getFlowNodeInventoryConfiguration() {
        return flowNodeInventoryConfiguration;
    }

    public void setFlowNodeInventoryConfiguration(String flowNodeInventoryConfiguration) {
        this.flowNodeInventoryConfiguration = flowNodeInventoryConfiguration;
    }

    public String getFlowNodeInventoryCurrentFeature() {
        return flowNodeInventoryCurrentFeature;
    }

    public void setFlowNodeInventoryCurrentFeature(String flowNodeInventoryCurrentFeature) {
        this.flowNodeInventoryCurrentFeature = flowNodeInventoryCurrentFeature;
    }

    public String getFlowNodeInventoryHardwareAddress() {
        return flowNodeInventoryHardwareAddress;
    }

    public void setFlowNodeInventoryHardwareAddress(String flowNodeInventoryHardwareAddress) {
        this.flowNodeInventoryHardwareAddress = flowNodeInventoryHardwareAddress;
    }

    public String getFlowNodeInventoryPeerFeatures() {
        return flowNodeInventoryPeerFeatures;
    }

    public void setFlowNodeInventoryPeerFeatures(String flowNodeInventoryPeerFeatures) {
        this.flowNodeInventoryPeerFeatures = flowNodeInventoryPeerFeatures;
    }

    public String getFlowNodeInventoryName() {
        return flowNodeInventoryName;
    }

    public void setFlowNodeInventoryName(String flowNodeInventoryName) {
        this.flowNodeInventoryName = flowNodeInventoryName;
    }

    public FlowNodeInventoryState getFlowNodeInventoryState() {
        return flowNodeInventoryState;
    }

    public void setFlowNodeInventoryState(FlowNodeInventoryState flowNodeInventoryState) {
        this.flowNodeInventoryState = flowNodeInventoryState;
    }

}
