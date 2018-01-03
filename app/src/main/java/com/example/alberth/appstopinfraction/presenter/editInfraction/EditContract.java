package com.example.alberth.appstopinfraction.presenter.editInfraction;

import android.widget.EditText;

import com.example.alberth.appstopinfraction.bases.BasePresenter;
import com.example.alberth.appstopinfraction.bases.BaseView;
import com.example.alberth.appstopinfraction.data.model.Papeleta;
import com.example.alberth.appstopinfraction.presenter.listInfraction.ListInfractionContract;
import com.example.alberth.appstopinfraction.presenter.register.RegisterContract;

import java.util.ArrayList;

/**
 * Created by alberth on 31/12/2017.
 */

public interface EditContract {

    interface View extends BaseView<Presenter> {
        void showSuccessfulToEdit(String message);
        void showErrorToEdit(String message);
        void navigateTo();
    }

    interface Presenter extends BasePresenter {
        boolean validateRegisterToEdit(int idPapeleta, EditText[] fields);
        Papeleta getItemById(int idPapeleta);
    }
}
