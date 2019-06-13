package com.example.pc.ilearn.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.entity.PeopleAll;
import com.example.pc.ilearn.entity.PeopleSingle;

import java.util.ArrayList;

public class DiaryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<PeopleSingle> listData;


    public DiaryAdapter(Context context,ArrayList<PeopleSingle> listData) {
        this.context = context;
        this.listData = listData;

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
            view=inflate.inflate(R.layout.listviewitem,null);//此处layout是listview item的布局,我的命名不规范！！！
            viewholder = new ViewHolder();
            viewholder.tv_id= (TextView)view.findViewById(R.id.tv_id);
            viewholder.tv_time= (TextView)view.findViewById(R.id.tv_time);
            viewholder.tv_date= (TextView)view.findViewById(R.id.tv_date);
            viewholder.tv_content = (TextView)view.findViewById(R.id.tv_content);
            view.setTag(viewholder);
        }
        viewholder = (ViewHolder)view.getTag();
        PeopleSingle model = listData.get(pos);
        viewholder.tv_id.setText(model.getId());
        viewholder.tv_time.setText(model.getLlongtime());
        viewholder.tv_date.setText(model.getDatetoday());
        viewholder.tv_content.setText(model.getSaytext());
        return view;
    }

    class ViewHolder {
        private TextView tv_id;
        private TextView tv_content;
        private TextView tv_date;
        private TextView tv_time;

    }
}
