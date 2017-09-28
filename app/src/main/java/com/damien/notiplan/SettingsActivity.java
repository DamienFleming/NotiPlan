package com.damien.notiplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {

    public static Toast settingsToast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void enableNotiPlanner(View v){
        String notiEnabled;
        ToggleButton toggle = (ToggleButton) findViewById(R.id.PlannerOnOff);
        if (toggle.isChecked())
        {
            notiEnabled = "Enabled";
        }
        else
        {
            notiEnabled = "Disabled";
        }
        if(settingsToast != null)
        {
            settingsToast.cancel();
            settingsToast = null;
        }
        if(settingsToast == null)
        {
            settingsToast = Toast.makeText(SettingsActivity.this ,"NotiPlanner has been " + notiEnabled, Toast.LENGTH_LONG);
            settingsToast.show();
        }
    }
}
