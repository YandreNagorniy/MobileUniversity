package com.example.yandre.mobileunivesity.ui.schedule.tabs;

import android.app.AlertDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yandre.mobileunivesity.R;
import com.example.yandre.mobileunivesity.ResourceManager;
import com.example.yandre.mobileunivesity.adapters.DayRvAdapter;
import com.example.yandre.mobileunivesity.databinding.FragmentFirstweekBinding;
import com.example.yandre.mobileunivesity.pojo.Day;
import com.example.yandre.mobileunivesity.pojo.Lesson;

import java.util.List;

public class FirstWeekTab extends Fragment implements WeekTabInterface {
    FragmentFirstweekBinding binding;
    SchedulePresenterInterface schedulePresenter;
    AlertDialog.Builder alertDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_firstweek, container, false);
        schedulePresenter = new SchedulePresenter(this, new ResourceManager(getContext()));

        binding.dayRv.setLayoutManager(new LinearLayoutManager(getContext()));
        schedulePresenter.loadFromDataBase();

        return binding.getRoot();
    }

    @Override
    public void displaySchedule(List<String> dayList, List<Lesson> lessonList) {
        if (dayList != null && lessonList != null) {
            RecyclerView.Adapter adapter = new DayRvAdapter(getActivity(), dayList, lessonList);
            binding.dayRv.setAdapter(adapter);
        } else Toast.makeText(getActivity(), "Список пуст", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlertDialog(String alertTitle, String message) {
        alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle(alertTitle);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Ок", (dialog, which) -> schedulePresenter.loadFromServer());
        alertDialog.setNegativeButton("Нет", (dialog, which) -> {
        });
        alertDialog.show();
    }
}
