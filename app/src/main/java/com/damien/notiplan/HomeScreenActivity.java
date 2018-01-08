package com.damien.notiplan;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.damien.notiplan.Database.AppDatabase;


public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button settingsButton = (Button)findViewById(R.id.settingsButton);
        Button manageButton = (Button)findViewById(R.id.manageButton);
        Button aboutButton = (Button)findViewById(R.id.aboutButton);
        Button asyncButton = (Button)findViewById(R.id.AsyncBackgroundDownloadButton);

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
        asyncButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeScreenActivity.this, AsyncBackgroundDownloadActivity.class));
            }
        });

        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            String id = "NotiplanChannel";
            CharSequence name = "NotiPlan";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(id, name, importance);
            mNotificationManager.createNotificationChannel(mChannel);
        }
    }

}
