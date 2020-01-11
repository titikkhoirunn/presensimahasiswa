package com.example.presensimahasiswa;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterJadwal extends RecyclerView.Adapter<AdapterJadwal.ViewHolder> {
    private static final String TAG ="AdapterJadwal";
    private String[] Tv_Makul,Tv_NamaDosen,Tv_Kelas,Tv_Hari,Tv_Hari1,Tv_Jam,Tv_Jam1,Tv_Ruang,Tv_Ruang1;
    private int[] Img_Panah,Img_Hari,Img_Jam,Img_Ruang;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView TvMakul,TvNamaDosen,TvKelas,TvHari,TvHari1,TvJam,TvJam1,TvRuang,TvRuang1;
        private final ImageView ImgPanah,ImgHari,ImgJam,ImgRuang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG,"Element" + getPosition() + "clicked.");
                }
            });
            TvMakul =(TextView) itemView.findViewById(R.id.tv_makul);
            TvNamaDosen =(TextView) itemView.findViewById(R.id.tv_nama_dosen);
            TvKelas =(TextView) itemView.findViewById(R.id.tv_kelas);
            TvHari =(TextView) itemView.findViewById(R.id.tv_hari);
            TvHari1 =(TextView) itemView.findViewById(R.id.tv_hari1);
            TvJam =(TextView) itemView.findViewById(R.id.tv_jam);
            TvJam1 =(TextView) itemView.findViewById(R.id.tv_jam1);
            TvRuang =(TextView) itemView.findViewById(R.id.tv_ruang);
            TvRuang1 =(TextView) itemView.findViewById(R.id.tv_ruang1);
            ImgPanah =(ImageView) itemView.findViewById(R.id.img_panah);
            ImgHari =(ImageView) itemView.findViewById(R.id.img_hari);
            ImgJam =(ImageView) itemView.findViewById(R.id.img_jam);
            ImgRuang =(ImageView) itemView.findViewById(R.id.img_ruang);
        }
        public TextView getTvMakul() {
            return TvMakul;
        }
        public TextView getTvNamaDosen() {
            return TvNamaDosen;
        }
        public TextView getTvKelas() {
            return TvKelas;
        }
        public TextView getTvHari() {
            return TvHari;
        }
        public TextView getTvHari1() {
            return TvHari1;
        }
        public TextView getTvJam() {
            return TvJam;
        }
        public TextView getTvJam1() {
            return TvJam1;
        }
        public TextView getTvRuang() {
            return TvRuang;
        }
        public TextView getTvRuang1() {
            return TvRuang1;
        }
        public ImageView getImgPanah() {
            return ImgPanah;
        }
        public ImageView getImgHari() {
            return ImgHari;
        }
        public ImageView getImgJam() {
            return ImgJam;
        }
        public ImageView getImgRuang() {
            return ImgRuang;
        }
    }
    public AdapterJadwal(String[] TvMakul_,String[] TvNamaDosen_,String[] TvKelas_,String[] TvHari_,
                         String[] TvHari1_,String[] TvJam_,String[] TvJam1_,String[] TvRuang_,String[] TvRuang1_,
                         int[] ImgPanah_,int[] ImgHari_,int[] ImgJam_,int[] ImgRuang_) {
        this.Tv_Makul = TvMakul_;
        this.Tv_NamaDosen = TvNamaDosen_;
        this.Tv_Kelas = TvKelas_;
        this.Tv_Hari = TvHari_;
        this.Tv_Hari1 = TvHari1_;
        this.Tv_Jam = TvJam_;
        this.Tv_Jam1 = TvJam1_;
        this.Tv_Ruang = TvRuang_;
        this.Tv_Ruang1 = TvRuang1_;
        this.Img_Panah = ImgPanah_;
        this.Img_Hari = ImgHari_;
        this.Img_Jam = ImgJam_;
        this.Img_Ruang = ImgRuang_;
    }
    @NonNull
    @Override
    public AdapterJadwal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_jadwal, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterJadwal.ViewHolder holder, int position) {
        Log.d(TAG,"Element" + position +"set.");
        holder.getTvMakul().setText(Tv_Makul[position]);
        holder.getTvNamaDosen().setText(Tv_NamaDosen[position]);
        holder.getTvKelas().setText(Tv_Kelas[position]);
        holder.getTvHari().setText(Tv_Hari[position]);
        holder.getTvHari1().setText(Tv_Hari1[position]);
        holder.getTvJam().setText(Tv_Jam[position]);
        holder.getTvJam1().setText(Tv_Jam1[position]);
        holder.getTvRuang().setText(Tv_Ruang[position]);
        holder.getTvRuang1().setText(Tv_Ruang1[position]);
        holder.getImgPanah().setImageResource(Img_Panah[position]);
        holder.getImgHari().setImageResource(Img_Hari[position]);
        holder.getImgJam().setImageResource(Img_Jam[position]);
        holder.getImgRuang().setImageResource(Img_Ruang[position]);

    }

    @Override
    public int getItemCount() {

        return Tv_Makul.length;
    }
}
