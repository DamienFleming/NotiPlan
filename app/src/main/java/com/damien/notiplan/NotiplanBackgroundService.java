package com.damien.notiplan;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Damien on 2018-01-08.
 */

public class NotiplanBackgroundService extends IntentService {

    //private Context context;

    public NotiplanBackgroundService() {
        super("com.damien.notiplan.NotiplanBackgroundService");
        //this.context = context;
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        DownloadWebPageTask task = new DownloadWebPageTask();
        task.execute(new String[]{"https://raw.githubusercontent.com/DamienFleming/gibsonAccessibility/master/README.md"});
    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            // we use the OkHttp library from https://github.com/square/okhttp
            OkHttpClient client = new OkHttpClient();
            Request request =
                    new Request.Builder()
                            .url(urls[0])
                            .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    return response.body().string();
                }
                return null;
            } catch (IOException e) {
                return null;
            }
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(NotiplanBackgroundService.this, result, Toast.LENGTH_LONG).show();
        }
    }


}

