package com.android.himalaya.presenters;

import com.android.himalaya.api.HimalayaApi;
import com.android.himalaya.interfaces.IAlbumDetailPresenter;
import com.android.himalaya.interfaces.IAlbumDetailViewCallback;
import com.android.himalaya.utils.Constants;
import com.android.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by chameleon
 * on 2020/1/9 0009
 */
public class AlbumDetailPresenter implements IAlbumDetailPresenter {

    private static final String TAG = "AlbumDetailPresenter";
    private List<IAlbumDetailViewCallback> mCallbacks = new ArrayList<>();
    private List<Track> mTracks = new ArrayList<>();

    private Album mTargetAlbum = null;
    private int mCurrentAlbumId = 1;
    private int mCurrentPageIndex = 0;

    private AlbumDetailPresenter() {
    }

    private static AlbumDetailPresenter sInstance = null;

    public static AlbumDetailPresenter getInstance() {
        if (sInstance == null) {
            synchronized (AlbumDetailPresenter.class) {
                if (sInstance == null) {
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
        //加载更多内容
        mCurrentPageIndex++;
        //传入true，表示结果加载后面
        doLoaded(true);
    }

    public void doLoaded(final boolean isLoadMore){
        HimalayaApi himalayaApi = HimalayaApi.getHimalayaApi();
        himalayaApi.getAlbumDetail(mCurrentAlbumId, mCurrentPageIndex, new IDataCallBack<TrackList>() {
            @Override
            public void onSuccess(TrackList trackList) {
                if (trackList != null) {
                    List<Track> tracks = trackList.getTracks();
                    LogUtil.d(TAG, "tracks size --> " + tracks.size());
                    if (isLoadMore) {
                        //下拉加载更多，在后面加载数据
                        mTracks.addAll(tracks);
                        int size = tracks.size();
                        handleLoadedMoreResult(size);
                    } else {
                        //刷新，在前面加载数据
                        mTracks.addAll(0, tracks);
//                        handleRefreshMoreResult(size);
                    }
                    handleAlbumDetailResult(mTracks);
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                if (isLoadMore) {
                    mCurrentPageIndex--;
                }
                LogUtil.d(TAG, "errorCode --> " + errorCode);
                LogUtil.d(TAG, "errorMsg --> " + errorMsg);
                handlerError(errorCode, errorMsg);
            }
        });
    }

    private void handleLoadedMoreResult(int size) {
        for (IAlbumDetailViewCallback callback : mCallbacks) {
            callback.onLoaderMoreFinished(size);
        }
    }

    @Override
    public void getAlbumDetail(int albumId, int page) {
        mTracks.clear();
        this.mCurrentAlbumId = albumId;
        this.mCurrentPageIndex = page;
        //更好用页码和专辑id获取列表
        doLoaded(false);

    }

    /**
     * 如果发生错误，那么就通知UI
     * @param errorCode
     * @param errorMsg
     */
    private void handlerError(int errorCode, String errorMsg) {
        for (IAlbumDetailViewCallback callback : mCallbacks) {
            callback.onNetWorkError(errorCode, errorMsg);
        }
    }

    /**
     * 返回数据
     * @param tracks
     */
    private void handleAlbumDetailResult(List<Track> tracks) {
        for (IAlbumDetailViewCallback callback : mCallbacks) {
            callback.onDetailListLoaded(tracks);
        }
    }

    @Override
    public void registerViewCallback(IAlbumDetailViewCallback iAlbumDetailViewCallback) {
        if (!mCallbacks.contains(iAlbumDetailViewCallback)) {
            mCallbacks.add(iAlbumDetailViewCallback);
            if (mTargetAlbum != null) {
                iAlbumDetailViewCallback.onAlbumLoaded(mTargetAlbum);
            }
        }
    }

    @Override
    public void unRegisterViewCallback(IAlbumDetailViewCallback iAlbumDetailViewCallback) {
        mCallbacks.remove(iAlbumDetailViewCallback);
    }


    //目标数据
    public void setTargetAlbum(Album targetAlbum) {
        this.mTargetAlbum = targetAlbum;
    }
}
