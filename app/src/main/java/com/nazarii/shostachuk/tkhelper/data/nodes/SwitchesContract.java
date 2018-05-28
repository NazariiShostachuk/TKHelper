package com.nazarii.shostachuk.tkhelper.data.nodes;

import com.nazarii.shostachuk.tkhelper.data.base.IBasePresenter;
import com.nazarii.shostachuk.tkhelper.data.base.IBaseView;
import com.nazarii.shostachuk.tkhelper.data.nodes.model.Node;

import java.util.List;

public interface SwitchesContract {
    interface SwitchesView extends IBaseView {
        void setTopoNameAndId(String topologyId);

        void setNodes(List<Node> node);
    }

    interface SwitchesPresenter extends IBasePresenter<SwitchesContract.SwitchesView> {
        void getSwitches();
    }
}
