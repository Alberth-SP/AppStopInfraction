package com.example.alberth.appstopinfraction.presenter.typeInfractions;

import com.example.alberth.appstopinfraction.bases.BasePresenter;
import com.example.alberth.appstopinfraction.bases.BaseView;
import com.example.alberth.appstopinfraction.data.model.TypeInfraction;

import java.util.List;

/**
 * Created by alberth on 01/01/2018.
 */

public interface TypeInfractionsContract {
    interface View extends BaseView<Presenter> {
        void showListTypesInfractions(List<TypeInfraction> list);
        void navigateTo();
    }

    interface Presenter extends BasePresenter {
        void getAllTypesInfractions();

    }
}
