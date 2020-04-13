package com.android.himalaya.views;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.himalaya.R;
import com.android.himalaya.adapters.PlayListAdapter;
import com.android.himalaya.base.BaseApplication;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;

import org.w3c.dom.Text;

import java.util.List;

/**
 * create by shadowman
 * on 2020/2/27
 */
public class SobPopWindow extends PopupWindow {

    private final View mPopView;
    private View mCloseBtn;
    private RecyclerView mTracksList;
    private PlayListAdapter mPlayListAdapter;
    private TextView mPlayModeTv;
    private ImageView mPlayModeIv;
    private View mPlayModeContainer;
    private PlayListActionListener mPlayModeClickListener = null;
    private View mOrderBtnContainer;
    private ImageView mOrderIcon;
    private TextView mOrderText;

    public SobPopWindow() {
        //设置宽高
        super(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置setOutsideTouchable前先设置setBackgroundDrawable
        //否则部分机型不发关闭pop
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
        //加载View
        mPopView = LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.pop_play_list, null);
        //设置内容
        setContentView(mPopView);
        //设置窗口进入和退出的动画
        setAnimationStyle(R.style.pop_animation);
        initView();
        initEvent();
    }

    private void initView() {
        //找控件
        mCloseBtn = mPopView.findViewById(R.id.play_list_close_btn);
        mTracksList = mPopView.findViewById(R.id.play_list_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(BaseApplication.getAppContext());
        mTracksList.setLayoutManager(layoutManager);
        //设置适配器
        mPlayListAdapter = new PlayListAdapter();
        mTracksList.setAdapter(mPlayListAdapter);
        mPlayModeTv = mPopView.findViewById(R.id.play_list_play_mode_tv);
        mPlayModeIv = mPopView.findViewById(R.id.play_list_play_mode_iv);
        mPlayModeContainer = mPopView.findViewById(R.id.play_list_play_mode_container);
        mOrderBtnContainer = mPopView.findViewById(R.id.play_list_order_container);
        mOrderIcon = mPopView.findViewById(R.id.play_list_order_iv);
        mOrderText = mPopView.findViewById(R.id.play_list_order_tv);
    }

    private void initEvent() {
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SobPopWindow.this.dismiss();
            }
        });

        mPlayModeContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换播放模式
                if (mPlayModeClickListener != null) {
                    mPlayModeClickListener.onPlayModeClick();
                }
            }
        });

        mOrderBtnContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换播放顺序
                mPlayModeClickListener.onOrderClick();
            }
        });
    }

    /**
     * 给适配器设置数据
     *
     * @param data
     */
    public void setListData(List<Track> data) {
        if (mPlayListAdapter != null) {
            mPlayListAdapter.setData(data);
        }
    }

    public void setCurrentPlayPostion(int position) {
        if (mPlayListAdapter != null) {
            mPlayListAdapter.setCurrentPlayPostion(position);
            mTracksList.scrollToPosition(position);
        }
    }

    public void setPlayListItemClickListener(PlayListItemClickListener listener) {
        mPlayListAdapter.setOnItemClickListener(listener);
    }

    /**
     * 更新播放列表的播放模式
     *
     * @param currentMode
     */
    public void updatePlayMode(XmPlayListControl.PlayMode currentMode) {
        updatePlayModeBtnImg(currentMode);
    }

    /**
     * 切换列表顺序和逆序的字体和图标
     * @param isReverse
     */
    public void updateOrderIcon(boolean isReverse) {
        mOrderIcon.setImageResource(isReverse ? R.drawable.selector_player_mode_list_order : R.drawable.selector_player_mode_list_reverse);
        mOrderText.setText(BaseApplication.getAppContext().getString(isReverse ? R.string.order_text : R.string.revers_text));
    }

    /**
     * 根据当前的状态，更新播放模式的图标
     * PLAY_MODEL_LIST
     * PLAY_MODEL_LIST_LOOP
     * PLAY_MODEL_RANDOM
     * PLAY_MODEL_SINGLE_LOOP
     */
    private void updatePlayModeBtnImg(XmPlayListControl.PlayMode playMode) {
        int resId = R.drawable.selector_player_mode_list_order;
        int textId = R.string.play_mode_list_play_text;
        switch (playMode) {
            case PLAY_MODEL_LIST:
                resId = R.drawable.selector_player_mode_list_order;
                textId = R.string.play_mode_order_text;
                break;
            case PLAY_MODEL_RANDOM:
                resId = R.drawable.selector_player_mode_random;
                textId = R.string.play_mode_random_text;
                break;
            case PLAY_MODEL_LIST_LOOP:
                resId = R.drawable.selector_player_mode_list_loop;
                textId = R.string.play_mode_list_play_text;
                break;
            case PLAY_MODEL_SINGLE_LOOP:
                resId = R.drawable.selector_player_mode_single_loop;
                textId = R.string.play_mode_single_play_text;
                break;
        }
        if (mPlayModeIv != null) {
            mPlayModeIv.setImageResource(resId);
        }
        mPlayModeTv.setText(textId);
    }


    public interface PlayListItemClickListener {
        void onItemClick(int position);
    }

    public void setPlayListPlayActionListener(PlayListActionListener playModeListener) {
        mPlayModeClickListener = playModeListener;
    }

    public interface PlayListActionListener {
        //播放模式点击
        void onPlayModeClick();

        //播放顺序点击
        void onOrderClick();
    }
}
