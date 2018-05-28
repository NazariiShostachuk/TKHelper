package com.nazarii.shostachuk.tkhelper.data.node;

import com.nazarii.shostachuk.tkhelper.data.base.IBasePresenter;
import com.nazarii.shostachuk.tkhelper.data.base.IBaseView;
import com.nazarii.shostachuk.tkhelper.data.node.model.NodeConnector;

import java.util.List;

public interface ConcreteNodeContract {
    interface ConcreteNodeView extends IBaseView {

        void setNodeConnectors(List<NodeConnector> nodeConnector);

        void setNodeId(String id);

        void setManufacturer(String flowNodeInventoryManufacturer);

        void setHardware(String flowNodeInventoryHardware);

        void setDescription(String flowNodeInventoryDescription);

    }

    interface ConcreteNodePresenter extends IBasePresenter<ConcreteNodeView> {
        void getConcreteNode(String node_id);
    }
}
