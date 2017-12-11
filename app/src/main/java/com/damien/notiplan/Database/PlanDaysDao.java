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
public interface PlanDaysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPlanDay(PlanDays planDays);

    @Query("SELECT * FROM planDays WHERE planId=:planId")
    List<PlanDays> findDaysForPlan(int planId);

    @Query("delete from planDays where dayId = :dayId and planId = :planId")
    void deleteDayFromPlan(int dayId, int planId);
}
