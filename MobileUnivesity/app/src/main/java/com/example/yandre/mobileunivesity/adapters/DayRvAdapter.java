package com.example.yandre.mobileunivesity.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yandre.mobileunivesity.R;
import com.example.yandre.mobileunivesity.databinding.CardDayBinding;
import com.example.yandre.mobileunivesity.pojo.Day;
import com.example.yandre.mobileunivesity.pojo.Lesson;

import java.util.List;

public class DayRvAdapter extends RecyclerView.Adapter<DayRvAdapter.DayHolder> {
    private Context mContext;
    private List<String> dayList;
    private List<Lesson> lessonList;

    public DayRvAdapter(Context context, List<String> dayList, List<Lesson> lessonList) {
        mContext = context;
        this.dayList = dayList;
        this.lessonList = lessonList;
    }

    @NonNull
    @Override
    public DayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        CardDayBinding binding = DataBindingUtil.inflate(inflater, R.layout.card_lesson, parent, false);

        return new DayHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DayHolder holder, int position) {
     //   holder.dayBinding.setDay(dayList.get(position));


        //заполняем парами RV
        RecyclerView.Adapter adapter = new LessonRvAdapter(mContext, lessonList);
        holder.dayBinding.lessonRv.setAdapter(adapter);

        //обрабатываем нажатие "добавить пару"
        holder.dayBinding.addLessonIv.setOnClickListener(v -> {
            //intent addChangeActivity
        });
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public class DayHolder extends RecyclerView.ViewHolder {
        CardDayBinding dayBinding;

        public DayHolder(CardDayBinding dayBinding) {
            super(dayBinding.getRoot());
            this.dayBinding = dayBinding;
        }
    }
}
