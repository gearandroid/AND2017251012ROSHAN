package gonotepad.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Android@codekul.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // Include permission in Manifest file
    //External memory has two parts: 1) Private-App specific, 2) Shared-can be accessed by Public
    //Hence R/W for appPrivate  and  R/W for publicShared
    //newPublicFolder() - method to make a folder which is publicly accessible
    //populateList() - method to (make+show) a list of directories
    //isMediaAvailable() -

    public void onAPRead(View view) {
        appPrivateRead();
    }
    public void onAPWrite(View view) {
        appPrivateWrite();
    }

    private void appPrivateRead() {

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),"testing.txt");
        StringBuilder builder = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(file);

            while (true){
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "Reading file "+" "+builder.toString());
        ((TextView)findViewById(R.id.txtAPInfo)).setText(builder.toString());
    }

    private void appPrivateWrite() {
        File file = new File(getExternalFilesDir(" "),"testing.txt");

        Log.i(TAG,"AppPrivate Path -"+file.getAbsolutePath());

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("Thsi is content of my.txt file".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(TAG,"AppPrivate Path -"+file.getAbsolutePath());
        ((TextView)findViewById(R.id.txtAPInfo)).setText(file.getAbsolutePath());

    }


    public void onPSREAD(View view) {

        if(isMediaAvailable()){
            File file =  new  File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"test2.txt");

            StringBuilder builder = new StringBuilder();

            try {
                FileInputStream fis = new FileInputStream(file);
                while (true){
                    int ch = fis.read();
                    if(ch == -1) break;
                    else builder.append((char)ch);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.i(TAG,builder.toString());
            ((TextView)findViewById(R.id.txtPSINfo)).setText(builder.toString());
        }else {

            Log.i(TAG,"Bad Media File");
        }


    }

    private boolean isMediaAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public void onPSWrite(View view) {
        if(isMediaAvailable()){
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"test2   .txt");

            Log.i(TAG,"AppPrivate Path -"+file.getAbsolutePath());

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("Thsi is content of my.txtx file".getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ((TextView)findViewById(R.id.txtPSINfo)).setText(file.getAbsolutePath());
            Log.i(TAG,"AppPrivate Path -"+file.getAbsolutePath());

        }else {
            Log.i(TAG,"BAD MEDIA FILE");
        }
    }
}
