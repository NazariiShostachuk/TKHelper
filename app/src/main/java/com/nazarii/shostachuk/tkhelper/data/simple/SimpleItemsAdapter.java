package com.nazarii.shostachuk.tkhelper.data.simple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nazarii.shostachuk.tkhelper.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleItemsAdapter extends RecyclerView.Adapter<SimpleItemsAdapter.SimpleItemsViewHolder> {

    private ArrayList<SimpleItem> simpleItems = new ArrayList<>();
    private Context context;

    public SimpleItemsAdapter(Context context) {
        this.context = context;
    }

    public void insertItems(ArrayList<SimpleItem> pingResults) {
        this.simpleItems.clear();
        this.simpleItems.addAll(pingResults);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimpleItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_simple, parent, false);
        return new SimpleItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleItemsViewHolder holder, int position) {
        SimpleItem item = simpleItems.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.right_text.setText(item.getRightText());

        if (item.getDescription() == null) holder.description.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return simpleItems.size();
    }

    public void insertItem(SimpleItem item) {
        simpleItems.add(item);
        notifyDataSetChanged();
    }

    public class SimpleItemsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_ping_result_title)
        TextView title;
        @BindView(R.id.item_ping_result_description)
        TextView description;
        @BindView(R.id.item_ping_result_right_text)
        TextView right_text;

        public SimpleItemsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
