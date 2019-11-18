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
import android.widget.Toast;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

public class TeacherRegister extends Activity {
    protected EditText et1;//用户名
    protected EditText et2;//密码一
    protected EditText et3;//密码二
    protected EditText et4;
    protected EditText et5;
    protected Spinner et6;
    protected EditText et7;
    protected ImageView imageView;//logo
    private Button bt;//注册按钮
    public String college;
    public myOverDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//全屏显示
        setContentView(R.layout.registertea);
        et1 = findViewById(R.id.register_nametea);
        et2 = findViewById(R.id.register_first_passwordtea);
        et3 = findViewById(R.id.register_second_passwordtea);
        et4 = findViewById(R.id.register_first_nametea);
        et5 = findViewById(R.id.register_first_tidtea);
        et7  = findViewById(R.id.register_first_majortea);
        imageView = findViewById(R.id.register_logotea);
        bt = findViewById(R.id.register_confirmtea);
        dbHelper = new myOverDatabaseHelper(this);

        et6 = findViewById(R.id.register_first_collegetea);
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
                String realname =et4.getText().toString();
                String tid = et5.getText().toString();
                String major = et7.getText().toString();
                //确认按钮的监听事件
                if (!password.matches("[0-9]{3,9}")) {
                    Toast.makeText(TeacherRegister.this, "密码为3-9位数字", Toast.LENGTH_SHORT).show();
                } else {
                    // 两次密码是否相同
                    if (password.equals(password_checked)) {
                        Cursor cursor = db.rawQuery("select username from teacher where username=? ", new String[]{username});
                        //用户是否存在
                        if (cursor.moveToNext()) {
                            Toast.makeText(TeacherRegister.this, "该用户已存在", Toast.LENGTH_SHORT).show();
                        } else {
                            db.execSQL("insert into teacher(username,password,tid,name,college,major)values(?,?,?,?,?,?)", new String[]{username, password,tid,realname,college,major});
                            Toast.makeText(TeacherRegister.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } else {
                        Toast.makeText(TeacherRegister.this, "两次密码不相同", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}






