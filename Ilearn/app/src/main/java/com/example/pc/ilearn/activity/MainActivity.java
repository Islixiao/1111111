package com.example.pc.ilearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.pc.ilearn.R;

//登陆注册界面
public class MainActivity extends AppCompatActivity {

    private Button stu;
    private Button tea;
    private Button adm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);//加载布局页面
        stu = findViewById(R.id.main_activity_student);//获取控件
        tea = findViewById(R.id.main_activity_teacher);
        adm=findViewById(R.id.main_activity_admin);

        //跳转到登录学生界面
        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(intent1);
              }

        });//跳转到老师登录界面
        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(MainActivity.this, TeacherLoginActivity.class);
                startActivity(intent2);
                Toast.makeText(MainActivity.this, "老师好！", Toast.LENGTH_SHORT).show();
            }
        });
        adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(MainActivity.this, AdminLoginActivity.class);
                startActivity(intent3);
            }
        });

    }
















}
















