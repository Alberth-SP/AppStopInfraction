package com.example.alberth.appstopinfraction.presenter.register;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.alberth.appstopinfraction.R;
import com.example.alberth.appstopinfraction.data.model.Papeleta;
import com.example.alberth.appstopinfraction.data.sqlite.SqliteController;
import com.example.alberth.appstopinfraction.presenter.register.RegisterContract.Presenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by alberth on 30/12/2017.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    @NonNull
    RegisterContract.View mView;
    Context context;
    String fname, lname, name_infraction, matricula, type_vehicle, color_vehicle, monto, date, place;

    SqliteController sqliteController;


    public RegisterPresenter(@NonNull RegisterContract.View view, Context context) {
        mView = view;
        mView.setPresenter(this);
        context = context;
        sqliteController = new SqliteController(context);
    }

    @Override
    public boolean validateRegisterFields(EditText[] fields) {

        for (EditText field : fields) {
            if (field.getText().toString().isEmpty()) {
                field.setError("Llene este Campo!");
                return false;
            }
        }

        if (isDouble(fields[6].getText().toString()) == false){
            fields[6].setError("Ingrese un Numero!");
            return false;
        }

        validated(fields);
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



    private void validated(EditText[] fields){

        fname = fields[0].getText().toString();
        lname = fields[1].getText().toString();
        name_infraction = fields[2].getText().toString();
        matricula = fields[3].getText().toString();
        type_vehicle = fields[4].getText().toString();
        color_vehicle = fields[5].getText().toString();
        monto = fields[6].getText().toString();
        place = fields[7].getText().toString();

        date = getTime();

        if (savingData(fname, lname, name_infraction, matricula, type_vehicle, color_vehicle, monto, date, place )){
            mView.showSuccessfulRegister("Register Successfully!");
            //System.out.println("agregado success!!!");
        }else{
            mView.showErrorRegister(context.getString(R.string.register_failed));
        }

    }

    private String getTime(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        return df.format(c.getTime());
    }

    private boolean savingData(String fname, String lname, String name_infraction,
                               String matricula, String type_vehicle, String color_vehicle, String monto, String date,  String place ){
        Papeleta papeleta = new Papeleta(fname, lname, name_infraction, matricula , type_vehicle, color_vehicle, Double.parseDouble(monto),  date , place);
       return sqliteController.saveUserData(papeleta);

    }



    @Override
    public void start() {  }
}
