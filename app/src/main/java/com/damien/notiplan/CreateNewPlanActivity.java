package com.damien.notiplan;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.damien.notiplan.Database.AppDatabase;
import com.damien.notiplan.Database.Plan;

import org.w3c.dom.Text;

public class CreateNewPlanActivity extends AppCompatActivity {

    private Plan plan;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_plan);

        database = AppDatabase.getDatabase(getApplicationContext());

        final Button complete = (Button)findViewById(R.id.completeCreatePlan);

        complete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String planName = ((EditText)findViewById(R.id.planNameInput)).getText().toString();
                TextView startTime = findViewById(R.id.startTimeInput);
                SeekBar ringVolumeInput = findViewById(R.id.ringVolumeInput);
                if (!(planName.length() < 3) && startTime.getText() != "")
                {
                    Toast toast = Toast.makeText(CreateNewPlanActivity.this ,"\"" + planName + "\" has been created", Toast.LENGTH_LONG);
                    toast.show();

                    float ringVolume = ringVolumeInput.getProgress();
                    ringVolume = ringVolume/100;

                    plan = new Plan(planName, ringVolume, startTime.getText().toString());
                    database.planDao().addPlan(plan);

                    startActivity(new Intent(CreateNewPlanActivity.this, ManageNotificationPlansActivity.class));
                }
                else
                {
                    Toast toast = Toast.makeText(CreateNewPlanActivity.this ,"Your plan name must be at least 3 characters long/must enter start time", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

        SeekBar ringVolumeInput = findViewById(R.id.ringVolumeInput);
        final TextView ringVolumePercent = findViewById(R.id.ringPercentDisplay);
        ringVolumeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            public void onStopTrackingTouch(SeekBar bar)
            {}

            public void onStartTrackingTouch(SeekBar bar)
            {}

            public void onProgressChanged(SeekBar bar, int paramInt, boolean paramBoolean)
            {
                ringVolumePercent.setText("" + paramInt + "%");
            }
        });

        final TextView setTime;
        setTime = findViewById(R.id.startTimeInput);
        setTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePicker picker = findViewById(R.id.startTimePicker);
                picker.setVisibility(View.VISIBLE);
                complete.setEnabled(false);
            }
        });
        Button pickTime;
        pickTime = findViewById(R.id.pickTimeConfirm);
        pickTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePicker picker = findViewById(R.id.startTimePicker);
                picker.setVisibility(View.GONE);
                String timeText = "";
                int hour;
                int min;
                Boolean isAM = true;
                if(Build.VERSION.SDK_INT < 23){
                    hour = picker.getCurrentHour();
                    min = picker.getCurrentMinute();
                }
                else{
                    hour = picker.getHour();
                    min = picker.getMinute();
                }
                if (hour > 12) {
                    hour = hour - 12;
                    isAM = false;
                }
                if (min > 10) {
                    timeText = Integer.toString(hour) + ":" + Integer.toString(min);
                }
                else {
                    timeText = Integer.toString(hour) + ":0" + Integer.toString(min);
                }
                if (isAM) {
                    timeText += "AM";
                }
                else {
                    timeText += "PM";
                }
                setTime.setText(timeText);
                complete.setEnabled(true);
            }
        });

    }
}
