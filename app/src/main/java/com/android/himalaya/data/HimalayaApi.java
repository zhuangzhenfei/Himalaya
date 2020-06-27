package com.android.himalaya.data;

import com.android.himalaya.utils.Constants;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.ximalaya.ting.android.opensdk.model.word.HotWordList;
import com.ximalaya.ting.android.opensdk.model.word.SuggestWords;

import java.util.HashMap;
import java.util.Map;

/**
 * create by shadowman
 * on 2020/3/3
 */
public class HimalayaApi {

    private HimalayaApi() {
    }

    private static HimalayaApi sHimalayaApi;

    public static HimalayaApi getHimalayaApi() {
        if (sHimalayaApi == null) {
            synchronized (HimalayaApi.class) {
                if (sHimalayaApi == null) {
                    sHimalayaApi = new HimalayaApi();
                }
            }
        }
        return sHimalayaApi;
    }

    /**
     * 获取推荐内容
     *
     * @param callBack 请求结果的回调接口
     */
    public void getRecommandList(IDataCallBack<GussLikeAlbumList> callBack) {
        Map<String, String> map = new HashMap<>();
        //这个参数表示一页数据返回多少条
        map.put(DTransferConstants.LIKE_COUNT, Constants.COUNT_RECOMMEND + "");
        CommonRequest.getGuessLikeAlbum(map, callBack);
    }

    /**
     * 根据专辑的id获取到专辑内容
     *
     * @param callBack  获取专辑详情的回调接口
     * @param albumId   专辑的id
     * @param pageIndex 页码
     */
    public void getAlbumDetail(long albumId, int pageIndex, IDataCallBack<TrackList> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put(DTransferConstants.ALBUM_ID, albumId + "");
        map.put(DTransferConstants.SORT, "asc");
        map.put(DTransferConstants.PAGE, pageIndex + "");
        map.put(DTransferConstants.PAGE_SIZE, Constants.COUNT_DEAFAULT + "");
        CommonRequest.getTracks(map, callBack);
    }

    /**
     * 根据关键字进行搜索
     *
     * @param keyword  关键字
     * @param page     页码
     * @param callBack 回调
     */
    public void setchByKeyword(String keyword, int page, IDataCallBack<SearchAlbumList> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put(DTransferConstants.SEARCH_KEY, keyword);
        map.put(DTransferConstants.PAGE, page + "");
        map.put(DTransferConstants.PAGE_SIZE, Constants.COUNT_DEAFAULT + "");
        CommonRequest.getSearchedAlbums(map, callBack);
    }

    /**
     * 获取推荐的热词
     *
     * @param callBack
     */
    public void getHotWords(IDataCallBack<HotWordList> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put(DTransferConstants.TOP, Constants.COUNT_HOT_WORD + "");
        CommonRequest.getHotWords(map, callBack);
    }

    /**
     * 根据关键字获取联想词
     *
     * @param keyword  关键字
     * @param callBack 回调
     */
    public void getSuggestWord(String keyword, IDataCallBack<SuggestWords> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put(DTransferConstants.SEARCH_KEY, keyword);
        CommonRequest.getSuggestWord(map, callBack);
    }
}
