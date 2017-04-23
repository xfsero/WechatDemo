package com.stupidwind.com.wechatdemo.base;

import android.content.Context;
import android.view.View;

/**
 * Created by 蠢风 on 2017/4/21.
 */

public abstract class BasePager {

    public Context mContext;

    public View rootView;

    public boolean isInitData;

    public BasePager(Context context) {
        mContext = context;
        rootView = initView();
    }

    public abstract View initView();

    public abstract void initData();

}
