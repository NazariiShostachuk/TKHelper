
package com.nazarii.shostachuk.tkhelper.data.node.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlowNodeInventoryTable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("opendaylight-flow-table-statistics:flow-table-statistics")
    @Expose
    private OpendaylightFlowTableStatisticsFlowTableStatistics opendaylightFlowTableStatisticsFlowTableStatistics;
    @SerializedName("opendaylight-flow-statistics:aggregate-flow-statistics")
    @Expose
    private OpendaylightFlowStatisticsAggregateFlowStatistics opendaylightFlowStatisticsAggregateFlowStatistics;
    @SerializedName("flow")
    @Expose
    private List<Flow> flow = null;
    @SerializedName("flow-hash-id-map")
    @Expose
    private List<FlowHashIdMap> flowHashIdMap = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OpendaylightFlowTableStatisticsFlowTableStatistics getOpendaylightFlowTableStatisticsFlowTableStatistics() {
        return opendaylightFlowTableStatisticsFlowTableStatistics;
    }

    public void setOpendaylightFlowTableStatisticsFlowTableStatistics(OpendaylightFlowTableStatisticsFlowTableStatistics opendaylightFlowTableStatisticsFlowTableStatistics) {
        this.opendaylightFlowTableStatisticsFlowTableStatistics = opendaylightFlowTableStatisticsFlowTableStatistics;
    }

    public OpendaylightFlowStatisticsAggregateFlowStatistics getOpendaylightFlowStatisticsAggregateFlowStatistics() {
        return opendaylightFlowStatisticsAggregateFlowStatistics;
    }

    public void setOpendaylightFlowStatisticsAggregateFlowStatistics(OpendaylightFlowStatisticsAggregateFlowStatistics opendaylightFlowStatisticsAggregateFlowStatistics) {
        this.opendaylightFlowStatisticsAggregateFlowStatistics = opendaylightFlowStatisticsAggregateFlowStatistics;
    }

    public List<Flow> getFlow() {
        return flow;
    }

    public void setFlow(List<Flow> flow) {
        this.flow = flow;
    }

    public List<FlowHashIdMap> getFlowHashIdMap() {
        return flowHashIdMap;
    }

    public void setFlowHashIdMap(List<FlowHashIdMap> flowHashIdMap) {
        this.flowHashIdMap = flowHashIdMap;
    }

}
