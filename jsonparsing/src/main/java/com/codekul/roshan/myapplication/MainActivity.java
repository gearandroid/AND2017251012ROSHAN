package com.codekul.roshan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.URLUtil;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@codekul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        try {
//            parseUsingNativeApi();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        parseUsingGson();

    }

    private void parseUsingGson() {

        //1: copy json, use pojo,generate jason zip, extract it and paste classes in the module's package

        //2: go to google, type dson gradle,select Maven Repository:com.google.code.gson
        //select latest gson, go to gradle tab, copy dependency and pasete in
        //module's build.gradle :     compile group: 'com.google.code.gson', name: 'gson', version: '2.8.1'

        Gson gson = new Gson();
        Example our = gson.fromJson(Util.readAsset(this),Example.class);

        Log.i(TAG," "+our.getCodekul());
        Log.i(TAG," "+our.getInfra().getFurniture());

        for (String crse: our.getCourse()){
            Log.i(TAG,"courses are"+crse);
        }

        for(ArrObj arrObject : our.getArrObj()){
            Log.i(TAG,"list is :"+arrObject.getName());
            Log.i(TAG,"list is :"+arrObject.getId());
        }

    }

    private void parseUsingNativeApi() throws JSONException {

        String json = Util.readAsset(this);
//        Log.i(TAG,"Complete Json is : "+ json);
//
//        //accessing string
        JSONObject ob = new JSONObject(json);
        String codekul = ob.getString("codekul");
        Log.i(TAG, "codekul is a :" + codekul);

        //accessing array
        JSONArray jArr = ob.getJSONArray("course");
        for (int i = 0; i <= jArr.length(); i++) {
            Log.i(TAG, " course :" + jArr.getString(i));
        }

        //accessing object
        JSONObject obj = ob.getJSONObject("infra");
        Log.i(TAG, "hi");
        Log.i(TAG, "furniture is:" + obj.getBoolean("furniture"));
        Log.i(TAG, "cooling with :" + obj.getBoolean("ac"));
        Log.i(TAG, "popularity % is :" + obj.getInt("popularity"));

        //accessing array of objects
        JSONArray arrObj = ob.getJSONArray("arrObj");
        for (int i = 0; i <= arrObj.length(); i++) {
//            JSONObject object = arrObj.getJSONObject(i);
//            Log.i(TAG, "Name is:" + object.getString("name"));

            JSONArray arrObj1 = ob.getJSONArray("arrObj");
            for (i = 0; i <= arrObj1.length(); i++) {
                JSONObject object1 = arrObj1.getJSONObject(i);
                Log.i(TAG, "id is:" + object1.getInt("id")); //why this line is not getting printed??
            }
        }
    }
}
