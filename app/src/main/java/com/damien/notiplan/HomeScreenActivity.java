package com.damien.notiplan;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.damien.notiplan.Database.AppDatabase;


public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button settingsButton = (Button)findViewById(R.id.settingsButton);
        Button manageButton = (Button)findViewById(R.id.manageButton);
        Button aboutButton = (Button)findViewById(R.id.aboutButton);

        //this.deleteDatabase("userdatabase");
        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeScreenActivity.this, AppSettingsActivity.class));
            }
        });
        manageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeScreenActivity.this, ManageNotificationPlansActivity.class));
            }
        });
        aboutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeScreenActivity.this, AboutActivity.class));
            }
        });
    }
}
