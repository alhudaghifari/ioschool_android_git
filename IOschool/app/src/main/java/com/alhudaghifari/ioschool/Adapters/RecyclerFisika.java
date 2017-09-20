package com.alhudaghifari.ioschool.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari on 9/9/2017.
 */

public class RecyclerFisika extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnArtikelClickListener mOnArtikelClickListener;

    public RecyclerFisika(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            default :
                view = LayoutInflater.from(mContext).inflate(R.layout.cardview_library, parent, false);
                return new ViewHolderArticle(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int posisi = getItemViewType(position);
        ViewHolderArticle viewHolderArticle1 = (ViewHolderArticle) holder;
        final int posisiAdapter2 = holder.getAdapterPosition();

        switch (posisi) {
            case 0:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar1);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_blue);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul1);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available);
                break;
            case 1:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar2);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_blue);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul2);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available);
                break;
            case 2:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar3);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_yellow);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul3);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available + "on 5/09/2017");
                break;
            case 3:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar4);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_blue);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul4);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available);
                break;
            case 4:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar5);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_yellow);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul5);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available + "on 15/09/2017");
                break;
            case 5:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar6);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_yellow);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul6);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available + "on 21/09/2017");
                break;
            case 6:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar7);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_blue);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul7);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available);
                break;
            case 7:
                viewHolderArticle1.mImageViewGambarBuku.setImageResource(R.drawable.gambar8);
                viewHolderArticle1.mImageViewStatusBuku.setImageResource(R.drawable.circle_blue);
                viewHolderArticle1.mTextViewTeksJudulBuku.setText(Constant.judul8);
                viewHolderArticle1.mTextViewTeksStatusAvailable.setText(Constant.available);
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
        return Constant.total_book;
    }

    //JIKA CONTAINER DI KLIK
    public interface OnArtikelClickListener {

        void onClick(int posisi);
    }

    public void setOnArtikelClickListener(OnArtikelClickListener onArtikelClickListener) {
        mOnArtikelClickListener = onArtikelClickListener;
    }

    protected class ViewHolderArticle extends RecyclerView.ViewHolder {
        public View mViewContainer;
        public CardView mCardViewContainer;

        public ImageView mImageViewGambarBuku;
        public ImageView mImageViewStatusBuku;

        public TextView mTextViewTeksJudulBuku;
        public TextView mTextViewTeksStatusAvailable;

        public ViewHolderArticle(View itemView) {
            super(itemView);

            mViewContainer = itemView;
            mCardViewContainer = (CardView) itemView.findViewById(R.id.cardview_container);

            mImageViewGambarBuku = (ImageView) itemView.findViewById(R.id.imgForBuku);
            mImageViewStatusBuku = (ImageView) itemView.findViewById(R.id.imgCircleStatus);

            mTextViewTeksJudulBuku = (TextView) itemView.findViewById(R.id.txtJudulBuku);
            mTextViewTeksStatusAvailable = (TextView) itemView.findViewById(R.id.txtStatusAvailable);
        }
    }
}