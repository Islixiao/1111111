package com.example.pc.ilearn.tools;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.ilearn.R;


public class AlterDatatea extends AppCompatActivity {
    private EditText Name,Tid;
    private Button but;
    private Utildaodb dao;
    private Intent intent;
    private myOverDatabaseHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_alter_data);
        dbHelper=new myOverDatabaseHelper(this);
        //初始化组件
        initWidget();
        DbUtil();

        /**
         * 点击编辑按钮传过来的值
         * 用于显示当前编辑项的数据信息
         * */
        intent = getIntent();
        String name1 = intent.getStringExtra("name");
            String tid=intent.getStringExtra("tid");

        Name.setText(name1);
        Tid.setText(tid);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    SQLiteDatabase db=dbHelper.getWritableDatabase();
                    String name = Name.getText().toString();
                    String tid=Tid.getText().toString();
                 db.execSQL("update teacher set name=?  where tid=?",new String[]{name,tid});
                    finish();
            }
        });
    }

    /**
     * 初始化控件
     * */
    private void initWidget(){
        Name = findViewById(R.id.add_edit_name);
        but = findViewById(R.id.add_button);
        Tid = findViewById(R.id.add_edit_sid);
    }

    public void DbUtil(){
        dao = ((Admin_Activity_db)this.getApplication()).getDao();

    }

}
