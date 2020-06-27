package com.android.himalaya.interfaces;

import com.android.himalaya.base.IBasePresenter;
import com.ximalaya.ting.android.opensdk.model.track.Track;

/**
 * create by shadowman
 * on 2020/6/27
 */
public interface IHistoryPresenter extends IBasePresenter<IHistoryCallback> {

    /**
     * 历史数据
     */
    void listHistory();

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
     * 清楚历史
     */
    void cleanHistory();
}
