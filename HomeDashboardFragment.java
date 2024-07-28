package com.project.trackerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.project.trackerapp.adapter.RecyclerAdapterBerita;
import com.project.trackerapp.databinding.FragmentHomeDashboardBinding;

public class HomeDashboardFragment extends Fragment {
    FragmentHomeDashboardBinding binding;
    RecyclerAdapterBerita recyclerAdapter;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = getContext();

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setToolbar("HOME");
        }

        initData();

        binding.seeAll.setOnClickListener(v -> {
            Intent intent = new Intent(context, SemuaBeritaActivity.class);
            startActivity(intent);
        });

        binding.btnLapor.setOnClickListener(v -> {
            showBottomSheetDialog();
        });

        binding.wrapShelter.setOnClickListener(v -> {
            showBottomSheetCategoryDialog("Shelter", "Program Rumah Singgah Bagi Individu/ Keluarga Yang Rentan Ketunawismaan Oleh Pemerintah/ NGO", R.drawable.image_shelter);
        });

        binding.wrapCommmunity.setOnClickListener(v -> {
            showBottomSheetCategoryDialog("Community", "Bergabung Di Grup Online Yang Membahas Hunian, Dukungan Komunitas Atas Akses Hunian, Event Sosial, & Program Bansos", R.drawable.image_community);
        });

        binding.wrapArticle.setOnClickListener(v -> {
            showBottomSheetCategoryDialog("Articles", "Ragam Bahasan Ketunawismaan, Pertolongan Kasus, Program Sosial & Artikel Kiriman Pengguna", R.drawable.image_article);
        });

        return root;
    }

    public void initData() {
        recyclerAdapter = new RecyclerAdapterBerita(context);
        binding.rvData.setAdapter(recyclerAdapter);
    }

    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.layout_bottom_home_lapor, null);
        bottomSheetView.findViewById(R.id.btn_close).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        bottomSheetView.findViewById(R.id.btn_cancel).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void showBottomSheetCategoryDialog(String title, String desc, Integer image) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.layout_bottom_category, null);
        bottomSheetView.findViewById(R.id.btn_close).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        TextView tvTitle = bottomSheetView.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        TextView tvDesc = bottomSheetView.findViewById(R.id.tv_desc);
        tvDesc.setText(desc);
        ImageView imgvImage = bottomSheetView.findViewById(R.id.imgv_image);
        Glide.with(context).load(image).into(imgvImage);

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

}