
package com.nazarii.shostachuk.tkhelper.data.node.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Instructions {

    @SerializedName("instruction")
    @Expose
    private List<Instruction> instruction = null;

    public List<Instruction> getInstruction() {
        return instruction;
    }

    public void setInstruction(List<Instruction> instruction) {
        this.instruction = instruction;
    }

}
