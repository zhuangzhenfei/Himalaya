package com.android.himalaya.presenters;

import com.android.himalaya.interfaces.IRecommendCallback;
import com.android.himalaya.interfaces.IRecommendPresenter;
import com.android.himalaya.utils.Constants;
import com.android.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by chameleon
 * on 2020/1/4 0004
 */
public class RecommendPresenter implements IRecommendPresenter {

    private static final String TAG = "RecommendPresenter";

    private List<IRecommendCallback> mCallbacks = new ArrayList<>();

    //创建单例步骤
    private RecommendPresenter(){}

    private static RecommendPresenter sInstance = null;

    /**
     * 获取单例对象（懒汉）
     * @return
     */
    public static RecommendPresenter getInstance(){
        if (sInstance == null) {
            synchronized (RecommendPresenter.class){
                if (sInstance == null) {
                    sInstance = new RecommendPresenter();
                }
            }
        }
        return sInstance;
    }

    /**
     * 获取推荐内容
     *
     * 接口：获取猜你喜欢
     */
    @Override
    public void getRecommendList() {
        Map<String, String> map = new HashMap<>();
        map.put(DTransferConstants.LIKE_COUNT, Constants.RECOMMEND_COUNT + "");
        CommonRequest.getGuessLikeAlbum(map, new IDataCallBack<GussLikeAlbumList>() {
            @Override
            public void onSuccess(GussLikeAlbumList gussLikeAlbumList) {
                //请求参数是子线程中，请求结束后返回子线程
                LogUtil.d(TAG, "thread name -- > " + Thread.currentThread().getName());

                if (gussLikeAlbumList != null){
                    List<Album> albumList = gussLikeAlbumList.getAlbumList();
                    //upRecommendUI(albumList);
                    handleRecommendResult(albumList);
                }
            }

            @Override
            public void onError(int i, String s) {
                LogUtil.d(TAG, "error -- >" + i);
                LogUtil.d(TAG, "errorMsg -- >" + s);
            }
        });
    }

    private void getRecommendData() {
    }

    private void handleRecommendResult(List<Album> albumList) {
        if (mCallbacks != null){
            for (IRecommendCallback callback : mCallbacks) {
                callback.onRecommendListLoaded(albumList);
            }
        }
    }

    @Override
    public void pullToReflashMore() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void registerViewCallback(IRecommendCallback callback) {
        //只有一个使用mcallback
//        this.mCallback = callback
        //多个使用的时候是由列表
        if (mCallbacks != null && !mCallbacks.contains(callback)) {
            mCallbacks.add (callback);
        }
    }

    @Override
    public void unRegisterViewCallback(IRecommendCallback callback) {
        if (mCallbacks != null) {
            mCallbacks.remove(mCallbacks);
        }
    }
}
