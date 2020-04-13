package com.android.himalaya.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.himalaya.api.HimalayaApi;
import com.android.himalaya.base.BaseApplication;
import com.android.himalaya.interfaces.IPlayCallBack;
import com.android.himalaya.interfaces.IPlayPresenter;
import com.android.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.ximalaya.ting.android.opensdk.player.advertis.IXmAdsStatusListener;
import com.ximalaya.ting.android.opensdk.player.constants.PlayerConstants;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerStatusListener;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode.PLAY_MODEL_LIST;
import static com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode.PLAY_MODEL_LIST_LOOP;
import static com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode.PLAY_MODEL_RANDOM;
import static com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode.PLAY_MODEL_SINGLE_LOOP;

/**
 * create by shadowman
 * on 2020/2/7
 */
public class PlayerPresenter implements IPlayPresenter, IXmAdsStatusListener, IXmPlayerStatusListener {

    private List<IPlayCallBack> mIPlayCallBacks = new ArrayList<>();

    private static final String TAG = "PlayerPresenter";
    private final XmPlayerManager mPlayerManager;
    private Track mCurrentTrack;
    public static final int DEFAULT_PLAY_INDEX = 0;
    private int mCurrentIndex = DEFAULT_PLAY_INDEX;
    private final SharedPreferences mPlayModeSp;
    private XmPlayListControl.PlayMode mCurrentPlayMode = XmPlayListControl.PlayMode.PLAY_MODEL_LIST;


    //    PLAY_MODEL_LIST
//    PLAY_MODEL_LIST_LOOP
//    PLAY_MODEL_RANDOM
//    PLAY_MODEL_SINGLE_LOOP
    public static final int PLAY_MODEL_LIST_INT = 0;
    public static final int PLAY_MODEL_LIST_LOOP_INT = 1;
    public static final int PLAY_MODEL_RANDOM_INT = 2;
    public static final int PLAY_MODEL_SINGLE_LOOP_INT = 3;

    //sp's key and name
    public static final String PLAY_MODE_SP_NAME = "play_mode";
    public static final String PLAY_MODE_SP_KEY = "currentPlayMode";
    private boolean mIsReverse;
    private int mCurrentProgressPosition = 0;
    private int mProgressDuration = 0;

    private PlayerPresenter() {
        mPlayerManager = XmPlayerManager.getInstance(BaseApplication.getAppContext());
        //广告相关的接口
        mPlayerManager.addAdsStatusListener(this);
        //注册播放器相关的接口
        mPlayerManager.addPlayerStatusListener(this);
        //需要记录当前的播放模式
        mPlayModeSp = BaseApplication.getAppContext().getSharedPreferences(PLAY_MODE_SP_NAME, Context.MODE_PRIVATE);
    }

    private static PlayerPresenter sPlayerpresenter;

    public static PlayerPresenter getPlayerpresenter() {
        if (sPlayerpresenter == null) {
            synchronized (PlayerPresenter.class) {
                if (sPlayerpresenter == null) {
                    sPlayerpresenter = new PlayerPresenter();
                }
            }
        }
        return sPlayerpresenter;
    }

    private boolean isPlayListSet = false;

    //获取播放数据
    public void setPlayList(List<Track> list, int playIndex) {
        if (mPlayerManager != null) {
            mPlayerManager.setPlayList(list, playIndex);
            isPlayListSet = true;
            mCurrentTrack = list.get(playIndex);
            mCurrentIndex = playIndex;
        } else {
            LogUtil.d(TAG, "mPlayerManager is null");
        }

    }

    @Override
    public void play() {
        if (isPlayListSet) {
            mPlayerManager.play();
        }
    }

    @Override
    public void pause() {
        if (mPlayerManager != null) {
            mPlayerManager.pause();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void playPre() {
        //播放前一个
        if (mPlayerManager != null) {
            mPlayerManager.playPre();
        }
    }

    @Override
    public void playNext() {
        //播放下一个
        if (mPlayerManager != null) {
            mPlayerManager.playNext();
        }
    }

    /**
     * 判断是否有播放列表
     *
     * @return
     */
    public boolean hasPlayList() {
        return isPlayListSet;
    }

    @Override
    public void switchPlayMode(XmPlayListControl.PlayMode mode) {
        if (mPlayerManager != null) {
            mCurrentPlayMode = mode;
            mPlayerManager.setPlayMode(mode);
            //通知UI更新播放模式
            for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
                iPlayCallBack.onPlayModeChange(mode);
            }
            //播放状态保存到sp里
            SharedPreferences.Editor editor = mPlayModeSp.edit();
            editor.putInt(PLAY_MODE_SP_KEY, getIntByPlayMode(mode));
            editor.commit();
        }
    }

    private int getIntByPlayMode(XmPlayListControl.PlayMode mode) {
        switch (mode) {
            case PLAY_MODEL_SINGLE_LOOP:
                return PLAY_MODEL_SINGLE_LOOP_INT;
            case PLAY_MODEL_LIST_LOOP:
                return PLAY_MODEL_LIST_LOOP_INT;
            case PLAY_MODEL_RANDOM:
                return PLAY_MODEL_RANDOM_INT;
            case PLAY_MODEL_LIST:
                return PLAY_MODEL_LIST_INT;
        }
        return PLAY_MODEL_LIST_INT;
    }

    private XmPlayListControl.PlayMode getModeByInt(int index) {
        switch (index) {
            case PLAY_MODEL_SINGLE_LOOP_INT:
                return PLAY_MODEL_SINGLE_LOOP;
            case PLAY_MODEL_LIST_LOOP_INT:
                return PLAY_MODEL_LIST_LOOP;
            case PLAY_MODEL_RANDOM_INT:
                return PLAY_MODEL_RANDOM;
            case PLAY_MODEL_LIST_INT:
                return PLAY_MODEL_LIST;
        }
        return PLAY_MODEL_LIST;
    }

    @Override
    public void getPlayList() {
        if (mPlayerManager != null) {
            List<Track> playList = mPlayerManager.getPlayList();
            mPlayerManager.getPlayList();
            for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
                iPlayCallBack.onListLoaded(playList);
            }
        }
    }

    @Override
    public void playByIndex(int index) {
        //切换播放器到index位置进行播放
        if (mPlayerManager != null) {
            mPlayerManager.play(index);
        }
    }

    @Override
    public void seekTo(int progressBar) {
        //更新播放器的进度
        mPlayerManager.seekTo(progressBar);
    }

    @Override
    public boolean isPlaying() {
        //返回当前是否在播放
        return mPlayerManager.isPlaying();
    }

    @Override
    public void reversePlayList() {
        //把播放列表反转
        List<Track> playList = mPlayerManager.getPlayList();
        Collections.reverse(playList);
        mIsReverse = !mIsReverse;
        //更新下标
        mCurrentIndex = playList.size() - 1 - mCurrentIndex;
        mPlayerManager.setPlayList(playList, mCurrentIndex);
        //更新UI
        mCurrentTrack = (Track) mPlayerManager.getCurrSound();
        for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
            iPlayCallBack.onListLoaded(playList);
            iPlayCallBack.onTrackUpdate(mCurrentTrack, mCurrentIndex);
            iPlayCallBack.updateListOrder(mIsReverse);
        }
    }

    @Override
    public void playByAlbumId(long id) {
        //TODO:
        //1.获取专辑的数据
        HimalayaApi himalayaApi = HimalayaApi.getHimalayaApi();
        himalayaApi.getAlbumDetail((int)id, 1, new IDataCallBack<TrackList>() {
            @Override
            public void onSuccess(TrackList trackList) {
                //2.专辑内容设置给播放器
                List<Track> tracks = trackList.getTracks();
                if (tracks != null && tracks.size() > 0) {
                    mPlayerManager.setPlayList(tracks, DEFAULT_PLAY_INDEX);
                    isPlayListSet = true;
                    mCurrentTrack = tracks.get(DEFAULT_PLAY_INDEX);
                    mCurrentIndex = DEFAULT_PLAY_INDEX;
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                LogUtil.d(TAG, "errorCode --> " + errorCode);
                LogUtil.d(TAG, "errorMsg --> " + errorMsg);
                Toast.makeText(BaseApplication.getAppContext(), "请求数据错误...", Toast.LENGTH_SHORT).show();
            }
        });
        //3.播放
    }

    @Override
    public void registerViewCallback(IPlayCallBack iPlayCallBack) {
        if (!mIPlayCallBacks.contains(iPlayCallBack)) {
            mIPlayCallBacks.add(iPlayCallBack);
        }
        //更新之前，让UI的page有数据
        getPlayList();
        //通知当前的节目
        iPlayCallBack.onTrackUpdate(mCurrentTrack, mCurrentIndex);
        iPlayCallBack.onProgressbarChange(mCurrentProgressPosition, mProgressDuration);
        //更新状态
        handlePlayState(iPlayCallBack);
        //从sp里拿数据
        int modeIndex = mPlayModeSp.getInt(PLAY_MODE_SP_KEY, PLAY_MODEL_LIST_INT);
        mCurrentPlayMode = getModeByInt(modeIndex);
        iPlayCallBack.onPlayModeChange(mCurrentPlayMode);
    }

    private void handlePlayState(IPlayCallBack iPlayCallBack) {
        int playerStatus = mPlayerManager.getPlayerStatus();
        //根据状态调用接口的方法
        if (PlayerConstants.STATE_STARTED == playerStatus) {
            iPlayCallBack.onPlayStart();
        } else {
            iPlayCallBack.onPlayPause();
        }

    }

    @Override
    public void unRegisterViewCallback(IPlayCallBack iPlayCallBack) {
        mIPlayCallBacks.remove(iPlayCallBack);
    }

    //=================广告相关的回调方法 start=====================
    @Override
    public void onStartGetAdsInfo() {
        LogUtil.d(TAG, "onStartGetAdsInfo");
    }

    @Override
    public void onGetAdsInfo(AdvertisList advertisList) {
        LogUtil.d(TAG, "onGetAdsInfo");
    }

    @Override
    public void onAdsStartBuffering() {
        LogUtil.d(TAG, "onAdsStartBuffering");

    }

    @Override
    public void onAdsStopBuffering() {
        LogUtil.d(TAG, "onAdsStopBuffering");
    }

    @Override
    public void onStartPlayAds(Advertis advertis, int i) {
        LogUtil.d(TAG, "onStartPlayAds");
    }

    @Override
    public void onCompletePlayAds() {
        LogUtil.d(TAG, "onCompletePlayAds");
    }

    @Override
    public void onError(int what, int extra) {
        LogUtil.d(TAG, "onError what ==>" + what + "extra = >" + extra);
    }
    //=================广告相关的回调方法 end=====================

    //========================播放器相关的回调 start========================
    @Override
    public void onPlayStart() {
        LogUtil.d(TAG, "onPlayStart");
        for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
            iPlayCallBack.onPlayStart();
        }
    }

    @Override
    public void onPlayPause() {
        LogUtil.d(TAG, "onPlayPause");
        for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
            iPlayCallBack.onPlayPause();
        }
    }

    @Override
    public void onPlayStop() {
        LogUtil.d(TAG, "onPlayStop");
        for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
            iPlayCallBack.onPlayStop();
        }
    }

    @Override
    public void onSoundPlayComplete() {
        LogUtil.d(TAG, "onSoundPlayComplete");

    }

    @Override
    public void onSoundPrepared() {
        LogUtil.d(TAG, "onSoundPrepared");
        mPlayerManager.setPlayMode(mCurrentPlayMode);
        if (mPlayerManager.getPlayerStatus() == PlayerConstants.STATE_PREPARED) {
            //播放器准备好了，可以播放在播放
            mPlayerManager.play();
        }

    }

    @Override
    public void onSoundSwitch(PlayableModel lastModel, PlayableModel currModel) {
        LogUtil.d(TAG, "onSoundSwitch");
        if (lastModel != null) {
            LogUtil.d(TAG, "lastModel ==> " + lastModel.getKind());
        }
        LogUtil.d(TAG, "currModel ==> " + currModel.getKind());
        //currModel代表当前的播放内容
        //通过getKind（）方法来获取数据类型
        //track表示track类型
        mCurrentIndex = mPlayerManager.getCurrentIndex();
        if (currModel instanceof Track) {
            Track currentTrack = (Track) currModel;
            mCurrentTrack = currentTrack;
            LogUtil.d(TAG, "title == > " + currentTrack.getTrackTitle());
            //更新标题UI
            for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
                iPlayCallBack.onTrackUpdate(mCurrentTrack, mCurrentIndex);
            }
        }

    }

    @Override
    public void onBufferingStart() {
        LogUtil.d(TAG, "onBufferingStart");
    }

    @Override
    public void onBufferingStop() {
        LogUtil.d(TAG, "onBufferingStop");
    }

    @Override
    public void onBufferProgress(int progress) {
        LogUtil.d(TAG, "onBufferProgress" + progress);
    }

    @Override
    public void onPlayProgress(int currPos, int duration) {
        this.mCurrentProgressPosition = currPos;
        this.mProgressDuration = duration;
        //单位是毫秒
        LogUtil.d(TAG, "onPlayProgress currPos==>" + currPos + "duration ==>" + duration);
        for (IPlayCallBack iPlayCallBack : mIPlayCallBacks) {
            iPlayCallBack.onProgressbarChange(currPos, duration);
        }
    }

    @Override
    public boolean onError(XmPlayerException e) {
        LogUtil.d(TAG, "onError e== >" + e);
        return false;
    }
    //========================播放器相关的回调 end========================
}
