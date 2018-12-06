package com.example.yandre.mobileunivesity.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.mobileunivesity.pojo.Lesson;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ScheduleDao {

    @Query("SELECT * FROM Lesson")
    Flowable<List<Lesson>> getAllSchedule();

    @Query("SELECT * FROM Lesson WHERE id IS :id")
    Single<Lesson> getSchedule(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Lesson lesson);

    @Query("DELETE FROM Lesson WHERE id IS :id")
    void delete(long id);

//    для today schedule по dayWeek
}
