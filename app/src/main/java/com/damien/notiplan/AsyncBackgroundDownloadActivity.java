package com.damien.notiplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AsyncBackgroundDownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_background_download);

        Intent intent = new Intent(getApplicationContext(), NotiplanBackgroundService.class);
        startService(intent);
    }
}
