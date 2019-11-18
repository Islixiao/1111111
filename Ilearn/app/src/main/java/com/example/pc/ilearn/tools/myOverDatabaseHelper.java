package com.example.pc.ilearn.tools;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myOverDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ailearn.db";
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
//+ "if not exists " +
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + "if not exists " + TABLE_NAME1 + "("
                + "id integer primary key autoincrement not null,"
                + "username text not null,"
                + "password text not null"
                + ")");

        db.execSQL("create table " + "if not exists " + TABLE_NAME2 + "("

                + "sid text primary key not null,"
                + "username text not null,"
                + "password text not null,"
                + "name text not null,"
                + "college text ,"
                + "major text,"
                + "clas text,"
                + "logintime text"
                +")");
        db.execSQL("create table " + "if not exists " + TABLE_NAME3 + "("
                + "tid text primary key not null,"
                + "username text not null,"
                + "password text not null,"
                + "name text not null,"
                + "college text ,"
                + "major text)");
        db.execSQL("create table " +  "if not exists " +TABLE_NAME4 + "("
                + "id integer primary key autoincrement not null,"
                +"username text not null,"
                + "datetoday text ,"
                + "llongtime text,"
                + "saytext text)");

        db.execSQL("create table " + "if not exists " + TABLE_NAME5 + "("
                + "id integer primary key autoincrement not null,"
                +" username text not null,"
                + "datetoday text,"
                + "llongtime int(20),"
                + "saytext text)");
        db.execSQL("create table "  +  "if not exists " +TABLE_NAME6 + "("
                + "zid int(4) not null,"//周次
                + "sid text,"
                + "dateseven text,"
                + "saytext text(20),"
                + "llongtime int," +
                "primary key(zid,sid))");
        db.execSQL("create table "  + "if not exists "+ TABLE_NAME7 + "("
                + "pid integer  primary key autoincrement ,"
                +" username text,"
                + "datetoday text,"
                + "llongtime int(12),"
                + "sid text )");
      db.beginTransaction();
      // execSQL()方法可以执行insert等有更改行为的SQL语句； rawQuery()方法用于执行select语句。
        db.execSQL("insert into admin(id,username,password)values(?,?,?)", new String[]{"1","邓伦","1111"});
        db.execSQL("insert into admin(id,username,password)values(?,?,?)", new String[]{"2","李肖","1111"});
     //   db.execSQL("alter table ranklist add foreign key(sid) references student(sid) ");
        db.setTransactionSuccessful();
        db.endTransaction();

    }




    @Override //  数据库升级时自动调用
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
}

