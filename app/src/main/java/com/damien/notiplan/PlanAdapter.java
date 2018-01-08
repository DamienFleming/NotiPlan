package com.damien.notiplan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.damien.notiplan.Database.AppDatabase;
import com.damien.notiplan.Database.Plan;

import java.util.List;

/**
 * Created by Damien on 2018-01-07.
 */

public class PlanAdapter extends ArrayAdapter<Plan> {

    private Context context;
    private AppDatabase database;

    public PlanAdapter(Context context, List<Plan> plans) {
        super(context, 0, plans);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        database = AppDatabase.getDatabase(((Activity) context).getApplicationContext());

        final Plan plan = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.plan_item, parent, false);
        }
        TextView planName = convertView.findViewById(R.id.planItemName);
        final ImageButton viewButton = convertView.findViewById(R.id.planItemView);
        final ImageButton editButton = convertView.findViewById(R.id.planItemEdit);
        final ImageButton deleteButton = convertView.findViewById(R.id.planItemDelete);

        planName.setText(plan.name);
        planName.setTag(plan.id);

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Activity activity = (Activity) context;
                LinearLayout viewer = activity.findViewById(R.id.planViewer);
                if (viewer.getVisibility() == View.GONE)
                {
                    viewer.setVisibility(View.VISIBLE);
                    TextView name = activity.findViewById(R.id.planViewer_Name);
                    name.setText(plan.name);
                    TextView ringVolume = activity.findViewById(R.id.planViewer_RingVolume);
                    int volume = (int)(plan.ringVolume * 100);
                    String volumeText = Integer.toString(volume) + "%";
                    ringVolume.setText(volumeText);
                    TextView startTime = activity.findViewById(R.id.planViewer_StartTime);
                    startTime.setText(plan.startTime);
                    ListView planList = activity.findViewById(R.id.planListHolder);
                    planList.setEnabled(false);
                }
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.planDao().removePlan(plan);
                remove(plan);
            }
        });

        return convertView;
    }
}
