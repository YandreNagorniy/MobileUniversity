package com.example.yandre.mobileunivesity.ui.delete;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.mobileunivesity.R;

/**
 * Created by Yandre on 27.02.2018.
 */

public class SentFragment extends Fragment {
    public SentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sent, container, false);
    }

}

