package com.example.pc.ilearn.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.ilearn.entity.Student;
import com.example.pc.ilearn.entity.Teacher;

import java.util.ArrayList;
import java.util.List;



public class Utildaodb {
    private myOverDatabaseHelper du;
    private SQLiteDatabase db;

    public Utildaodb(Context context){
        du = new myOverDatabaseHelper(context);
        db = du.getWritableDatabase();
    }


    /**
     * 添加数据
     * */
    public void addData(String tableName,String[] key,String[] values){
        ContentValues contentValues = new ContentValues();
        for(int i = 0; i < key.length; i ++){
            contentValues.put(key[i],values[i]);
        }
        db.insert(tableName,null,contentValues);
        contentValues.clear();
    }

    /**
     * 删除数据
     * */
    public int delData(String where,String[] values){
        int del_data;
        del_data = db.delete("student",where,values);
        return del_data;
    }
    public int delDataTea(String where,String[] values){
        int del_data;
        del_data = db.delete("teacher",where,values);
        return del_data;
    }

    /**
     * 修改数据
     * */
    public void update(String name,String sid){
        db.execSQL("update student set name=? and sid=? ",new String[]{name,sid});

    }
    public void updatetea(String name,String tid){
        db.execSQL("update teacher set name=? and tid=? ",new String[]{name,tid});

    }

    /**
     * 查询数据
     * */
    public List<Student> inquireData(){
        List<Student> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select name,sid from student",null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            String sid = cursor.getString(1);
        Student student=new Student();
            student.setName(name);
            student.setSid(sid);
            list.add(student);
        }
        return list;
    }
    public List<Teacher> inquireDatatea(){
        List<Teacher> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select name,tid from teacher",null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            String tid = cursor.getString(1);
            Teacher teacher=new Teacher();
            teacher.setName(name);
            teacher.setTid(tid);
            list.add(teacher);
        }
        return list;
    }

    /**
     * 关闭数据库连接
     * */
    public void getClose(){
        if(db != null){
            db.close();
        }
    }
}
