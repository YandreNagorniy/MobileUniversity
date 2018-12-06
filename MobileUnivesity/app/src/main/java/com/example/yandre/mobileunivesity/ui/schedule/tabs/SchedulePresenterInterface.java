package com.example.yandre.mobileunivesity.ui.schedule.tabs;

import com.example.yandre.mobileunivesity.pojo.Lesson;

import java.util.List;

public interface SchedulePresenterInterface {
    void loadData(List<Lesson> lessonList);
    void loadFromDataBase();
    void loadFromServer();
    void destroyed();
}
