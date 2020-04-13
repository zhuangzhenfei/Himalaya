package com.android.himalaya;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.himalaya.adapters.DetailListAdapter;
import com.android.himalaya.base.BaseActivity;
import com.android.himalaya.base.BaseApplication;
import com.android.himalaya.interfaces.IAlbumDetailViewCallback;
import com.android.himalaya.interfaces.IPlayCallBack;
import com.android.himalaya.presenters.AlbumDetailPresenter;
import com.android.himalaya.presenters.PlayerPresenter;
import com.android.himalaya.utils.ImageBlur;
import com.android.himalaya.utils.LogUtil;
import com.android.himalaya.views.UILoader;
import com.bumptech.glide.Glide;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.List;

public class DetailActivity extends BaseActivity implements IAlbumDetailViewCallback, UILoader.OnRetryClickListener, DetailListAdapter.ItemClickListener, IPlayCallBack {

    private static final String TAG = "DetailActivity";
    private ImageView mLargeCover;
    private ImageView mSmallCover;
    private TextView mAlbumTitle;
    private TextView mAlbumAuthor;
    private AlbumDetailPresenter mAlbumDetailPresenter;

    private int mCurrentPage = 1;
    private RecyclerView mDetailList;
    private DetailListAdapter mDetailListAdapter;
    private FrameLayout mDetailListContainer;
    private UILoader mUiLoader;
    private long mCurrentId = -1;
    private TextView mPlayControlTips;
    private ImageView mPlayControlBtn;
    private PlayerPresenter mPlayerPresenter;
    private List<Track> mCurrentTrack = null;
    public static final int DEFAULT_PLAY_INDEX = 0;
    private TwinklingRefreshLayout mRefreshLayout;
    private boolean mIsLoadMore = false;
    private String mCurrentTrackTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //设置导航栏等控件是否可见
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        initView();
        initPresenter();

        updatePlayState(mPlayerPresenter.isPlaying());
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAlbumDetailPresenter != null) {
            mAlbumDetailPresenter.unRegisterViewCallback(this);
        }
        if (mPlayerPresenter != null) {
            mPlayerPresenter.unRegisterViewCallback(this);
        }
    }

    private void initPresenter() {
        //专辑详情的presenter
        mAlbumDetailPresenter = AlbumDetailPresenter.getInstance();
        mAlbumDetailPresenter.registerViewCallback(this);
        //播放的presenter
        mPlayerPresenter = PlayerPresenter.getPlayerpresenter();
        mPlayerPresenter.registerViewCallback(this);
    }

    private void initListener() {
        mPlayControlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayerPresenter != null) {
                    //判断是否有播放列表
                    boolean has = mPlayerPresenter.hasPlayList();
                    if (has) {
                        handlePlayControl();
                    } else {
                        //没有的话播放第一条
                        handleNoPlayList();
                    }
                }

            }
        });
    }

    private void handleNoPlayList() {
        mPlayerPresenter.setPlayList(mCurrentTrack, DEFAULT_PLAY_INDEX);
    }

    private void handlePlayControl() {
        //控制状态器的改变
        if (mPlayerPresenter.isPlaying()) {
            //播放点击后停止，停止点击后播放
            mPlayerPresenter.pause();
        } else {
            mPlayerPresenter.play();
        }
    }

    private void initView() {
        mDetailListContainer = this.findViewById(R.id.detail_list_container);

        if (mUiLoader == null) {
            mUiLoader = new UILoader(this) {
                @Override
                protected View getSuccessView(ViewGroup container) {
                    return createSuccessView(container);
                }
            };
            mDetailListContainer.removeAllViews();
            mDetailListContainer.addView(mUiLoader);
            mUiLoader.setOnRetryClickListener(DetailActivity.this);
        }

        //版本26之后就不需要强转
        mLargeCover = findViewById(R.id.iv_latge_cover);
        mSmallCover = findViewById(R.id.iv_small_cover);
        mAlbumTitle = findViewById(R.id.tv_album_title);
        mAlbumAuthor = findViewById(R.id.tv_album_author);
        mPlayControlBtn = findViewById(R.id.detail_play_control);
        mPlayControlTips = findViewById(R.id.play_control_tv);
        mPlayControlTips.setSelected(true);

    }

    private View createSuccessView(ViewGroup container) {
        View detailListView = LayoutInflater.from(this).inflate(R.layout.item_detail_list, container, false);
        mDetailList = detailListView.findViewById(R.id.album_detail_list);
        mRefreshLayout = detailListView.findViewById(R.id.refresh_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mDetailList.setLayoutManager(linearLayoutManager);
        mDetailListAdapter = new DetailListAdapter();
        mDetailList.setAdapter(mDetailListAdapter);
        //设置Item的上下间距
        mDetailList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.bottom = UIUtil.dip2px(view.getContext(), 5);
                outRect.top = UIUtil.dip2px(view.getContext(), 5);
                outRect.left = UIUtil.dip2px(view.getContext(), 5);
                outRect.right = UIUtil.dip2px(view.getContext(), 5);
            }
        });
        mDetailListAdapter.setItemClickListener(this);
        //设置刷新导航的高度
        BezierLayout headView = new BezierLayout(this);
        mRefreshLayout.setHeaderView(headView);
        mRefreshLayout.setHeaderHeight(50);
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                BaseApplication.getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(DetailActivity.this, "刷新成功...", Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishRefreshing();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                if (mAlbumDetailPresenter != null) {
                    mAlbumDetailPresenter.loadMore();
                    mIsLoadMore = true;
                }
            }
        });
        return detailListView;
    }

    @Override
    public void onDetailListLoaded(List<Track> tracks) {
        if (mIsLoadMore && mRefreshLayout != null) {
            mRefreshLayout.finishLoadmore();
            mIsLoadMore = true;
        }

        this.mCurrentTrack = tracks;
        //判断数据结果，根据结果控制UI显示
        //没内容
        if (tracks == null || tracks.size() == 0) {
            if (mUiLoader != null) {
                mUiLoader.updateStatus(UILoader.UIStatus.EMPTY);
            }
        }

        //有内容
        if (mUiLoader != null) {
            mUiLoader.updateStatus(UILoader.UIStatus.SUCCESS);
        }
        mDetailListAdapter.setData(tracks);
    }

    @Override
    public void onNetWorkError(int errorCode, String errorMsg) {
        //请求发生错误，网络请求异常状态
        mUiLoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
    }

    @Override
    public void onAlbumLoaded(Album album) {
        long id = album.getId();
        mCurrentId = id;
        //获取专辑的详情内容
        if (mAlbumDetailPresenter != null) {
            mAlbumDetailPresenter.getAlbumDetail((int) album.getId(), mCurrentPage);
        }

        //拿数据显示loading状态
        if (mUiLoader != null) {
            mUiLoader.updateStatus(UILoader.UIStatus.LOADING);
        }
        //设置之前要判空，否则异步执行容易崩溃
        if (mAlbumTitle != null) {
            mAlbumTitle.setText(album.getAlbumTitle());
        }

        if (mAlbumAuthor != null) {
            mAlbumAuthor.setText(album.getAnnouncer().getNickname());
        }

        //毛玻璃效果需要异步操作，picasso加载图片需要时间，如果未完成ImageBlur就传入mLargeCOver会为空，导致崩溃
        if (mLargeCover != null) {
            Picasso.with(this).load(album.getCoverUrlLarge()).into(mLargeCover, new Callback() {
                @Override
                public void onSuccess() {
                    Drawable drawable = mLargeCover.getDrawable();
                    if (drawable != null) {
                        ImageBlur.makeBlur(mLargeCover, DetailActivity.this);
                    }
                }

                @Override
                public void onError() {
                    LogUtil.d(TAG, "onError");
                }
            });

        }

        if (mSmallCover != null) {
            Glide.with(this).load(album.getCoverUrlSmall()).into(mSmallCover);

        }
    }

    @Override
    public void onLoaderMoreFinished(int size) {
        if (size>0) {
            Toast.makeText(this, "成功加载" + size + "条节目", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "没有更多节目", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRefreshedFinished(int size) {

    }

    @Override
    public void onRetryClick() {
        //这里面表示用户网络不佳的时候重新加载
        if (mAlbumDetailPresenter != null) {
            mAlbumDetailPresenter.getAlbumDetail((int) mCurrentId, mCurrentPage);
        }
    }

    @Override
    public void onItemCLick(List<Track> dataList, int position) {
        //设置播放器的数据
        PlayerPresenter playerpresenter = PlayerPresenter.getPlayerpresenter();
        playerpresenter.setPlayList(dataList, position);
        //跳转到播放器界面
        Intent intent = new Intent(DetailActivity.this, PlayerActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPlayStart() {
        //设置暂停的图标，文字修改成已播放
        updatePlayState(true);
    }

    /**
     * 根据播放状态修改图标
     *
     * @param playing
     */
    public void updatePlayState(boolean playing) {
        if (mPlayControlBtn != null && mPlayControlTips != null) {
            mPlayControlBtn.setImageResource(playing ? R.drawable.selector_play_control_pause : R.drawable.selector_play_control_play);
            if (!playing) {
                mPlayControlTips.setText(R.string.click_play_tips_text);
            }else {
                if (!TextUtils.isEmpty(mCurrentTrackTitle)) {
                    mPlayControlTips.setText(mCurrentTrackTitle);
                }
            }
        }
    }

    @Override
    public void onPlayPause() {
        //设置成播放的图标，文字修改成已暂停
        updatePlayState(false);
    }

    @Override
    public void onPlayStop() {
        //设置成播放的图标，文字修改成已暂停
        updatePlayState(false);
    }

    @Override
    public void onPlayError() {

    }

    @Override
    public void nextPlay(Track track) {

    }

    @Override
    public void prePlay(Track track) {

    }

    @Override
    public void onListLoaded(List<Track> list) {

    }

    @Override
    public void onPlayModeChange(XmPlayListControl.PlayMode mode) {

    }

    @Override
    public void onProgressbarChange(int currentProgress, int total) {

    }

    @Override
    public void onAdLoading() {

    }

    @Override
    public void onAdFinished() {

    }

    @Override
    public void onTrackUpdate(Track track, int playIndex) {
        if (track != null) {
            mCurrentTrackTitle = track.getTrackTitle();
            if (!TextUtils.isEmpty(mCurrentTrackTitle) && mPlayControlTips != null) {
                mPlayControlTips.setText(mCurrentTrackTitle);
            }
        }

    }

    @Override
    public void updateListOrder(boolean isReverse) {

    }
}
