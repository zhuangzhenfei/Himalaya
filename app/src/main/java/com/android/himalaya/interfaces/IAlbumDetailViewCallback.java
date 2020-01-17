package com.android.himalaya.interfaces;

import android.os.Trace;

import java.util.List;

/**
 * create by chameleon
 * on 2020/1/9 0009
 */
public interface IAlbumDetailViewCallback {

    /**
     * 专辑内容加载出来
     * @param traces
     */
    void onDetailListLoaded(List<Trace> traces);
}
