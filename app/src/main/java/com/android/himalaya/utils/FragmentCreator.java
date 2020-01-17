package com.android.himalaya.utils;

import com.android.himalaya.base.BaseFragment;
import com.android.himalaya.fragments.HistoryFragment;
import com.android.himalaya.fragments.RecommendFragment;
import com.android.himalaya.fragments.SubscriptionFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * create by shadowman
 * on 2019/12/28
 *
 * 添加fragment工具类，减少重复创建fragment，节省资源，
 * 如果后续要添加fragment，可以直接添加静态常量
 *
 */
public class FragmentCreator {
    public final static int INDEX_RECOMMEND = 0;
    public final static int INDEX_SUBSCRIPTION = 1;
    public final static int INDEX_HISTORY = 2;

    public static final int PAGE_COUNT =3;

    private static Map<Integer, BaseFragment> sCache = new HashMap<>();

    public static BaseFragment getFragment(int index) {
        BaseFragment baseFragment = sCache.get(index);
        if (baseFragment != null) {
            return baseFragment;
        }

        switch (index) {
            case INDEX_RECOMMEND:
                baseFragment = new RecommendFragment();
                break;
            case INDEX_SUBSCRIPTION:
                baseFragment = new SubscriptionFragment();
                break;
            case INDEX_HISTORY:
                baseFragment = new HistoryFragment();
                break;
        }
        sCache.put(index, baseFragment);
        return baseFragment;
    }
}

