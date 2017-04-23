package com.stupidwind.com.wechatdemo.pager;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.stupidwind.com.wechatdemo.base.BasePager;

/**
 * Created by 蠢风 on 2017/4/21.
 */

public class AboutMePager extends BasePager {

    private static final String TAG = AboutMePager.class.getSimpleName();

    private TextView tv_content;

    public AboutMePager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        tv_content = new TextView(mContext);
        tv_content.setTextSize(28);
        tv_content.setGravity(Gravity.CENTER);
        return tv_content;
    }

    @Override
    public void initData() {
        Log.d(TAG, "我页面初始化...");
        tv_content.setText("我是我页面");
    }
}
