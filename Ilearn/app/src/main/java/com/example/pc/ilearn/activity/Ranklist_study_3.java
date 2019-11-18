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
import com.example.pc.ilearn.entity.PeopleAll;
import com.example.pc.ilearn.tools.DiaryAdapter2;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

import java.sql.Date;
import java.util.ArrayList;

<<<<<<< HEAD
public class Ranklist_study_3 extends Fragment {
    TextView tv_id,tv_time,tv_username;
    ListView l_diary;
=======

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class Ranklist_study_3 extends Fragment {
    TextView tv_id,tv_time,tv_username;
    ListView lv_diary;
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
    private SQLiteDatabase db;
    myOverDatabaseHelper helper;
    private ArrayList<PeopleAll> listData;
    private DiaryAdapter2 adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ranklist_study_3,container,false);
<<<<<<< HEAD
        l_diary =  view.findViewById(R.id.l_diary);//l_diary =  getActivity().findViewById(R.id.l_diary);错误
=======
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv_id=getActivity().findViewById(R.id.tv_id);
        tv_time=getActivity().findViewById(R.id.tv_time);
        tv_username=getActivity().findViewById(R.id.tv_username);
<<<<<<< HEAD
=======
        lv_diary = (ListView) getActivity().findViewById(R.id.lv_diary);
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25

        listData = new ArrayList<>();
        helper = new myOverDatabaseHelper(getActivity());
        db = helper.getWritableDatabase();

        String table="ranklist";
        String[] select=new String[]{new Date(new java.util.Date().getTime()).toString()};
<<<<<<< HEAD
        Cursor cursor = db.query(table, null, null, null, null, null, "llongtime DESC");
        while (cursor.moveToNext()) {//new Date(new java.util.Date().getTime()).toString()
            PeopleAll diary = new PeopleAll();
            diary.setPid(cursor.getString(cursor.getColumnIndex("pid")));
=======
        Cursor cursor = db.query(table, null, null, null, null, null, null);
        while (cursor.moveToNext()) {//new Date(new java.util.Date().getTime()).toString()
            PeopleAll diary = new PeopleAll();
            diary.setId(cursor.getString(cursor.getColumnIndex("id")));
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
            diary.setLlongtime(cursor.getString(cursor.getColumnIndex("llongtime")));
            diary.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            listData.add(diary);
        }

<<<<<<< HEAD
        adapter = new DiaryAdapter2(this.getActivity(), listData);
        l_diary.setAdapter(adapter);
=======

        adapter = new DiaryAdapter2(this.getActivity(), listData);
        lv_diary.setAdapter(adapter);
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
        adapter.notifyDataSetChanged();
    }

}


