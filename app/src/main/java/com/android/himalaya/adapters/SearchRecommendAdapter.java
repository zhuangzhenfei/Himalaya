package com.android.himalaya.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.himalaya.R;
import com.ximalaya.ting.android.opensdk.model.word.QueryResult;

import java.util.ArrayList;
import java.util.List;

/**
 * create by shadowman
 * on 2020/4/5
 */
public class SearchRecommendAdapter extends RecyclerView.Adapter<SearchRecommendAdapter.viewHolder> {

    private List<QueryResult> mData = new ArrayList<>();
    private ItemClickListener mItemClickListener = null;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_tecommend, parent, false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TextView text = holder.itemView.findViewById(R.id.search_recommend_item);
        QueryResult queryResult = mData.get(position);
        text.setText(queryResult.getKeyword());
        //设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(queryResult.getKeyword());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 设置数据
     *
     * @param keyWordList
     */
    public void setData(List<QueryResult> keyWordList) {
        mData.clear();
        mData.addAll(keyWordList);
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setItemClickListener(ItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public interface ItemClickListener{
        void onItemClick(String keyword);
    }
}
