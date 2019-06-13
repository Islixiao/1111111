package com.example.pc.ilearn.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.EditText;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class PeopleteaActivity extends AppCompatActivity {
    private myOverDatabaseHelper dbHelper;

    private EditText Info1,Info2,Info3,Info4,Info5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teachermessage);
        dbHelper = new myOverDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Info1=findViewById(R.id.edtusername);
        Info2=findViewById(R.id.edtrealname);
        Info3=findViewById(R.id.edttid);
        Info4=findViewById(R.id.edtcollege);
        Info5=findViewById(R.id.edtmajor);
        //接收TeacherInfoActivity的参数data
        Bundle bundl=this.getIntent().getExtras();
        String username=bundl.getString("data");

        String real = "";
        String tid = "";
        String col = "";
        String maj = "";

        Cursor cursor1 = db.rawQuery("select username,name,tid,college,major from teacher  where username=?", new String[]{username});
        if (cursor1.moveToNext()) {
            real = cursor1.getString(cursor1.getColumnIndex("name"));
            tid = cursor1.getString(cursor1.getColumnIndex("tid"));
            col = cursor1.getString(cursor1.getColumnIndex("college"));
            maj = cursor1.getString(cursor1.getColumnIndex("major"));
        }

        Info1.setText(username);
        Info2.setText(real);
        Info3.setText(tid);
        Info4.setText(col);
        Info5.setText(maj);


    }
}

