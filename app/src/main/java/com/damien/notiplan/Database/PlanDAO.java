package com.damien.notiplan.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Damien on 2017-11-29.
 */

@Dao
public interface PlanDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPlan(Plan plan);

    @Query("select * from user")
    public List<Plan> getAllPlans();

    @Query("select * from user where id = :planId")
    public List<Plan> getPlan(int planId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePlan(Plan plan);

    @Query("delete from user")
    void removeAllPlans();
}