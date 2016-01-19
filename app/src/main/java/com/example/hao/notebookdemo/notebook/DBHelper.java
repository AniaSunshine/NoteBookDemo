package com.example.hao.notebookdemo.notebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 012 on 2016/1/18.
 */
public class DBHelper extends SQLiteOpenHelper {
    private final static String DB_NAME ="notebook.db";
    private final static String TABLE_NAME ="notebook";
    private final static int DBVersion =1;
    private final static String ID="_id";
    public  final static String CONTENT="content";
    SQLiteDatabase database=getWritableDatabase();

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQl="create table "+ TABLE_NAME +"("+ID+" integer primary key autoincrement,"+CONTENT+" text"+")";
        db.execSQL(createSQl);
        Log.i("DBHelper", createSQl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 插入数据
     * @param content
     * @return
     */
    public long insert(String content ){
        ContentValues contentValues=new ContentValues();
        contentValues.put("content", content);
        long row=database.insert(TABLE_NAME,null,contentValues);
        return row;
    }

    /**
     * 删除某个记录
     * @param id
     */
    public void delete(int id){
        database.delete(TABLE_NAME,ID+"=?",new String[]{Integer.toString(id)});
    }

    /**
     * 更新数据库汇总记录的方法
     * @param id
     * @param content
     */
    public void update(int id,String content){
        ContentValues contentValues=new ContentValues();
        contentValues.put("content",content);

        database.update(TABLE_NAME, contentValues, ID+"=?", new String[]{Integer.toString(id)});

    }

    /**
     * 查询所有的记录
     * @return
     */
    public Cursor select(){
        Cursor cursor=database.query(TABLE_NAME,null,null,null,null,null,null);
        return cursor;
    }
}
