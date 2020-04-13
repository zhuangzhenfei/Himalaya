package com.android.himalaya.presenters;

import com.android.himalaya.api.HimalayaApi;
import com.android.himalaya.interfaces.ISearchCallback;
import com.android.himalaya.interfaces.ISearchPresenter;
import com.android.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;
import com.ximalaya.ting.android.opensdk.model.word.HotWord;
import com.ximalaya.ting.android.opensdk.model.word.HotWordList;
import com.ximalaya.ting.android.opensdk.model.word.QueryResult;
import com.ximalaya.ting.android.opensdk.model.word.SuggestWords;

import java.util.ArrayList;
import java.util.List;

/**
 * create by shadowman
 * on 2020/3/24
 */
public class SearchPresenter implements ISearchPresenter {

    private static final String TAG = "SearchPresenter";
    //当前的搜索关键字
    private String mCurrentKeyword = null;
    private final HimalayaApi mHimalayaApi;
    private static final int DEFAULT_PAGE = 1;
    private int mCurrentPage = DEFAULT_PAGE;

    private SearchPresenter() {
        mHimalayaApi = HimalayaApi.getHimalayaApi();
    }

    private static SearchPresenter sSearchPresenter = null;

    public static SearchPresenter getSearchPresenter() {
        if (sSearchPresenter == null) {
            synchronized (SearchPresenter.class) {
                if (sSearchPresenter == null) {
                    sSearchPresenter = new SearchPresenter();
                }
            }
        }
        return sSearchPresenter;
    }

    private List<ISearchCallback> mCallback = new ArrayList<>();

    @Override
    public void doSearch(String keyword) {
        //用于新搜索
        //当网络不好的时候，用户会点击重新搜索
        this.mCurrentKeyword = keyword;
        search(keyword);
    }

    private void search(String keyword) {
        mHimalayaApi.setchByKeyword(keyword, mCurrentPage, new IDataCallBack<SearchAlbumList>() {
            @Override
            public void onSuccess(SearchAlbumList searchAlbumList) {
                List<Album> albums = searchAlbumList.getAlbums();
                if (albums != null) {
                    LogUtil.d(TAG, "album size == " + albums.size());
                    for (ISearchCallback iSearchCallback : mCallback) {
                        iSearchCallback.onSearchResultLoaded(albums);
                    }
                } else {
                    LogUtil.d(TAG, "album is null");
                }

            }

            @Override
            public void onError(int errorCode, String errorString) {
                LogUtil.d(TAG, "errorCode == " + errorCode);
                LogUtil.d(TAG, "errorString == " + errorString);
                for (ISearchCallback iSearchCallback : mCallback) {
                    iSearchCallback.onError(errorCode, errorString);
                }
            }
        });
    }

    @Override
    public void reSearch() {
        search(mCurrentKeyword);
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void getHotWord() {
        //TODO:缓存热词
        mHimalayaApi.getHotWords(new IDataCallBack<HotWordList>() {
            @Override
            public void onSuccess(HotWordList hotWordList) {
                if (hotWordList != null) {
                    List<HotWord> result = hotWordList.getHotWordList();
                    LogUtil.d(TAG, "hotWords Size == " + result);
                    for (ISearchCallback iSearchCallback : mCallback) {
                        iSearchCallback.onHotWordLoaded(result);

                    }
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                LogUtil.d(TAG, "errorCode == " + errorCode);
                LogUtil.d(TAG, "errorString == " + errorMsg);

            }
        });
    }

    @Override
    public void getRecommandWord(String keyword) {
        mHimalayaApi.getSuggestWord(keyword, new IDataCallBack<SuggestWords>() {
            @Override
            public void onSuccess(SuggestWords suggestWords) {
                if (suggestWords != null) {
                    List<QueryResult> keyWordList = suggestWords.getKeyWordList();
                    LogUtil.d(TAG, "keywordList Size == " + keyWordList.size());
                    for (ISearchCallback iSearchCallback : mCallback) {
                        iSearchCallback.onRecommandWordLoaded(keyWordList);
                    }
                }
            }

            @Override
            public void onError(int errorCode, String errorString) {
                LogUtil.d(TAG, "errorCode == " + errorCode);
                LogUtil.d(TAG, "errorString == " + errorString);

            }
        });
    }

    @Override
    public void registerViewCallback(ISearchCallback iSearchCallback) {
        if (!mCallback.contains(iSearchCallback)) {
            mCallback.add(iSearchCallback);
        }
    }

    @Override
    public void unRegisterViewCallback(ISearchCallback iSearchCallback) {
        mCallback.remove(iSearchCallback);
    }
}
