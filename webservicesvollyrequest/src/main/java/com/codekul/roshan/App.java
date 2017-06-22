package com.codekul.roshan;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.lang.ref.ReferenceQueue;

/**
 * Created by rtb on 21/6/17.
 */

public class App extends Application {

    private Gson gson;
    private RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(this);

        gson = new Gson();
    }

    public Gson gson(){
        return  gson;
    }

    public RequestQueue q(){
        return queue;
    }
}
