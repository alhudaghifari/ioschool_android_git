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
import com.alhudaghifari.ioschool.Adapters.RecyclerFisika;
import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/9/2017.
 */

public class FragmentLainlain extends Fragment {
    RecyclerView mRecyclerView;

    private Toast toast;

    private RecyclerFisika mRecyclerLibrary;

    private RecyclerFisika.OnArtikelClickListener mOnArtikelClickListener;

    private String juduartikel = "";
    private String linkartikel = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_library, container, false);
        Log.w("FragmentLainlain", " onCreateView");

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_numbers);

        inisialisasiListener();

        inisialisasiTampilan();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w("FragmentLainlain", " onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w("FragmentLainlain", " onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w("FragmentLainlain", " onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w("FragmentLainlain", " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w("FragmentLainlain", " onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w("FragmentLainlain", " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("FragmentLainlain", " onDestroy");
    }


    private void inisialisasiListener() {
        mOnArtikelClickListener = new RecyclerFisika.OnArtikelClickListener() {
            @Override
            public void onClick(int posisi) {
                try {
                    if (toast != null) {
                        toast.cancel();
                    }

                    Intent intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);

                    Log.d("KLIK Posisi : ", posisi + "");

                    switch (posisi) {
                        case 0:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul1);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar1);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 1:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul2);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar2);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 2:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul3);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar3);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 3:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul1);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar1);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 4:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul2);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar2);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 5:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul3);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar3);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 6:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul1);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar1);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 7:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul2);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar2);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 8:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul3);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar3);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 9:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul1);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar1);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 10:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul2);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar2);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                        case 11:
                            intentdetil = new Intent(FragmentLainlain.this.getActivity(), DetilArtikel.class);
                            intentdetil.putExtra(Constant.TAG_JUDUL_ARTIKEL, Constant.judul3);
                            intentdetil.putExtra(Constant.TAG_TEKS_ARTIKEL, Constant.teks);
                            intentdetil.putExtra(Constant.TAG_GAMBAR_ARTIKEL, R.drawable.gambar3);
                            FragmentLainlain.this.startActivity(intentdetil);
                            break;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void inisialisasiTampilan() {
        final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(FragmentLainlain.this.getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerLibrary = new RecyclerFisika(FragmentLainlain.this.getActivity());
        mRecyclerLibrary.setOnArtikelClickListener(mOnArtikelClickListener);
        mRecyclerView.setAdapter(mRecyclerLibrary);
    }

}