package com.example.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MyDBhelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_ID = 1;
    private static final String TABLE_CONTACT = "contacts";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String KEY_PHONE_NO = "phone_no";
    public MyDBhelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_ID);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_CONTACT+ "("+KEY_ID+" INTEGER ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
