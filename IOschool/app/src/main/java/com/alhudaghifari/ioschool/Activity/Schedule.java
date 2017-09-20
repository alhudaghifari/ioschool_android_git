package com.alhudaghifari.ioschool.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alhudaghifari.ioschool.R;

public class Schedule extends AppCompatActivity {

    private ScheduleReguler scheduleReguler;

    private Button btnReguler;
    private Button btnUts;
    private Button btnUas;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        scheduleReguler = new ScheduleReguler();// Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

//        mViewPager.setAdapter(scheduleReguler);

        btnReguler = (Button) findViewById(R.id.btn_reguler);
        btnReguler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
