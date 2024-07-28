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
import com.project.trackerapp.DetailBeritaActivity;
import com.project.trackerapp.R;

public class RecyclerAdapterBerita extends RecyclerView.Adapter<RecyclerAdapterBerita.GridViewHolder> {
    private RecyclerAdapterBerita.OnItemClickCallback onItemClickCallback;
    Context ctx;

    public void setOnclickCallback(RecyclerAdapterBerita.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public RecyclerAdapterBerita(Context context) {
        ctx = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_berita, parent, false);
        GridViewHolder viewHolder = new GridViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Integer[] images = {R.drawable.image_berita_1, R.drawable.image_berita_2, R.drawable.image_berita_3, R.drawable.image_berita_4, R.drawable.image_berita_5};
        String[] nama = {"Penawaran Khusus", "Shelter", "Articles", "Community", "Articles"};
        String[] desc = {"Hunian Minimalis Lahan & Biaya", "Program Baru September 2024", "Ketunawismaan Terselubung, Apaan tuh?", "HUT RI Ke-79 Bersama Anak Panti", "Bansos Perumahan, Apa Saja?"};
        String[] tag = {"Paid Promo", "", "", "Up Coming Event!", ""};
        holder.nama.setText(nama[position]);
        holder.desc.setText(desc[position]);
        holder.tag.setText(tag[position]);
        Glide.with(ctx).load(images[position]).into(holder.imageView);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(ctx, DetailBeritaActivity.class);
            intent.putExtra("nama", nama[position]);
            intent.putExtra("tag", tag[position]);
            intent.putExtra("desc", desc[position]);
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
        ImageView imageView;
        TextView desc;
        TextView tag;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgv_image);
            nama = itemView.findViewById(R.id.tv_nama);
            desc = itemView.findViewById(R.id.tv_desc);
            tag = itemView.findViewById(R.id.tv_tag);
        }
    }

    public interface OnItemClickCallback {
        void onItemClick(int pos);
    }


}
