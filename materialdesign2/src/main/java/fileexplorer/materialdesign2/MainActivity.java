package fileexplorer.materialdesign2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

//Step 1: make layout in layout content
//Step 2: register for context menu
//Step 3: make following methods and implement the logic
//onCreateContextMenu, onContextItemSelected
public class MainActivity extends AppCompatActivity {

    String copiedText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        registerForContextMenu(findViewById(R.id.edtUsername));
        registerForContextMenu(findViewById(R.id.edtPassword));
    }

    public void onLogin(View view){
        //Toast.makeText(this, "Loged In..!!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.actionSettings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.actionProfile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //Creating context: manually type this method and use it to created the context menu
    // context menu is the long press menu (usually referred as right click in computers)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.edtUsername) {
            menu.add(100, 1, 0, "CUT");
            menu.add(100, 2, 1, "COPY");
        } else if (v.getId() == R.id.edtPassword) {
            menu.add(101, 1, 0, "PASTE");
        }
    }

    //Creating context: manually type this method and use it to provide actions on clicking the
    //context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getGroupId() == 100) {

            if (item.getItemId() == 1) {

                copiedText = ((EditText) findViewById(R.id.edtUsername)).getText().toString();
                ((EditText) findViewById(R.id.edtUsername)).setText("");

                Toast.makeText(this, "Cut", Toast.LENGTH_SHORT).show();

            } else if (item.getItemId() == 2) {

                copiedText = ((EditText) findViewById(R.id.edtUsername)).getText().toString();

                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
            }
        } else if (item.getGroupId() == 101) {

            if (item.getItemId() == 1) {

                ((EditText) findViewById(R.id.edtPassword)).setText(copiedText);
            }
        }

        return super.onContextItemSelected(item);
    }
}
