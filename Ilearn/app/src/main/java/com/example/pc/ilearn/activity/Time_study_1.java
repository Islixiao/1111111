package com.example.pc.ilearn.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

import java.sql.Date;
<<<<<<< HEAD
/**
* 重点：fragment以及chronometer的运用
*
 **/
=======

>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25

public class Time_study_1 extends Fragment  implements View.OnClickListener,Chronometer.OnChronometerTickListener{
    private Chronometer chronometer;
    private Button btn_start,btn_stop,btn_base,btn_pc;
    private EditText e2;
    private TextView e1;
<<<<<<< HEAD
    Integer sum=0;
    String mess = null;
    private myOverDatabaseHelper dbHelper;
    private static boolean PAUSE =false ;
    private long rangeTime;
    private TextView textView;
    @Nullable//定义的字段可以为空

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 一个布局文件 填充Fragment
        View view=inflater.inflate(R.layout.time_study_1,container,false);
        textView = view.findViewById(R.id.hhh);

        //将要传递的数据封装在一Bundle中，得到main_Activity传来的数据
        Bundle bundle =this.getArguments();
        if(bundle!=null){
            mess=bundle.getString("data");
        }
        textView.setText(mess);//setText()设置控件显示内容
        return view;
    }
//onCreateView()：每次创建、绘制该Fragment的View组件时回调该方法，Fragment将会显示该方法返回的View组件。
//onActivityCreated()：当Fragment所在的Activity被启动完成后回调该方法。
=======
    String mess = null;
   private myOverDatabaseHelper dbHelper;
    private static boolean PAUSE =false ;
    private long rangeTime;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.time_study_1,container,false);
        textView = view.findViewById(R.id.hhh);
        //得到main_Activity数据
        Bundle bundle =this.getArguments();

        if(bundle!=null){
            mess=bundle.getString("data");
        }
        textView.setText(mess);
        //
        return view;
    }

>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        chronometer=getActivity().findViewById(R.id.chronometer);
        btn_start= getActivity().findViewById(R.id.btnStart);
        btn_stop=getActivity().findViewById(R.id.btnStop);
        btn_pc=getActivity().findViewById(R.id.btnpc);
        btn_base=getActivity().findViewById(R.id.btnReset);
        e1=getActivity().findViewById(R.id.timesum);
        e2=getActivity().findViewById(R.id.textsum);
        dbHelper= new myOverDatabaseHelper(getActivity());

        chronometer.setOnChronometerTickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_pc.setOnClickListener(this);
        btn_base.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();// 开始计时
                Toast.makeText(getActivity(),"开始计时",Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnStop:
                SQLiteDatabase db= dbHelper.getWritableDatabase();
                chronometer.stop();// 停止计时
                //秒数
                String e11=getChronometerSeconds(chronometer);
                int ie11=Integer.valueOf(e11);
                //00:00
                String e111=chronometer.getText().toString();
                String string =e2.getText().toString();
                String today=new Date(new java.util.Date().getTime()).toString();

                //插入表
<<<<<<< HEAD
                db.execSQL("insert into single_people_time(datetoday , llongtime , saytext,username)values(?,?,?,?)",
                        new String[]{today,e111,string,mess});

                Cursor cursor = db.rawQuery("select username ,llongtime ,datetoday from all_people_today  where username=? and datetoday=?", new String[]{mess,today});
                 sum = ie11;
                //判断总记录表中是否存在该用户名且日期属于今天的记录，存在就更新时长属性，不存在就创建
                if (cursor.moveToNext()) {

                      sum+=cursor.getInt(cursor.getColumnIndex("llongtime"));//获取总秒数
                     db.beginTransaction();
                    //更新数据
                    db.execSQL("update all_people_today set llongtime=? where username=? and datetoday=?",new Object[]{sum,mess,today});
                    db.setTransactionSuccessful();
                    db.endTransaction();
                } else {
                    db.execSQL("insert into all_people_today(datetoday,llongtime ,username) values(?,?,?)",new Object[] { today,sum,mess });
                }


                //排行榜
                //判断排行中是否存在该用户名，存在就更新时长属性，不存在就创建
                Cursor cursor1 = db.rawQuery("select username ,llongtime ,datetoday from ranklist  where username=? and datetoday=?", new String[]{mess,today});
                if (cursor1.moveToNext()) {
                    sum+=cursor1.getInt(cursor1.getColumnIndex("llongtime"));//获取总秒数

                    db.beginTransaction();
                    //更新数据
                    db.execSQL("update ranklist set llongtime=? where username=? ",new Object[]{sum,mess});
                    db.setTransactionSuccessful();
                    db.endTransaction();
                } else {
                    db.execSQL("insert into ranklist(datetoday,llongtime ,username) values(?,?,?)",new Object[] { today,sum,mess });
                }//删除多余数据
                db.execSQL("delete from ranklist where  datetoday!=?  " ,new Object[]{today});


=======
                db.execSQL("insert into single_people_time(datetoday , llongtime , saytext)values(?,?,?)",
                        new String[]{today,e111,string});

                //从数据库中获取用户名并判断是否相同
                Cursor cursor = db.rawQuery("select username ,llongtime from all_people_today  where username=?", new String[]{mess});
                int sum ;
                if (cursor.moveToNext()) {
                    Cursor cursor1 = db.rawQuery("select llongtime  from all_people_today  where username=?", new String[]{mess});
                    sum= cursor1.getInt(cursor1.getColumnIndex("llongtime"));//获取总秒数
                    sum+=ie11;
                    db.execSQL("update all_people_today set llongtime="+sum+"  where username="+mess);

                } else {
                    db.execSQL("insert into all_people_today(datetoday,llongtime ,username) values('today',2,'hehe')");
                   // Toast.makeText(getActivity(),"已单击",Toast.LENGTH_SHORT).show();


                }
                db.execSQL("insert into ranklist(llongtime ,username) select llongtime ,username from all_people_today " );
                //+" Order by llongtime DESC"


               //new Date(new java.util.Date().getTime())
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
                if(Integer.valueOf(e11)<=1800){
                    String a1="咳咳，今天的学习时间太少了吧";
                    e1.setText("今日总时间："+e111);
                    Toast.makeText(getActivity(), a1, Toast.LENGTH_SHORT).show();

                }
                if(Integer.valueOf(e11)>=18000) {
                    String a2="优秀了";
                    Toast.makeText(getActivity(), a2, Toast.LENGTH_SHORT).show();
                    e1.setText("今日总时间："+e111);
                }
                if(1800<=Integer.valueOf(e11)&&Integer.valueOf(e11)<18000){
                    String a3="。。。。。";
                    e1.setText("今日总时间："+e111);
                    Toast.makeText(getActivity(), a3, Toast.LENGTH_SHORT).show();

                }
                break;

                case R.id.btnReset:
                chronometer.setBase(SystemClock.elapsedRealtime());// 复位
                chronometer.stop();
                break;

                case R.id.btnpc:
                if(!PAUSE)//暂停计时
                {
                    btn_pc.setText("继续");
//从开始计时计时器运行的时间差。。。。。关键
                    Time_study_1.this.rangeTime=SystemClock.elapsedRealtime()-chronometer.getBase();
//Toast.makeText(MainActivity.this, "时间："+rangeTime, Toast.LENGTH_SHORT).show();
                    chronometer.stop();
                }
                else //继续计时
                {
                    btn_pc.setText("暂停");


//设置计时器的基时间。。。。。关键
                    chronometer.setBase(SystemClock.elapsedRealtime()-rangeTime);
                    chronometer.start();
                }

                PAUSE=!PAUSE;

        }

    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        int totalss = 0;
        String string = chronometer.getText().toString();
<<<<<<< HEAD
=======
       /* if(time.equals("00:00")){
            Toast.makeText(getActivity(),"时间到了",Toast.LENGTH_SHORT).show();
        }*/


>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
    }
    /**
     *
     * @param cmt  Chronometer控件
     * @return 小时+分钟+秒数  的所有秒数
     */
    public  static String getChronometerSeconds(Chronometer cmt) {
        int totalss = 0;
        String string = cmt.getText().toString();
        if(string.length()==7){

            String[] split = string.split(":");
            String string2 = split[0];
            int hour = Integer.parseInt(string2);
            int Hours =hour*3600;
            String string3 = split[1];
            int min = Integer.parseInt(string3);
            int Mins =min*60;
            int  SS =Integer.parseInt(split[2]);
            totalss = Hours+Mins+SS;
            return String.valueOf(totalss);
        }

        else if(string.length()==5){

            String[] split = string.split(":");
            String string3 = split[0];
            int min = Integer.parseInt(string3);
            int Mins =min*60;
            int  SS =Integer.parseInt(split[1]);

            totalss =Mins+SS;
            return String.valueOf(totalss);
        }
        return String.valueOf(totalss);


    }

}