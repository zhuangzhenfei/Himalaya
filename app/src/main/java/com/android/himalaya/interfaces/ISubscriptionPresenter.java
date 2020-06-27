package com.android.himalaya.interfaces;

import com.android.himalaya.base.IBasePresenter;
import com.ximalaya.ting.android.opensdk.model.album.Album;

/**
 * create by shadowman
 * on 2020/4/15
 */
public interface ISubscriptionPresenter extends IBasePresenter<ISubscriptionCallback> {

    /**
     * 添加订阅
     *
     * @param album
     */
    void addSubscription(Album album);

    /**
     * 删除订阅
     *
     * @param album
     */
    void deleteSubscription(Album album);

    /**
     * 获取订阅列表
     */
    void getSubscriptionList();


    /**
     * 判断当前是否已经收藏/d订阅
     *
     * @param album
     * @return
     */
    boolean isSub(Album album);
}
