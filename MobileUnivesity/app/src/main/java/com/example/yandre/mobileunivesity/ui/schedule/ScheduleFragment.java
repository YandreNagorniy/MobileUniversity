package com.example.yandre.mobileunivesity.ui.schedule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.mobileunivesity.R;
import com.example.yandre.mobileunivesity.ui.schedule.tabs.FirstWeekTab;
import com.example.yandre.mobileunivesity.ui.schedule.tabs.SecondWeekTab;
import com.example.yandre.mobileunivesity.ui.schedule.tabs.TodayTab;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ScheduleFragment extends Fragment {
    private Unbinder unbinder;

    @BindView(R.id.tabLay) TabLayout tabLay;
    @BindView(R.id.viewPager) ViewPager viewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        unbinder = ButterKnife.bind(this, view);

        class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {

                switch (position){
                    case 0:
                        TodayTab tab1 = new TodayTab();
                        return tab1;
                    case 1:
                        FirstWeekTab tab2 = new FirstWeekTab();
                        return tab2;
                    case 2:
                        SecondWeekTab tab3 = new SecondWeekTab();
                        return tab3;
                    default: return null;
                }
            }

            @Override
            public int getCount() {
                // Show 3 total pages.
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "Сегодня";
                    case 1:
                        return "1 неделя";
                    case 2:
                        return "2 неделя";
                }
                return null;
            }
        }

        viewPager.setAdapter(new SectionsPagerAdapter( getChildFragmentManager()));

        tabLay.post(new Runnable() {
            @Override
            public void run() {
                tabLay.setupWithViewPager(viewPager);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
