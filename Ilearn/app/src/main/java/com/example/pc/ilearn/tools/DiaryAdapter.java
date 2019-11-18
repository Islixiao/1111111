package com.example.pc.ilearn.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.entity.PeopleSingle;

import java.util.ArrayList;

public class DiaryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<PeopleSingle> listData;//一个保存有PeopleSingle类型对象的泛型数组列表


    public DiaryAdapter(Context context,ArrayList<PeopleSingle> listData) {
        this.context = context;
        this.listData = listData;

    }

    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int pos) {
        return listData.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return pos;
    }

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
        viewholder.tv_time.setText(model.getLlongtime());
        viewholder.tv_date.setText(model.getDatetoday());
        viewholder.tv_content.setText(model.getSaytext());
        return view;
    }
    //对应实体类的4个属性
    class ViewHolder {
        private TextView tv_id;
        private TextView tv_content;
        private TextView tv_date;
        private TextView tv_time;

    }
}
