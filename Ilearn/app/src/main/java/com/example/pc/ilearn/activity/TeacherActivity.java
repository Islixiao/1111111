package com.example.pc.ilearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.pc.ilearn.R;

public class TeacherActivity extends AppCompatActivity {

    private Button Info1,Info2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_layout);
        Info1=findViewById(R.id.Tea_activity_select);
        Info2=findViewById(R.id.Tea_activity_time);

        //接收TeacherLoginActivity的参数uesrname
        Bundle bundl=this.getIntent().getExtras();
        final String username=bundl.getString("username");


        Info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TeacherActivity.this,"已单击",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TeacherActivity.this,main_tea_Activity.class);
                startActivity(intent);
            }
        });


        Info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Toast.makeText(TeacherActivity.this,"已单击",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TeacherActivity.this,TeacherInfoActivity.class);
                Bundle bundle = new Bundle();
                //参数传递
                bundle.putString("data",username);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}

