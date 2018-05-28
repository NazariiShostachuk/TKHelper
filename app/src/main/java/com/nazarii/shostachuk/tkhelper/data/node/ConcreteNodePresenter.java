package com.nazarii.shostachuk.tkhelper.data.node;

import com.nazarii.shostachuk.tkhelper.api.RetrofitHelper;
import com.nazarii.shostachuk.tkhelper.data.base.BasePresenter;
import com.nazarii.shostachuk.tkhelper.data.base.CallbackWrapper;
import com.nazarii.shostachuk.tkhelper.data.node.model.InventoryNodeResponse;
import com.nazarii.shostachuk.tkhelper.data.node.model.Node;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ConcreteNodePresenter extends BasePresenter<ConcreteNodeContract.ConcreteNodeView> implements ConcreteNodeContract.ConcreteNodePresenter {

    public ConcreteNodePresenter(ConcreteNodeContract.ConcreteNodeView view) {
        super(view);
    }

    @Override
    public void getConcreteNode(String node_id) {
        disposables.add(RetrofitHelper.getService().getNodeById(node_id)
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribeWith(new CallbackWrapper<InventoryNodeResponse>(view) {
                    @Override
                    protected void onSuccess(InventoryNodeResponse inventoryNodeResponse) {
                        ConcreteNodePresenter.this.onSuccess(inventoryNodeResponse);
                    }
                }));
    }

    private void onSuccess(InventoryNodeResponse inventoryNodeResponse) {
        Node node = inventoryNodeResponse.getNode().get(0);

        view.setNodeId(node.getId());
        view.setManufacturer(node.getFlowNodeInventoryManufacturer());
        view.setHardware(node.getFlowNodeInventoryHardware());
        view.setNodeConnectors(node.getNodeConnector());
        view.setDescription(node.getFlowNodeInventoryDescription());

    }
}
