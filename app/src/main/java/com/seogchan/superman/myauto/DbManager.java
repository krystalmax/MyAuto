package com.seogchan.superman.myauto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by superman on 2017-01-23.
 */

public class DbManager extends SQLiteOpenHelper {

    public static DbManager dbManager = null;
    public static final String DATABASE_NAME = "auto.db";
    public static final String EXP_TABLE = "exp_info_table";
    public static final String SHOP_TABLE = "shop_info_table";

//    public static final String FUEL_TABLE = "fuel_table";   //
//    public static final String SERVICE_TABLE = "service_table";
//    public static final String CHARGE_TABLE = "charge_table";
//    public static final String REPAIR_ITEM_TABLE = "repair_item_table";

    public static final int DATABASE_VERSION = 1;

    private SQLiteDatabase database;

    private DbManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DbManager getInstance(Context context) {
        if(dbManager == null) {
            dbManager = new DbManager(context);
        }
        return dbManager;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + EXP_TABLE + "(" +
                "_id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date       INTEGER, " +
                "mileage    INTEGER, " +
                "amount     INTEGER, " +
                "category   INTEGER, " +
                "shop       TEXT, " +
                "price      REAL, " +
                "quantity   REAL, " +
                "item       TEXT, " +
                "ext_item   TEXT, " +
                "memo       TEXT, " +
                "picture    BLOB );");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + SHOP_TABLE + "(" +
                "_id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                "shop       TEXT, " +
                "category   TEXT, " +
                "address    TEXT, " +
                "phone      TEXT, " +
                "posX       TEXT, " +
                "posY       TEXT, " +
                "code       TEXT, " +
                "memo       TEXT, " +
                "picture    BLOB );");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + FUEL_TABLE + "(" +
//                "_id        INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "date       INTEGER, " +
//                "distance   INTEGER, " +
//                "cost       INTEGER, " +
//                "price      REAL, " +
//                "quantity   REAL, " +
//                "station    TEXT, " +
//                "memo       TEXT, " +
//                "picture    BLOB );");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + SERVICE_TABLE + "("+
//                "_id        INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "date       INTEGER, " +
//                "distance   INTEGER, " +
//                "cost       INTEGER, " +
//                "item       TEXT, " +
//                "shop       TEXT, " +
//                "memo       TEXT," +
//                "picture    BLOB );");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + CHARGE_TABLE + "("+
//                "_id        INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "date       INTEGER, " +
//                "distance   INTEGER, " +
//                "cost       INTEGER, " +
//                "item       TEXT, " +
//                "shop       TEXT, " +
//                "memo       TEXT," +
//                "picture    BLOB );");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + REPAIR_ITEM_TABLE + "("+
//                "_id        INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "date       INTEGER, " +
//                "distance   INTEGER, " +
//                "cost       INTEGER, " +
//                "item       TEXT, " +
//                "shop       TEXT, " +
//                "memo       TEXT," +
//                "picture    BLOB );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
