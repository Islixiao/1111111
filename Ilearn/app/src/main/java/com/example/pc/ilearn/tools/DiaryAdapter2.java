package com.example.pc.ilearn.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.entity.PeopleAll;

import java.util.ArrayList;

public class DiaryAdapter2 extends BaseAdapter {

    private Context context;

    private  ArrayList<PeopleAll> listData;


    public DiaryAdapter2(Context context, ArrayList<PeopleAll> list) {
        this.context = context;
        this.listData = list;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listData.size();
    }
    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return listData.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup arg2) {
        // TODO Auto-generated method stub


        ViewHolder viewholder = null;
        if(view == null){
            LayoutInflater inflate=LayoutInflater.from(context);
            view=inflate.inflate(R.layout.listviewitem1,null);//此处layout是listview item的布局,我的命名不规范！！！
            viewholder = new ViewHolder();
            viewholder.tv_id= (TextView)view.findViewById(R.id.tv_id);
            viewholder.tv_time= (TextView)view.findViewById(R.id.tv_time);
            viewholder.tv_username = (TextView)view.findViewById(R.id.tv_name);
            view.setTag(viewholder);
        }
        viewholder = (ViewHolder)view.getTag();
        PeopleAll model = listData.get(pos);
        int i;
        viewholder.tv_id.setText(model.getId());
        viewholder.tv_time.setText(model.getLlongtime());
        viewholder.tv_username.setText(model.getUsername());
        return view;
    }

    class ViewHolder {
        private TextView tv_id;
        private TextView tv_username;
        private TextView tv_time;

    }
}
