package com.damien.notiplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.damien.notiplan.Database.Plan;

import java.util.List;

/**
 * Created by Damien on 2018-01-07.
 */

public class PlanAdapter extends ArrayAdapter<Plan> {

    public PlanAdapter(Context context, List<Plan> plans) {
        super(context, 0, plans);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Plan plan = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.plan_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.planItemName);
        // Populate the data into the template view using the data object
        tvName.setText(plan.name);
        // Return the completed view to render on screen
        return convertView;
    }
}
