
package com.nazarii.shostachuk.tkhelper.data.node.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlowNodeInventorySwitchFeatures {

    @SerializedName("max_buffers")
    @Expose
    private Integer maxBuffers;
    @SerializedName("capabilities")
    @Expose
    private List<String> capabilities = null;
    @SerializedName("max_tables")
    @Expose
    private Integer maxTables;

    public Integer getMaxBuffers() {
        return maxBuffers;
    }

    public void setMaxBuffers(Integer maxBuffers) {
        this.maxBuffers = maxBuffers;
    }

    public List<String> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    public Integer getMaxTables() {
        return maxTables;
    }

    public void setMaxTables(Integer maxTables) {
        this.maxTables = maxTables;
    }

}
