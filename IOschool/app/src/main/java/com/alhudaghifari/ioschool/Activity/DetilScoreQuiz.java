package com.alhudaghifari.ioschool.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alhudaghifari.ioschool.R;

public class DetilScoreQuiz extends AppCompatActivity {

    private TextView textViewKompetensi;
    private TextView textViewScore;
    private TextView textViewRightAnswer;
    private TextView textViewWrongAnswer;
    private TextView textViewKkm;
    private TextView textViewCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_score_quiz);

        initializeView();
    }

    private void initializeView() {
        textViewKompetensi = (TextView) findViewById(R.id.tv_kompetensi);
        textViewScore = (TextView) findViewById(R.id.tv_score);
        textViewRightAnswer = (TextView) findViewById(R.id.tv_right_answer);
        textViewWrongAnswer = (TextView) findViewById(R.id.tv_wrong_answer);
        textViewKkm = (TextView) findViewById(R.id.tv_kkm);
        textViewCatatan = (TextView) findViewById(R.id.tv_catatan);
    }
}
