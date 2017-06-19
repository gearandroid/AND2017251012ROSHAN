package com.codekul.roshan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rtb on 18/6/17.
 */


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        //this class is a must class and we need to provide default constructor manually by alt+enter
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table my_table(id number,name text)");

        //this method is called only once at the start so queries which should execute only once at
        // creation should be written inside this onCreate()

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onCreate() executes only once but onUpgrade wil be called on each query
        //if old published app is to be updated with new column, new database is created, so old
        // database and new database are mentioned as old and new versions-2 parameters
        // REFER it's object in the Main Activity #:-
    }
}
