package com.example.presensimahasiswa;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPertemuan extends RecyclerView.Adapter<AdapterPertemuan.ViewHolder> {
    private static final String TAG ="AdapterPertemuan";
    private String[] Tv_Pertemuan,Tv_Tanggal,Tv_Materi;
    private int[] Btn_Review, Btn_presensi;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView TvPertemuan,TvTanggal,TvMateri;
        private final Button BtnReview,BtnPresensi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG,"Element" + getPosition() + "clicked.");
                }
            });
            TvPertemuan =(TextView) itemView.findViewById(R.id.tv_pertemuan);
            TvTanggal =(TextView) itemView.findViewById(R.id.tv_tanggal);
            TvMateri =(TextView) itemView.findViewById(R.id.tv_materi);
            BtnReview =(Button)itemView.findViewById(R.id.btn_review);
            BtnPresensi =(Button)itemView.findViewById(R.id.btn_presensi);
        }
        public TextView getTvPertemuan() {
            return TvPertemuan;
        }
        public TextView getTvMateri() {
            return TvMateri;
        }
        public TextView getTvTanggal() {
            return TvTanggal;
        }
        public Button getBtnReview(){return  BtnReview;}
        public Button getBtnPresensi(){return  BtnPresensi;}
    }
    public AdapterPertemuan(String[] TvPertemuan_,String[] TvMateri_,String[] TvTanggal_,int[] BtnReview_, int[] BtnPresensi_){
        this.Tv_Pertemuan = TvPertemuan_;
        this.Tv_Materi = TvMateri_;
        this.Tv_Tanggal = TvTanggal_;
        this.Btn_presensi = BtnPresensi_;
        this.Btn_Review = BtnReview_;
    }

    @NonNull
    @Override
    public AdapterPertemuan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_pertemuan, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPertemuan.ViewHolder holder, int position) {
        Log.d(TAG,"Element" + position +"set.");
        holder.getTvPertemuan().setText(Tv_Pertemuan[position]);
        holder.getTvMateri().setText(Tv_Materi[position]);
        holder.getTvTanggal().setText(Tv_Tanggal[position]);
        holder.getBtnPresensi().setText(Btn_presensi[position]);
        holder.getBtnReview().setText(Btn_Review[position]);
    }

    @Override
    public int getItemCount() {
        return Tv_Pertemuan.length;
    }
}
