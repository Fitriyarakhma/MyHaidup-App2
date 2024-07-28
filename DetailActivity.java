package com.project.trackerapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.project.trackerapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = DetailActivity.this;

        String bio  = getIntent().getStringExtra("bio");
        String nama  = getIntent().getStringExtra("nama");
        String kota  = getIntent().getStringExtra("kota");
        String phone  = getIntent().getStringExtra("phone");
        String join  = getIntent().getStringExtra("join");
        String email  = getIntent().getStringExtra("email");
        String oraganization  = getIntent().getStringExtra("organization");
        Integer image  = getIntent().getIntExtra("image", 0);

        binding.tvNama.setText(nama);
        binding.tvOragnization.setText(oraganization);
        binding.tvBio.setText(bio);
        binding.tvKota.setText(kota);
        binding.tvPhone.setText(phone);
        binding.tvJoin.setText(join);
        binding.tvEmail.setText(email);
        Glide.with(context).load(image).into(binding.imgvImage);

        binding.btnBack.setOnClickListener(v -> {
            finish();
        });

        binding.btnLaporkan.setOnClickListener(v -> {
            Intent intent = new Intent(context, LaporanActivity.class);
            startActivity(intent);
        });

        binding.btnKonsultasi.setOnClickListener(v -> {
            Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/CAAjkjRJsW4NWzFM8"));
            startActivity(viewIntent);
        });
    }
}