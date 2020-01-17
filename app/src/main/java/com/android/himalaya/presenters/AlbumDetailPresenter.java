package com.android.himalaya.presenters;

import com.android.himalaya.interfaces.IAlbumDetailPresenter;
import com.ximalaya.ting.android.opensdk.model.album.Album;

/**
 * create by chameleon
 * on 2020/1/9 0009
 */
public class AlbumDetailPresenter implements IAlbumDetailPresenter {

    private Album mTargetAlbum = null;

    private AlbumDetailPresenter(){}

    private static AlbumDetailPresenter sInstance = null;

    public static AlbumDetailPresenter getInstance(){
        if (sInstance != null) {
            synchronized (AlbumDetailPresenter.class){
                if (sInstance != null) {
                    sInstance = new AlbumDetailPresenter();
                }
            }
        }
        return sInstance;
    }

    @Override
    public void pullToReflashMore() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void getAlbumDetail(int albumId, int page) {

    }

    public void setTargetAlbum(Album targetAlbum){
        this.mTargetAlbum = targetAlbum;
    }
}
