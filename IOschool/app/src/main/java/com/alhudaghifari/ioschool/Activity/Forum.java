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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.alhudaghifari.ioschool.Adapters.RecyclerForum;
import com.alhudaghifari.ioschool.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class Forum extends AppCompatActivity {

    private Spinner spinner;
    private RecyclerView mRecyclerViewForum;

    private Toast toast;

    private RecyclerForum mRecyclerForum;
    private RecyclerForum.OnArtikelClickListener mOnArtikelClickListener;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    initilazieListener();
                    initializeView();
                    return true;
                case R.id.navigation_dashboard:
                    initilazieListener();
                    initializeView();
                    return true;
                case R.id.navigation_notifications:
                    initilazieListener();
                    initializeView();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        BottomNavigationViewEx navigation = (BottomNavigationViewEx) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setTextVisibility(false);
        navigation.setIconSize(40,40);
        navigation.setPadding(0,0,0,25);

        addDataDefaultSpinner();
        initilazieListener();
        initializeView();
    }

    private void addDataDefaultSpinner() {

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Fisika");
        list.add("Biologi");
        list.add("Kimia");
        list.add("Ekonomi");
        list.add("Sosiologi");
        list.add("Geografi");
        list.add("Matematika IPA");
        list.add("Matematika IPS");
        list.add("Lain-lain");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    private void initilazieListener() {
        mOnArtikelClickListener = new RecyclerForum.OnArtikelClickListener() {
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
                            intentdetil = new Intent(Forum.this, DetilForum.class);
                            Forum.this.startActivity(intentdetil);
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private void initializeView() {

        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(Forum.this);

        mRecyclerViewForum = (RecyclerView) findViewById(R.id.rv_forum);

        mRecyclerViewForum.setLayoutManager(mLinearLayoutManager);
        mRecyclerViewForum.setHasFixedSize(true);
        mRecyclerForum = new RecyclerForum(Forum.this);
        mRecyclerForum.setOnArtikelClickListener(mOnArtikelClickListener);
        mRecyclerViewForum.setAdapter(mRecyclerForum);
    }

    public class OnItemSelectedListenerClick implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}
