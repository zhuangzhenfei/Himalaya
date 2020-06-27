package com.android.himalaya.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.himalaya.R;

/**
 * create by shadowman
 * on 2020/6/23
 */
public class ConfirmCheckBoxDialog extends Dialog {

    private View mCancel;
    private View mConfirm;
    private OnDialogActionClickListener mClickListener = null;
    private CheckBox mCheckBox;

    public ConfirmCheckBoxDialog(@NonNull Context context) {
        this(context, 0);
    }

    public ConfirmCheckBoxDialog(@NonNull Context context, int themeResId) {
        this(context, true, null);
    }

    protected ConfirmCheckBoxDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_check_box_confirm);
        initView();
        initListener();
    }

    private void initListener() {
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onCancelClick();
                    dismiss();
                }
            }
        });
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    boolean checked = mCheckBox.isChecked();
                    mClickListener.onConfimrClick(checked);
                    dismiss();
                }
            }
        });
    }

    private void initView() {
        mCancel = findViewById(R.id.dialog_check_box_cancel);
        mConfirm = findViewById(R.id.dialog_check_box_confirm);
        mCheckBox = this.findViewById(R.id.dialog_check_box);
    }

    public void setOnDialogActionClickListener(OnDialogActionClickListener listener){
        this.mClickListener = listener;
    }

    public interface OnDialogActionClickListener{
        void onCancelClick();

        void onConfimrClick(boolean isCheck);
    }

}
