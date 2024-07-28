package com.project.trackerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.project.trackerapp.adapter.RecyclerAdapterOrang;
import com.project.trackerapp.databinding.FragmentHomeSettingBinding;

public class HomeCaseworkerFragment extends Fragment {
    FragmentHomeSettingBinding binding;
    RecyclerAdapterOrang recyclerAdapter;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        context = getContext();

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setToolbar("Caseworker");
        }

        initData();

        return root;
    }

    public void initData() {
        recyclerAdapter = new RecyclerAdapterOrang(context);
        binding.rvData.setAdapter(recyclerAdapter);
        binding.rvData.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerAdapter.setOnclickCallback(position -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("pos", position);
            startActivity(intent);
        });
    }
}