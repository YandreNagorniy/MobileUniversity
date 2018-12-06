package com.example.yandre.mobileunivesity.ui.schedule.tabs;

import com.example.yandre.mobileunivesity.pojo.Day;
import com.example.yandre.mobileunivesity.pojo.Lesson;

import java.util.List;

public interface WeekTabInterface {
    void displaySchedule(List<String> dayList, List<Lesson> lessonList);
    void showAlertDialog(String alertTitle, String alertMessage);
}
