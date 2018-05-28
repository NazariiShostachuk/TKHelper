
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flow {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("match")
    @Expose
    private Match match;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("idle-timeout")
    @Expose
    private Integer idleTimeout;
    @SerializedName("instructions")
    @Expose
    private Instructions instructions;
    @SerializedName("opendaylight-flow-statistics:flow-statistics")
    @Expose
    private OpendaylightFlowStatisticsFlowStatistics opendaylightFlowStatisticsFlowStatistics;
    @SerializedName("table_id")
    @Expose
    private Integer tableId;
    @SerializedName("hard-timeout")
    @Expose
    private Integer hardTimeout;
    @SerializedName("cookie")
    @Expose
    private Integer cookie;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(Integer idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public Instructions getInstructions() {
        return instructions;
    }

    public void setInstructions(Instructions instructions) {
        this.instructions = instructions;
    }

    public OpendaylightFlowStatisticsFlowStatistics getOpendaylightFlowStatisticsFlowStatistics() {
        return opendaylightFlowStatisticsFlowStatistics;
    }

    public void setOpendaylightFlowStatisticsFlowStatistics(OpendaylightFlowStatisticsFlowStatistics opendaylightFlowStatisticsFlowStatistics) {
        this.opendaylightFlowStatisticsFlowStatistics = opendaylightFlowStatisticsFlowStatistics;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getHardTimeout() {
        return hardTimeout;
    }

    public void setHardTimeout(Integer hardTimeout) {
        this.hardTimeout = hardTimeout;
    }

    public Integer getCookie() {
        return cookie;
    }

    public void setCookie(Integer cookie) {
        this.cookie = cookie;
    }

}
