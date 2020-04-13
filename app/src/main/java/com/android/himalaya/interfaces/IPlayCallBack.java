package com.android.himalaya.interfaces;

import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;

import java.util.List;

/**
 * create by shadowman
 * on 2020/2/6
 */
public interface IPlayCallBack {

    /**
     * 播放
     */
    void onPlayStart();

    /**
     * 暂停
     */
    void onPlayPause();

    /**
     * 停止
     */
    void onPlayStop();

    /**
     * 播放错误
     */
    void onPlayError();

    /**
     * 下一首
     */
    void nextPlay(Track track);

    /**
     * 上一首
     */
    void prePlay(Track track);

    /**
     * 播放列表数据加载完成
     * @param list 播放列表数据
     */
    void onListLoaded(List<Track> list);

    /**
     * 播放模式改变
     * @param mode
     */
    void onPlayModeChange(XmPlayListControl.PlayMode mode);

    /**
     * 进度条的改变
     * @param currentProgress 当前进度条
     * @param total 总进度条
     */
    void onProgressbarChange(int currentProgress, int total);

    /**
     * 广告正在加载
     */
    void onAdLoading();

    /**
     * 广告加载结束
     */
    void onAdFinished();

    /**
     * 更新当前节目界面
     * @param track 节目
     */
    void onTrackUpdate(Track track, int playIndex);

    /**
     * 通知UI更新播放列表的顺序文字和图标
     * @param isReverse
     */
    void updateListOrder(boolean isReverse);
}
