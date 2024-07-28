package com.project.trackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.project.trackerapp.databinding.ActivityDetailBeritaBinding;

public class DetailBeritaActivity extends AppCompatActivity {
    Context context;
    ActivityDetailBeritaBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBeritaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = DetailBeritaActivity.this;

        String desc  = getIntent().getStringExtra("desc");
        String nama  = getIntent().getStringExtra("nama");
        String tag  = getIntent().getStringExtra("tag");
        Integer image  = getIntent().getIntExtra("image", 0);

        binding.tvNama.setText(nama);
        binding.tvTag.setText(tag);
        binding.tvDesc.setText(desc);
        Glide.with(context).load(image).into(binding.imgvImage);

        binding.btnBack.setOnClickListener(v -> {
            finish();
        });
    }

}
