package com.alhudaghifari.ioschool.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/1/2017.
 */

public class HomePage extends AppCompatActivity {

    private ImageButton btnScore;
    private ImageButton btnSchedule;
    private ImageButton btnLibrary;
    private ImageButton btnNews;
    private ImageButton btnForum;
    private ImageButton btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        initializeView();

    }

    private void initializeView() {
        btnScore = (ImageButton) findViewById(R.id.btnMyScore);
        btnSchedule = (ImageButton) findViewById(R.id.btnMySchedule);
        btnLibrary = (ImageButton) findViewById(R.id.btnMyLibrary);
        btnNews = (ImageButton) findViewById(R.id.btnMyNews);
        btnForum = (ImageButton) findViewById(R.id.btnMyForum);
        btnProfile = (ImageButton) findViewById(R.id.btnMyProfile);
    }

    public void toProfile(View view)
    {
        Intent intent = new Intent(HomePage.this, Profile.class);
        startActivity(intent);
    }
}
