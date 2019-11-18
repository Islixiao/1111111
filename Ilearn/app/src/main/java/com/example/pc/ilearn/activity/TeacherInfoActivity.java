package com.example.pc.ilearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.pc.ilearn.R;


public class TeacherInfoActivity extends AppCompatActivity {
    private Button Info1,Info2,Info3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_info3);

        Info1=findViewById(R.id.teacher_Info1);
        Info2=findViewById(R.id.teacher_Info2);
        Info3=findViewById(R.id.teacher_changePassword);

        //接收TeacherActivity的参数data
        final Bundle bundl=this.getIntent().getExtras();
        final String username=bundl.getString("data");
        //个人资料查看
        Info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TeacherInfoActivity.this,PeopleteaActivity.class);
                Bundle bundle = new Bundle();
                //参数传递
                bundle.putString("data",username);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(TeacherInfoActivity.this,"已单击",Toast.LENGTH_SHORT).show();
            }
        });
        //修改个人资料
        Info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TeacherInfoActivity.this,"该功能暂未实现",Toast.LENGTH_SHORT).show();
            }
        });

        //密码修改
        Info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TeacherInfoActivity.this,PasswordActivity.class);
                Bundle bundle = new Bundle();
                //参数传递
                bundle.putString("data",username);
                bundle.putString("num","1");
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(TeacherInfoActivity.this,"已单击",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

