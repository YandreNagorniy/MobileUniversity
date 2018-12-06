package com.example.yandre.mobileunivesity;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.yandre.mobileunivesity.database.AppDatabase;

public class App extends Application {
    public static App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "appDatabase")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
