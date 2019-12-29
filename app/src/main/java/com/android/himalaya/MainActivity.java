package com.android.himalaya;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.android.himalaya.adapters.IndicatorAdapter;
import com.android.himalaya.adapters.MainContentAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

public class MainActivity extends FragmentActivity {
    private MagicIndicator mMagicIndicator;
    private ViewPager mContentPager;
    private static final String TAG = "MainActivity";
    private FragmentManager mSupportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mMagicIndicator = findViewById(R.id.magic_indicator3);
        mMagicIndicator.setBackgroundColor(this.getColor(R.color.main_color));
        //创建Indicator的适配器
        IndicatorAdapter indicatorAdapter = new IndicatorAdapter(this);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(indicatorAdapter);

        //ViewPage
        mContentPager = findViewById(R.id.content_pager);

        //创建内容适配器
        mSupportFragmentManager = getSupportFragmentManager();
        MainContentAdapter mainContentAdapter = new MainContentAdapter(mSupportFragmentManager);
        mContentPager.setAdapter(mainContentAdapter);

        //把ViewPage和indicator绑定到一起
        mMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMagicIndicator,mContentPager);
    }
}
