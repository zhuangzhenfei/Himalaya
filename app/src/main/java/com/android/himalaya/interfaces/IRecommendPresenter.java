package com.android.himalaya.interfaces;

/**
 * create by chameleon
 * on 2020/1/3 0003
 */
public interface IRecommendPresenter {

    /**
     * 获取推荐内容
     */
    void getRecommendList();

    /**
     * 下拉刷新更多
     */
    void pullToReflashMore();

    /**
     * 上拉加载更多
     */
    void loadMore();

    /**
     * 注册UI的回调
     *
     * @param callback
     */
    void registerViewCallback(IRecommendCallback callback);

    /**
     * 取消UI注册的回调
     *
     * @param callback
     */
    void unRegisterViewCallback(IRecommendCallback callback);
}
