package com.damien.notiplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_plan);

        Button complete = (Button)findViewById(R.id.completeCreatePlan);


        complete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String planName = ((EditText)findViewById(R.id.planNameInput)).getText().toString();
                if (!(planName.length() < 3))
                {
                    Toast toast = Toast.makeText(CreateNewPlanActivity.this ,"\"" + planName + "\" has been created", Toast.LENGTH_LONG);
                    toast.show();
                    startActivity(new Intent(CreateNewPlanActivity.this, ManageNotificationPlansActivity.class));
                }
                else
                {
                    Toast toast = Toast.makeText(CreateNewPlanActivity.this ,"Your plan name must be at least 3 characters long.", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });
    }
}