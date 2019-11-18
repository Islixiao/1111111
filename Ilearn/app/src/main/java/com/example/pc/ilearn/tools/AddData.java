package com.example.pc.ilearn.tools;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.ilearn.R;


public class AddData extends AppCompatActivity {
    private EditText Name,Username,College,Major,Sid;
    private Button but;
    private Utildaodb dao;
    private Intent intent;
    SQLiteDatabase db;
    private myOverDatabaseHelper dbhelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_alterdata);
        //初始化组件
        dbhelper=new myOverDatabaseHelper(this);
        initWidget();
        DbUtil();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String username = Username.getText().toString();
                String college = College.getText().toString();
                String major = Major.getText().toString();
                String sid=Sid.getText().toString();
                db=dbhelper.getWritableDatabase();
                    String[] key = {"name","username","college","major","sid"};
                    String[] values = {name,username,college,major,sid};
                    intent = new Intent();
                    /*Bundle bundle = new Bundle();
                    bundle.putString("",);*/

                    //点击添加按钮则返回 key 和 values 数组
                    intent.putExtra("key",key);
                    intent.putExtra("values",values);
                    intent.putExtra("name",name);
                    intent.putExtra("username",username);
                    intent.putExtra("college",college);
                    intent.putExtra("major",major);
                    intent.putExtra("sid",sid);
                    setResult(RESULT_OK,intent);
                    db.execSQL("insert into student(username,password, sid,name,college, major)values(?,?,?,?,?,?)", new String[]{username, "123456",sid, name, college, major});
                Toast.makeText(AddData.this, "添加成功", Toast.LENGTH_SHORT).show();//默认密码123456

                finish();

            }
        });
    }

    /**
     * 初始化控件
     * */
    private void initWidget(){
        Name = findViewById(R.id.add_edit_name);
        Username = findViewById(R.id.add_edit_username);
        College = findViewById(R.id.add_edit_college);
        Major = findViewById(R.id.add_edit_major);
        but = findViewById(R.id.add_button);
        Sid = findViewById(R.id.add_edit_sid);
    }

    public void DbUtil(){
        dao = ((Admin_Activity_db)this.getApplication()).getDao();
    }

}
