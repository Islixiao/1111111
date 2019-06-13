package com.example.pc.ilearn.activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

public class StudentRegister extends Activity {
    protected EditText et1;//用户名
    protected EditText et2;//密码一
    protected EditText et3;//密码二
    protected EditText et4;//姓名
    protected EditText et5;//学号
    protected TextView et6_1;//学院
    protected Spinner et6;
    private String college=null;
    protected EditText et7;//专业
    protected EditText et8;//班级
    protected EditText et9;//入学年份
    protected ImageView imageView;//logo
    private Button bt;//注册按钮
    public myOverDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//全屏显示
        setContentView(R.layout.registerstu);
        et1 = findViewById(R.id.register_namestu);
        et2 = findViewById(R.id.register_first_passwordstu);
        et3 = findViewById(R.id.register_second_passwordstu);
        et4 = findViewById(R.id.register_first_namestu);
        et5 = findViewById(R.id.register_first_sid);
        et7 = findViewById(R.id.register_first_majorstu);
        et8 = findViewById(R.id.register_first_classstu);
        et9 = findViewById(R.id.register_first_time);
        imageView = findViewById(R.id.register_logostu);
        bt = findViewById(R.id.register_confirmstu);
        dbHelper = new myOverDatabaseHelper(this);

        et6 = findViewById(R.id.register_first_collegestu);



             //添加事件Spinner事件监听
        et6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被选择项的值
                college= (String )et6.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //注册按钮监听事件
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            //点击事件  插入数据库中
            public void onClick(View view){
                SQLiteDatabase db= dbHelper.getWritableDatabase();
                String username = et1.getText().toString();
                String password =et2.getText().toString();
                String password_checked = et3.getText().toString();
                String realname = et4.getText().toString();
                String sid = et5.getText().toString();
                String major = et7.getText().toString();
                String clas = et8.getText().toString();
                String time = et9.getText().toString();
                //确认按钮的监听事件
                if (!password.matches("[0-9]{3,9}")) {
                    Toast.makeText(StudentRegister.this, "密码为3-9位数字", Toast.LENGTH_SHORT).show();
                } else {
                    // 两次密码是否相同
                    if (password.equals(password_checked)) {
                       // Cursor cursor = db.rawQuery("select username from admin where username=? ", new String[]{username});
                       Cursor cursor = db.rawQuery("select username from student where username=? ", new String[]{username});

                        //用户是否存在
                        if (cursor.moveToNext()) {
                            Toast.makeText(StudentRegister.this, "该用户已存在", Toast.LENGTH_SHORT).show();
                        } else {
                            //db.execSQL("insert into admin(username,password)values(?,?)", new String[]{username,password});

                            db.execSQL("insert into student(username,password, sid,name,college, major, clas,logintime)values(?,?,?,?,?,?,?,?)", new String[]{username,password,sid, realname,college, major, clas,time});
                            Toast.makeText(StudentRegister.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();

                        }
                    } else {
                        Toast.makeText(StudentRegister.this, "两次密码不相同", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}






