package com.example.pc.ilearn.activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.entity.Student;
import com.example.pc.ilearn.entity.Teacher;
import com.example.pc.ilearn.tools.Adapter_Adminstu;
import com.example.pc.ilearn.tools.Adapter_Admintea;
import com.example.pc.ilearn.tools.AddData;
import com.example.pc.ilearn.tools.AddDatatea;
import com.example.pc.ilearn.tools.Admin_Activity_db;
import com.example.pc.ilearn.tools.AlterData;
import com.example.pc.ilearn.tools.AlterDatatea;
import com.example.pc.ilearn.tools.Utildaodb;

import java.util.ArrayList;
import java.util.List;

public class Admin_Activitytea extends AppCompatActivity implements View.OnClickListener {

    private TextView textNum;
    private Button button;
    private ListView listView;
    private List<Teacher> list,newList;
    private Utildaodb dao;
    private Adapter_Admintea adapter;
    private int listNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminmangertea);
        //初始化控件
        initWidget();
        //实例dao
        DbUtil();
        //显示ListView
        showListView();
        //显示listView的条目数量
        linkmanNum();
    }
    /**
     * 初始化控件
     * */
    private void initWidget(){
        button = findViewById(R.id.main_button);
        listView = findViewById(R.id.main_list_view);
        textNum = findViewById(R.id.main_num);
        newList = new ArrayList<>();
        list = new ArrayList<>();
    }

    /**
     * 显示ListView
     * */
    public void showListView(){
        //查询数据
        /**
         * 添加数据到链表中
         * **/
        list = dao.inquireDatatea();

        /**
         * 创建并绑定适配器
         * */
        adapter = new Adapter_Admintea(this,R.layout.admin_teaitem,list);
        listView.setAdapter(adapter);

        /**
         * ListView事件监听
         * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialogList();
                listNum = i;
            }
        });

        button.setOnClickListener(this);
    }

    /**
     * 普通对话框
     * */
    public void dialogNormal(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener dialogOnClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Teacher userDel = list.get(listNum);
                switch (i){
                    case DialogInterface.BUTTON_POSITIVE:
                        dao.delDataTea("name=?",new String[]{userDel.getName()});
                        refresh();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                    default:break;
                }
            }
        };
        builder.setTitle("删除教师");
        builder.setMessage("确定删除吗？");
        builder.setPositiveButton("确定", dialogOnClick);
        builder.setNegativeButton("取消",dialogOnClick);
        builder.create().show();
    }

    /**
     * 选项列表
     * */
    public void dialogList(){
        final String[] items = {"编辑","删除"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                //拿到当前选中项的 User 对象
                Teacher userNum = list.get(listNum);
                Intent intent;
                switch (i){

                    case 0: intent = new Intent(Admin_Activitytea.this,AlterDatatea.class);
                        //传入当前选中项的姓名和电话以在编辑页面中显示在输入框中
                        intent.putExtra("name",userNum.getName().toString());
                        intent.putExtra("tid",userNum.getTid().toString());

                        startActivityForResult(intent,2);
                        break;
                    //弹出对话框提示是否删除
                    case 1: dialogNormal();
                        break;
                    default:
                        break;
                }
            }
        });
        builder.create().show();
    }

    //刷新
    public void refresh(){
        //最后查询数据刷新列表
        getNotifyData();
    }

    //页面顶部显示ListView条目数
    public void linkmanNum(){
        textNum.setText("("+list.size()+")");
    }

    //点击添加按钮
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_button:
                //跳转到 AddData Activity 传入请求码 1
                Intent intent = new Intent(Admin_Activitytea.this,AddDatatea.class);
                startActivityForResult(intent,1);
                break;
            default:break;
        }
    }

    public void DbUtil(){
        dao = ((Admin_Activity_db)this.getApplication()).getDao();
    }

    /**
     * 当页面回到此活动时，调用此方法，刷新ListView
     * */
    @Override
    protected void onResume() {
        super.onResume();
        getNotifyData();
    }

    /**
     * 这个是用来动态刷新 * */
    public void getNotifyData(){
        //使用新的容器获得最新查询出来的数据
        newList = dao.inquireDatatea();
        //清除原容器里的所有数据
        list.clear();
        //将新容器里的数据添加到原来容器里
        list.addAll(newList);
        //更新页面顶部括号里显示数据
        linkmanNum();
        //刷新适配器
        adapter.notifyDataSetChanged();
    }

    /**
     * 上一个页面传回来的值
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            //请求码为1，表示点击了添加按钮
            case 1:
                //执行添加方法
                if(resultCode == RESULT_OK){
                    String[] key = data.getStringArrayExtra("key");
                    String[] values = data.getStringArrayExtra("values");
                    dao.addData("teacher",key,values);
                }
                break;
            //请求码为2，表示点击了编辑按钮
            case 2:
                //执行编辑方法
                if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("name");
                    String tid = data.getStringExtra("tid");
                    dao.updatetea(name,tid);
                }
                break;
        }
    }
}

