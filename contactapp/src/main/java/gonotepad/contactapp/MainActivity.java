package gonotepad.contactapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //readContacts();
        myData();
    }


    //Include permission in manifest
    //Also,after launching app, manually enable the permission
    //then the app will execute successfully

    private void readContacts() {

        //1: List+Adapter
        List<String> contacts = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);

        //2: ContentResolver+cursor
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER},
                null,
                null,
                null
        );

        //3:getname,number from cursor
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            contacts.add(name +"\n"+number);
        }

        ((ListView)findViewById(R.id.lstContactList)).setAdapter(adapter);

    }

    private void myData() {

        //1:
        List<String> contacts = new ArrayList<>();
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);

        //2:
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(Uri.parse("content://com.codekul.read.PROJECT"),
                new String[]{"id","name"},
                null,
                null,
                null
        );

        if(cursor != null){
            while (cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));

                contacts.add(id+ "\n" + name);
            }
        }


    }
}
