package com.android.himalaya.interfaces;

import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.word.HotWord;
import com.ximalaya.ting.android.opensdk.model.word.QueryResult;

import java.util.List;

/**
 * create by shadowman
 * on 2020/3/23
 */
public interface ISearchCallback {

    /**
     * 搜索结果的回调
     *
     * @param result
     */
    void onSearchResultLoaded(List<Album> result);

    /**
     * 获取热词的结果回调
     *
     * @param hotWordList
     */
    void onHotWordLoaded(List<HotWord> hotWordList);

    /**
     * 加载更多的结果回调
     *
     * @param result 结果
     * @param isOkey true表示成功，false表示失败
     */
    void onLoadMoreResult(List<Album> result, boolean isOkey);

    /**
     * 联想关键词的回调方法
     *
     * @param keyWordList
     */
    void onRecommandWordLoaded(List<QueryResult> keyWordList);

    /**
     * 错误通知回调
     *
     * @param errorCode
     * @param errorMsg
     */
    void onError(int errorCode, String errorMsg);
}
