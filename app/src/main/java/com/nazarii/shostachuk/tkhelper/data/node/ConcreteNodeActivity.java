package com.nazarii.shostachuk.tkhelper.data.node;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.nazarii.shostachuk.tkhelper.R;
import com.nazarii.shostachuk.tkhelper.data.base.BaseActivity2;
import com.nazarii.shostachuk.tkhelper.data.node.model.NodeConnector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConcreteNodeActivity extends BaseActivity2 implements ConcreteNodeContract.ConcreteNodeView {
//    @BindView(R.id.node_connectors_recycler_view)
//    RecyclerView connectorsRecyclerView;
    @BindView(R.id.activity_concrete_node_id)
    TextView node_id;
    @BindView(R.id.activity_concrete_node_manufacturer)
    TextView manufacturer;
    @BindView(R.id.activity_concrete_node_hardware)
    TextView hardware;
    @BindView(R.id.activity_concrete_node_description)
    TextView description;
    ConcreteNodeContract.ConcreteNodePresenter presenter;
//    NodeConnectorsAdapter nodeConnectorsAdapter;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("node_id");
        presenter = new ConcreteNodePresenter(this);
//        nodeConnectorsAdapter = new NodeConnectorsAdapter();
//        connectorsRecyclerView.setAdapter(nodeConnectorsAdapter);
//        connectorsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.getConcreteNode(id);
    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_node;
    }

    @Override
    public void setNodeConnectors(List<NodeConnector> nodeConnector) {

    }

    @Override
    public void setNodeId(String id) {
        node_id.setText(id);
    }

    @Override
    public void setManufacturer(String flowNodeInventoryManufacturer) {
        manufacturer.setText(flowNodeInventoryManufacturer);
    }

    @Override
    public void setHardware(String flowNodeInventoryHardware) {
        hardware.setText(flowNodeInventoryHardware);
    }

    @Override
    public void setDescription(String flowNodeInventoryDescription) {
        description.setText(flowNodeInventoryDescription);
    }
}
