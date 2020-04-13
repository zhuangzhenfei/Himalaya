package com.android.himalaya.presenters;

import com.android.himalaya.api.HimalayaApi;
import com.android.himalaya.interfaces.IRecommendCallback;
import com.android.himalaya.interfaces.IRecommendPresenter;
import com.android.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import java.util.ArrayList;
import java.util.List;

/**
 * create by chameleon
 * on 2020/1/4 0004
 */
public class RecommendPresenter implements IRecommendPresenter {

    private static final String TAG = "RecommendPresenter";

    private List<IRecommendCallback> mCallbacks = new ArrayList<>();
    private List<Album> mCurrentRecommend = null;
    private List<Album> mRecommendList;

    //私有化构造方法，创建单例
    private RecommendPresenter() {}

    private static RecommendPresenter sInstance = null;

    /**
     * 获取单例对象（懒汉）
     *
     * @return
     */
    public static RecommendPresenter getInstance() {
        if (sInstance == null) {
            synchronized (RecommendPresenter.class) {
                if (sInstance == null) {
                    sInstance = new RecommendPresenter();
                }
            }
        }
        return sInstance;
    }

    /**
     * 获取当前的推荐专辑列表
     * @return 使用之前判空
     */
    public List<Album> getCurrentRecommend(){
        return mCurrentRecommend;
    }
    /**
     * 获取推荐内容
     * <p>
     * 接口：获取猜你喜欢
     */
    @Override
    public void getRecommendList() {
        //如果内容不为空的话，那么直接使用当前的内容
        if (mRecommendList != null && mRecommendList.size()>0) {
            LogUtil.d(TAG, "getRecommendList --> ");
            handleRecommendResult(mRecommendList);
            return;
        }
        //加载数据时出现的空档期出现加载中界面，这是一个调用会有一个callback，这个callback可以调用所有的“加载情况界面”，运行中调用那个方法就出现那个界面。
        updateLoading();
        HimalayaApi himalayaApi = HimalayaApi.getHimalayaApi();
        himalayaApi.getRecommandList(new IDataCallBack<GussLikeAlbumList>() {
            @Override
            public void onSuccess(GussLikeAlbumList gussLikeAlbumList) {
                //请求参数是子线程中，请求结束后返回子线程
                LogUtil.d(TAG, "thread name -- > " + Thread.currentThread().getName());

                if (gussLikeAlbumList != null) {
                    mRecommendList = gussLikeAlbumList.getAlbumList();
                    //upRecommendUI(albumList);
                    handleRecommendResult(mRecommendList);
                }
            }

            @Override
            public void onError(int i, String s) {
                LogUtil.e(TAG, "error -- >" + i);
                LogUtil.e(TAG, "errorMsg -- >" + s);

                handlerError();
            }
        });
    }

    private void handlerError() {
        if (mCallbacks != null) {
            for (IRecommendCallback callback : mCallbacks) {
                callback.onNetworkError();
            }
        }
    }

    private void handleRecommendResult(List<Album> albumList) {
        //通知UI更新
        if (albumList != null) {
            if (albumList.size() == 0) {
                for (IRecommendCallback callback : mCallbacks) {
                    callback.onEmpty();
                }
            } else {
                for (IRecommendCallback callback : mCallbacks) {
                    callback.onRecommendListLoaded(albumList);
                }
                this.mCurrentRecommend = albumList;
            }
        }
    }

    private void updateLoading(){
        for (IRecommendCallback callback : mCallbacks) {
            callback.onLoading();
        }
    }

    @Override
    public void pullToRefreshMore() {

    }

    @Override
    public void loadMore() {

    }

    //每有一个界面调用这个注册接口，就会有一个callback传回来
    @Override
    public void registerViewCallback(IRecommendCallback callback) {
        //只有一个使用mcallback
//        this.mCallback = callback
        //多个使用的时候是由列表
        if (mCallbacks != null && !mCallbacks.contains(callback)) {
            mCallbacks.add(callback);
        }
    }

    @Override
    public void unRegisterViewCallback(IRecommendCallback callback) {
        if (mCallbacks != null) {
            mCallbacks.remove(callback);
        }
    }
}
