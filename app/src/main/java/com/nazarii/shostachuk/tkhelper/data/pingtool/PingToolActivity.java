package com.nazarii.shostachuk.tkhelper.data.pingtool;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
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

public class PingToolActivity extends AppCompatActivity implements PingToolContract.View {
    @BindView(R.id.appBarLayout)
    protected AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.ping_tool_search)
    protected EditText ping_input;
    @BindView(R.id.ping_tool_search_button)
    protected Button ping_button;
    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;
    @BindView(R.id.rotateloading)
    protected RotateLoading rotateLoading;
    boolean isValid;
    private PingToolContract.Presenter presenter;
    private SimpleItemsAdapter adapter;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_tool);
        ButterKnife.bind(this);
        setupToolbar();

        prepareView();

        validatePingInput();
    }

    private void prepareView() {
        presenter = new PingToolPresenter(this, this);
        adapter = new SimpleItemsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void validatePingInput() {
//        RxValidator.createFor(ping_input).ip4().nonEmpty().onValueChanged().toObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(
//                result -> {
//                    result.setError();
//                    isValid = result.isProper();
//                }, throwable -> TKUtils.log("Validation error " + throwable)
//        );
    }

    @OnClick(R.id.ping_tool_search_button)
    protected void onPingAction() {
        if (ping_input.getText() != null && !TextUtils.isEmpty(ping_input.getText())) {
            presenter.doPing(ping_input.getText().toString(), 5);
        } else if (TextUtils.isEmpty(ping_input.getText())) {
            Snackbar.make(findViewById(R.id.ping_tool_content), "Cannot be empty", Snackbar.LENGTH_LONG).show();
        } else if (!isValid) {
            Snackbar.make(findViewById(R.id.ping_tool_content), "Invalid IP address", Snackbar.LENGTH_LONG).show();
        }
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ping");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.DST);
        toolbar.setNavigationOnClickListener((view) -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void setPingResults(ArrayList<SimpleItem> pingResults) {
        adapter.insertItems(pingResults);
    }

    @Override
    public void showLoading(boolean loading) {
        rotateLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
        if (loading) rotateLoading.start();
        else rotateLoading.stop();
        ping_button.setVisibility(loading ? View.INVISIBLE : View.VISIBLE);
    }

}
