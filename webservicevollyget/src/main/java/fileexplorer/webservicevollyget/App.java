package fileexplorer.webservicevollyget;

import android.app.Application;

import com.google.gson.Gson;

import java.lang.ref.ReferenceQueue;

/**
 * Created by rtb on 22/6/17.
 */

public class App extends Application {

    private Gson gson;
    private ReferenceQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();

        gson = new Gson();
        queue = new ReferenceQueue()
    }
}
