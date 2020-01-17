package com.android.himalaya.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.himalaya.R;
import com.bumptech.glide.Glide;
import com.ximalaya.ting.android.opensdk.model.album.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * create by Administrator [chameleon]
 * on 2020/1/3 0003
 */
public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.ViewHolder> {

    private List<Album> mData = new ArrayList<>();
    private OnRecommendItemClick mOnRecommendItemClick;

    @NonNull
    @Override
    public RecommendListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //载入view
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendListAdapter.ViewHolder holder, int position) {
        //设置数据
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRecommendItemClick != null) {
                    int clickPosition = (int) v.getTag();
                    mOnRecommendItemClick.onItemClick(clickPosition, mData.get(clickPosition));
                }
            }
        });
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null){
            return mData.size();
        }
        return 0;
    }

    public void setData(List<Album> albumList) {
        if (mData != null){
            mData.clear();
            mData.addAll(albumList);
        }
        //每次数据改变都会更新UI
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(Album album) {
            //找到各个控件，设置数据
            ImageView albumCoverIv = itemView.findViewById(R.id.album_cover);
            TextView albumDescritionTv = itemView.findViewById(R.id.album_description);
            TextView albumTitleTv = itemView.findViewById(R.id.album_title);
            TextView albumPlayCountTv = itemView.findViewById(R.id.album_play_count);
            TextView albumContentTv = itemView.findViewById(R.id.album_content_size);

            albumTitleTv.setText(album.getAlbumTitle());
            albumDescritionTv.setText(album.getAlbumIntro());
            albumPlayCountTv.setText(album.getPlayCount() + "");
            albumContentTv.setText(album.getIncludeTrackCount() + "");

            Glide.with(itemView.getContext()).load(album.getCoverUrlLarge()).into(albumCoverIv);
        }
    }

    public void setOnRecommendItemClick(OnRecommendItemClick onRecommendItemClick){
        mOnRecommendItemClick = onRecommendItemClick;
    }

    public interface OnRecommendItemClick{
        void onItemClick(int position, Album album);
    }
}
