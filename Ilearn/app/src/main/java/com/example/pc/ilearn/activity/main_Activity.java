package com.example.pc.ilearn.activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.pc.ilearn.R;

public class main_Activity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Ranklist_study_3 fragment3;
    private Layout_study_4 fragment4;
    private Time_study_1 timeActivity1;
    private Poster_study_2 poster_study_2;
    private Fragment[] fragments;

    private int lastfragment;//用于记录上个选择的Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_center);
        initFragment();
    }
    //初始化fragment和fragment数组
    private void initFragment()
    {
        timeActivity1 = new Time_study_1 ();
        poster_study_2= new Poster_study_2();
        fragment3 = new Ranklist_study_3();
        fragment4 = new Layout_study_4();
        fragments = new Fragment[]{timeActivity1,poster_study_2,fragment3,fragment4};
        lastfragment=0;
        //接收StudentLoginActivity的参数uesrname
        Bundle bundl=this.getIntent().getExtras();
        String data=bundl.getString("user");

        String username=bundl.getString("username");
        String sid=bundl.getString("sid");
        String col=bundl.getString("college");
        String realname=bundl.getString("realname");
        String major=bundl.getString("major");
        String clas=bundl.getString("clas");

        String year=bundl.getString("year");
        Bundle bundle = new Bundle();

    //把参数传递给fragment4，
        bundle.putString("data",data);
        bundle.putString("username",username);
        bundle.putString("sid",sid);
        bundle.putString("college",col);
        bundle.putString("major",major);
        bundle.putString("realname",realname);
        bundle.putString("clas",clas);
        bundle.putString("year",year);
        fragment4.setArguments(bundle);
<<<<<<< HEAD
        //把参数传递给fragment1,2，       activity-->fragment
        Bundle bundle1 = new Bundle();
        bundle1.putString("data",data);
        timeActivity1.setArguments(bundle1);
        poster_study_2.setArguments(bundle1);
=======
        //把参数传递给fragment1，       activity-->fragment
        Bundle bundle1 = new Bundle();
        bundle1.putString("data",data);
        timeActivity1.setArguments(bundle1);


>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25

        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,timeActivity1).show(timeActivity1).addToBackStack(null).commit();
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }
    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.id1:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;

                    }

                    return true;
                }
                case R.id.id2:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }
                case R.id.id3:
                {
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;

                    }

                    return true;
                }
                case R.id.id4:
                {
                    if(lastfragment!=3)
                    {
                        switchFragment(lastfragment,3);
                        lastfragment=3;

                    }

                    return true;
                }

            }
            return false;
        }
    };
    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.mainview,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
}
