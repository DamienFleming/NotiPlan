package com.damien.notiplan.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Damien on 2017-11-29.
 */

@Dao
public interface PlanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPlan(Plan plan);

    @Query("select * from plan")
    public List<Plan> getAllPlans();

    @Query("select * from plan where id = :planId")
    public Plan getPlan(int planId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePlan(Plan plan);

    @Query("delete from plan")
    void removeAllPlans();

    @Delete
    void removePlan(Plan plan);
}