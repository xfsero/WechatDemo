package com.stupidwind.com.wechatdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.stupidwind.com.wechatdemo.R;


/**
 * 启动界面，2.5秒后进入主界面
 */
public class LaunchActivity extends Activity {

    private static final String TAG = LaunchActivity.class.getSimpleName();

    private Handler handler = new Handler();

    private boolean isStartMain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        //设置2.5秒之后切换到主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!isStartMain) {
                    isStartMain = true;
                    Log.d(TAG, "当前线程 = " + Thread.currentThread().getName());
                    Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2500);
    }

    @Override
    protected void onDestroy() {
        //切换到主页面时，移除所有消息和回调
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
