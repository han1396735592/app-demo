package com.example.myapplication.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewHolder {
    private SparseArray<View> itemMap;   //存储ListView 的 item中的View
    private View convertView;                  //存放convertView
    private Context context;            //Context上下文

    //构造方法，完成相关初始化
    private ViewHolder(Context context, ViewGroup parent, int layoutRes) {
        itemMap = new SparseArray<View>();
        this.context = context;
        convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
        convertView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context, View convertView, ViewGroup parent, int layoutRes) {
        ViewHolder viewHolder = null;
        if (convertView != null) {
            viewHolder = ((ViewHolder) convertView.getTag());
        } else {
            viewHolder = new ViewHolder(context, parent, layoutRes);
        }
        return viewHolder;
    }


    public View getConvertView() {
        return convertView;
    }

    public View getView(int id) {
        View view = itemMap.get(id);
        if (view == null) {
            view = convertView.findViewById(id);
            itemMap.put(id,view);
        }
        return view;
    }
}
