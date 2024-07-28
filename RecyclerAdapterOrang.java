package com.project.trackerapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.trackerapp.DetailActivity;
import com.project.trackerapp.DetailBeritaActivity;
import com.project.trackerapp.R;

public class RecyclerAdapterOrang extends RecyclerView.Adapter<RecyclerAdapterOrang.GridViewHolder> {
    private RecyclerAdapterOrang.OnItemClickCallback onItemClickCallback;
    Context ctx;

    public void setOnclickCallback(RecyclerAdapterOrang.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public RecyclerAdapterOrang(Context context) {
        ctx = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_orang, parent, false);
        GridViewHolder viewHolder = new GridViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Integer[] images = {R.drawable.image_4, R.drawable.image_5, R.drawable.image_3, R.drawable.image_1, R.drawable.image_2};
        String[] nama = {"Nur Fitriya", "Fifih Rofikoh", "Ferri Satria R", "M Alibasyir", "Azhura R."};
        String[] email = {"fitriya.n@haidup.org", "fifih.r@IPSPI.org", "ferri.911@gmail.com", "m.alibasyirrr@gmail.com", "a.rachmasyifa@haidup.org"};
        String[] kota = {"BEKASI", "JAKARTA TIMUR", "JAKARTA SELATAN", "TANGGERANG SELATAN", "KOTA DEPOK"};
        String[] organization = {"LOKA", "IPSPI", "LOKA", "Yayasan Cipta Sejahtera", "LOKA"};
        String[] phone_number = {"0811 324 0112", "0811 324 0112", "0818 322 0122", "0813 4144 0112", "0856 6640 6689"};
        String[] join = {"1 year ago", "11 months ago", "1 year ago", "8 months ago", "9 months ago"};
        String[] bio = {"2 Tahun fokus pekerja kasus dalam bidang ketunawismaan, & advokasi individu/ keluarga atas akses hunian layak dan terjangkau. Juga memiliki pengalaman penanganan kasus anak terlantar, dan VCT(HIV).",
                "1 Tahun fokus pekerja kasus dalam advokasi individu/ keluarga bagi akses hunian layak yang terjangkau.\n" +
                        "\n" +
                        "Dan total 7 tahun pengalaman di bidang pendampingan keluarga pra sejahtera, akses bansos, dan supervisi pekerjaan sosial.",
                "1 Tahun fokus pekerja kasus dalam bidang ketunawismaan usia muda 16 s/d 24 tahun.Memiliki 3 tahun pengalaman bidang konseling pendidikan, dan pendamping UMKM tersertifikasi BNSP.",
                "Pekerja kasus di bidang ketunawismaan pada usia muda (16-24 thn), dan advokasi individu atas akses hunian layak yang terjangkau. \n" +
                        "Juga memiliki 4 tahun pengalaman dalam bidang rehabilitasi narkoba & kenakalan remaja. ",
                "1 Tahun fokus pekerja kasus di bidang ketunawismaan pada usia muda (16-24 thn), advokasi individu atas akses hunian layak yang terjangkau, dan kesehatan mental."};
        holder.nama.setText(nama[position]);
        holder.kota.setText(kota[position]);
        Glide.with(ctx).load(images[position]).into(holder.imageView);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(ctx, DetailActivity.class);
            intent.putExtra("nama", nama[position]);
            intent.putExtra("email", email[position]);
            intent.putExtra("organization", organization[position]);
            intent.putExtra("phone", phone_number[position]);
            intent.putExtra("bio", bio[position]);
            intent.putExtra("join", join[position]);
            intent.putExtra("kota", kota[position]);
            intent.putExtra("image", images[position]);
            ctx.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class GridViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        TextView kota;
        ImageView imageView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgv_image);
            kota = itemView.findViewById(R.id.tv_kota);
            nama = itemView.findViewById(R.id.tv_nama);
        }
    }

    public interface OnItemClickCallback {
        void onItemClick(int pos);
    }


}
