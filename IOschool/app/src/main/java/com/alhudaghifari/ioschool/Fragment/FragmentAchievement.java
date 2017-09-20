package com.alhudaghifari.ioschool.Fragment;

import android.content.Intent;
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

import com.alhudaghifari.ioschool.Activity.DetilArtikel;
import com.alhudaghifari.ioschool.Adapters.RecyclerAchievement;
import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/9/2017.
 */

public class FragmentAchievement extends Fragment {
    RecyclerView mRecyclerView;

    private Toast toast;

    private RecyclerAchievement mRecyclerLibrary;

    private RecyclerAchievement.OnArtikelClickListener mOnArtikelClickListener;

    private String juduartikel = "";
    private String linkartikel = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        Log.w("FragmentAchievement", " onCreateView");

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_numbers);

        inisialisasiListener();

        inisialisasiTampilan();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w("FragmentAchievement", " onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w("FragmentAchievement", " onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w("FragmentAchievement", " onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w("FragmentAchievement", " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w("FragmentAchievement", " onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w("FragmentAchievement", " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("FragmentAchievement", " onDestroy");
    }


    private void inisialisasiListener() {
        mOnArtikelClickListener = new RecyclerAchievement.OnArtikelClickListener() {
            @Override
            public void onClick(int posisi) {
                try {
                    if (toast != null) {
                        toast.cancel();
                    }

                    Intent intentdetil = new Intent(FragmentAchievement.this.getActivity(), DetilArtikel.class);

                    Log.d("KLIK Posisi : ", posisi + "");

                    switch (posisi) {
                        case 0:
                            intentdetil = new Intent(FragmentAchievement.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews1);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita1);
                            FragmentAchievement.this.startActivity(intentdetil);
                            break;

                        case 1:
                            intentdetil = new Intent(FragmentAchievement.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews2);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita2);
                            FragmentAchievement.this.startActivity(intentdetil);
                            break;

                        case 2:
                            intentdetil = new Intent(FragmentAchievement.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews3);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita3);
                            FragmentAchievement.this.startActivity(intentdetil);
                            break;

                        case 3:
                            intentdetil = new Intent(FragmentAchievement.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews4);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita4);
                            FragmentAchievement.this.startActivity(intentdetil);
                            break;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void inisialisasiTampilan() {
        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(FragmentAchievement.this.getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerLibrary = new RecyclerAchievement(FragmentAchievement.this.getActivity());
        mRecyclerLibrary.setOnArtikelClickListener(mOnArtikelClickListener);
        mRecyclerView.setAdapter(mRecyclerLibrary);
    }

}