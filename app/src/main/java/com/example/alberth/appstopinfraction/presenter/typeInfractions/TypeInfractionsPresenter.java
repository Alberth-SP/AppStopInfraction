package com.example.alberth.appstopinfraction.presenter.typeInfractions;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.example.alberth.appstopinfraction.data.model.TypeInfraction;
import com.example.alberth.appstopinfraction.presenter.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alberth on 01/01/2018.
 */

public class TypeInfractionsPresenter implements TypeInfractionsContract.Presenter {

    @NonNull
    TypeInfractionsContract.View mView;
    Context context;
    //String fname, lname, name_infraction, matricula, type_vehicle, monto, date, place ;

    public TypeInfractionsPresenter(@NonNull TypeInfractionsContract.View view, Context context){
        mView = view;
        mView.setPresenter(this);
        context = context;

    }

    @Override
    public void start() {   }



    @Override
    public void getAllTypesInfractions() {

        List<TypeInfraction> list = new ArrayList<TypeInfraction>();
        String idPapeleta = "papeleta";
        int count = 1;
        String [] arrTemp;


        Integer resourceId = HomeActivity.RESOURCES.getIdentifier("papeleta"+count,"array", HomeActivity.PACKAGE_NAME);

        while(resourceId != null && resourceId > 0){
            arrTemp = HomeActivity.RESOURCES.getStringArray(resourceId);
            TypeInfraction typeInfraction = new TypeInfraction();

            typeInfraction.setCodigo(arrTemp[0]);
            typeInfraction.setDetalle(arrTemp[1]);
            typeInfraction.setMonto(arrTemp[2]);

            list.add(typeInfraction);

            count++;
            resourceId = HomeActivity.RESOURCES.getIdentifier("papeleta"+count,"array", HomeActivity.PACKAGE_NAME);
        }

        System.out.println("SIZE TYEP: "+ list.size());
        mView.showListTypesInfractions(list);

    }
}
