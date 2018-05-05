package com.nazarii.shostachuk.tkhelper.data.base;

import android.os.Bundle;

public interface IBasePresenter<View> {
    void onCreate(Bundle savedInstanceState);

//    void onAttach();
//
//    void onSaveInstanceState(Bundle outState);
//
//    void onDetach();
//
//    void onDestroyView();

    void onDestroy();
}
