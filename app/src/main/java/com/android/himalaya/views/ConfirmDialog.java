package com.android.himalaya.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.himalaya.R;

/**
 * create by shadowman
 * on 2020/6/23
 */
public class ConfirmDialog extends Dialog {

    private View mCancleSub;
    private View mGiveUp;
    private OnDialogActionClickListener mClickListener = null;

    public ConfirmDialog(@NonNull Context context) {
        this(context, 0);
    }

    public ConfirmDialog(@NonNull Context context, int themeResId) {
        this(context, true, null);
    }

    protected ConfirmDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirm);
        initView();
        initListener();
    }

    private void initListener() {
        mCancleSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onCancelClick();
                    dismiss();
                }
            }
        });
        mGiveUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onConfimClick();
                    dismiss();
                }
            }
        });
    }

    private void initView() {
        mCancleSub = findViewById(R.id.dialog_check_box_cancel);
        mGiveUp = findViewById(R.id.dialog_check_box_confirm);
    }

    public void setOnDialogActionClickListener(OnDialogActionClickListener listener){
        this.mClickListener = listener;
    }

    public interface OnDialogActionClickListener{
        void onCancelClick();

        void onConfimClick();
    }

}
