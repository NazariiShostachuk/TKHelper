package com.nazarii.shostachuk.tkhelper.data.base;

import android.os.Bundle;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V> implements IBasePresenter<V> {
    protected V view;
    protected CompositeDisposable disposables = new CompositeDisposable();

    public BasePresenter(V view) {
        this.view = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onDestroy() {
        if (!disposables.isDisposed())
            disposables.dispose();
        this.view = null;
    }


}
