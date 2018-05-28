package com.nazarii.shostachuk.tkhelper.api;

import com.nazarii.shostachuk.tkhelper.data.nodes.model.NetworkTopologyResponse;
import com.nazarii.shostachuk.tkhelper.data.node.model.InventoryNodeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/restconf/operational/network-topology:network-topology")
    Observable<NetworkTopologyResponse> getTopologies();

    @GET("/restconf/operational/opendaylight-inventory:nodes/node/{id}")
    Observable<InventoryNodeResponse> getNodeById(@Query("id") String node_id);

}
