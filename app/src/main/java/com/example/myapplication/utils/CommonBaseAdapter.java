package com.example.myapplication.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class CommonBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> dataList;
    protected int itemViewId;

    public CommonBaseAdapter(Context context, List<T> dataList, int itemViewId) {
        this.dataList = dataList;
        this.context = context;
        this.itemViewId = itemViewId;
    }


    public void addALl(List<T> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public T getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(context, convertView, parent, itemViewId);
        bindView(viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void bindView(ViewHolder viewHolder, T t);

    //添加一个元素
    public void add(T data) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        dataList.add(data);
        notifyDataSetChanged();
    }

    //往特定位置，添加一个元素
    public void add(int position, T data) {
        if (dataList == null) {
            dataList = new LinkedList<>();
        }
        dataList.add(position, data);
        notifyDataSetChanged();
    }

    public void remove(T data) {
        if (dataList != null) {
            dataList.remove(data);
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (dataList != null) {
            dataList.remove(position);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (dataList != null) {
            dataList.clear();
        }
        notifyDataSetChanged();
    }


}
