package fileexplorer.webservicepost;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private LocationManager manager;

    private static final String TAG = "@codekul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);


        //Here, we are checking the permissions for using services
        //here,refer code for taking permission
        //condition for following if can be taken from Android developers runtime permission
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }

        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                500,
                0.1f,
                new MyLocation());

    }

    public void onGo(View view) {
        //following code is for GET service: getting temperature from open weather website API
        App app = (App) getApplication();
        String lat = ((EditText)findViewById(R.id.edtLat)).getText().toString();
        String lon = ((EditText)findViewById(R.id.edtLon)).getText().toString();

        //getting following URL through internet as API is the task here, to be done properly for diff websites
        app.q().add(new StringRequest("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon +"&mode=json&units=metric&cnt=7&appid=a068151144b3ee312b054e1b7887d621", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            //to check whether we are getting response or not, we are using Log.i
                Log.i(TAG,":"+response);

                Weather wh = ((App)getApplication()).gson().fromJson(response,Weather.class);

                String data =wh.getMain().getTemp().toString();

                ((TextView)findViewById(R.id.txtDisplay)).setText(data);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.wtf(error,"This is error message");
            }
        }));
    }

    public void postLocaton(double lat,double lon){

        JSONObject locObj = new JSONObject();

        try {
            locObj.put("lat",lat);
            locObj.put("lon",lon);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final App app = (App) getApplication();

        app.q().add(new JsonObjectRequest("https://webposttest-31937.firebaseio.com/myLoc.json",
                locObj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(app,"Request Posted",Toast.LENGTH_SHORT).show();
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(app,"Error",Toast.LENGTH_SHORT).show();
            }
        }));

    }

    public class MyLocation implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {

            ((TextView)findViewById(R.id.txtDisplay)).setText("Lat is"+location.getLatitude()+" "+"Lon is"+location.getLongitude());

            postLocaton(location.getLatitude(),location.getLongitude());

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }


}
