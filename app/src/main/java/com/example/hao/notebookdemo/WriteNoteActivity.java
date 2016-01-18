package com.example.hao.notebookdemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 012 on 2016/1/18.
 */
public class WriteNoteActivity extends Activity{

    private Button btn_ok;
    private Button btn_cancle;
    private TextView et_content;
    private DBHelper dbHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_note);
        initData();
        initView();
    }

    private void initData() {
        dbHelper=new DBHelper(WriteNoteActivity.this);
    }

    private void initView() {
        btn_ok= (Button) findViewById(R.id.btn_ok);
        btn_cancle= (Button) findViewById(R.id.btn_cancle);
        et_content= (TextView) findViewById(R.id.et_content);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=et_content.getText().toString().trim();
                if (TextUtils.isEmpty(content)){
                    Toast.makeText(WriteNoteActivity.this,"不能为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                //插入数据库
                dbHelper.insert(content);
                finish();
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
