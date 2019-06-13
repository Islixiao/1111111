package com.example.pc.ilearn.tools;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 单例模式
 * Created by he on 2016/10/3.
 */
public class myOverDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Overlearn.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME1 = "admin";
    private static final String TABLE_NAME2 = "student";
    private static final String TABLE_NAME3 = "teacher";
    private static final String TABLE_NAME4 = "single_people_time";
    private static final String TABLE_NAME5 = "all_people_today";
    private static final String TABLE_NAME6 = "week_poster";
    private static final String TABLE_NAME7 = "ranklist";
    private SQLiteDatabase mSQLiteDatabase = null;
    public myOverDatabaseHelper(Context context) {
        //, String name, SQLiteDatabase.CursorFactory factory, int version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + "if not exists " + TABLE_NAME1 + "("
                + "id integer primary key autoincrement,"
                + "username text,"
                + "password text"
                + ")");

        db.execSQL("create table " + "if not exists " + TABLE_NAME2 + "("
                + "id integer primary key autoincrement,"
                + "sid text ,"
                + "username text,"
                + "password text,"
                + "password_checked text,"
                + "name text,"
                + "college text ,"
                + "major text,"
                + "clas text,"
                + "rxny text,"
                + "logintime text"
                +")");
        db.execSQL("create table " + "if not exists " + TABLE_NAME3 + "("
                + "id integer primary key autoincrement,"
                + "tid text ,"
                + "username text,"
                + "password text,"
                + "password_checked text,"
                + "name text,"
                + "college text ,"
                + "major text)");
        db.execSQL("create table " + "if not exists " + TABLE_NAME4 + "("
                + "id integer primary key autoincrement,"
                +"username text,"
                + "datetoday text,"
                + "llongtime text,"
                + "saytext text)");
        db.execSQL("create table " + "if not exists " + TABLE_NAME6 + "("
                + "zid integer primary key,"
                + "id integer,"
                + "dateseven text,"
                + "saytext text,"
                + "llongtime text)");
        db.execSQL("create table " + "if not exists " + TABLE_NAME5 + "("
                + "id integer primary key autoincrement,"
                +"username text,"
                + "datetoday text,"
                + "llongtime int,"
                + "saytext text)");
        db.execSQL("create table " + "if not exists " + TABLE_NAME7 + "("
                + "id integer primary key autoincrement,"
                +" username text,"
                + "llongtime int,"
                + "pid text)");
      db.beginTransaction();
        db.execSQL("insert into admin(id,username,password)values(?,?,?)", new String[]{"1","邓伦","1111"});
        db.execSQL("insert into admin(id,username,password)values(?,?,?)", new String[]{"2","李肖","1111"});
        db.setTransactionSuccessful();
        db.endTransaction();

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME1);
        db.execSQL("drop table if exists "+TABLE_NAME2);
        db.execSQL("drop table if exists "+TABLE_NAME3);
        db.execSQL("drop table if exists "+TABLE_NAME4);
        db.execSQL("drop table if exists "+TABLE_NAME5);
        db.execSQL("drop table if exists "+TABLE_NAME6);
        this.onCreate(db);

    }
    //打开数据库
    @Override
    public void onOpen  (SQLiteDatabase db) throws SQLException{
        super.onOpen(db);
    }


    public boolean deleteDatabase(Context context) {
        return context.deleteDatabase(DATABASE_NAME);
    }

}