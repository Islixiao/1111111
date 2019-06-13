package com.example.pc.ilearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.pc.ilearn.R;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class AdminActivity extends AppCompatActivity {

    private Button Info1,Info2,Info3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.admin_layout);

        Info2=findViewById(R.id.admin_activity_stu);
        Info3=findViewById(R.id.admin_activity_tea);


        Info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminActivity.this,QueayStudentActivity.class);
                startActivity(intent);
                Toast.makeText(AdminActivity.this,"已单击",Toast.LENGTH_SHORT).show();
            }
        });
        Info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminActivity.this,"该功能暂未实现",Toast.LENGTH_SHORT).show();
            }
        });


    }
}

