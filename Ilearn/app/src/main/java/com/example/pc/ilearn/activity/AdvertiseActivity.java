package com.example.pc.ilearn.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.pc.ilearn.R;


public class AdvertiseActivity extends Activity {

    private static final int WHAT_DELAY = 0x11;// 延时跳转
    private static final int DELAY_TIME = 3000;// 延时时间

    // 创建Handler对象，处理接收的消息
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case WHAT_DELAY:// 延时3秒跳转
                    goHome();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise);
        //Button跳过(非延时跳转）
        Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        handler.sendEmptyMessageDelayed(WHAT_DELAY, DELAY_TIME);//指定延时多少毫秒后发送空信息

    }

    private void goHome() {
        //等价   startActivity(new Intent(AdvertiseActivity.this, MainActivity.class));
        Intent intent = new Intent(AdvertiseActivity.this, MainActivity.class);
        startActivity(intent);
        finish();// 销毁当前活动界面
    }
}