package com.nazarii.shostachuk.tkhelper.utils.rxvalidator;

public interface TypeOfChangeBuilder {
    RxValidator onFocusChanged();

    RxValidator onValueChanged();

    RxValidator onSubscribe();
}
