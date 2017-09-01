package com.alhudaghifari.loschool;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.alhudaghifari.loschool.Activity.HomePage;
import com.alhudaghifari.loschool.Activity.LoginActivity;

public class Loading extends AppCompatActivity {

    private static final int GOTOLOGINPAGE = 1;
    private static final int GOTOHOMEPAGE = 2;

    //time in milliseconds
    private static final long SPLASHTIME = 2000;

    private ImageView splash;

    //handler for splash screen
    private Handler splashHandler = new Handler() {
        /* (non-Javadoc)
         * @see android.os.Handler#handleMessage(android.os.Message)
         */
        @Override
        public void handleMessage(Message msg) {
            Intent intentpindah;
            switch (msg.what) {
                case GOTOLOGINPAGE:
                    //remove SplashScreen from view
                    splash.setVisibility(View.GONE);
                    intentpindah = new Intent(Loading.this, LoginActivity.class);
                    Loading.this.startActivity(intentpindah);
                    Loading.this.finish();
                    break;
                case GOTOHOMEPAGE:
                    splash.setVisibility(View.GONE);
                    intentpindah = new Intent(Loading.this, HomePage.class);
                    Loading.this.startActivity(intentpindah);
                    Loading.this.finish();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_loading);
        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        splash = (ImageView) findViewById(R.id.splashscreen);

        boolean isLogged = isLogged();
        Message msg = new Message();

        if (isLogged)
            msg.what = GOTOHOMEPAGE;
        else
            msg.what = GOTOLOGINPAGE;

        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
    }

    private boolean isLogged() {
        Context context = this;
        SharedPreferences mPrefs;
        mPrefs = context.getSharedPreferences(getString(R.string.this_app), Context.MODE_PRIVATE);

        boolean isLogged;
        isLogged = mPrefs.getBoolean(Constant.isLogin,false);

        return isLogged;
    }
}
