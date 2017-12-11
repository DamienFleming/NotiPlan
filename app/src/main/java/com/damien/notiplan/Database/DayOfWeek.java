package com.damien.notiplan.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Damien on 2017-12-10.
 */

@Entity
public class DayOfWeek {

    @PrimaryKey
    public final int id;
    public String name;
    public int isWeekend;

    public DayOfWeek(int id, String name, int isWeekend) {
        this.id = id;
        this.name = name;
        this.isWeekend = isWeekend;
    }
}
