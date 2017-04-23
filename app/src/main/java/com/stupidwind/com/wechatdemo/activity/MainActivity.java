package com.stupidwind.com.wechatdemo.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.stupidwind.com.wechatdemo.R;
import com.stupidwind.com.wechatdemo.base.BasePager;
import com.stupidwind.com.wechatdemo.pager.ContactPager;
import com.stupidwind.com.wechatdemo.pager.DiscoverPager;
import com.stupidwind.com.wechatdemo.pager.AboutMePager;
import com.stupidwind.com.wechatdemo.pager.WechatPager;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<BasePager> pagers;

    private RadioGroup rg_bottom;

    private TextView titleBarText;

    private String[] titleBarTexts = {"微信", "通讯录", "发现", "我"};

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rg_bottom = (RadioGroup) findViewById(R.id.rg_bottom);
        titleBarText = (TextView) findViewById(R.id.title_bar_text);

        pagers = new ArrayList<>();
        pagers.add(new WechatPager(this));      //添加微信页面
        pagers.add(new ContactPager(this));     //添加通讯录页面
        pagers.add(new DiscoverPager(this));    //添加发现页面
        pagers.add(new AboutMePager(this));          //添加我页面

        rg_bottom.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg_bottom.check(R.id.rb_wechat);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_wechat:
                    position = 0;
                    break;

                case R.id.rb_contact:
                    position = 1;
                    break;

                case R.id.rb_discover:
                    position = 2;
                    break;

                case R.id.rb_about_me:
                    position = 3;
                    break;

                default:
            }

            getFragment();

        }
    }

    private void getFragment() {
        //获取FragmentManager
        FragmentManager manager = getFragmentManager();
        //开始事务
        FragmentTransaction ft = manager.beginTransaction();
        //替换
        ft.replace(R.id.fl_main, new Fragment() {
            @Override
            @Nullable
            public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
                BasePager basePager = getBasePager();
                if(basePager != null) {
                    return basePager.rootView;
                }
                return null;
            }
        });

        //设置顶部栏文字
        titleBarText.setText(titleBarTexts[position]);

        //提交事务
        ft.commit();
    }

    /**
     * 根据position获取对应的页面
     * @return
     */
    private BasePager getBasePager() {
        BasePager basePager = pagers.get(position);
        if(basePager != null && !basePager.isInitData) {
            basePager.initData();
            basePager.isInitData = true;
        }
        return basePager;
    }

}
