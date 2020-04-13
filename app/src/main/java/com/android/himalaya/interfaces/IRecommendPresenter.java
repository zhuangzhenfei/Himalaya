package com.android.himalaya.interfaces;

import com.android.himalaya.base.IBasePresenter;

/**
 * create by chameleon
 * on 2020/1/3 0003
 */
public interface IRecommendPresenter extends IBasePresenter<IRecommendCallback> {

    /**
     * 获取推荐内容
     */
    void getRecommendList();

    /**
     * 下拉刷新更多
     */
    void pullToRefreshMore();

    /**
     * 上拉加载更多
     */
    void loadMore();

}
