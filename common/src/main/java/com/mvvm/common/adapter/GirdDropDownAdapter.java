package com.mvvm.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.mvvm.base.utils.UtilsLog;
import com.mvvm.common.R;

import java.util.List;

/**
* @author :WinterSweett
 * @description
 * 列表中文字颜色 与对勾选中状态
 *
*/
public class GirdDropDownAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private int checkItemPosition = 0;

    public void setCheckItem(int position) {
        checkItemPosition = position;
        UtilsLog.d("ws","adapter setCheckItem fillvalue");
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        UtilsLog.d("ws","notifyDatasetChanged:");
    }

    public GirdDropDownAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        UtilsLog.d("ws","getCount:"+list.size());
        return list.size();
    }

    @Override
    public String getItem(int position) {
        UtilsLog.d("ws","联动：GridDropDownAdapter:position:"+position);
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        UtilsLog.d("ws","getItemId:"+position);
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UtilsLog.d("ws","getView:"+position);
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_drop_down, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        if(position == list.size()-1){
            viewHolder.v.setVisibility(View.GONE);
        }else{
            viewHolder.v.setVisibility(View.VISIBLE);
        }
        UtilsLog.d("ws","adapter getView fillvalue");
        fillValue(position, viewHolder);
        return convertView;
    }

    private void fillValue(int position, ViewHolder viewHolder) {
        viewHolder.mText.setText(list.get(position));
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.drop_down_selected));
                viewHolder.mText.setCompoundDrawablesWithIntrinsicBounds(null, null, context.getResources().getDrawable(R.mipmap.yes_check), null);
            } else {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.drop_down_unselected));
                viewHolder.mText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
        }
    }

    static class ViewHolder {
        TextView mText;
        View v;
        ViewHolder(View view) {
            mText= (TextView) view.findViewById(R.id.text);
            v = (View)view.findViewById(R.id.v_price);
        }
    }
}
