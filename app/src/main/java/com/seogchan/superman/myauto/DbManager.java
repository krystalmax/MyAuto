package com.seogchan.superman.myauto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by superman on 2017-01-23.
 */

public class DbManager extends SQLiteOpenHelper {

    public static DbManager dbManager = null;
    public static final String DATABASE_NAME = "myauto.db";
    public static final String PAYMENT_TABLE = "payment_table";
    public static final String SHOP_INFO_TABLE = "shop_info_table";
    public static final String ITEM_INFO_TABLE = "ritem_info_table";

//    public static final String FUEL_TABLE = "fuel_table";   //maintenance
//    public static final String MAINTENANCE_TABLE = "maintenance_table";
//    public static final String CHARGE_TABLE = "charge_table";

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

    public long insert(ContentValues values) {
        return getWritableDatabase().insert(PAYMENT_TABLE, null, values);
    }

    public int update(ContentValues values){
        String[] args = {values.getAsString("_id")};
        return getWritableDatabase().update(PAYMENT_TABLE, values, "_id=?", args);
    }

    public int delete(String[] args) {
        return getWritableDatabase().delete(PAYMENT_TABLE, "_id=?", args);

    }

    public void getAll() {

    }

    public void get() {

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + PAYMENT_TABLE + "(" +
                "_id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date       INTEGER, " +        //날짜
                "mileage    INTEGER, " +        //주행거리
                "amount     INTEGER, " +        //금액
                "category   INTEGER, " +        //분류 (주유:1, 정비:2, 기타:0)
                "shop       TEXT, " +           //영업소이름 (외래키:SHOP_INFO_TABLE)
                "price      REAL, " +           //주유단가
                "quantity   REAL, " +           //주유량
                "item       TEXT, " +           //정비항목 (외래키:ITEM_INFO_TABLE)
                "ext_item   TEXT, " +           //기타항목
                "memo       TEXT, " +           //메모
                "picture    BLOB );");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + SHOP_INFO_TABLE + "(" +
                "_id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                "shop       TEXT, " +           //영업소명
                "category   INTEGER, " +        //구분 (주유소:1, 정비소:2, 기타:0)
                "address    TEXT, " +           //주소
                "phone      TEXT, " +           //전화번호
                "posX       TEXT, " +           //좌표X
                "posY       TEXT, " +           //좌표Y
                "code       TEXT, " +           //코드(주유소코드. opinet 연결시 이용예정)
                "memo       TEXT, " +           //메모
                "picture    BLOB );");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + ITEM_INFO_TABLE + "("+
                "_id        INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name       TXT, " +            //항목이름
                "recommend  INTEGER, " +        //권장 주행거리
                "memo       TEXT," +            //기타정보
                "picture    BLOB );");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + FUEL_TABLE + "(" +
//                "_id        INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "fuelDate       INTEGER, " +
//                "distance   INTEGER, " +
//                "cost       INTEGER, " +
//                "price      REAL, " +
//                "quantity   REAL, " +
//                "station    TEXT, " +
//                "memo       TEXT, " +
//                "picture    BLOB );");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + SERVICE_TABLE + "("+
//                "_id        INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "fuelDate       INTEGER, " +
//                "distance   INTEGER, " +
//                "cost       INTEGER, " +
//                "item       TEXT, " +
//                "shop       TEXT, " +
//                "memo       TEXT," +
//                "picture    BLOB );");
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + CHARGE_TABLE + "("+
//                "_id        INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "fuelDate       INTEGER, " +
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
