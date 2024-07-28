package com.project.trackerapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.project.trackerapp.databinding.FragmentHomeTrackerBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeTrackerFragment extends Fragment {
    FragmentHomeTrackerBinding binding;
    BarChart chartData;
    Context context;
    private List<float[]> dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = requireContext();
        binding = FragmentHomeTrackerBinding.inflate(inflater, container, false);

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setToolbar("Tracker!");
        }

        chartData = binding.chart;

        binding.add.setOnClickListener(v -> {
            showBottomSheetDialog();
        });

        dataList = new ArrayList<>();
        dataList.add(new float[]{700000.0f, 710000.0f, 720000.0f, 730000.0f});
        dataList.add(new float[]{740000.0f, 750000.0f, 760000.0f, 770000.0f});
        dataList.add(new float[]{780000.0f, 790000.0f, 800000.0f, 810000.0f});
        dataList.add(new float[]{820000.0f, 830000.0f, 840000.0f, 850000.0f});
        dataList.add(new float[]{860000.0f, 870000.0f, 880000.0f, 890000.0f});
        dataList.add(new float[]{900000.0f, 910000.0f, 920000.0f, 930000.0f});
        dataList.add(new float[]{940000.0f, 950000.0f, 960000.0f, 970000.0f});
        grafikData();

        return binding.getRoot();
    }

    public void grafikData() {
        List<BarEntry> entriesHunian = new ArrayList<>();
        List<BarEntry> entriesSembako = new ArrayList<>();
        List<BarEntry> entriesOperasi = new ArrayList<>();
        List<BarEntry> entriesRekreasi = new ArrayList<>();
        String[] datainfo = new String[dataList.size() + 1];
        String[] dataLabel = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"};

        datainfo[0] = "";

        for (int i = 0; i < dataList.size(); i++) {
            float[] data = dataList.get(i);
            entriesHunian.add(new BarEntry(i+1, data[0]));
            entriesSembako.add(new BarEntry(i+1, data[1]));
            entriesOperasi.add(new BarEntry(i+1, data[2]));
            entriesRekreasi.add(new BarEntry(i+1, data[3]));
            datainfo[i+1] = dataLabel[i];
        }

        BarDataSet dataSetHunian = new BarDataSet(entriesHunian, "Hunian");
        dataSetHunian.setColor(Color.GREEN);
        dataSetHunian.setDrawValues(false); // Disable value labels

        BarDataSet dataSetSembako = new BarDataSet(entriesSembako, "Sembako");
        dataSetSembako.setColor(Color.LTGRAY);
        dataSetSembako.setDrawValues(false); // Disable value labels

        BarDataSet dataSetOperasi = new BarDataSet(entriesOperasi, "Operasi");
        dataSetOperasi.setColor(Color.BLUE);
        dataSetOperasi.setDrawValues(false); // Disable value labels

        BarDataSet dataSetRekreasi = new BarDataSet(entriesRekreasi, "Rekreasi");
        dataSetRekreasi.setColor(Color.RED);
        dataSetRekreasi.setDrawValues(false); // Disable value labels

        BarData barData = new BarData(dataSetHunian, dataSetSembako, dataSetOperasi, dataSetRekreasi);

        // Set bar width
        float groupSpace = 0.4f;
        float barSpace = 0.02f;
        float barWidth = 0.13f;
        // (4 variables * barWidth) + (3 variables * barSpace) = 1.00 -> Interval per "group"

        barData.setBarWidth(barWidth);

        chartData.setData(barData);
        chartData.getDescription().setEnabled(false);
        chartData.getDescription().setText("");
        chartData.setBackgroundColor(Color.WHITE);
        chartData.setGridBackgroundColor(Color.WHITE);
        chartData.setDrawGridBackground(true);
        chartData.setDrawBorders(true);
        chartData.setAutoScaleMinMaxEnabled(true);
        chartData.setBorderColor(Color.BLACK);
        chartData.setBorderWidth(0f);
        chartData.setDragEnabled(true);
        chartData.setScaleEnabled(true);
        chartData.setVisibleXRangeMaximum(6);

        // Set the X-Axis labels
        XAxis xAxis = chartData.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(datainfo));
        xAxis.setLabelCount(datainfo.length);
        xAxis.setSpaceMin(0f);
        xAxis.setSpaceMax(1f);
        xAxis.setCenterAxisLabels(true);

        chartData.getAxisRight().setEnabled(false);
        chartData.setFitBars(true);
        chartData.groupBars(1f, groupSpace, barSpace); // perform the "explicit" grouping
        chartData.invalidate(); // refresh
    }

    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.layout_bottom_pengeluaran, null);
        bottomSheetView.findViewById(R.id.btn_close).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        bottomSheetView.findViewById(R.id.btn_cancel).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}