package com.example.pc.ilearn.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.ilearn.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.example.pc.ilearn.tools.BarChartManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class Collegetea_Activity extends Fragment {
    private BarChart barChart1;
    private XAxis xAxis;
/*
    private SQLiteDatabase db;
    myOverDatabaseHelper helper;
    private ArrayList<PeopleSingle> listData;
    private DiaryAdapter adapter;*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.college_tea_1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }
    private void initView() {
        barChart1 =getActivity().findViewById(R.id.barChart);
        showBarChart();
    }
    private void showBarChart() {

        BarChartManager barChartManager = new BarChartManager(barChart1);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 80f));
        yVals.add(new BarEntry(2f, 50f));
        yVals.add(new BarEntry(3f, 60f));
        yVals.add(new BarEntry(4f, 60f));
        yVals.add(new BarEntry(5f, 70f));
        yVals.add(new BarEntry(6f, 80f));
        String label = "";
        barChartManager.showBarChart(yVals, label, Color.parseColor("#233454"));

    }


}


