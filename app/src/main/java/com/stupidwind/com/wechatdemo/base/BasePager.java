package com.stupidwind.com.wechatdemo.base;

import android.content.Context;
import android.view.View;

/**
 * Created by 蠢风 on 2017/4/21.
 */

/**
 *  页面抽象类
 */
public abstract class BasePager {

    public Context mContext;

    public View rootView;

    public boolean isInitData;

    public BasePager(Context context) {
        mContext = context;
        rootView = initView();
    }

    //初始化视图，子页面实现该方法
    public abstract View initView();

    //初始化数据，子页面实现该方法
    public abstract void initData();

}
