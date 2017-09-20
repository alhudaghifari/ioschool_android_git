package com.alhudaghifari.ioschool.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.alhudaghifari.ioschool.Constant;
import com.alhudaghifari.ioschool.R;

/**
 * Created by Alhudaghifari 9/9/2017.
 */

public class RecyclerHari extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnArtikelClickListener mOnArtikelClickListener;

    public RecyclerHari(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        Log.d("ViewtType : " , viewType + "");
        switch (viewType) {
            case 2:
                view = LayoutInflater.from(mContext).inflate(R.layout.cardview_schedule_break, parent, false);
                return new ViewHolderBreak(view);
            case 5:
                view = LayoutInflater.from(mContext).inflate(R.layout.cardview_schedule_break, parent, false);
                return new ViewHolderBreak(view);
            default :
                view = LayoutInflater.from(mContext).inflate(R.layout.cardview_schedule, parent, false);
                return new ViewHolderArticle(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("Position : " , position + "");
        if (position == 2)
            return 2;
        else if (position == 5)
            return 5;
        else
            return position;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int posisi = getItemViewType(position);
        ViewHolderBreak viewHolderBreak;
        ViewHolderArticle viewHolderArticle1;

        final int posisiAdapter2 = holder.getAdapterPosition();

        Log.d("PositionBind : " , posisi + "");
        Log.d("------- :" ,"-------");
        switch (posisi) {
            case 0:
                viewHolderArticle1 = (ViewHolderArticle) holder;
                viewHolderArticle1.mTextViewMapel.setText("Matematika");
                viewHolderArticle1.mTextViewGuru.setText("Sulaiman S.Pd");
                viewHolderArticle1.mTextViewJam.setText("07.00 WIB");
                break;
            case 1:
                viewHolderArticle1 = (ViewHolderArticle) holder;
                viewHolderArticle1.mTextViewMapel.setText("Matematika");
                viewHolderArticle1.mTextViewGuru.setText("Sulaiman S.Pd");
                viewHolderArticle1.mTextViewJam.setText("08.00 WIB");
                break;
            case 2:
                viewHolderBreak = (ViewHolderBreak) holder;
                viewHolderBreak.mTextViewMapel.setText("Istirahat");
                viewHolderBreak.mTextViewJam.setText("09.15 WIB");
                break;
            case 3:
                viewHolderArticle1 = (ViewHolderArticle) holder;
                viewHolderArticle1.mTextViewMapel.setText("Biologi");
                viewHolderArticle1.mTextViewGuru.setText("Hartini S.Pd");
                viewHolderArticle1.mTextViewJam.setText("09.30 WIB");
                break;
            case 4:
                viewHolderArticle1 = (ViewHolderArticle) holder;
                viewHolderArticle1.mTextViewMapel.setText("Biologi");
                viewHolderArticle1.mTextViewGuru.setText("Hartini S.Pd");
                viewHolderArticle1.mTextViewJam.setText("10.15 WIB");
                break;
            case 5:
                viewHolderBreak = (ViewHolderBreak) holder;
                viewHolderBreak.mTextViewMapel.setText("Istirahat");
                viewHolderBreak.mTextViewJam.setText("11.45 WIB");
                break;
            case 6:
                viewHolderArticle1 = (ViewHolderArticle) holder;
                viewHolderArticle1.mTextViewMapel.setText("English");
                viewHolderArticle1.mTextViewGuru.setText("Setiyadi S.Pd");
                viewHolderArticle1.mTextViewJam.setText("12.15 WIB");
                break;
            case 7:
                viewHolderArticle1 = (ViewHolderArticle) holder;
                viewHolderArticle1.mTextViewMapel.setText("TIK");
                viewHolderArticle1.mTextViewGuru.setText("Arofik S.Pd");
                viewHolderArticle1.mTextViewJam.setText("13.00 WIB");
                break;
        }

        if (posisi!= 2 && posisi!=5) {
            viewHolderArticle1 = (ViewHolderArticle) holder;
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
    }

    @Override
    public int getItemCount() {
        return 8;
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

        public TextView mTextViewMapel;
        public TextView mTextViewGuru;
        public TextView mTextViewJam;

        public ViewHolderArticle(View itemView) {
            super(itemView);

            mViewContainer = itemView;
            mCardViewContainer = (CardView) itemView.findViewById(R.id.cardview_container);

            mTextViewMapel = (TextView) itemView.findViewById(R.id.tv_mapel);
            mTextViewGuru = (TextView) itemView.findViewById(R.id.tv_guru);
            mTextViewJam = (TextView) itemView.findViewById(R.id.tv_jam);
        }
    }

    protected class ViewHolderBreak extends RecyclerView.ViewHolder {
        public View mViewContainer;
        public CardView mCardViewContainer;

        public TextView mTextViewMapel;
        public TextView mTextViewJam;

        public ViewHolderBreak(View itemView) {
            super(itemView);

            mViewContainer = itemView;
            mCardViewContainer = (CardView) itemView.findViewById(R.id.cardview_container);

            mTextViewMapel = (TextView) itemView.findViewById(R.id.tv_mapel);
            mTextViewJam = (TextView) itemView.findViewById(R.id.tv_jam);
        }
    }
}