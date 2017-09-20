package com.alhudaghifari.ioschool.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.alhudaghifari.ioschool.Adapters.RecyclerQuiz;
import com.alhudaghifari.ioschool.Adapters.RecyclerRaport;
import com.alhudaghifari.ioschool.Adapters.RecyclerUtsUas;
import com.alhudaghifari.ioschool.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Score extends AppCompatActivity {

    private TextView mTextMessage;

    private RecyclerView mRecyclerViewQuiz;
    private RecyclerView mRecyclerViewUtsUas;
    private RecyclerView mRecyclerViewRaport;

    private Toast toast;

    private RecyclerQuiz mRecyclerQuiz;
    private RecyclerQuiz.OnArtikelClickListener mOnArtikelClickListener;
    private RecyclerUtsUas mRecyclerUtsUas;
    private RecyclerUtsUas.OnArtikelClickListener mOnArtikelClickListenerUtsUas;
    private RecyclerRaport mRecyclerRaport;
    private RecyclerRaport.OnArtikelClickListener mOnArtikelClickListenerRaport;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    initilazieListener();
                    inisialisasiTampilanX();
                    return true;
                case R.id.navigation_dashboard:
                    inisialisasiTampilanX();
                    return true;
                case R.id.navigation_notifications:
                    inisialisasiTampilanX();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        BottomNavigationViewEx navigation = (BottomNavigationViewEx) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setTextVisibility(false);
        navigation.setIconSize(40,40);
        navigation.setPadding(0,0,0,25);

        initilazieListener();
        inisialisasiTampilanX();
    }
    
    private void initilazieListener() {
        mOnArtikelClickListener = new RecyclerQuiz.OnArtikelClickListener() {
            @Override
            public void onClick(int posisi) {
                try {
                    if (toast != null) {
                        toast.cancel();
                    }

                    Intent intentdetil;

                    Log.d("KLIK Posisi : ", posisi + "");

                    switch (posisi) {
                        default:
                            intentdetil = new Intent(Score.this, DetilScoreQuiz.class);
                            Score.this.startActivity(intentdetil);
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        mOnArtikelClickListenerUtsUas = new RecyclerUtsUas.OnArtikelClickListener() {
            @Override
            public void onClick(int posisi) {
                try {
                    if (toast != null) {
                        toast.cancel();
                    }

                    Intent intentdetil;

                    Log.d("KLIK Posisi : ", posisi + "");

                    switch (posisi) {
                        default:
                            intentdetil = new Intent(Score.this, DetilScoreUtsUas.class);
                            Score.this.startActivity(intentdetil);
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        mOnArtikelClickListenerRaport = new RecyclerRaport.OnArtikelClickListener() {
            @Override
            public void onClick(int posisi) {
                try {
                    if (toast != null) {
                        toast.cancel();
                    }

                    Intent intentdetil;

                    Log.d("KLIK Posisi : ", posisi + "");

                    switch (posisi) {
                        default:
                            intentdetil = new Intent(Score.this, DetilScoreUtsUas.class);
                            Score.this.startActivity(intentdetil);
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


    }
    
    private void inisialisasiTampilanX() {
        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(Score.this,
                LinearLayoutManager.HORIZONTAL, false);
        final LinearLayoutManager mLinearLayoutManagerUt = new LinearLayoutManager(Score.this,
                LinearLayoutManager.HORIZONTAL, false);
        final LinearLayoutManager mLinearLayoutManagerRap = new LinearLayoutManager(Score.this,
                LinearLayoutManager.HORIZONTAL, false);

        mRecyclerViewQuiz = (RecyclerView) findViewById(R.id.rv_kuislatihan);
        mRecyclerViewUtsUas = (RecyclerView) findViewById(R.id.rv_utsuas);
        mRecyclerViewRaport = (RecyclerView) findViewById(R.id.rv_rapotsemester);

        mRecyclerViewQuiz.setLayoutManager(mLinearLayoutManager);
        mRecyclerViewQuiz.setHasFixedSize(true);
        mRecyclerQuiz = new RecyclerQuiz(Score.this);
        mRecyclerQuiz.setOnArtikelClickListener(mOnArtikelClickListener);
        mRecyclerViewQuiz.setAdapter(mRecyclerQuiz);

        mRecyclerViewUtsUas.setLayoutManager(mLinearLayoutManagerUt);
        mRecyclerViewUtsUas.setHasFixedSize(true);
        mRecyclerUtsUas = new RecyclerUtsUas(Score.this);
        mRecyclerUtsUas.setOnArtikelClickListener(mOnArtikelClickListenerUtsUas);
        mRecyclerViewUtsUas.setAdapter(mRecyclerUtsUas);

        mRecyclerViewRaport.setLayoutManager(mLinearLayoutManagerRap);
        mRecyclerViewRaport.setHasFixedSize(true);
        mRecyclerRaport = new RecyclerRaport(Score.this);
        mRecyclerRaport.setOnArtikelClickListener(mOnArtikelClickListenerRaport);
        mRecyclerViewRaport.setAdapter(mRecyclerRaport);
    }



}
