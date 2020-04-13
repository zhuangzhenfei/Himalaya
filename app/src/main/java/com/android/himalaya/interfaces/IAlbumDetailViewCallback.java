package com.android.himalaya.interfaces;

import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.track.Track;

import java.util.List;

/**
 * create by chameleon
 * on 2020/1/9 0009
 */
public interface IAlbumDetailViewCallback {

    /**
     * 专辑内容加载出来
     *
     * @param traces
     */
    void onDetailListLoaded(List<Track> traces);

    /**
     * 网络错误
     *
     */
    void onNetWorkError(int errorCode, String errorMsg);

    /**
     * 把album传给UI使用
     *
     * @param album
     */
    void onAlbumLoaded(Album album);

    /**
     * 加载更多的结果
     *
     * @param size size>0 表示加载成功 else表示加载失败
     */
    void onLoaderMoreFinished(int size);

    void onRefreshedFinished(int size);
}
