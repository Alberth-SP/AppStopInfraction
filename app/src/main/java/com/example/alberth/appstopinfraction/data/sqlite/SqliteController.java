package com.example.alberth.appstopinfraction.data.sqlite;

import android.content.ContentValues;
import android.content.Context;

import com.example.alberth.appstopinfraction.data.model.Papeleta;

import java.util.ArrayList;

/**
 * Created by alberth on 30/12/2017.
 */

public class SqliteController {
    private SqliteHelper sqliteHelper;
    Context context;

    public SqliteController(Context mContext){
        this.context = mContext;
        sqliteHelper = new SqliteHelper(context);
    }

    public boolean saveUserData(Papeleta papeleta){
        ContentValues values = new ContentValues();
        values.put(SqliteTablePapeleta.COL_FNAME_CONDUCTOR, papeleta.getFname_conductor());
        values.put(SqliteTablePapeleta.COL_LNAME_CONDUCTOR, papeleta.getLname_conductor());
        values.put(SqliteTablePapeleta.COL_NAME_INFRACTION, papeleta.getName_infraction());
        values.put(SqliteTablePapeleta.COL_MATRICULA, papeleta.getMatricula());
        values.put(SqliteTablePapeleta.COL_TYPE_VEHICLE, papeleta.getType_vehicle());
        values.put(SqliteTablePapeleta.COL_MONTO, papeleta.getMonto());
        values.put(SqliteTablePapeleta.COL_COLOR_VEHICLE,papeleta.getColor_vehicle());
        values.put(SqliteTablePapeleta.COL_DATE, papeleta.getDate());
        values.put(SqliteTablePapeleta.COL_PLACE, papeleta.getPlace());

        return sqliteHelper.insertData(SqliteTablePapeleta.TABLE_PAPELETA, values);
    }

    public ArrayList<Papeleta> getAllData(){
        return sqliteHelper.getAllData(SqliteTablePapeleta.TABLE_PAPELETA);
    }

    public Papeleta getPapeletaDetail(int idPapeleta){
        return sqliteHelper.getPapeletaDetail(idPapeleta);
    }

    public int  updatePapeletaData(Papeleta papeleta){
        ContentValues values = new ContentValues();

        values.put(SqliteTablePapeleta.COL_FNAME_CONDUCTOR, papeleta.getFname_conductor());
        values.put(SqliteTablePapeleta.COL_LNAME_CONDUCTOR, papeleta.getLname_conductor());
        values.put(SqliteTablePapeleta.COL_NAME_INFRACTION, papeleta.getName_infraction());
        values.put(SqliteTablePapeleta.COL_MATRICULA, papeleta.getMatricula());
        values.put(SqliteTablePapeleta.COL_TYPE_VEHICLE, papeleta.getType_vehicle());
        values.put(SqliteTablePapeleta.COL_MONTO, papeleta.getMonto());
        values.put(SqliteTablePapeleta.COL_COLOR_VEHICLE,papeleta.getColor_vehicle());
        values.put(SqliteTablePapeleta.COL_PLACE, papeleta.getPlace());

        return sqliteHelper.updateData(SqliteTablePapeleta.TABLE_PAPELETA, values, papeleta.getIdPapeleta());
    }
}
