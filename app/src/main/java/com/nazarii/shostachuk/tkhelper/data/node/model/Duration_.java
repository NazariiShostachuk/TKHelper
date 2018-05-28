
package com.nazarii.shostachuk.tkhelper.data.node.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Duration_ {

    @SerializedName("nanosecond")
    @Expose
    private Integer nanosecond;
    @SerializedName("second")
    @Expose
    private Integer second;

    public Integer getNanosecond() {
        return nanosecond;
    }

    public void setNanosecond(Integer nanosecond) {
        this.nanosecond = nanosecond;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

}
