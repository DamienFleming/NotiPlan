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
//        for (int i = 1; i <= plans.size(); i++) {
//
//            plan = database.planDao().getPlan(i);
//            float dpScale = getResources().getDisplayMetrics().density;
//
//            //Plan Container/Linear Layout
//            int padding = (int)(10*dpScale + 0.5f);
//            int margin = (int)(10*dpScale + 0.5f);
//            int marginBottom = (int)(4*dpScale + 0.5f);
//            LinearLayout planContainer = new LinearLayout(this);
//            planContainer.setOrientation(LinearLayout.HORIZONTAL);
//            planContainer.setBackground(getResources().getDrawable(R.drawable.plan_container));
//            LayoutParams params = new LayoutParams(
//                    LayoutParams.MATCH_PARENT,
//                    (int)(75*dpScale + 0.5f)
//            );
//            if (i == 1) {
//                params.setMargins(margin, margin, margin, -marginBottom);
//            }
//            else {
//                params.setMargins(margin, 0, margin, -marginBottom);
//            }
//            planContainer.setLayoutParams(params);
//            planContainer.setPadding(padding*2, padding, padding, padding);
//            planContainer.setTag(plan.id);
//
//            //Plan TextView
//            TextView planName = new TextView(this);
//            LayoutParams params2 = new LayoutParams(
//                    0,
//                    LayoutParams.WRAP_CONTENT,
//                    3
//            );
//            params2.gravity = Gravity.CENTER;
//            planName.setLayoutParams(params2);
//            planName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
//            planName.setTextColor(Color.parseColor("#444444"));
//            planName.setText(plan.name);
//            planName.setTypeface(Typeface.DEFAULT);
//
//            //View Button
//            final ImageButton viewButton = new ImageButton(this);
//            LayoutParams params3 = new LayoutParams(
//                    0,
//                    LayoutParams.WRAP_CONTENT,
//                    1
//            );
//            params3.gravity = Gravity.CENTER;
//            viewButton.setLayoutParams(params3);
//            viewButton.setImageResource(android.R.drawable.ic_menu_view);
//            viewButton.setContentDescription("View");
//            viewButton.setTag(plan.id);
//            viewButton.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    LinearLayout viewer = findViewById(R.id.planViewer);
//                    if (viewer.getVisibility() == View.GONE)
//                    {
//                        viewer.setVisibility(View.VISIBLE);
//                        TextView name = findViewById(R.id.planViewer_Name);
//                        name.setText(database.planDao().getPlan((int)(viewButton.getTag())).name);
//                        TextView ringVolume = findViewById(R.id.planViewer_RingVolume);
//                        int volume = (int)(database.planDao().getPlan((int)(viewButton.getTag())).ringVolume * 100);
//                        String volumeText = Integer.toString(volume) + "%";
//                        ringVolume.setText(volumeText);
//                        TextView startTime = findViewById(R.id.planViewer_StartTime);
//                        startTime.setText(database.planDao().getPlan((int)(viewButton.getTag())).startTime);
//                        LinearLayout planList = findViewById(R.id.planListHolder);
//                        planList.setEnabled(false);
//                    }
//                }
//            });
//
//            //Edit Button
//            final ImageButton editButton = new ImageButton(this);
//            editButton.setLayoutParams(params3);
//            editButton.setImageResource(android.R.drawable.ic_menu_edit);
//            editButton.setContentDescription("Edit");
//            editButton.setTag(plan.id);
////            editButton.setOnClickListener(new View.OnClickListener() {
////                public void onClick(View v) {
////                    Intent intent = new Intent(ManageNotificationPlansActivity.this, CreateNewPlanActivity.class);
////                    intent.putExtra("editPlanId", (int)(editButton.getTag()));
////                    startActivity(intent);
////                }
////            });
//
//            //Delete Button
//            final ImageButton deleteButton = new ImageButton(this);
//            deleteButton.setLayoutParams(params3);
//            deleteButton.setImageResource(android.R.drawable.ic_menu_delete);
//            deleteButton.setContentDescription("Delete");
//            deleteButton.setTag(plan.id);
//            deleteButton.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    database.planDao().removePlan(database.planDao().getPlan((int)(deleteButton.getTag())));
//                    finish();
//                    overridePendingTransition(0, 0);
//                    startActivity(getIntent());
//                    overridePendingTransition(0, 0);
//                }
//            });
//
//
//
//            //Add items to screen
//            planContainer.addView(planName);
//            planContainer.addView(viewButton);
//            planContainer.addView(editButton);
//            planContainer.addView(deleteButton);
//            LinearLayout layout = findViewById(R.id.planListHolder);
//            layout.addView(planContainer, i);
//        }
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
