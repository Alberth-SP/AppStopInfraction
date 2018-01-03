package com.example.alberth.appstopinfraction.presenter.listInfraction;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.alberth.appstopinfraction.data.model.Papeleta;
import com.example.alberth.appstopinfraction.data.sqlite.SqliteController;
import com.example.alberth.appstopinfraction.presenter.register.RegisterContract;

import java.util.ArrayList;

/**
 * Created by alberth on 30/12/2017.
 */

public class ListInfractionPresenter implements ListInfractionContract.Presenter{

    @NonNull
    ListInfractionContract.View mView;
    Context context;
    //String fname, lname, name_infraction, matricula, type_vehicle, monto, date, place ;

    SqliteController sqliteController;

    public ListInfractionPresenter(@NonNull ListInfractionContract.View view, Context context){
        mView = view;
        mView.setPresenter(this);
        context = context;
        sqliteController = new SqliteController(context);
    }


    @Override
    public void start() {

    }

    @Override
    public void getAllPapeletas() {

        ArrayList<Papeleta> p= sqliteController.getAllData();
        System.out.println("SIZE: "+p.size());
        mView.showListView(p);
    }
}
