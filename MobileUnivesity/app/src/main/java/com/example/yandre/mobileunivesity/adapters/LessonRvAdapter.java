package com.example.yandre.mobileunivesity.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yandre.mobileunivesity.R;
import com.example.yandre.mobileunivesity.databinding.CardLessonBinding;
import com.example.yandre.mobileunivesity.pojo.Lesson;
import com.example.yandre.mobileunivesity.ui.lesson.LessonActivity;

import java.util.List;

public class LessonRvAdapter extends RecyclerView.Adapter<LessonRvAdapter.LessonHolder> {
    private Context mContext;
    private List<Lesson> lessonList;

    //передавать контекст фрагмента..
    public LessonRvAdapter(Context mContext, List<Lesson> lessonList) {
        this.mContext = mContext;
        this.lessonList = lessonList;
    }

    @NonNull
    @Override
    public LessonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        CardLessonBinding binding = DataBindingUtil.inflate(inflater, R.layout.card_lesson, parent, false);

        return new LessonHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonHolder holder, int position) {
        holder.lessonBinding.setLesson(lessonList.get(position));

        holder.itemView.setOnClickListener(v -> {
            //тут открываю LessonActivity передаю в него some id и
            //   String date = lessonList.get(position).getDate();
            if (v.getId() == R.id.addLesson_Iv) {
                long lessonId = lessonList.get(position).getId();
                Intent intent = new Intent(mContext, LessonActivity.class);
                //  intent.putExtra("date", date);
                intent.putExtra("subjectName", lessonId);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public class LessonHolder extends RecyclerView.ViewHolder {
        CardLessonBinding lessonBinding;

        public LessonHolder(CardLessonBinding lessonBinding) {
            super(lessonBinding.getRoot());
            this.lessonBinding = lessonBinding;
        }
    }
}
