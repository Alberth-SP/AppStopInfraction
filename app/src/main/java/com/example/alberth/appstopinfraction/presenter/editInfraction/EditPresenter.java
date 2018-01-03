package com.example.alberth.appstopinfraction.presenter.editInfraction;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.data.model.Papeleta;
import com.example.alberth.appstopinfraction.data.sqlite.SqliteController;
import com.example.alberth.appstopinfraction.presenter.register.RegisterContract;

/**
 * Created by alberth on 31/12/2017.
 */

public class EditPresenter implements EditContract.Presenter{

    @NonNull
    EditContract.View mView;
    Context context;
    String fname, lname, name_infraction, matricula, type_vehicle, color_vehicle, monto, place ;

    SqliteController sqliteController;


    public EditPresenter(@NonNull EditContract.View view, Context context){
        mView = view;
        mView.setPresenter(this);
        context = context;
        sqliteController = new SqliteController(context);
    }

    @Override
    public void start() {   }

    @Override
    public boolean validateRegisterToEdit(int idPapeleta, EditText[] fields) {

        for (EditText field: fields){
            if (field.getText().toString().isEmpty()){
                field.setError("Llene este Campo!");
                return false;
            }
        }

        if (isDouble(fields[6].getText().toString()) == false){
            fields[6].setError("Ingrese un Numero!");
            return false;
        }

        validated(idPapeleta, fields);
        return true;
    }

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void validated(int idPapeleta, EditText[] fields){

        fname = fields[0].getText().toString();
        lname = fields[1].getText().toString();
        name_infraction = fields[2].getText().toString();
        matricula = fields[3].getText().toString();
        type_vehicle = fields[4].getText().toString();
        color_vehicle = fields[5].getText().toString();
        monto = fields[6].getText().toString();
        place = fields[7].getText().toString();

        if (updateData(idPapeleta, fname, lname, name_infraction, matricula, type_vehicle, color_vehicle, monto, place )){
            mView.showSuccessfulToEdit("Updating Successfully!");
            //System.out.println("agregado success!!!");
        }else{
            mView.showErrorToEdit("Ourrio un ERROR");
        }

    }

    private boolean updateData(int idPapeleta, String fname, String lname, String name_infraction,
                               String matricula, String type_vehicle, String color_vehicle, String monto, String place ){
        Papeleta papeleta = new Papeleta(idPapeleta, fname, lname, name_infraction, matricula , type_vehicle, color_vehicle, Double.parseDouble(monto),"" , place);

        int res = sqliteController.updatePapeletaData(papeleta);
        System.out.print("RES: "+res);
        return  true;

    }

    @Override
    public Papeleta getItemById(int idPapeleta) {
        return sqliteController.getPapeletaDetail(idPapeleta);
    }
}
