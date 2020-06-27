package com.android.himalaya.interfaces;

import com.ximalaya.ting.android.opensdk.model.track.Track;

import java.util.List;

/**
 * create by shadowman
 * on 2020/6/27
 */
public interface IHistoryCallback {

    /**
     * 历史内容加载的结果
     * @param tracks
     */
    void onHistoriesLoaded(List<Track> tracks);
}
