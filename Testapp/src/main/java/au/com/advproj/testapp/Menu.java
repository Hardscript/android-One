package au.com.advproj.testapp;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {


    String classes[] = { "MainActivity", "TextPlay", "Email", "Camera", "Data", "SettingsActivity" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes));

        //Sets Default Preferences.
        PreferenceManager.setDefaultValues(this, R.xml.prefs,false);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String lstrClass = classes[position];

        try{
            Class ourClass = Class.forName("au.com.advproj.testapp." + lstrClass);
            Intent ourIntent = new Intent(this, ourClass);
            startActivity(ourIntent);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.aboutUs:
               Intent i = new Intent(".ABOUT");
               startActivity(i);
               break;
           case R.id.preferences:
               break;

       }
        return false;
    }
}
