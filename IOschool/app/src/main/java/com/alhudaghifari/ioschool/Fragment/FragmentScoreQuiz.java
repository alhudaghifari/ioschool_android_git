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
import com.alhudaghifari.ioschool.Adapters.RecyclerQuiz;
import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/17/2017.
 */

public class FragmentScoreQuiz extends Fragment {
    RecyclerView mRecyclerView;

    private Toast toast;

    private RecyclerQuiz mRecyclerQuiz;

    private RecyclerQuiz.OnArtikelClickListener mOnArtikelClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        Log.w("FragmentScoreQuiz", " onCreateView");

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_numbers);

        inisialisasiListener();

        inisialisasiTampilan();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w("FragmentScoreQuiz", " onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w("FragmentScoreQuiz", " onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w("FragmentScoreQuiz", " onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w("FragmentScoreQuiz", " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w("FragmentScoreQuiz", " onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w("FragmentScoreQuiz", " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("FragmentScoreQuiz", " onDestroy");
    }


    private void inisialisasiListener() {
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
                        case 0:
//                            intentdetil = new Intent(FragmentScoreQuiz.this.getActivity(), DetilArtikel.class);
//                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews1);
//                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
//                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita1);
//                            FragmentScoreQuiz.this.startActivity(intentdetil);
                            break;

                        case 1:
//                            intentdetil = new Intent(FragmentScoreQuiz.this.getActivity(), DetilArtikel.class);
//                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews2);
//                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
//                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita2);
//                            FragmentScoreQuiz.this.startActivity(intentdetil);
                            break;

                        case 2:
//                            intentdetil = new Intent(FragmentScoreQuiz.this.getActivity(), DetilArtikel.class);
//                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews3);
//                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
//                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita3);
//                            FragmentScoreQuiz.this.startActivity(intentdetil);
                            break;

                        case 3:
//                            intentdetil = new Intent(FragmentScoreQuiz.this.getActivity(), DetilArtikel.class);
//                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judulNews4);
//                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks2);
//                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.berita4);
//                            FragmentScoreQuiz.this.startActivity(intentdetil);
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void inisialisasiTampilan() {
        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(FragmentScoreQuiz.this.getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerQuiz = new RecyclerQuiz(FragmentScoreQuiz.this.getActivity());
        mRecyclerQuiz.setOnArtikelClickListener(mOnArtikelClickListener);
        mRecyclerView.setAdapter(mRecyclerQuiz);
    }

}