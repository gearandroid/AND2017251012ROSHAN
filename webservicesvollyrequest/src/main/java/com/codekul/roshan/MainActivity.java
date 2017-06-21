package com.codekul.roshan;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@codekul.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onDisplay(View view) {

        App app = (App) getApplication();

        String lat = ((EditText)findViewById(R.id.edtLatt)).getText().toString();
        String lon = ((EditText)findViewById(R.id.edtLong)).getText().toString();

        final ProgressDialog pd = ProgressDialog.show(MainActivity.this,"Weather","Fetching your data...");

        app.q().add(new StringRequest("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&mode=json&units=metric&cnt=7&appid=d7d115cbfae7711182c21b3ea3b2971c", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i(TAG, "response is : " + response);

                Wh wh = ((App)getApplication()).gson()
                        .fromJson(response,Wh.class);

                String data = wh.getMain().getTemp()+", "+wh.getName()+", "+wh.getDt();

                ((TextView)findViewById(R.id.txtShow)).setText(data);

                pd.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.wtf(error,"Bad Network or Link");
                pd.dismiss();
            }
        }));
    }
}
