package au.com.advproj.testapp;


import android.R;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

    //gLocals
    String classes[] = { "MainActivity", "TextPlay", "Email", "Camera", "Data", "example5" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item_1, classes));
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
       return super.onCreateOptionsMenu(menu);
    }
}
