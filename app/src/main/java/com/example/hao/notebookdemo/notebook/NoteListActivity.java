package com.example.hao.notebookdemo.notebook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.hao.notebookdemo.R;

public class NoteListActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private DBHelper dbHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_note_list);

        initView();
        initData();
    }

    private void initData() {
        dbHelper=new DBHelper(NoteListActivity.this);
        cursor=dbHelper.select();
        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(NoteListActivity.this,R.layout.list_item,cursor,new String[]{DBHelper.CONTENT},new int[]{R.id.tv_info},0);

        listView.setAdapter(simpleCursorAdapter);
        listView.invalidateViews();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(NoteListActivity.this,ModifyNoteActivity.class);
                //1、将查询出来的这个数据传递过去。2、或者将查询出来的id传递过去，在那个页面重新进行查询，最好只查询一次吧，节省时间
                cursor.moveToPosition(position);//移动到指定行
                int cursorId=cursor.getInt(0);//得到指定行的指定列的数据
                String cursorContent=cursor.getString(1);
                intent.putExtra("cursorId",cursorId);
                intent.putExtra("cursorContent",cursorContent);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        listView= (ListView) findViewById(R.id.listview);
        button= (Button) findViewById(R.id.btn_write_note);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteListActivity.this, WriteNoteActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        cursor.requery();//todo 已经过时，那么有没有替代的方法？
        listView.invalidateViews();//todo 不管用，不能刷新
        super.onResume();
    }
}
