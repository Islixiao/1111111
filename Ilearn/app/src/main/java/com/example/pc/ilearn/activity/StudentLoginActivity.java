package com.example.pc.ilearn.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.ilearn.R;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;

//登陆注册界面
public class StudentLoginActivity extends AppCompatActivity {
    private EditText username;//用户名
    private EditText password;//用户密码
    private Button login;//登录按钮
    private Button register;//注册
    private Button forgetNum;//忘记密码
    private myOverDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.student_login);
        dbHelper = new myOverDatabaseHelper(this);//创建数据库对象


        username = findViewById(R.id.activity_main_name_input_student);
        password = findViewById(R.id.activity_main_input_student);
        login = findViewById(R.id.login_student);
        register = findViewById(R.id.register_student);

        //点击登录按钮跳转
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Info = username.getText().toString();
                String usern ="";
                String real = "";
                String sid = "";
                String col = "";
                String ma ="" ;
                String clas = "";
                String year = "";
                //getWritableDatabase()读写数据库的对象
                SQLiteDatabase db = dbHelper.getWritableDatabase();//打开数据库
                //cursor每行集合，rawQuery()用于执行select语句第一个参数为select语句；第二个参数为select语句中占位符参数的值，如果select语句没有使用占位符，该参数可以设置为null。
                Cursor cursor1 = db.rawQuery("select username,name,sid,college,major,clas,logintime from student  where username=?", new String[]{Info});
                //光标 第0行
                if (cursor1.moveToNext()) {//getString返回当前指定列的值
                    usern = cursor1.getString(cursor1.getColumnIndex("username"));//获取用户名,返回指定列，如果不存在返回-1
                    real = cursor1.getString(cursor1.getColumnIndex("name"));
                    sid = cursor1.getString(cursor1.getColumnIndex("sid"));
                    col = cursor1.getString(cursor1.getColumnIndex("college"));
                    ma = cursor1.getString(cursor1.getColumnIndex("major"));
                    clas = cursor1.getString(cursor1.getColumnIndex("clas"));
                    year=cursor1.getString(cursor1.getColumnIndex("logintime"));
                }

                forgetNum = findViewById(R.id.forgetNum_student);
                String nameInfo = username.getText().toString();
                String passwordInfo = password.getText().toString();
                //从数据库中获取密码并判断是否相同
                Cursor cursor = db.rawQuery("select username,password from student  where username=?", new String[]{nameInfo});
                String pi;
                if (cursor.moveToNext()) {
                    pi = cursor.getString(cursor.getColumnIndex("password"));//获取密码
                    //密码正确后跳转
                    if (passwordInfo.matches(pi)) {
                        Cursor user = db.rawQuery("select sid from student where username=?", new String[]{nameInfo});
                        if (user.moveToNext()) {
                            Intent intent1 = new Intent(StudentLoginActivity.this, main_Activity.class);
                            // 参数传递activity-->activity
                            Bundle bundle = new Bundle();
                            bundle.putString("user", nameInfo);//与username值相同
                            bundle.putString("username", usern);
                            bundle.putString("sid", sid);
                            bundle.putString("college", col);
                            bundle.putString("major", ma);
                            bundle.putString("realname", real);
                            bundle.putString("clas", clas);
                            bundle.putString("year", year);
                            intent1.putExtras(bundle);
                            startActivity(intent1);
                            user.close();
                            cursor.close();

                        } else {
                            Intent intent2 = new Intent(StudentLoginActivity.this, main_Activity.class);
                            intent2.putExtra("user", nameInfo);
                            startActivity(intent2);
                            Toast.makeText(StudentLoginActivity.this, "欢迎使用吧！", Toast.LENGTH_SHORT).show();
                            user.close();
                            cursor.close();
                        }
                    } else {
                        Toast.makeText(StudentLoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(StudentLoginActivity.this, "用户名不存在，请先注册！", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(StudentLoginActivity.this,StudentRegister.class);
                        startActivity(intent);
                }


            }
        });
        //注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLoginActivity.this, StudentRegister.class);
                startActivity(intent);

            }

        });

    }
}
















 /*   Intent intent = new Intent(StudentRegister.this, StudentLoginActivity.class);*/

/*    // 参数传递activity-->activity
    Bundle bundle = new Bundle();
                            bundle.putString("username",username);
                                    bundle.putString("password",password);
                                    bundle.putString("sid",sid);
                                    bundle.putString("college",college);
                                    bundle.putString("major",major);
                                    bundle.putString("realname",realname);
                                    bundle.putString("clas",clas);
                                    intent.putExtras(bundle);
                                    startActivity(intent);*/
