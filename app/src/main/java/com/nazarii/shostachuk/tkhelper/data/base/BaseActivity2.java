package com.nazarii.shostachuk.tkhelper.data.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity2 extends AppCompatActivity implements IBaseView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentView());
        ButterKnife.bind(this);

    }


    protected abstract int provideContentView();


    @Override
    public void onUnknownError(String errorMessage) {

    }

    @Override
    public void onTimeout() {

    }

    @Override
    public void onNetworkError() {

    }
}
