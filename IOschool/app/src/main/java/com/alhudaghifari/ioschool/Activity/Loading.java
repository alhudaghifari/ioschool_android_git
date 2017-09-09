package com.alhudaghifari.ioschool.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;
import com.alhudaghifari.ioschool.helper.SessionManager;

/**
 * Created by Alhudaghifari on 9/1/2017.
 */

public class Loading extends AppCompatActivity {

    private static final int GOTOLOGINPAGE = 1;
    private static final int GOTOHOMEPAGE = 2;

    //time in milliseconds
    private static final long SPLASHTIME = 2000;

    private ImageView splash_mid;

    private SessionManager session;

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
                    splash_mid.setVisibility(View.GONE);
                    intentpindah = new Intent(Loading.this, LoginActivity.class);
                    Loading.this.startActivity(intentpindah);
                    Loading.this.finish();
                    break;
                case GOTOHOMEPAGE:
                    splash_mid.setVisibility(View.GONE);
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
        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(this.getResources().getColor(R.color.blue_main_color));

        //Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loading);

        splash_mid = (ImageView) findViewById(R.id.splashscreen_mid);

        // Session manager
        session = new SessionManager(getApplicationContext());

        Message msg = new Message();

        if (session.isLoggedIn())
            msg.what = GOTOHOMEPAGE;
        else
            msg.what = GOTOLOGINPAGE;

        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
    }
}
