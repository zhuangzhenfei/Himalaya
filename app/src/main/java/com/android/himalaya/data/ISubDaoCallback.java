package com.android.himalaya.data;

import com.ximalaya.ting.android.opensdk.model.album.Album;

import java.util.List;

/**
 * create by shadowman
 * on 2020/5/10
 */
public interface ISubDaoCallback {

    /**
     * 添加专辑订阅结果
     *
     * @param isSuccess
     */
    void onAddResult(boolean isSuccess);

    /**
     * 删除结果
     *
     * @param isSuccess
     */
    void onDelResult(boolean isSuccess);

    /**
     * 加载的结果
     *
     */
    void onSubListLoaded(List<Album> result);
}
