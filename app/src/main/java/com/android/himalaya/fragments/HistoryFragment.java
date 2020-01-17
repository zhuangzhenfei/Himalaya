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
public class HistoryFragment extends BaseFragment {
    private static final String TAG = "HistoryFragment";

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View rootView = layoutInflater.inflate(R.layout.fragment_history, container, false);
        LogUtil.e(TAG, "this is HistoryFragment");
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, "this is HistoryFragment");
    }
}
