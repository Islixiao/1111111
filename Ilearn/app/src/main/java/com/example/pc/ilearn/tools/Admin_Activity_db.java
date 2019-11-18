package com.example.pc.ilearn.tools;
import android.app.Application;

import com.example.pc.ilearn.tools.Utildaodb;

public class Admin_Activity_db extends Application {
    private Utildaodb dao;

    /**
     * 创建时调用
     * */
    @Override
    public void onCreate() {
        super.onCreate();
        dao = new Utildaodb(this);
    }

    /**
     * 用于关闭数据库连接
     * */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        dao.getClose();
    }

    public Utildaodb getDao() {
        return dao;
    }
}
