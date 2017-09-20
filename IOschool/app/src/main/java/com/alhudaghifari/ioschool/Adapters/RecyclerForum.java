package com.alhudaghifari.ioschool.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alhudaghifari.ioschool.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Alhudaghifari on 9/20/2017.
 */

public class RecyclerForum extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private RecyclerForum.OnArtikelClickListener mOnArtikelClickListener;

    public RecyclerForum(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            default :
                view = LayoutInflater.from(mContext).inflate(R.layout.cardview_forum, parent, false);
                return new RecyclerForum.ViewHolderArticle(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int posisi = getItemViewType(position);
        RecyclerForum.ViewHolderArticle viewHolderArticle1 = (RecyclerForum.ViewHolderArticle) holder;
        final int posisiAdapter2 = holder.getAdapterPosition();

        switch (posisi) {
            case 0:
                viewHolderArticle1.mTextViewNamaAnak.setText("Diyar Yasin");
                viewHolderArticle1.circleImageViewProfPic.setImageResource(R.drawable.elonmusk);
                break;
            case 1:
                viewHolderArticle1.mTextViewNamaAnak.setText("Farhan Ghifari");
                viewHolderArticle1.circleImageViewProfPic.setImageResource(R.drawable.bilgates);
                break;
            case 2:
                viewHolderArticle1.mTextViewNamaAnak.setText("Petra Legato");
                viewHolderArticle1.circleImageViewProfPic.setImageResource(R.drawable.larrypage);
                break;
            case 3:
                viewHolderArticle1.mTextViewNamaAnak.setText("Royyan Abdullah");
                viewHolderArticle1.circleImageViewProfPic.setImageResource(R.drawable.trudeau);
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
        return 4;
    }

    //JIKA CONTAINER DI KLIK
    public interface OnArtikelClickListener {

        void onClick(int posisi);
    }

    public void setOnArtikelClickListener(RecyclerForum.OnArtikelClickListener onArtikelClickListener) {
        mOnArtikelClickListener = onArtikelClickListener;
    }

    protected class ViewHolderArticle extends RecyclerView.ViewHolder {
        public View mViewContainer;
        public CardView mCardViewContainer;

        public TextView mTextViewNamaAnak;
        public TextView mTextViewIsi;

        public CircleImageView circleImageViewProfPic;
        public ImageButton imageButtonHapus;

        public ViewHolderArticle(View itemView) {
            super(itemView);

            mViewContainer = itemView;
            mCardViewContainer = (CardView) itemView.findViewById(R.id.cardview_container);

            mTextViewNamaAnak = (TextView) itemView.findViewById(R.id.tv_namaanak);
            mTextViewIsi = (TextView) itemView.findViewById(R.id.tv_isiberita);

            circleImageViewProfPic = (CircleImageView) itemView.findViewById(R.id.civ_profpic);
            imageButtonHapus = (ImageButton) itemView.findViewById(R.id.ib_hapus);
        }
    }
}