package com.alhudaghifari.ioschool.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/1/2017.
 */

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void toProfile(View view)
    {
        Intent intent = new Intent(HomePage.this, Profile.class);
        startActivity(intent);
    }

    public void toLibrary(View view)
    {
        Intent intent = new Intent(HomePage.this, Library.class);
        startActivity(intent);
    }

    public void toNews(View view)
    {
        Intent intent = new Intent(HomePage.this, News.class);
        startActivity(intent);
    }

    public void toSchedule(View view)
    {
        Intent intent = new Intent(HomePage.this, ScheduleReguler.class);
        startActivity(intent);
    }

    public void toScore(View view)
    {
        Intent intent = new Intent(HomePage.this, Score.class);
        startActivity(intent);
    }

    public void toForum(View view)
    {
        Intent intent = new Intent(HomePage.this, Forum.class);
        startActivity(intent);
    }
}
