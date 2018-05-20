package com.nazarii.shostachuk.tkhelper.data.portscanner;

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

public class PortScannerActivity extends BaseActivity implements PortScannerContract.View {
    PortScannerContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        presenter = new PortScannerPresenter(this, this);

    }

    @Override
    public String getToolbarTitle() {
        return "Port Scanner";
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_port_scanner;
    }


    @OnClick(R.id.action_search_button)
    protected void onScanAction() {
        if (action_input.getText() != null && !TextUtils.isEmpty(action_input.getText())) {
            presenter.doScan(action_input.getText().toString());
        } else if (TextUtils.isEmpty(action_input.getText())) {
            Snackbar.make(findViewById(R.id.action_content), "Cannot be empty", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void setPortScanResults(ArrayList<SimpleItem> items) {
        adapter.insertItems(items);
    }

    @Override
    public void setPortScanDevice(SimpleItem item) {
        runOnUiThread(() -> adapter.insertItem(item));
    }

    @Override
    public void showLoading(boolean loading) {
        rotateLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
        if (loading) rotateLoading.start();
        else rotateLoading.stop();
        action_button.setVisibility(loading ? View.INVISIBLE : View.VISIBLE);
    }
}
