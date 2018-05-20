package com.nazarii.shostachuk.tkhelper.data.subnetdevices;

import com.nazarii.shostachuk.tkhelper.data.base.IBasePresenter;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;

import java.util.ArrayList;

public interface SubnetDevicesContract {
    interface View {
        void setDevices(ArrayList<SimpleItem> pingResults);

        void showLoading(boolean loading);
    }

    interface Presenter extends IBasePresenter<View> {
        void doDevicesSearch(String address);
    }
}