package com.example.pc.ilearn.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.ilearn.R;
<<<<<<< HEAD
=======
import com.example.pc.ilearn.entity.PeopleAll;
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
import com.example.pc.ilearn.entity.PeopleSingle;

import java.util.ArrayList;

public class DiaryAdapter extends BaseAdapter {

    private Context context;
<<<<<<< HEAD
    private ArrayList<PeopleSingle> listData;//一个保存有PeopleSingle类型对象的泛型数组列表
=======
    private ArrayList<PeopleSingle> listData;
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25


    public DiaryAdapter(Context context,ArrayList<PeopleSingle> listData) {
        this.context = context;
        this.listData = listData;

    }

    @Override
    public int getCount() {
<<<<<<< HEAD
=======
        // TODO Auto-generated method stub
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
        return listData.size();
    }
    @Override
    public Object getItem(int pos) {
<<<<<<< HEAD
=======
        // TODO Auto-generated method stub
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
        return listData.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return pos;
    }

<<<<<<< HEAD
    @Override//完成里面的每一个item子项的适配工作,view为空则利用xml产生一个view并返回
    public View getView(int pos, View view, ViewGroup arg2) {
       //初始化一个ViewHolder的对象，初始值为空。
        ViewHolder viewholder = null;
        if(view == null){
            LayoutInflater inflate=LayoutInflater.from(context);//为列表的行定义了一个布局名字叫listviewitem.xml
            view=inflate.inflate(R.layout.listviewitem,null);

            viewholder = new ViewHolder();
            viewholder.tv_id= view.findViewById(R.id.tv_id);//通过ID引用该控件
            viewholder.tv_time= view.findViewById(R.id.tv_time);
            viewholder.tv_date= view.findViewById(R.id.tv_date);
            viewholder.tv_content = view.findViewById(R.id.tv_content);
            view.setTag(viewholder);//添加数据
        }
        viewholder = (ViewHolder)view.getTag();//获取数据
        PeopleSingle model = listData.get(pos);//行数
        pos++;//pos从0开始，所以要先自增1；
        viewholder.tv_id.setText(pos+"");
=======
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
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
        viewholder.tv_time.setText(model.getLlongtime());
        viewholder.tv_date.setText(model.getDatetoday());
        viewholder.tv_content.setText(model.getSaytext());
        return view;
    }
<<<<<<< HEAD
    //对应实体类的4个属性
=======

>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
    class ViewHolder {
        private TextView tv_id;
        private TextView tv_content;
        private TextView tv_date;
        private TextView tv_time;

    }
}
