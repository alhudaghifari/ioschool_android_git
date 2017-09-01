package com.alhudaghifari.loschool.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.alhudaghifari.loschool.R;

/**
 * Created and edited by Alhudaghifari on 8/27/2017.
 * with source code from Gulajava Ministudio.
 */

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_homepage);
    }
}
