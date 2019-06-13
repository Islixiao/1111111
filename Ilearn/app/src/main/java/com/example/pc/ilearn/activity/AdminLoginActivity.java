
package com.example.pc.ilearn.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

//登陆注册界面
public class AdminLoginActivity extends AppCompatActivity {
    private EditText username;//用户名
    private EditText password;//用户密码
    private Button login;//登录按钮
    private Button forgetNum;//忘记密码
    private myOverDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.admin_login);
        dbHelper = new myOverDatabaseHelper(this);
        username = findViewById(R.id.activity_main_name_input);
        password = findViewById(R.id.activity_main_input);
        login = findViewById(R.id.login);
        forgetNum = findViewById(R.id.forgetNum);

        //点击登录按钮跳转
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameInfo = username.getText().toString();
                String passwordInfo = password.getText().toString();
    /*            if (nameInfo == "deng" && passwordInfo == "1111") {
                    Intent intent1 = new Intent(AdminLoginActivity.this, AdminActivity.class);
                    intent1.putExtra("user", nameInfo);
                    startActivity(intent1);
                    Toast.makeText(AdminLoginActivity.this, "欢迎使用！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AdminLoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                }
            }*/
              //从数据库中获取密码并判断是否相同
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select username,password from admin  where username=?", new String[]{nameInfo});
                String pi = null;
                if (cursor.moveToNext()) {
                    pi = cursor.getString(cursor.getColumnIndex("password"));//获取密码   //密码正确后跳转
                    if (passwordInfo.matches(pi)) {
                        Cursor user = db.rawQuery("select id from admin where username=?", new String[]{nameInfo});
                        if (user.moveToNext()) {
                            Intent intent1 = new Intent(AdminLoginActivity.this, AdminActivity.class);
                            intent1.putExtra("user", nameInfo);
                            startActivity(intent1);
                            Toast.makeText(AdminLoginActivity.this, "欢迎使用！", Toast.LENGTH_SHORT).show();
                            user.close();
                            cursor.close();
                        }
                        else {
                            Intent intent2 = new Intent(AdminLoginActivity.this, AdminActivity.class);
                            intent2.putExtra("user", nameInfo);
                            startActivity(intent2);
                            Toast.makeText(AdminLoginActivity.this, "欢迎使用！", Toast.LENGTH_SHORT).show();
                            user.close();
                            cursor.close();
                        }
                    } else {
                        Toast.makeText(AdminLoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(AdminLoginActivity.this, "用户名不存在！", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //忘记密码
        forgetNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminLoginActivity.this, "此功能暂不支持", Toast.LENGTH_SHORT).show();


            }
        });


    }
}