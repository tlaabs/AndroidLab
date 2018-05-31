package com.github.tlaabs.lab6_3;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DevSim on 2018-05-31.
 */

public class DBHelper extends SQLiteOpenHelper{

    static final String DB_NAME = "mydb.db";
    static final String DATABASE_TABLE = "student";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_CREATE =
            "create table student (_id integer primary key autoincrement, " +
                    "name text not null, " +
                    "studentNo text not null);";

    public DBHelper(Context context){
        super(context,DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(DATABASE_CREATE);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }
}
