package com.android.himalaya.interfaces;

import android.widget.ProgressBar;

import com.android.himalaya.base.IBasePresenter;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;

/**
 * create by shadowman
 * on 2020/2/6
 */
public interface IPlayPresenter extends IBasePresenter<IPlayCallBack> {

    /**
     * 播放
     */
    void play();

    /**
     * 暂停
     */
    void pause();

    /**
     * 停止播放
     */
    void stop();

    /**
     * 播放上一首
     */
    void playPre();

    /**
     * 播放下一首
     */
    void playNext();

    /**
     * 切换播放模式
     * @param mode
     */
    void switchPlayMode(XmPlayListControl.PlayMode mode);

    /**
     * 获取播放列表
     */
    void getPlayList();

    /**
     * 根据列表位置进行播放
     * @param index 节目列表位置
     */
    void playByIndex(int index);

    /**
     * 切换播放进度
     * @param progressBar
     */
    void seekTo(int progressBar);

    /**
     * 判断播放是否在播放
     * @return
     */
    boolean isPlaying();

    /**
     * 把播放列表反转
     */
    void reversePlayList();

    /**
     * 播放专辑的第一个节目
     *
     * @param id
     */
    void playByAlbumId(long id);
}
