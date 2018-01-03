package com.example.alberth.appstopinfraction.presenter.home;

import android.widget.EditText;

import com.example.alberth.appstopinfraction.bases.BasePresenter;
import com.example.alberth.appstopinfraction.bases.BaseView;

/**
 * Created by alberth on 28/12/2017.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void navigateTo();
    }

    interface Presenter extends BasePresenter {
        boolean validateRegisterFields(EditText[] fields);
    }
}
