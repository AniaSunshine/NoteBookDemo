package com.example.hao.notebookdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hao.notebookdemo.notebook.NoteListActivity;
import com.example.hao.notebookdemo.test.AActivity;

/**
 * Created by 012 on 2016/1/19.
 */
public class MainActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.ac_main);
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        Button btn_note= (Button) findViewById(R.id.btn_note);
        btn_note.setOnClickListener(this);
        Button btn_test_activity= (Button) findViewById(R.id.btn_test_activity);
        btn_test_activity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_note:
                Intent intent=new Intent(MainActivity.this,NoteListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_test_activity:
                intent=new Intent(MainActivity.this,AActivity.class);
                startActivity(intent);
                break;
        }
    }
}
