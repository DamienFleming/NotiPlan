package com.damien.notiplan.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by Damien on 2017-11-29.
 */

@Entity
public class Plan {

    @PrimaryKey
    public final int id;
    public String name;
    public float ringVolume;
    public LocalTime startTime;
    public DayOfWeek[] daysOfPlan;

    public Plan(int id, String name, float ringVolume, LocalTime startTime, DayOfWeek[] daysOfPlan) {
        this.id = id;
        this.name = name;
        this.ringVolume = ringVolume;
        this.startTime = startTime;
        this.daysOfPlan = daysOfPlan;
    }
}
