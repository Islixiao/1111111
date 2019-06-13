
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
public class TeacherLoginActivity extends AppCompatActivity {
    private EditText username;//用户名
    private EditText password;//用户密码
    private Button login;//登录按钮
    private Button register;//注册
    private Button forgetNum;//忘记密码
    private myOverDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_login);
        dbHelper = new myOverDatabaseHelper(this);

        username = findViewById(R.id.activity_main_name_input_tea);
        password = findViewById(R.id.activity_main_input_tea);
        login = findViewById(R.id.login_tea);
        register = findViewById(R.id.register_tea);
        forgetNum = findViewById(R.id.forgetNum_tea);

        //点击登录按钮跳转
        login.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                String Info = username.getText().toString();


                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String passwordInfo = password.getText().toString();
                //从数据库中获取密码并判断是否相同
                Cursor cursor = db.rawQuery("select username,password from teacher  where username=?", new String[]{Info});
                String pi = null;
                if (cursor.moveToNext()) {
                    pi = cursor.getString(cursor.getColumnIndex("password"));//获取密码
                    //密码正确后跳转
                    if (passwordInfo.matches(pi)) {
                        Cursor user = db.rawQuery("select id from teacher where username=?", new String[]{Info});
                        if (user.moveToNext()) {
                            String usern = cursor.getString(cursor.getColumnIndex("username"));//获取用户名

                            Intent intent1 = new Intent(TeacherLoginActivity.this, TeacherActivity.class);
                            // 参数传递activity-->activity
                            Bundle bundle = new Bundle();
                            bundle.putString("user", Info);//与username值相同
                            bundle.putString("username", usern);
                            intent1.putExtras(bundle);
                            startActivity(intent1);
                            user.close();
                            cursor.close();
                        }

                    } else {
                        Toast.makeText(TeacherLoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TeacherLoginActivity.this, "用户名不存在，请先注册！", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherLoginActivity.this, TeacherRegister.class);
                startActivity(intent);

            }

        });
        //忘记密码
        forgetNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeacherLoginActivity.this, "此功能暂不支持", Toast.LENGTH_SHORT).show();


            }
        });


    }
}