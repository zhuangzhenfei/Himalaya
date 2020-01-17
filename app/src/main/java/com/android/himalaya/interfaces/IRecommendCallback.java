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
     * 网络错误
     */
    void onNetworkError();

    /**
     * 数据为空
     */
    void onEmpty();

    /**
     * 正在加载
     */
    void onLoading();
}
