package com.example.alberth.appstopinfraction.data.sqlite;

/**
 * Created by Lab02-06 on 21/12/2017.
 */

public class SqliteTablePapeleta {

    public static final String TABLE_PAPELETA = "table_papeleta";
    public static final String COL_ID_PAPELETA = " col_idPapeleta";
    public static final String COL_FNAME_CONDUCTOR = " col_fname_conductor";
    public static final String COL_LNAME_CONDUCTOR = " col_lname_conductor";
    public static final String COL_NAME_INFRACTION = " col_name_infraction";
    public static final String COL_MATRICULA = " col_matricula";
    public static final String COL_TYPE_VEHICLE = " col_type_vehicle";
    public static final String COL_MONTO = "col_monto";
    public static final String COL_COLOR_VEHICLE = " col_color_vehicle";
    public static final String COL_DATE = " col_date";
    public static final String COL_PLACE = " col_place";
    public static final String COL_GPS = " col_gps";

    public static final String DB_PAPELETA = "CREATE TABLE " + TABLE_PAPELETA + "(" + COL_ID_PAPELETA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_FNAME_CONDUCTOR + " TEXT, " + COL_LNAME_CONDUCTOR + " TEXT, " + COL_NAME_INFRACTION + " TEXT, " + COL_MATRICULA + " TEXT, "
            + COL_TYPE_VEHICLE + " TEXT, " + COL_MONTO + " REAL,  "+ COL_COLOR_VEHICLE + " TEXT, "
            + COL_DATE + " TEXT, "+ COL_PLACE +" TEXT, "+ COL_GPS + " TEXT" +")";

    public static  final String DB_DROPDATABASE = "DROP TABLE IF EXISTS 'table_papeleta'";
}
