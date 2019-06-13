package com.example.pc.ilearn.activity;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

public class Register extends Activity {
    protected EditText et1;//用户名
    protected EditText et2;//密码一
    protected EditText et3;//密码二
    protected ImageView imageView;//logo
    private Button bt;//注册按钮

    public myOverDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//全屏显示
        setContentView(R.layout.register);
        et1 = findViewById(R.id.register_name);
        et2 = findViewById(R.id.register_first_password);
        et3 = findViewById(R.id.register_second_password);
        imageView = findViewById(R.id.register_logo);
        bt = findViewById(R.id.register_confirm);
        dbHelper = new myOverDatabaseHelper(this);

        //注册按钮监听事件
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            //点击事件  插入数据库中
            public void onClick(View view){
                SQLiteDatabase db= dbHelper.getWritableDatabase();
                String username = et1.getText().toString();
                String password =et2.getText().toString();
                String password_checked = et3.getText().toString();
                //确认按钮的监听事件
                if (!password.matches("[0-9||a-z||A-Z]{6}")) {
                    Toast.makeText(Register.this, "密码为6位纯数字", Toast.LENGTH_SHORT).show();
                } else {
                    // 两次密码是否相同
                    if (password.equals(password_checked)) {
                        Cursor cursor = db.rawQuery("select username from admin where username=? ", new String[]{username});
                        //用户是否存在
                        if (cursor.moveToNext()) {
                            Toast.makeText(Register.this, "该用户已存在", Toast.LENGTH_SHORT).show();
                        } else {
                            db.execSQL("insert into register(username,password)values(?,?)", new String[]{username, password});
                            Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } else {
                        Toast.makeText(Register.this, "两次密码不相同", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });



    }
}








