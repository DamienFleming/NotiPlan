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
    public String startTime;
//    public int activeOnSunday;
//    public int activeOnMonday;
//    public int activeOnTuesday;
//    public int activeOnWednesday;
//    public int activeOnThursday;
//    public int activeOnFriday;
//    public int activeOnSaturday;


    public Plan(int id, String name, float ringVolume, String startTime) { //, int[] daysOfPlan) {
        this.id = id;
        this.name = name;
        this.ringVolume = ringVolume;
        this.startTime = startTime;
//        this.activeOnSunday = daysOfPlan[0];
//        this.activeOnMonday = daysOfPlan[1];
//        this.activeOnTuesday = daysOfPlan[2];
//        this.activeOnWednesday = daysOfPlan[3];
//        this.activeOnThursday = daysOfPlan[4];
//        this.activeOnFriday = daysOfPlan[5];
//        this.activeOnSaturday = daysOfPlan[6];
    }
}
