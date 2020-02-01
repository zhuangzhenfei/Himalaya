package com.android.himalaya.fragments;

import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.himalaya.DetailActivity;
import com.android.himalaya.R;
import com.android.himalaya.adapters.RecommendListAdapter;
import com.android.himalaya.base.BaseFragment;
import com.android.himalaya.interfaces.IRecommendCallback;
import com.android.himalaya.presenters.AlbumDetailPresenter;
import com.android.himalaya.presenters.RecommendPresenter;
import com.android.himalaya.utils.LogUtil;
import com.android.himalaya.views.UILoader;
import com.ximalaya.ting.android.opensdk.model.album.Album;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.List;

/**
 * create by shadowman
 * on 2019/12/28
 */
public class RecommendFragment extends BaseFragment implements IRecommendCallback, RecommendListAdapter.OnRecommendItemClick {
    private static final String TAG = "RecommendFragment";
    private View mRootView;
    private RecyclerView mRecommendRv;
    private RecommendListAdapter mRecommendListAdapter;
    private RecommendPresenter mRecommendPresenter;
    private UILoader mUiLoader;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {

        mUiLoader = new UILoader(getContext()) {
            @Override
            protected View getSuccessView(ViewGroup container) {
                return createSuccessView(layoutInflater, container);
            }
        };

        //获取到逻辑层对象
        mRecommendPresenter = RecommendPresenter.getInstance();
        //设置通知接口的注册/在presenter层会有一个callback
        mRecommendPresenter.registerViewCallback(this);
        //获取推荐列表
        mRecommendPresenter.getRecommendList();


        //Android中不允许重复绑定，填充View
        if (mUiLoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUiLoader.getParent()).removeView(mUiLoader);
        }

        //返回View给界面显示
        return mUiLoader;
    }

    private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container) {
        mRootView = layoutInflater.inflate(R.layout.fragment_recommend, container, false);
        mRecommendRv = mRootView.findViewById(R.id.recommend_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecommendRv.setLayoutManager(linearLayoutManager);
        mRecommendRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //UIUtiil工具类可以将px转为pd，pd转为px
                outRect.bottom = UIUtil.dip2px(view.getContext(), 4);
                outRect.top = UIUtil.dip2px(view.getContext(), 4);
                outRect.left = UIUtil.dip2px(view.getContext(), 5);
                outRect.right = UIUtil.dip2px(view.getContext(), 5);
            }
        });
        mRecommendListAdapter = new RecommendListAdapter();
        mRecommendRv.setAdapter(mRecommendListAdapter);
        mRecommendListAdapter.setOnRecommendItemClick(this);
        return mRootView;
    }

    @Override
    public void onRecommendListLoaded(List<Album> result) {
        LogUtil.d(TAG,"onRecommendListLoaded");
        //当获取到推荐内容的时候，此方法就会被调用（成功）
        //把数据设置给适配器，并且更新UI
        mRecommendListAdapter.setData(result);
        mUiLoader.updateStatus(UILoader.UIStatus.SUCCESS);
    }

    //网络错误加载界面
    @Override
    public void onNetworkError() {
        LogUtil.d(TAG,"onNetworkError");

        mUiLoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
        mUiLoader.setOnRetryClickListener(new UILoader.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                //网络不佳的时候，用户点击了重试
                if (mRecommendPresenter != null) {
                    mRecommendPresenter.getRecommendList();
                }

            }
        });
    }

    //空数据加载界面
    @Override
    public void onEmpty() {
        LogUtil.d(TAG,"onEmpty");

        mUiLoader.updateStatus(UILoader.UIStatus.EMPTY);
    }

    //加载中界面
    @Override
    public void onLoading() {
        LogUtil.d(TAG,"onLoading");

        mUiLoader.updateStatus(UILoader.UIStatus.LOADING);
    }

    //fragment界面摧毁后数据消失，再次创建界面显示数据
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRecommendPresenter != null) {
            mRecommendPresenter.unRegisterViewCallback(this);
        }
    }

    @Override
    public void onItemClick(int position, Album album) {
        //presenter层传数据
        AlbumDetailPresenter.getInstance().setTargetAlbum(album);
        //item被点击
        Intent intent = new Intent(getContext(), DetailActivity.class);
        startActivity(intent);
    }
}
