package com.android.himalaya.interfaces;

import com.android.himalaya.base.IBasePresenter;

/**
 * create by shadowman
 * on 2020/3/23
 */
public interface ISearchPresenter extends IBasePresenter<ISearchCallback> {

    /**
     * 进行搜索
     *
     * @param keyword
     */
    void doSearch(String keyword);

    /**
     * 重新搜索
     */
    void reSearch();

    /**
     * 重新搜索
     */
    void loadMore();

    /**
     * 获取热词
     *
     */
    void getHotWord();

    /**
     * 获取推荐到关键字（相关的关键字）
     * @param keyword
     */
    void getRecommandWord(String keyword);
}
