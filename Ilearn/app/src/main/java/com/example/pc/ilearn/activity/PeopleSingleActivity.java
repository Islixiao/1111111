package com.example.pc.ilearn.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.entity.PeopleSingle;
import com.example.pc.ilearn.tools.DiaryAdapter;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

import java.sql.Date;
import java.util.ArrayList;

public class PeopleSingleActivity extends AppCompatActivity {

    TextView tv_id,tv_time,tv_date,tv_content;
    ListView lv_diary;
    private SQLiteDatabase db;
    myOverDatabaseHelper helper;
    private ArrayList<PeopleSingle> listData;
    private DiaryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.timetable);
        tv_id =  findViewById(R.id.tv_id);
        tv_content = findViewById(R.id.tv_content);
        tv_date = findViewById(R.id.tv_date);
        tv_time = findViewById(R.id.tv_time);
        lv_diary =findViewById(R.id.lv_diary);
        Bundle bundle =this.getIntent().getExtras();

//        String[] mess=new String[]{bundle.getString("user")};
        String mess=bundle.getString("user");

        listData= new ArrayList<>();
        helper=new myOverDatabaseHelper(this);
        db=helper.getWritableDatabase();
        String table="single_people_time";
        String select=new Date(new java.util.Date().getTime()).toString();

//        String[] select=new String[]{new Date(new java.util.Date().getTime()).toString()};
        Cursor cursor = db.query(table, null, "datetoday=? and username=?",new String[]{select,mess} , null, null, null);
        while (cursor.moveToNext()) {//new Date(new java.util.Date().getTime()).toString()
            PeopleSingle diary = new PeopleSingle();
            diary.setId(cursor.getString(cursor.getColumnIndex("id")));
            diary.setLlongtime(cursor.getString(cursor.getColumnIndex("llongtime")));
            diary.setDatetoday(cursor.getString(cursor.getColumnIndex("datetoday")));
            diary.setSaytext(cursor.getString(cursor.getColumnIndex("saytext")));

            listData.add(diary);
        }
        adapter = new DiaryAdapter(this, listData);
        lv_diary.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}

