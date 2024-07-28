package com.project.trackerapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.project.trackerapp.adapter.RecyclerAdapterBerita;
import com.project.trackerapp.databinding.ActivitySemuaBeritaBinding;

public class SemuaBeritaActivity extends AppCompatActivity {
    Context context;
    ActivitySemuaBeritaBinding binding;

    RecyclerAdapterBerita recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySemuaBeritaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = SemuaBeritaActivity.this;
        
        binding.btnBack.setOnClickListener(v -> {
            finish();
        });

        initData();
    }

    public void initData() {
        recyclerAdapter = new RecyclerAdapterBerita(context);
        binding.rvData.setAdapter(recyclerAdapter);
    }
}