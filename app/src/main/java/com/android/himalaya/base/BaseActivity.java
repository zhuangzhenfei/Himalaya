package com.android.himalaya.base;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.android.himalaya.R;

public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
