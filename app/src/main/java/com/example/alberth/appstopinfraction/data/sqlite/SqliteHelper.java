package com.example.alberth.appstopinfraction.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.alberth.appstopinfraction.data.model.Papeleta;

import java.util.ArrayList;


/**
 * Created by benidict on 02/09/2017.
 */

@SuppressWarnings("WeakerAccess")
public class SqliteHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "sample_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = SqliteHelper.class.getSimpleName();

    public SqliteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqliteTablePapeleta.DB_DROPDATABASE);
       // db.execSQL(SqliteTablePapeleta.DB_PAPELETA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + SqliteTablePapeleta.DB_PAPELETA);
        onCreate(db);
    }

    public boolean insertData(String table, ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table, null, values);
        if (result == -1){
            Log.d(TAG, "failed to save data!");
            return false;
        }else{
            Log.d(TAG, "save data successful");
            return true;
        }
    }

    /**
     * This method edit the user details and it return int value.
     * @param table this param provide table that you want to update.
     * @param values values param provide col value.
     * @param idPapeleta to identify the you use want to edit.
     * @return int value.
     **/
    public int updateData(String table, ContentValues values, Integer idPapeleta){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(table, values,
                SqliteTablePapeleta.COL_ID_PAPELETA + " = "+idPapeleta, null);
    }

    public Papeleta getPapeletaDetail(Integer idPapeleta){
        Papeleta papeleta;

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = SqliteTablePapeleta.COL_ID_PAPELETA + " = " +idPapeleta ;

        String[] columns={
                SqliteTablePapeleta.COL_ID_PAPELETA,
                SqliteTablePapeleta.COL_FNAME_CONDUCTOR,
                SqliteTablePapeleta.COL_LNAME_CONDUCTOR,
                SqliteTablePapeleta.COL_NAME_INFRACTION,
                SqliteTablePapeleta.COL_MATRICULA,
                SqliteTablePapeleta.COL_TYPE_VEHICLE,
                SqliteTablePapeleta.COL_MONTO,
                SqliteTablePapeleta.COL_COLOR_VEHICLE,
                SqliteTablePapeleta.COL_DATE,
                SqliteTablePapeleta.COL_PLACE,
        };

        Cursor cursor = db.query(SqliteTablePapeleta.TABLE_PAPELETA, columns,
                selection, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()){
            papeleta = new Papeleta();
            papeleta.setIdPapeleta(cursor.getInt(0));
            papeleta.setFname_conductor(cursor.getString(1));
            papeleta.setLname_conductor(cursor.getString(2));
            papeleta.setName_infraction(cursor.getString(3));
            papeleta.setMatricula(cursor.getString(4));
            papeleta.setType_vehicle(cursor.getString(5));
            papeleta.setMonto(cursor.getDouble(6));
            papeleta.setColor_vehicle(cursor.getString(7));
            papeleta.setDate(cursor.getString(8));
            papeleta.setPlace(cursor.getString(9));
            return papeleta;
        }

        return null;
    }


    /**
     * This method delete user details permanently, and it returns boolean value.
     * @param idPapeleta param email provide email of the user that are logged in the app.
     * @return true/false.
     **/
    public boolean deletePapeleta(Integer idPapeleta){
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(SqliteTablePapeleta.TABLE_PAPELETA, SqliteTablePapeleta.COL_ID_PAPELETA + " = " + idPapeleta ,
                null) > 0;
    }

    public ArrayList<Papeleta> getAllData(String table) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Papeleta> list= new ArrayList<Papeleta>();
        Cursor cursor = db.rawQuery("select * from "+ table , null);

        System.out.println("COUNT :"+cursor.getCount());
        while(cursor.moveToNext()){
            System.out.println("DATA :"+cursor.getString(1)+" "+cursor.getString(2));
            list.add( new Papeleta(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(4),
                    cursor.getString(8)));

        }
        return list;
    }
}
