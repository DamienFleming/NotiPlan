package com.damien.notiplan;


import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppSettingsFragment extends PreferenceFragment {

    public static Toast settingsToast = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        SwitchPreference pref = (SwitchPreference)findPreference("enable_notiplan");
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                return false;
            }
        });
//        pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//            @Override
//            public boolean onPreferenceChange(Preference preference, Object o) {
//                String notiEnabled;
//                SwitchPreference pref = (SwitchPreference)findPreference("enable_notiplan");
//                if (pref.isChecked())
//                {
//                    notiEnabled = "Enabled";
//                }
//                else
//                {
//                    notiEnabled = "Disabled";
//                }
//                if(settingsToast != null)
//                {
//                    settingsToast.cancel();
//                    settingsToast = null;
//                }
//                if(settingsToast == null)
//                {
//                    settingsToast = Toast.makeText((AppSettingsActivity)getActivity() ,"NotiPlanner has been " + notiEnabled, Toast.LENGTH_SHORT);
//                    settingsToast.show();
//                }
//                return false;
//            }
//        });
    }

}
