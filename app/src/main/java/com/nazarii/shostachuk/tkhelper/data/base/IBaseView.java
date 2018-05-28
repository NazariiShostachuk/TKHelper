package com.nazarii.shostachuk.tkhelper.data.base;

public interface IBaseView {

    void onUnknownError(String errorMessage);

    void onTimeout();

    void onNetworkError();
}
