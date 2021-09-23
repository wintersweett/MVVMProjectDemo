package com.mvvm.common.citypicker.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;



import java.util.List;

import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.common.R;
import com.mvvm.common.citypicker.model.City;
import com.mvvm.common.citypicker.model.HotCity;

/**
 * @Author: Bro0cL
 */
public class GridListAdapter extends RecyclerView.Adapter<GridListAdapter.GridViewHolder>{
    public static final int SPAN_COUNT = 3;

    private Context mContext;
    private List<HotCity> mData;
    private InnerListener mInnerListener;

    public GridListAdapter(Context context, List<HotCity> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cp_grid_item_layout, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        final int pos = holder.getAdapterPosition();
        final City data = mData.get(pos);
        if (data == null) return;
        //设置item宽高
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        TypedValue typedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.cpGridItemSpace, typedValue, true);
        int space = mContext.getResources().getDimensionPixelSize(typedValue.resourceId);
        int padding = mContext.getResources().getDimensionPixelSize(R.dimen.cp_default_padding);
        int indexBarWidth = mContext.getResources().getDimensionPixelSize(R.dimen.cp_index_bar_width);
        int itemWidth = (screenWidth - padding - space * (SPAN_COUNT - 1) - indexBarWidth) / SPAN_COUNT;
        ViewGroup.LayoutParams lp = holder.container.getLayoutParams();
        lp.width = itemWidth;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        holder.container.setLayoutParams(lp);

        holder.name.setText(data.getName());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInnerListener != null){
                    mInnerListener.dismiss(pos, data);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
    @Keep
    public static class GridViewHolder extends RecyclerView.ViewHolder{
        FrameLayout container;
        TextView name;

        public GridViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.cp_grid_item_layout);
            name = itemView.findViewById(R.id.cp_gird_item_name);
        }
    }

    public void setInnerListener(InnerListener listener){
        this.mInnerListener = listener;
    }
}
