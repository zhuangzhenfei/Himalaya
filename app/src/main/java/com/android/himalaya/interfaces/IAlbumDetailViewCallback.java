package com.android.himalaya.interfaces;

import android.os.Trace;

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
     * 把album传给UI使用
     *
     * @param album
     */
    void onAlbumLoaded(Album album);
}
