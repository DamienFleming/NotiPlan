package com.damien.notiplan.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Damien on 2017-12-10.
 */

@Dao
public interface DayOfWeekDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addDay(DayOfWeek dayOfWeek);
}
