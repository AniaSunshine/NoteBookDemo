package com.example.hao.notebookdemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 012 on 2016/1/18.
 */
public class ModifyNoteActivity extends Activity implements View.OnClickListener {
    private EditText et_modify;
    private int id;
    private String content;
    private DBHelper dbHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_modify);
        initView();
        initData();
    }

    private void initData() {
        dbHelper=new DBHelper(ModifyNoteActivity.this);
        cursor=dbHelper.select();
        id = getIntent().getIntExtra("cursorId", -1);
        content = getIntent().getStringExtra("cursorContent");

        et_modify.setText(content);

    }

    private void initView() {
        et_modify = (EditText) findViewById(R.id.et_modify);
        Button btn_update = (Button) findViewById(R.id.btn_update);
        Button btn_delete = (Button) findViewById(R.id.btn_delete);
        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_update.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                //更新数据
                String changedContent=et_modify.getText().toString().trim();
                if (TextUtils.isEmpty(changedContent)){
                    Toast.makeText(ModifyNoteActivity.this, "不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHelper.update(id,changedContent);
                Toast.makeText(ModifyNoteActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();//todo  这里会不会发生修改失败的情况，需不需要try catch？来捕捉异常？
                finish();
                break;
            case R.id.btn_delete:
                //删除数据
                dbHelper.delete(id);
                Toast.makeText(ModifyNoteActivity.this, "删除成功！", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
