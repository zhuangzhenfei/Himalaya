package com.android.himalaya.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.himalaya.R;
import com.android.himalaya.base.BaseFragment;
import com.android.himalaya.utils.LogUtil;

/**
 * create by shadowman
 * on 2019/12/28
 */
public class SubscriptionFragment extends BaseFragment {

    private static final String TAG = "subscriptionFragment";

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View rootView = layoutInflater.inflate(R.layout.fragment_subscription, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, "this is HistoryFragment");
    }
}
