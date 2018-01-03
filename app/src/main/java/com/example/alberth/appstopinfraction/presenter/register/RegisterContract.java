package com.example.alberth.appstopinfraction.presenter.register;

import android.widget.EditText;

import com.example.alberth.appstopinfraction.bases.BasePresenter;
import com.example.alberth.appstopinfraction.bases.BaseView;
import com.example.alberth.appstopinfraction.presenter.home.HomeContract;

/**
 * Created by alberth on 30/12/2017.
 */

public interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void showSuccessfulRegister(String message);
        void showErrorRegister(String message);
        void navigateTo();
    }

    interface Presenter extends BasePresenter {
        boolean validateRegisterFields(EditText[] fields);
    }
}
