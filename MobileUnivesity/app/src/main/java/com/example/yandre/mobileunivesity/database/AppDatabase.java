package com.example.yandre.mobileunivesity.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.yandre.mobileunivesity.pojo.Lesson;

@Database(entities = {Lesson.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ScheduleDao scheduleDao();
}
