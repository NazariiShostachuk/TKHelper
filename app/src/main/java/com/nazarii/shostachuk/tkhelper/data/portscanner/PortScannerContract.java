package com.nazarii.shostachuk.tkhelper.data.portscanner;

import com.nazarii.shostachuk.tkhelper.data.base.IBasePresenter;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;

import java.util.ArrayList;

public interface PortScannerContract {
    interface View {
        void setPortScanResults(ArrayList<SimpleItem> items);

        void showLoading(boolean loading);
    }

    interface Presenter extends IBasePresenter<PortScannerContract.View> {
        void doScan(String address);
    }
}
