package com.alhudaghifari.ioschool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alhudaghifari.ioschool.Adapters.RecyclerUtsUasDetil;
import com.alhudaghifari.ioschool.Adapters.RecyclerUtsUas;
import com.alhudaghifari.ioschool.Adapters.RecyclerUtsUasDetil;
import com.alhudaghifari.ioschool.R;

public class DetilScoreUtsUas extends AppCompatActivity {

    private RecyclerView mRecyclerViewUtsUas;

    private RecyclerUtsUasDetil mRecyclerUtsUas;
    private RecyclerUtsUasDetil.OnArtikelClickListener mOnArtikelClickListenerUtsUas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_score_uts_uas);

//        initializeListener();
        initializeView();
    }

    private void initializeView() {
        final LinearLayoutManager mLinearLayoutManagerUt = new LinearLayoutManager(DetilScoreUtsUas.this);

        mRecyclerViewUtsUas = (RecyclerView) findViewById(R.id.rv_utsuas);

        mRecyclerViewUtsUas.setLayoutManager(mLinearLayoutManagerUt);
        mRecyclerViewUtsUas.setHasFixedSize(true);
        mRecyclerUtsUas = new RecyclerUtsUasDetil(DetilScoreUtsUas.this);
        mRecyclerUtsUas.setOnArtikelClickListener(mOnArtikelClickListenerUtsUas);
        mRecyclerViewUtsUas.setAdapter(mRecyclerUtsUas);
    }

    private void initializeListener() {
        mOnArtikelClickListenerUtsUas = new RecyclerUtsUasDetil.OnArtikelClickListener() {
            @Override
            public void onClick(int posisi) {
                try {
                    Intent intentdetil;

                    Log.d("KLIK Posisi : ", posisi + "");

                    switch (posisi) {
                        default:
                            intentdetil = new Intent(DetilScoreUtsUas.this, DetilScoreQuiz.class);
                            DetilScoreUtsUas.this.startActivity(intentdetil);
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
