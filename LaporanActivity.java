package com.project.trackerapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.project.trackerapp.databinding.ActivityLaporanBinding;


public class LaporanActivity extends AppCompatActivity {
    ActivityLaporanBinding binding;
    Context context;
    Integer pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaporanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = LaporanActivity.this;

        binding.btnContinue.setOnClickListener(v -> {
            if(pos == 0){
                binding.wrapStep1.setVisibility(View.GONE);
                binding.wrapStep2.setVisibility(View.VISIBLE);
                pos+=1;
            }else if(pos == 1){
                binding.wrapStep2.setVisibility(View.GONE);
                binding.wrapStep3.setVisibility(View.VISIBLE);
                pos+=1;
                binding.btnContinue.setText("Selesai");
            }else {
                finish();
            }
        });

    }
}