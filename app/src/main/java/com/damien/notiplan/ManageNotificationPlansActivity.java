package com.damien.notiplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.damien.notiplan.Database.AppDatabase;
import com.damien.notiplan.Database.Plan;

import java.util.List;

public class ManageNotificationPlansActivity extends AppCompatActivity {

    private Plan plan;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_notification_plans);

        database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        database.planDao().removeAllPlans();

        List<Plan> plans = database.planDao().getAllPlans();
        if (plans.size()==0) {
            database.planDao().addPlan(new Plan(1, "Nighttime silence", 0, "12:00AM", new int[] {1, 1, 1, 1, 1, 1, 1}));
            database.planDao().addPlan(new Plan(2, "Morning restart", 1, "7:00AM", new int[] {1, 1, 1, 1, 1, 1, 1}));
            database.planDao().addPlan(new Plan(3, "Work silence", 0, "9:00AM", new int[] {0, 1, 1, 1, 1, 1, 0}));
            database.planDao().addPlan(new Plan(1, "Finished work", 0, "5:00PM", new int[] {0, 1, 1, 1, 1, 1, 0}));
            //plan = database.planDao().getAllPlans().get(0);
            //Toast.makeText(this, String.valueOf(plan.startTime), Toast.LENGTH_SHORT).show();
        }
        plans = database.planDao().getAllPlans();

        Button createNew = (Button)findViewById(R.id.createNewPlan);

        createNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ManageNotificationPlansActivity.this, CreateNewPlanActivity.class));
            }
        });
    }
}
