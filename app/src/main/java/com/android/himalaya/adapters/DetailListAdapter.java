package com.android.himalaya.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.himalaya.R;
import com.ximalaya.ting.android.opensdk.model.track.Track;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * create by chameleon
 * on 2020/1/21 0021
 */
public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.ViewHolder> {
    private List<Track> mDataList = new ArrayList<>();
    //设置时间格式
    private SimpleDateFormat mUpdateDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat mDurationFormat = new SimpleDateFormat("mm:ss");
    private ItemClickListener mItemCLickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_detail, parent, false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        View itemView = holder.itemView;
        TextView orderTv = itemView.findViewById(R.id.order_text);
        TextView titleTv = itemView.findViewById(R.id.detail_item_title);
        TextView playCountTv = itemView.findViewById(R.id.detail_item_play_count);
        TextView durationTv = itemView.findViewById(R.id.detail_item_duration);
        TextView updateDateTv = itemView.findViewById(R.id.detail_item_update_time);

        Track track = mDataList.get(position);
        orderTv.setText((position + 1) + "");
        titleTv.setText(track.getTrackTitle());
        playCountTv.setText(track.getPlayCount() + "");
        int durationMill = track.getDuration() * 1000;
        String duration = mDurationFormat.format(durationMill);
        durationTv.setText(duration);
        String updateTimeText = mUpdateDateFormat.format(track.getUpdatedAt());
        updateDateTv.setText(updateTimeText);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(v.getContext(), "you click" + position + "item", Toast.LENGTH_SHORT).show();
                if (mItemCLickListener != null) {
                    mItemCLickListener.onItemCLick(mDataList, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setData(List<Track> traces) {
        mDataList.clear();
        mDataList.addAll(traces);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setItemClickListener(ItemClickListener listener) {
        this.mItemCLickListener = listener;
    }

    public interface ItemClickListener {
        void onItemCLick(List<Track> dataList, int position);
    }
}
