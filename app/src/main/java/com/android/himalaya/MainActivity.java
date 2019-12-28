package com.android.himalaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.android.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.category.Category;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.magic_indicator3)
    MagicIndicator mMagicIndicator;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试网络，解析目录
//        Map<String, String> map = new HashMap<>();
//        CommonRequest.getCategories(map, new IDataCallBack<CategoryList>() {
//            @Override
//            public void onSuccess(CategoryList categoryList) {
//                List<Category> categories = categoryList.getCategories();
//                if (categories != null) {
//                    int size = categories.size();
//                    LogUtil.d(TAG, "categories size -->" + size);
//                    for (Category category : categories) {
//                        LogUtil.d(TAG, "category -->" + category.getCategoryName());
//                    }
//                }
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                LogUtil.e(TAG, "error code -->" + code + " error msg -->" + message);
//            }
//        });

        initView();

    }

    private void initView() {
        mMagicIndicator.setBackgroundColor(this.getColor(R.color.main_color));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                return null;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
    }
}
