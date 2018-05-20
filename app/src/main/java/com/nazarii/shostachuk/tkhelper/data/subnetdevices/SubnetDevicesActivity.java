package com.nazarii.shostachuk.tkhelper.data.subnetdevices;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nazarii.shostachuk.tkhelper.R;
import com.nazarii.shostachuk.tkhelper.data.base.BaseActivity;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class SubnetDevicesActivity extends BaseActivity implements SubnetDevicesContract.View {
    private SubnetDevicesContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public String getToolbarTitle() {
        return "SubnetDevices";
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_subnet_devices;
    }

    @Override
    public void setDevices(ArrayList<SimpleItem> pingResults) {

    }

    @Override
    public void showLoading(boolean loading) {

    }
}
