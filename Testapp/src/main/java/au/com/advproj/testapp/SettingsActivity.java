package au.com.advproj.testapp;



import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;


public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Setting ContentView to Fragment.
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefFrag()).commit();
    }

    public static class PrefFrag extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.prefs);
        }
    }
}


