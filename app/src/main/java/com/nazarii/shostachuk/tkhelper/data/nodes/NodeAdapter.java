package com.nazarii.shostachuk.tkhelper.data.nodes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nazarii.shostachuk.tkhelper.R;
import com.nazarii.shostachuk.tkhelper.data.node.ConcreteNodeActivity;
import com.nazarii.shostachuk.tkhelper.data.nodes.model.Node;
import com.nazarii.shostachuk.tkhelper.data.nodes.model.TerminationPoint;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NodeAdapter extends RecyclerView.Adapter<NodeAdapter.NodeViewHolder> {
    private List<Node> topologies = new ArrayList<>();
    private List<Boolean> expandingItems = new ArrayList<>();

    private Context context;


    public NodeAdapter(Context context) {
        this.context = context;
    }

    public void insertData(List<Node> topologies) {
        this.topologies = topologies;
        for (int i = 0; i < topologies.size(); i++) {
            expandingItems.add(false);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_node, parent, false);
        return new NodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NodeViewHolder holder, int position) {
        Node node = topologies.get(position);
        final Boolean[] expanded = {expandingItems.get(position)};

        holder.node_id.setText(node.getNodeId());

        PointsAdapter pointsAdapter = new PointsAdapter(context, node.getTerminationPoint());

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(pointsAdapter);

        holder.node_id.setOnClickListener(v -> {
            context.startActivity(new Intent(context, ConcreteNodeActivity.class).putExtra("node_id", node.getNodeId()));
        });

        holder.sub_button_container.setOnClickListener(v -> {
            if (expanded[0]) {
                holder.recyclerView.setVisibility(View.GONE);
                expandingItems.set(position, false);
                expanded[0] = false;
            } else {
                holder.recyclerView.setVisibility(View.VISIBLE);
                expandingItems.set(position, true);
                expanded[0] = true;
            }
        });

    }

    private void onExpand(NodeViewHolder holder, boolean expanded, int position) {

    }


    @Override
    public int getItemCount() {
        return topologies.size();
    }

    public class NodeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_node_root)
        ConstraintLayout root;
        @BindView(R.id.item_node_card)
        CardView card;
        @BindView(R.id.layout_termination_point)
        RelativeLayout sub_button_container;
        @BindView(R.id.sub_recycler_view)
        RecyclerView recyclerView;
        @BindView(R.id.item_node_name)
        TextView node_id;

        public NodeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    protected class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.PointsViewHolder> {
        List<TerminationPoint> terminationPoints;
        Context context;

        public PointsAdapter(Context context, List<TerminationPoint> terminationPoints) {
            this.context = context;
            this.terminationPoints = terminationPoints;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public PointsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PointsViewHolder(LayoutInflater.from(context).inflate(R.layout.expanding_sub_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PointsViewHolder holder, int position) {
            TerminationPoint point = terminationPoints.get(position);

            holder.title.setText(point.getTpId());
        }

        @Override
        public int getItemCount() {
            return terminationPoints.size();
        }

        public class PointsViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.sub_title)
            TextView title;

            public PointsViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
