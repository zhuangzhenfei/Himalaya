package com.android.himalaya.data;

import com.ximalaya.ting.android.opensdk.model.track.Track;

import java.util.List;

/**
 * create by shadowman
 * on 2020/6/27
 */
public interface IHistoryDaoCallback {

    /**
     * 添加历史的结果
     * @param isSucess
     */
    void onHistoryAdd(boolean isSucess);

    /**
     * 删除历史的结果
     * @param isSucess
     */
    void onHistoryDel(boolean isSucess);

    /**
     * 历史数据加载的结果
     * @param tracks
     */
    void onHistoriesLoaded(List<Track> tracks);

    /**
     * 历史清除结果
     * @param isSucess
     */
    void onHistoriesClean(boolean isSucess);
}
