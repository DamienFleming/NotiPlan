package com.damien.notiplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageNotificationPlansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_notification_plans);

        Button createNew = (Button)findViewById(R.id.createNewPlan);

        createNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ManageNotificationPlansActivity.this, CreateNewPlanActivity.class));
            }
        });
    }
}
