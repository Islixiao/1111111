
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
import com.example.pc.ilearn.entity.Teacher;
import com.example.pc.ilearn.tools.myOverDatabaseHelper;


public class PasswordActivity extends AppCompatActivity {

    private EditText mPwd_old;
    private EditText myh;
    private EditText mPwd_new;
    private EditText mPwdCheck;
    private Button mSureButton;    //确定按钮

    public myOverDatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password_layout);
        Bundle bundle=this.getIntent().getExtras();
        final String num=bundle.getString("num");

        myh=findViewById(R.id.yonghu);
        mPwd_old = findViewById(R.id.password_old);
        mPwd_new = findViewById(R.id.change_password);
        mPwdCheck = findViewById(R.id.change_password_second_password);
        mSureButton = findViewById(R.id.sure);
        dbHelper = new myOverDatabaseHelper(this);
        mSureButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //getWritableDatabase()读写数据库的对象
                SQLiteDatabase db = dbHelper.getWritableDatabase();//打开数据库
                String nameInfo = myh.getText().toString();
                String passwordInfo = mPwd_old.getText().toString();
                String xin=mPwd_new.getText().toString();
                String check=mPwdCheck.getText().toString();


                if(num.equals("1")){
                    Cursor curso = db.rawQuery("select username,password from teacher  where username=?", new String[]{nameInfo});
                    String p;
                    if (curso.moveToNext()) {
                        p = curso.getString(curso.getColumnIndex("password"));//获取密码
                        //密码正确后跳转
                        if (passwordInfo.matches(p)) {
                            if (xin.matches(check)) {
                                db.beginTransaction();
                                db.execSQL("update teacher set password=? where username=?", new String[]{check,nameInfo});
                                db.setTransactionSuccessful();
                                db.endTransaction();
                                Toast.makeText(PasswordActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(PasswordActivity.this,TeacherLoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(PasswordActivity.this, "两次密码不同", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(PasswordActivity.this, "旧密码错误", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(PasswordActivity.this, "用户名不存在！", Toast.LENGTH_SHORT).show();
                    }}

                    else {
                    //从数据库中获取密码并判断是否相同
                    Cursor cursor = db.rawQuery("select username,password from student  where username=?", new String[]{nameInfo});
                    String pi;
                    if (cursor.moveToNext()) {
                        pi = cursor.getString(cursor.getColumnIndex("password"));//获取密码
                        //密码正确后跳转
                        if (passwordInfo.matches(pi)) {
                            if (xin.matches(check)) {
                                db.beginTransaction();
                                db.execSQL("update student set password=? where username=?", new String[]{check, nameInfo});
                                //                    db.rawQuery("replace into student(password,username) values (?,?)", new String[]{check,nameInfo});

                                db.setTransactionSuccessful();
                                db.endTransaction();
                                Toast.makeText(PasswordActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(PasswordActivity.this,TeacherLoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(PasswordActivity.this, "两次密码不同", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(PasswordActivity.this, "旧密码错误", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(PasswordActivity.this, "用户名不存在！", Toast.LENGTH_SHORT).show();
                    }
                }
           /*    if(num.equals(S)) {
                   Cursor cursor = db.rawQuery("select username,password from student  where username=?", new String[]{username});
                   if (cursor.moveToNext()) {
                       passold = cursor.getString(cursor.getColumnIndex("password"));

                       if (old.equals(passold)) {
                               db.execSQL("update  student set password=? where username=?", new String[]{xin, username});
                               Toast.makeText(PasswordActivity.this, "修改成功", Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(PasswordActivity.this,StudentLoginActivity.class);
                                startActivity(intent);

                       } else {
                           Toast.makeText(PasswordActivity.this, "旧密码不正确", Toast.LENGTH_LONG).show();
                       }
                   } else {
                       Toast.makeText(PasswordActivity.this, "出错了", Toast.LENGTH_LONG).show();
                   }
               }

              else{
                Cursor cursor1=db.rawQuery("select username,password from teacher  where username=?", new String[]{username});

                if (cursor1.moveToNext()) {
                    String passold = cursor1.getString(cursor1.getColumnIndex("password"));
                    if(old.equals(passold)) {
                        if(xin.equals(check)){
                            db.execSQL("update  teacher set password=? where username=?", new String[]{xin, username});
                            Toast.makeText(PasswordActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(PasswordActivity.this, TeacherLoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(PasswordActivity.this,"两次密码不一致",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(PasswordActivity.this,"旧密码不对",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(PasswordActivity.this,"出错啦",Toast.LENGTH_LONG).show();
                }

               }
*/


            }
        });

    }
}
