package com.nazarii.shostachuk.tkhelper.data.nodes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.nazarii.shostachuk.tkhelper.R;
import com.nazarii.shostachuk.tkhelper.data.base.BaseActivity2;
import com.nazarii.shostachuk.tkhelper.data.nodes.model.Node;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopologiesActivity extends BaseActivity2 implements SwitchesContract.SwitchesView {
    @BindView(R.id.topo_name)
    TextView topoName;
    @BindView(R.id.nodes_recycler_view)
    RecyclerView nodesRecyclerView;
    NodeAdapter nodeAdapter;
    TopologiesPresenter topologiesPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        prepareView();
        getData();
    }

    private void getData() {
        topologiesPresenter.getSwitches();
    }

    private void prepareView() {
        topologiesPresenter = new TopologiesPresenter(this);
        nodeAdapter = new NodeAdapter(this);
        nodesRecyclerView.setAdapter(nodeAdapter);
        nodesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int provideContentView() {
        return R.layout.topologies_activity;
    }

    @Override
    public void setTopoNameAndId(String topologyId) {
        topoName.setText(String.format("Topology: %s", topologyId));
    }

    @Override
    public void setNodes(List<Node> node) {
        nodeAdapter.insertData(node);
    }

}
