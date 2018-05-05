package com.nazarii.shostachuk.tkhelper.data.portscanner;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nazarii.shostachuk.tkhelper.R;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItemsAdapter;
import com.victor.loading.rotate.RotateLoading;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PortScannerActivity extends AppCompatActivity implements PortScannerContract.View {
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;
    @BindView(R.id.port_scan_search)
    protected EditText port_input;
    @BindView(R.id.rotateloading)
    protected RotateLoading rotateLoading;
    @BindView(R.id.port_scan_scan_button)
    protected Button scan_button;
    PortScannerContract.Presenter presenter;
    SimpleItemsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port_scanner);
        ButterKnife.bind(this);
        setupToolbar();
        prepareView();
    }

    private void prepareView() {
        adapter = new SimpleItemsAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        presenter = new PortScannerPresenter(this, this);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Port Scanner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.DST);
        toolbar.setNavigationOnClickListener((view) -> {
            onBackPressed();
        });
    }

    @OnClick(R.id.port_scan_scan_button)
    protected void onScanAction() {
        if (port_input.getText() != null && !TextUtils.isEmpty(port_input.getText())) {
            presenter.doScan(port_input.getText().toString());
        } else if (TextUtils.isEmpty(port_input.getText())) {
            Snackbar.make(findViewById(R.id.ping_tool_content), "Cannot be empty", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void setPortScanResults(ArrayList<SimpleItem> items) {
        adapter.insertItems(items);
    }

    @Override
    public void showLoading(boolean loading) {
        rotateLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
        if (loading) rotateLoading.start();
        else rotateLoading.stop();
        scan_button.setVisibility(loading ? View.INVISIBLE : View.VISIBLE);
    }
}
