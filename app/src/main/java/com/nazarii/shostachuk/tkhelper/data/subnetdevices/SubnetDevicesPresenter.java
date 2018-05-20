package com.nazarii.shostachuk.tkhelper.data.subnetdevices;

import com.nazarii.shostachuk.tkhelper.data.base.BasePresenter;

public class SubnetDevicesPresenter extends BasePresenter<SubnetDevicesContract.View> implements SubnetDevicesContract.Presenter {

    public SubnetDevicesPresenter(SubnetDevicesContract.View view) {
        super(view);
    }

    @Override
    public void doDevicesSearch(String address) {

    }
}
