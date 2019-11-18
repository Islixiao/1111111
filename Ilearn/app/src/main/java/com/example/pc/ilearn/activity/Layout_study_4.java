package com.example.pc.ilearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.ilearn.R;

<<<<<<< HEAD

=======
/**
 * Created by IT-CTY on 2018/4/25.
 */
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25

public class Layout_study_4 extends Fragment {
   private TextView textView;
    private Button timeInfo,changePassword,selectInfo,alter;
    String string=null;//全局变量
    String username=null;
    String sid=null;
    String col=null;
    String realname=null;
    String major=null;
    String clas=null;
    String year=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.student_layout_4,container,false);
        textView=view.findViewById(R.id.tv3);

        //得到从Activity传来的数据
        Bundle bundle =this.getArguments();
        String mess = null;
        string=bundle.getString("data");
        username=bundle.getString("username");
        sid=bundle.getString("sid");
        col=bundle.getString("college");
        realname=bundle.getString("realname");
        major=bundle.getString("major");
        clas=bundle.getString("clas");
        year=bundle.getString("year");
        if(bundle!=null){
            mess=bundle.getString("data");

        }
        textView.setText(mess);
        //
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        selectInfo=(Button)getActivity().findViewById(R.id.student_activity_selectInfo);
        changePassword=(Button)getActivity().findViewById(R.id.student_activity_changePassword);
        timeInfo=(Button)getActivity().findViewById(R.id.student_activity_timeInfo);
        alter=getActivity().findViewById(R.id.student_activityinfo);
       //查询个人信息
        selectInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //传递参数从fragment-->activity,
                Intent intent=new Intent(getActivity(),PeopleActivity.class);

                Bundle bundle =new Bundle();
                bundle.putString("user",string);
                bundle.putString("username",username);
                bundle.putString("sid",sid);
                bundle.putString("college",col);
                bundle.putString("major",major);
                bundle.putString("realname",realname);
                bundle.putString("clas",clas);
                bundle.putString("year",year);
                intent.putExtras(bundle);
                startActivity(intent);

                Toast.makeText(getActivity(),"已单击",Toast.LENGTH_SHORT).show();
            }
        });
        //修改密码
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),PasswordActivity.class);

                Bundle bundle =new Bundle();
                bundle.putString("data",string);
                bundle.putString("num","2");
                intent.putExtras(bundle);
<<<<<<< HEAD
=======

>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
                startActivity(intent);
                Toast.makeText(getActivity(),"已单击",Toast.LENGTH_SHORT).show();
            }
        });
        //查询今日时长
        timeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),PeopleSingleActivity.class);
<<<<<<< HEAD
                Bundle bundle =new Bundle();
                bundle.putString("user",string);
                bundle.putString("username",username);
                intent.putExtras(bundle);

=======
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
                startActivity(intent);
                Toast.makeText(getActivity(),"已单击",Toast.LENGTH_SHORT).show();
            }
        });
        //修改个人信息
        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"尚未实现",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

