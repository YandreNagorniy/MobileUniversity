package com.example.yandre.mobileunivesity.ui.schedule.tabs;

import android.annotation.SuppressLint;

import com.example.yandre.mobileunivesity.App;
import com.example.yandre.mobileunivesity.R;
import com.example.yandre.mobileunivesity.ResourceManager;
import com.example.yandre.mobileunivesity.database.ScheduleDao;
import com.example.yandre.mobileunivesity.pojo.Day;
import com.example.yandre.mobileunivesity.pojo.Lesson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SchedulePresenter implements SchedulePresenterInterface {
    private WeekTabInterface weekTabInterface;
    private Disposable disposable;
    private ScheduleDao scheduleDao;
    private List<Lesson> lessonList;
    private static List<String> dayList;
    private ResourceManager resourceManager;

    SchedulePresenter(WeekTabInterface weekTabInterface, ResourceManager resourceManager) {
        this.weekTabInterface = weekTabInterface;
        scheduleDao = App.getInstance().getDatabase().scheduleDao();
        dayList = new ArrayList<>();
        lessonList = new ArrayList<>();
        this.resourceManager = resourceManager;
    }

    public void loadData(List<Lesson> lessonList) {
        if (lessonList != null) {
            getDayList();
            weekTabInterface.displaySchedule(dayList, lessonList);
        } else {
            weekTabInterface.showAlertDialog(
                    resourceManager.getString(R.string.scheduleNotFound),
                    resourceManager.getString(R.string.load_from_server));
        }
    }

    @Override
    public void loadFromDataBase() {
        disposable = scheduleDao.getAllSchedule()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loadData);
    }

    @Override
    public void loadFromServer() {
        //получаем данные с сайта кубгау
        //сейчас просто смоделируем
        for (int i = 0; i < 4; i++) {
            lessonList.add(new Lesson(i, "08:00", "09:30", "Лекция",
                    "Разработка кросплатформенных приложений", "203эк",
                    "Мурлин А.Г.", false, "1"));
            lessonList.add(new Lesson(i, "08:00", "09:30", "Лекция",
                    "Разработка кросплатформенных приложений", "203эк",
                    "Мурлин А.Г.", false, "1"));
        }
    }


    public static void getDayList() {
        Calendar calendar = Calendar.getInstance();
        String date;
        int dayOfWeek;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("E d MMM ");

        //Опред. тек. дня нед.(-1)
        if (calendar.get(Calendar.DAY_OF_WEEK) > 1) {
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        } else dayOfWeek = 7;

        calendar.add(Calendar.DATE, -dayOfWeek + 1);

        for (int i = 0; i < 7; i++) {
            date = formatter.format(calendar.getTime());
            dayList.add(date);
            calendar.add(Calendar.DATE, 1);
        }
    }

    @Override
    public void destroyed() {

    }

}
