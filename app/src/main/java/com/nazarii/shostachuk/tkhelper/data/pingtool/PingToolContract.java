package com.nazarii.shostachuk.tkhelper.data.pingtool;

import com.nazarii.shostachuk.tkhelper.data.base.IBasePresenter;
import com.nazarii.shostachuk.tkhelper.data.simple.SimpleItem;

import java.util.ArrayList;

public interface PingToolContract {

    interface View {
        void setPingResults(ArrayList<SimpleItem> pingResults);

        void showLoading(boolean loading);
    }

    interface Presenter extends IBasePresenter<View> {
        void doPing(String address, int times);
    }
}
