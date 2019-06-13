
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


public class PasswordActivity extends AppCompatActivity {

    private EditText mPwd_old;
    private EditText mPwd_new;
    private EditText mPwdCheck;
    private Button mSureButton;    //确定按钮
    public myOverDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password_layout);
        dbHelper = new myOverDatabaseHelper(this);

        mPwd_old = findViewById(R.id.password_old);
        mPwd_new = findViewById(R.id.change_password);
        mPwdCheck = findViewById(R.id.change_password_second_password);
        mSureButton = findViewById(R.id.sure);

        //接收参数data
        Bundle bundl = this.getIntent().getExtras();
        final String username = bundl.getString("data");
        final String num = bundl.getString("num");
        final String S="2";
        mSureButton.setOnClickListener(new View.OnClickListener() {

            String xin=mPwd_new.getText().toString();
            String check=mPwdCheck.getText().toString();
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String old=mPwd_old.getText().toString();

               if(num.equals(S)) {
                   Cursor cursor = db.rawQuery("select username,password from student  where username=?", new String[]{username});
                   if (cursor.moveToNext()) {
                       String passold = cursor.getString(cursor.getColumnIndex("password"));
                       if (old.equals(passold)) {
                           if (xin.equals(check) ) {
                               db.beginTransaction();
                               db.execSQL("update  student set password=? where username=?", new String[]{xin, username});
                               db.setTransactionSuccessful();
                               db.endTransaction();

                               Toast.makeText(PasswordActivity.this, "修改成功", Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(PasswordActivity.this,StudentLoginActivity.class);
                                startActivity(intent);
                           } else {
                               Toast.makeText(PasswordActivity.this, "两次密码不一致", Toast.LENGTH_LONG).show();
                           }
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



            }
        });

    }
}
