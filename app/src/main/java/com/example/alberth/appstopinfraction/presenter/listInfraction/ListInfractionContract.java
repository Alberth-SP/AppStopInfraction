package com.example.alberth.appstopinfraction.presenter.listInfraction;

import android.widget.EditText;

import com.example.alberth.appstopinfraction.bases.BasePresenter;
import com.example.alberth.appstopinfraction.bases.BaseView;
import com.example.alberth.appstopinfraction.data.model.Papeleta;
import com.example.alberth.appstopinfraction.presenter.register.RegisterContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alberth on 30/12/2017.
 */

public interface ListInfractionContract {

    interface View extends BaseView<Presenter> {
        void showListView(ArrayList<Papeleta> list);
        void navigateTo(String papeleta);
    }

    interface Presenter extends BasePresenter {
       void getAllPapeletas();
    }
}
