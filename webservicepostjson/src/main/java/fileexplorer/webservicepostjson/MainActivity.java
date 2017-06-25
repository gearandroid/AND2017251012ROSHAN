package fileexplorer.webservicepostjson;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

//This code runs successfully above marshmallow
//in marshmallow or below, the app needs to be given permission explicitly through app settings

public class MainActivity extends AppCompatActivity {

    private LocationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1: initializing manager
        manager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //2: taking permissions
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }

        //3: Requesting Location updates as location will keep on changing
        //Remember these 4 parameters. We provide location
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                500,
                0.1f,
                new Mylocation());
    }

    //Defining MyLocation class
    public class Mylocation implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
            //get latitude and longitude of app/ nd can use it anywhere
            //we will use it to display on txt box and pass to post the location
            //location.getLatitude();
            //location.getLongitude();

            //setting in txt box
            ((TextView)findViewById(R.id.txtShow)).setText("Latitude is " + location.getLatitude()+"\n"
                    +"Longitude is "+location.getLongitude());
            Log.i("@code:"," "+location.getLatitude());

            //posting the location
            postLocation(location.getLatitude(),location.getLongitude());
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

    private void postLocation(double latitude, double longitude) {
        //create Json object
        JSONObject locationObject = new JSONObject();

        //use App to hve its requestQueue()
        final App app = (App) getApplication();

        //Actually posting our request here: Observe the 4 parameters of the method
        //To have the URL as 1st parameter, one can use FireBase as a temporary database which reacts at real-time
        //I created a database whose link i am using as the URL here: Real-time response can be seen there at firebase
        //As the app/device changes the location, we can see it enlisting in the firebase database which we created
        app.requestQueue().add(new JsonObjectRequest(" https://webposttest-31937.firebaseio.com/",

                locationObject,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //can do any thing while the requested is posted
                        Toast.makeText(app,"REQUESTED POSTED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //show/notify error message
                        Toast.makeText(app,"This is error message",Toast.LENGTH_SHORT).show();
                    }
                }));
    }

}
