package com.damien.notiplan.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Damien on 2017-12-10.
 */


@Entity(tableName = "planDays",
        foreignKeys = {
                @ForeignKey(
                        entity = Plan.class,
                        parentColumns = "id",
                        childColumns = "planId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = DayOfWeek.class,
                        parentColumns = "id",
                        childColumns = "dayId",
                        onDelete = ForeignKey.CASCADE
                )}
)
public class PlanDays {

    @PrimaryKey
    public final int id;
    public int planId;
    public int dayId;

    public PlanDays(int id, int planId, int dayId) {
        this.id = id;
        this.planId = planId;
        this.dayId = dayId;
    }
}
