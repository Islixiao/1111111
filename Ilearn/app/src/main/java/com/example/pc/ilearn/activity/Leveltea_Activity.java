package com.example.pc.ilearn.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.entity.PeopleSingle;
import com.example.pc.ilearn.tools.DiaryAdapter;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

import java.util.ArrayList;

<<<<<<< HEAD

=======
/**
 * Created by IT-CTY on 2018/4/25.
 */
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25

public class Leveltea_Activity extends Fragment {
    TextView tv_id,tv_time,tv_date,tv_content;
    ListView lv_diary;
    private SQLiteDatabase db;
    myOverDatabaseHelper helper;
    private ArrayList<PeopleSingle> listData;
    private DiaryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.level_tea_1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      lv_diary = (ListView) getActivity().findViewById(R.id.lv_diary);


    }

    }

