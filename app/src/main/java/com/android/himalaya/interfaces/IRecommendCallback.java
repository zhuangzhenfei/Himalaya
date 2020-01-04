package com.android.himalaya.interfaces;

import android.app.AliasActivity;

import com.ximalaya.ting.android.opensdk.model.album.Album;

import java.util.List;

/**
 * create by chameleon
 * on 2020/1/3 0003
 */
public interface IRecommendCallback {

    /**
     * 获取更多内容
     *
     * @param result
     */
    void onRecommendListLoaded(List<Album> result);

    /**
     * 加载更多
     *
     * @param result
     */
    void onLoadMore(List<Album> result);

    /**
     * 下拉加载更多
     *
     * @param result
     */
    void onReflashMore(List<Album> result);
}
