package com.damien.notiplan;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

import com.damien.notiplan.Database.AppDatabase;
import com.damien.notiplan.Database.Plan;

import java.util.List;

public class ManageNotificationPlansActivity extends AppCompatActivity {

    private Plan plan;
    private AppDatabase database;

    private void instantiatePlanList() {
        database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        //database.planDao().removeAllPlans();

        List<Plan> plans = database.planDao().getAllPlans();
//        if (plans.size()==0) {
//            database.planDao().addPlan(new Plan("Nighttime silence", 0, "12:00AM"));//, new int[] {1, 1, 1, 1, 1, 1, 1}));
//            database.planDao().addPlan(new Plan("Morning restart", 1, "7:00AM"));//, new int[] {1, 1, 1, 1, 1, 1, 1}));
//            database.planDao().addPlan(new Plan("Work silence", 0, "9:00AM"));//, new int[] {0, 1, 1, 1, 1, 1, 0}));
//            database.planDao().addPlan(new Plan("Finished work", 1, "5:00PM"));//, new int[] {0, 1, 1, 1, 1, 1, 0}));
//            //plan = database.planDao().getAllPlans().get(0);
//            //Toast.makeText(this, String.valueOf(plan.startTime), Toast.LENGTH_SHORT).show();
//        }

        PlanAdapter adapter = new PlanAdapter(this, plans);
        ListView listView = (ListView) findViewById(R.id.planListHolder);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_notification_plans);

        instantiatePlanList();

        Button createNew = (Button)findViewById(R.id.createNewPlan);
        createNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ManageNotificationPlansActivity.this, CreateNewPlanActivity.class));
            }
        });

        Button closeplanViewer = (Button)findViewById(R.id.closePlanViewer);
        closeplanViewer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout viewer = findViewById(R.id.planViewer);
                viewer.setVisibility(View.GONE);
                ListView planList = findViewById(R.id.planListHolder);
                planList.setEnabled(true);
            }
        });
    }
}
