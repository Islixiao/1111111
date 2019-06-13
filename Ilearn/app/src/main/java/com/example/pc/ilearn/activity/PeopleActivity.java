package com.example.pc.ilearn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.example.pc.ilearn.R;



public class PeopleActivity extends AppCompatActivity {


    private TextView Info1,Info2,Info3,Info4,Info5,Info6,Info7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.peoplemessage);

        //接收从Layout_study_4（fragment）传过来的参数，并通过setText()方法赋值给Info1
        Info1=findViewById(R.id.edtusername);
        Info2=findViewById(R.id.edtrealname);
        Info3=findViewById(R.id.edtsid);
        Info4=findViewById(R.id.edtcollege);
        Info5=findViewById(R.id.edtmajor);
        Info6=findViewById(R.id.edtclass);
        Info7=findViewById(R.id.edtyear);
        Bundle bundl=this.getIntent().getExtras();
        //String data=bundl.getString("user");
        String username=bundl.getString("username");
        String sid=bundl.getString("sid");
        String col=bundl.getString("college");
        String realname=bundl.getString("realname");
        String major=bundl.getString("major");
        String clas=bundl.getString("clas");
        String year=bundl.getString("year");
        Info1.setText(username);
        Info2.setText(realname);
        Info3.setText(sid);
        Info4.setText(col);
        Info5.setText(major);
        Info6.setText(clas);
        Info7.setText(year);
    }
}

