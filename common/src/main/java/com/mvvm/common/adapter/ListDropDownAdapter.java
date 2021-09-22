package com.mvvm.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.mvvm.common.R;

import java.util.List;

public class ListDropDownAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private int checkItemPosition = 0;

    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }

    public ListDropDownAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_default_drop_down, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        if(position == list.size()-1){
            viewHolder.v.setVisibility(View.GONE);
        }else {
            viewHolder.v.setVisibility(View.VISIBLE);
        }
        fillValue(position, viewHolder);
        return convertView;
    }

    private void fillValue(int position, ViewHolder viewHolder) {
        viewHolder.mText.setText(list.get(position));
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.drop_down_selected));
               // viewHolder.mText.setBackgroundResource(R.color.check_bg);
                viewHolder.mText.setCompoundDrawablesWithIntrinsicBounds(null, null, context.getResources().getDrawable(R.mipmap.yes_check), null);
            } else {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.drop_down_unselected));
               // viewHolder.mText.setBackgroundResource(R.color.white);
                viewHolder.mText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
        }
    }

    static class ViewHolder {
        TextView mText;
        View v ;
        ViewHolder(View view) {
            mText= (TextView) view.findViewById(R.id.text);
            v = (View)view.findViewById(R.id.view_drop_down);
        }
    }
}
