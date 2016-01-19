package com.example.hao.notebookdemo.test;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hao.notebookdemo.R;

import java.util.List;

/**
 * Created by 012 on 2016/1/19.
 */
public class AActivity extends Activity {
    private static final String TAG="AActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate-----------");
        setContentView(R.layout.ac_a_activity);
        super.onCreate(savedInstanceState);

        Button btn_open_b= (Button) findViewById(R.id.btn_open_b);
        btn_open_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ActivityManager activityManager= (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfos=activityManager.getRunningTasks(10);
        for (ActivityManager.RunningTaskInfo runningTaskInfo:runningTaskInfos){
            Log.i(TAG,"id: " + runningTaskInfo.id);
            Log.i(TAG,"description: " + runningTaskInfo.description);
            Log.i(TAG,"number of activities: " + runningTaskInfo.numActivities);
            Log.i(TAG,"topActivity: " + runningTaskInfo.topActivity);
            Log.i(TAG,"baseActivity: " + runningTaskInfo.baseActivity.toString());
        }
    }

    @Override
    protected void onStart() {
        Log.i(TAG,"onStart-----------");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG,"onRestart-----------");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"onResume-----------");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"onPause-----------");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"onStop-----------");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"onDestroy-----------");
        super.onDestroy();
    }
}
