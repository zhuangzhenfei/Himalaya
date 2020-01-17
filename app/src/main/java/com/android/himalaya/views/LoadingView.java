package com.android.himalaya.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.android.himalaya.R;

/**
 * create by chameleon
 * on 2020/1/8 0008
 */
public class LoadingView extends ImageView {

    //旋转角度
    private int mRotateDegree = 0;
    private boolean mNeedRotate = true;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //设置图标
        setImageResource(R.drawable.loading);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mNeedRotate = true;
        //绑定到window时
        post(new Runnable() {
            @Override
            public void run() {
                mRotateDegree += 30;
                mRotateDegree = mRotateDegree <= 360 ? mRotateDegree : mRotateDegree-360;
                invalidate();//调用onDraw
                //是否需要旋转
                if (mNeedRotate) {
                    postDelayed(this, 100);
                }

            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        //从window上解绑
        mNeedRotate = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 第一个参数旋转角度
         * 第二个参数旋转x坐标
         * 第三个参数旋转y坐标
         */
        canvas.rotate(mRotateDegree, getHeight()/2, getWidth()/2);
        super.onDraw(canvas);
    }
}
