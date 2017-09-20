package com.alhudaghifari.ioschool.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/17/2017.
 */

public class RecyclerUtsUasDetil extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private RecyclerUtsUasDetil.OnArtikelClickListener mOnArtikelClickListener;

    public RecyclerUtsUasDetil(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            default :
                view = LayoutInflater.from(mContext).inflate(R.layout.cardview_score_uts_uas, parent, false);
                return new RecyclerUtsUasDetil.ViewHolderArticle(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int posisi = getItemViewType(position);
        RecyclerUtsUasDetil.ViewHolderArticle viewHolderArticle1 = (RecyclerUtsUasDetil.ViewHolderArticle) holder;
        final int posisiAdapter2 = holder.getAdapterPosition();

        switch (posisi) {
            case 0:
                viewHolderArticle1.mTextViewMapel.setText("1. Agama");
                viewHolderArticle1.mTextViewNilai.setText("100");
                break;
            case 1:
                viewHolderArticle1.mTextViewMapel.setText("2. PPKN");
                viewHolderArticle1.mTextViewNilai.setText("80");
                break;
            case 2:
                viewHolderArticle1.mTextViewMapel.setText("3. Matematika");
                viewHolderArticle1.mTextViewNilai.setText("100");
                break;
            case 3:
                viewHolderArticle1.mTextViewMapel.setText("4. Fisika");
                viewHolderArticle1.mTextViewNilai.setText("95");
                break;
            case 4:
                viewHolderArticle1.mTextViewMapel.setText("5. Kimia");
                viewHolderArticle1.mTextViewNilai.setText("80");
                break;
            case 5:
                viewHolderArticle1.mTextViewMapel.setText("6. Biologi");
                viewHolderArticle1.mTextViewNilai.setText("86");
                break;
            case 6:
                viewHolderArticle1.mTextViewMapel.setText("7. Seni");
                viewHolderArticle1.mTextViewNilai.setText("100");
                break;
            case 7:
                viewHolderArticle1.mTextViewMapel.setText("8. Olah Raga ");
                viewHolderArticle1.mTextViewNilai.setText("95");
                break;
            case 8:
                viewHolderArticle1.mTextViewMapel.setText("9. Bahasa Mandarin");
                viewHolderArticle1.mTextViewNilai.setText("75");
                break;
            case 9:
                viewHolderArticle1.mTextViewMapel.setText("10. Sejarah");
                viewHolderArticle1.mTextViewNilai.setText("99");
                break;
        }

        viewHolderArticle1.mViewContainer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (mOnArtikelClickListener != null) {

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (mOnArtikelClickListener != null)
                                        mOnArtikelClickListener.onClick(posisiAdapter2);
                                }
                            }, 250);
                        }
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    //JIKA CONTAINER DI KLIK
    public interface OnArtikelClickListener {

        void onClick(int posisi);
    }

    public void setOnArtikelClickListener(RecyclerUtsUasDetil.OnArtikelClickListener onArtikelClickListener) {
        mOnArtikelClickListener = onArtikelClickListener;
    }

    protected class ViewHolderArticle extends RecyclerView.ViewHolder {
        public View mViewContainer;
        public CardView mCardViewContainer;

        public TextView mTextViewMapel;
        public TextView mTextViewNilai;

        public ViewHolderArticle(View itemView) {
            super(itemView);

            mViewContainer = itemView;
            mCardViewContainer = (CardView) itemView.findViewById(R.id.cardview_container);

            mTextViewMapel = (TextView) itemView.findViewById(R.id.tv_mapel);
            mTextViewNilai = (TextView) itemView.findViewById(R.id.tv_nilai);
        }
    }
}