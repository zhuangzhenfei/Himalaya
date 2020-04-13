package com.android.himalaya.base;

/**
 * create by shadowman
 * on 2020/2/6
 */
public interface IBasePresenter<T> {

    /**
     * 注册接口
     * @param t
     */
    void registerViewCallback(T t);

    /**
     * 取消注册接口
     * @param t
     */
    void unRegisterViewCallback(T t);

}
