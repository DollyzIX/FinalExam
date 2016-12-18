package com.example.admin.FinalExam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static com.example.admin.FinalExam.DataBaseHelper.COL_ID;
import static com.example.admin.FinalExam.DataBaseHelper.COL_NAME;
import static com.example.admin.FinalExam.DataBaseHelper.COL_PASS;
import static com.example.admin.FinalExam.DataBaseHelper.COL_UNAME;
import static com.example.admin.FinalExam.DataBaseHelper.TABLE_NAME;

/**
 * Created by Ja on 18/12/2559.
 */

public class loginDataBaseAdapter {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;



    public SQLiteDatabase db;

    private final Context context;

    private DataBaseHelper dbHelper;
    public  loginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  loginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry()
    {
        ContentValues newValues = new ContentValues();


        newValues.put("id",COL_ID);
        newValues.put("name",COL_NAME);
        newValues.put("USERNAME", COL_UNAME);
        newValues.put("PASSWORD",COL_PASS);

        db.insert(TABLE_NAME, null, newValues);

    }
    public int deleteEntry(String UserName)
    {

        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;

        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String userName)
    {
        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, DataBaseHelper.COL_ID);

        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void  updateEntry(String userName,int password,String id,String name)
    {

        ContentValues updatedValues = new ContentValues();

        updatedValues.put("_id",id);
        updatedValues.put("name",name);
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});
    }
}
