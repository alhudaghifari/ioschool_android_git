package com.alhudaghifari.ioschool.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;

public class DetilArtikel extends AppCompatActivity {

    private ImageView iv_gambarberita;

    private TextView tv_judul;
    private TextView tv_subjudul;
    private TextView tv_isiberita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_artikel);

        Bundle extras = getIntent().getExtras();
        String judul = extras.getString(Constant.TAG_JUDUL_ARTIKEL);
        String teks = extras.getString(Constant.TAG_TEKS_ARTIKEL);
        int imgres = extras.getInt(Constant.TAG_GAMBAR_ARTIKEL);

        initializeView();

        iv_gambarberita.setImageResource(imgres);
        tv_judul.setText(judul);
        tv_subjudul.setText("available");
        tv_isiberita.setText(teks);

    }

    private void initializeView() {
        iv_gambarberita = (ImageView) findViewById(R.id.iv_gambarartikel);
        tv_judul = (TextView) findViewById(R.id.tv_judulartikel);
        tv_subjudul = (TextView) findViewById(R.id.tv_subjudul);
        tv_isiberita = (TextView) findViewById(R.id.tv_isiberita);
    }
}
