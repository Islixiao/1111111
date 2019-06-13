package com.example.pc.ilearn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.entity.Student;

import java.util.List;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class QueayStudentActivity extends AppCompatActivity {

    private Button Info1,Info2,Info3;
    List<Student> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.admin_layoutstu);
        Info1= findViewById(R.id.admin_activity_stu);
        Info2= findViewById(R.id.admin_activity_tea);
        Info3= findViewById(R.id.admin_activity_m);

        Info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QueayStudentActivity.this,"已单击",Toast.LENGTH_SHORT).show();
            }
        });
        Info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Toast.makeText(QueayStudentActivity.this,"已单击",Toast.LENGTH_SHORT).show();
            }
        });
        Info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QueayStudentActivity.this,"已单击",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

