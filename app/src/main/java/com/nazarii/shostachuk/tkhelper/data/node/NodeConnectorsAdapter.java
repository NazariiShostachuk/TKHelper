package com.nazarii.shostachuk.tkhelper.data.node;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nazarii.shostachuk.tkhelper.R;
import com.nazarii.shostachuk.tkhelper.data.node.model.NodeConnector;

import java.util.List;

public class NodeConnectorsAdapter extends RecyclerView.Adapter<NodeConnectorsAdapter.NodeConnectorsViewHolder> {
    private List<NodeConnector> nodeConnector;

    public NodeConnectorsAdapter() {
    }

    public void insertData(List<NodeConnector> nodeConnector) {
        this.nodeConnector = nodeConnector;
    }

    @NonNull
    @Override
    public NodeConnectorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NodeConnectorsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_node_connectors, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NodeConnectorsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return nodeConnector.size();
    }

    public class NodeConnectorsViewHolder extends RecyclerView.ViewHolder {
        public NodeConnectorsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
