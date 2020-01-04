package com.android.himalaya.fragments;

import android.graphics.Rect;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.himalaya.R;
import com.android.himalaya.adapters.RecommendListAdapter;
import com.android.himalaya.base.BaseFragment;
import com.android.himalaya.interfaces.IRecommendCallback;
import com.android.himalaya.presenters.RecommendPresenter;
import com.android.himalaya.utils.Constants;
import com.android.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by shadowman
 * on 2019/12/28
 */
public class RecommendFragment extends BaseFragment implements IRecommendCallback {
    private static final String TAG = "RecommendFragment";
    private View mRootView;
    private RecyclerView mRecommendRv;
    private RecommendListAdapter mRecommendListAdapter;
    private RecommendPresenter mRecommendPresenter;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        mRootView = layoutInflater.inflate(R.layout.fragment_recommend, container, false);

        mRecommendRv = mRootView.findViewById(R.id.recommend_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecommendRv.setLayoutManager(linearLayoutManager);
        mRecommendRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //UIUtiil工具类可以将px转为pd，pd转为px
                outRect.bottom = UIUtil.dip2px(view.getContext(),5);
                outRect.top = UIUtil.dip2px(view.getContext(),5);
                outRect.left = UIUtil.dip2px(view.getContext(),5);
                outRect.right = UIUtil.dip2px(view.getContext(),5);
            }
        });
        mRecommendListAdapter = new RecommendListAdapter();
        mRecommendRv.setAdapter(mRecommendListAdapter);

        //获取到逻辑层对象
        mRecommendPresenter = RecommendPresenter.getInstance();
        //设置通知接口的注册
        mRecommendPresenter.registerViewCallback(this);
        //获取推荐列表
        mRecommendPresenter.getRecommendList();


        return mRootView;
    }

    @Override
    public void onRecommendListLoaded(List<Album> result) {
        //当获取到推荐内容的时候，此方法就会被调用（成功）
        //数据回来就更新UI
        //把数据设置给适配器，并且更新UI
        mRecommendListAdapter.setData(result);
    }

    @Override
    public void onLoadMore(List<Album> result) {

    }

    @Override
    public void onReflashMore(List<Album> result) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRecommendPresenter != null){
            mRecommendPresenter.unRegisterViewCallback(this);
        }
    }
}
