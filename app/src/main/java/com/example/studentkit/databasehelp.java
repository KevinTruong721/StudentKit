package com.example.studentkit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelp extends SQLiteOpenHelper {

    public static final String DBNAME = "a.db";

    public databasehelp(Context context) {
        super(context, "a.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
    }

    public Boolean insert_userAndPassword(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = sqLiteDatabase.insert("users", null, values);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean exist_username(String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("select * from users where username=?", new String[] {username});
        if (c.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean exist_password(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("select * from users where username=? and password=?", new String[] {username, password});
        if (c.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }
}
