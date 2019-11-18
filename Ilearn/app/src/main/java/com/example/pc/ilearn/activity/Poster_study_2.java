package com.example.pc.ilearn.activity;

import android.database.Cursor;
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

import java.sql.Date;
import java.util.ArrayList;


public class Poster_study_2 extends Fragment {
    ListView lv_diary;
    private SQLiteDatabase db;
    myOverDatabaseHelper helper;
    private ArrayList<PeopleSingle> listData;
    private DiaryAdapter adapter;
    private String mess;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.poster_study_2,container,false);
        View view=this.getLayoutInflater().inflate(R.layout.poster_study_2,null);
        lv_diary = view.findViewById(R.id.lv_diary);

        //将要传递的数据封装在一Bundle中，得到main_Activity传来的数据
        Bundle bundle =this.getArguments();
      if(bundle!=null){
            mess=bundle.getString("data");
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listData = new ArrayList<PeopleSingle>();
        helper = new myOverDatabaseHelper(getActivity());
        db = helper.getWritableDatabase();

        String table="single_people_time";
        String[] select=new String[]{new Date(new java.util.Date().getTime()).toString()};
        Cursor cursor = db.query(table, null, "username=?", new String[]{mess}, null, null, null);
        Cursor cursor1 = db.query("ranklist", null, null, null, null, null, null);

        while (cursor.moveToNext()) {//new Date(new java.util.Date().getTime()).toString()
            PeopleSingle diary = new PeopleSingle();
            diary.setId(cursor.getString(cursor.getColumnIndex("id")));
              diary.setLlongtime(cursor.getString(cursor.getColumnIndex("llongtime")));
            diary.setDatetoday(cursor.getString(cursor.getColumnIndex("datetoday")));
            diary.setSaytext(cursor.getString(cursor.getColumnIndex("saytext")));
            listData.add(diary);
        }
        adapter = new DiaryAdapter(this.getActivity(), listData);
        lv_diary.setAdapter(adapter);
        adapter.notifyDataSetChanged();

      }

    }

