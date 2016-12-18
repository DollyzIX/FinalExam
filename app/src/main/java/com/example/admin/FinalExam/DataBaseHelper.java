package com.example.admin.FinalExam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ja on 18/12/2559.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Login";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Login";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_UNAME = "username";
    public static final String COL_PASS = "Password";

    private static final String SQL_CRATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_UNAME + " TEXT"
                    + COL_PASS + "INTEGER"
            +")";


    public DataBaseHelper(Context context, String databaseName, Object o, int databaseVersion) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CRATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {

    }
    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_ID,"1");
        cv.put(COL_NAME, "Andoid Studio");
        cv.put(COL_UNAME, "android");
        cv.put(COL_PASS,"123456");
        db.insert(TABLE_NAME, null, cv);
    }
}