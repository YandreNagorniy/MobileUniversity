package com.example.yandre.mobileunivesity.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Lesson {
    @PrimaryKey
    private long id;
    private String startTime;
    private String endTime;
    private String typeOccupation;
    private String subjectName;
    private String classRoom;
    private String teacherName;
    private Boolean homeWork;
    private String dayOfWeek;

    public Lesson(long id, String startTime, String endTime, String typeOccupation,
                  String subjectName, String classRoom, String teacherName, Boolean homeWork, String dayOfWeek) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.typeOccupation = typeOccupation;
        this.subjectName = subjectName;
        this.classRoom = classRoom;
        this.teacherName = teacherName;
        this.homeWork = homeWork;
        this.dayOfWeek = dayOfWeek;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTypeOccupation() {
        return typeOccupation;
    }

    public void setTypeOccupation(String typeOccupation) {
        this.typeOccupation = typeOccupation;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Boolean getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(Boolean homeWork) {
        this.homeWork = homeWork;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
