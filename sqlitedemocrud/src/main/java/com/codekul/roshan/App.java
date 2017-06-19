package com.codekul.roshan;

import android.app.Application;

/**
 * Created by rtb on 18/6/17.
 */

public class App extends Application {

    private DBHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();

        helper = new DBHelper(this,"my_db.sqlite",null,1);
    }

    public DBHelper helper(){
        return helper;
    }

}
