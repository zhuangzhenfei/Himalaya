package com.android.himalaya.interfaces;

/**
 * create by chameleon
 * on 2020/1/9 0009
 */
public interface IAlbumDetailPresenter {

    /**
     * 下拉刷新更多
     */
    void pullToReflashMore();

    /**
     * 上拉加载更多
     */
    void loadMore();

    /**
     * 获取专辑详情
     *
     * @param albumId
     * @param page
     */
    void getAlbumDetail(int albumId, int page);

}
