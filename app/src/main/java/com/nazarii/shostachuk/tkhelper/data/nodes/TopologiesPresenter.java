package com.nazarii.shostachuk.tkhelper.data.nodes;

import com.nazarii.shostachuk.tkhelper.api.RetrofitHelper;
import com.nazarii.shostachuk.tkhelper.data.base.BasePresenter;
import com.nazarii.shostachuk.tkhelper.data.base.CallbackWrapper;
import com.nazarii.shostachuk.tkhelper.data.nodes.model.NetworkTopologyResponse;
import com.nazarii.shostachuk.tkhelper.data.nodes.model.Topology;

import java.util.Collections;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TopologiesPresenter extends BasePresenter<SwitchesContract.SwitchesView> implements SwitchesContract.SwitchesPresenter {

    public TopologiesPresenter(SwitchesContract.SwitchesView view) {
        super(view);
    }

    @Override
    public void getSwitches() {
        disposables.add(RetrofitHelper.getService().getTopologies()
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribeWith(new CallbackWrapper<NetworkTopologyResponse>(view) {
                    @Override
                    protected void onSuccess(NetworkTopologyResponse networkTopologyResponse) {
                        TopologiesPresenter.this.onSuccess(networkTopologyResponse);
                    }
                }));

    }

    private void onSuccess(NetworkTopologyResponse networkTopologyResponse) {
//        view.setTopologies(networkTopologyResponse.getNetworkTopology().getTopology());
        Topology topology = networkTopologyResponse.getNetworkTopology().getTopology().get(0);
        view.setTopoNameAndId(topology.getTopologyId());
        Collections.sort(topology.getNode(), (o1, o2) -> o1.getNodeId().compareTo(o2.getNodeId()));
        view.setNodes(topology.getNode());
    }
}