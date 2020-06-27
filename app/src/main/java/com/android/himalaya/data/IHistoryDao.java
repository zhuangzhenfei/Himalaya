package com.android.himalaya.data;

import com.ximalaya.ting.android.opensdk.model.track.Track;

/**
 * create by shadowman
 * on 2020/6/27
 */
public interface IHistoryDao {

    /**
     * 设置回调接口
     * @param callback
     */
    void setCallback(IHistoryDaoCallback callback);

    /**
     * 添加历史
     * @param track
     */
    void addHistory(Track track);

    /**
     * 删除历史
     * @param track
     */
    void delHistory(Track track);

    /**
     * 清楚历史内容
     */
    void cleanHistory();

    /**
     * 获取历史的内容
     */
    void listHistories();
}
