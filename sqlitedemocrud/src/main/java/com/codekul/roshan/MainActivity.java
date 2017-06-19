package com.codekul.roshan;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.LocaleDisplayNames;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Sqlite@Codekul";
    // #:- creating reference of DBHelper class
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // #:- creating object of DBHelper class: no previous database
        // of this app/module so version:null and we are creating a new database so version :1

        helper = new DBHelper(this,"my_info.sqlite",null,1);


        //we will insert by ORM and (simple or raw) method both


        //rawMethod();



    }

    public void onUpdate(View view) {
        App app = (App) getApplication();

        ContentValues values = new ContentValues();
        values.put("name","Appu");

        String table = "my_table";
        String whereClause = "name = ?";

        String[] whereArgs = {"Roshan"};

        SQLiteDatabase sqDb = app.helper().getWritableDatabase();
        int reflected = sqDb.update(table,values,whereClause,whereArgs);

        Log.i(TAG," "+reflected+"row inserted");

        sqDb.close();
    }

    public void onDelete(View view) {
        App app = (App) getApplication();

        String table = "my_table";
        String whereClause = "id = ?";
        String[] whereArgs = {"01"};

        SQLiteDatabase sqDb = app.helper().getWritableDatabase();
        int deleted = sqDb.delete(table,whereClause,whereArgs);

        Log.i(TAG," "+deleted+": row deleted");
        sqDb.close();
    }

    public void onDisplay(View view) {

                    App app = (App) getApplication();
                    SQLiteDatabase sqldb = app.helper().getReadableDatabase();

                    String table = "my_table";
                    String[] columns = {"id"};
                    String selection = "name = ?";
                    String[] selectionArgs = {"11"};
                    String groupBy = null;
                    String having = null;
                    String orderBy = null;

                    Cursor cursor = sqldb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);

                    while (cursor.moveToNext()){
                        String id = cursor.getString(1);

                        Log.i(TAG,id);
                        }

                    cursor.close();
                    sqldb.close();
    }



    private void rawMethod() {
        //simply provide CRUD sql queries to the execSQL()

        App app = (App) getApplication();

        SQLiteDatabase sqDb = app.helper().getWritableDatabase();
        sqDb.execSQL("insert into my_table values(01,'Roshan')");
        sqDb.close();
    }


    public void onInsertt(View view) {
        App app = (App) getApplication();

        String table = "my_table";
        String nullColumnHack = null; //if entire row is empty, it will insert the
        // specified column as null making it non empty as sqlite does not accept empty row

        ContentValues values = new ContentValues();
        values.put("id","11");
        values.put("name","Roshan_11");

        SQLiteDatabase sqDb = app.helper().getWritableDatabase();

        Long row = sqDb.insert(table,nullColumnHack,values);

        if(row<0) Log.i(TAG," "+ "Insertion Failed");
        else Log.i(TAG," "+ " Inserted Succesfully");
        sqDb.close();
    }


}
