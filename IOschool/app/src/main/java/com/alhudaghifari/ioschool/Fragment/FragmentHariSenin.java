package com.alhudaghifari.ioschool.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alhudaghifari.ioschool.Adapters.RecyclerHari;
import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/9/2017.
 */

public class FragmentHariSenin extends Fragment {
    RecyclerView mRecyclerView;

    private Toast toast;

    private RecyclerHari mRecyclerLibrary;

    private RecyclerHari.OnArtikelClickListener mOnArtikelClickListener;

    private String juduartikel = "";
    private String linkartikel = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule_reguler, container, false);
        Log.w("FragmentHariSenin", " onCreateView");

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_numbers);

        inisialisasiListener();

        inisialisasiTampilan();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w("FragmentHariSenin", " onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w("FragmentHariSenin", " onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w("FragmentHariSenin", " onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w("FragmentHariSenin", " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w("FragmentHariSenin", " onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w("FragmentHariSenin", " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("FragmentHariSenin", " onDestroy");
    }


    private void inisialisasiListener() {
        mOnArtikelClickListener = new RecyclerHari.OnArtikelClickListener() {
            @Override
            public void onClick(int posisi) {

            }
        };
    }

    public void inisialisasiTampilan() {
        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(FragmentHariSenin.this.getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerLibrary = new RecyclerHari(FragmentHariSenin.this.getActivity());
        mRecyclerLibrary.setOnArtikelClickListener(mOnArtikelClickListener);
        mRecyclerView.setAdapter(mRecyclerLibrary);
    }

}