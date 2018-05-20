package com.nazarii.shostachuk.tkhelper.data.pingtool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;

import com.nazarii.shostachuk.tkhelper.R;
import com.nazarii.shostachuk.tkhelper.data.base.BaseActivity;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PingToolActivity extends BaseActivity implements PingToolContract.View {
    private PingToolContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        presenter = new PingToolPresenter(this, this);
    }

    @Override
    public String getToolbarTitle() {
        return "Ping";
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_ping_tool;
    }

    @OnClick(R.id.action_search_button)
    protected void onPingAction() {
        if (action_input.getText() != null && !TextUtils.isEmpty(action_input.getText())) {
            presenter.doPing(action_input.getText().toString(), 5);
        } else if (TextUtils.isEmpty(action_input.getText())) {
            Snackbar.make(findViewById(R.id.action_content), "Cannot be empty", Snackbar.LENGTH_LONG).show();
        }
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
        action_button.setVisibility(loading ? View.INVISIBLE : View.VISIBLE);
    }

}
