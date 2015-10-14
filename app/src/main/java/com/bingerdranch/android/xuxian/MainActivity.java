package com.bingerdranch.android.xuxian;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private View homeTap;
    private View aroundTap;
    private View shoppingTap;
    private View guestTap;
    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;

    private Class fragmentArray[] = {
            homeFragment.class,
            aroundFragment.class,
            shoppingFragment.class,
            guestFragment.class
    };

    private int mImageViewArray[] = {
            R.drawable.tab_home_btn,
            R.drawable.tab_around_btn,
            R.drawable.tab_shopping_btn,
            R.drawable.tab_guest_btn
    };

    private String mTextViewArray[] = {
            "首页",
            "附近",
            "购物车",
            "我的"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fragmentContainer);

        //去除分割线
        mTabHost.getTabWidget().setDividerDrawable(R.color.nav_background);
        //得到fragment的个数
        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //设置Tab按钮的背景
        }
    }

    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextViewArray[index]);

        return view;
    }
}
