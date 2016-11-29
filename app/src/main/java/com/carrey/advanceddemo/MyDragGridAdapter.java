package com.carrey.advanceddemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.carrey.advanceddemo.dragview.DragGridBaseAdapter;

import java.util.Collections;
import java.util.List;

/**
 * class:  MyDragGridAdapter
 * auth:  carrey
 * date: 16-11-28.
 * desc:
 */

public class MyDragGridAdapter extends BaseAdapter implements DragGridBaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private int mHidePosition = -1;
    private List<String> names;

    public MyDragGridAdapter(Context context, List<String> names) {
        mContext = context;
        this.names = names;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv_name;
        convertView = mInflater.inflate(R.layout.item_dragview, parent, false);
        tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        tv_name.setText(names.get(position));
        if (position == mHidePosition) {
            convertView.setVisibility(View.GONE);
        } else {
            convertView.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    @Override
    public void reorderItems(int oldPosition, int newPosition) {
        String temp = names.get(oldPosition);
        if (oldPosition < newPosition) {
            for (int i = oldPosition; i < newPosition; i++) {
                Collections.swap(names, i, i + 1);
            }
        } else if (oldPosition > newPosition) {
            for (int i = oldPosition; i > newPosition; i--) {
                Collections.swap(names, i, i - 1);
            }
        }

        names.set(newPosition, temp);

    }

    @Override
    public void setHideItem(int hidePosition) {
        this.mHidePosition = hidePosition;
        notifyDataSetChanged();
    }

    @Override
    public void showDelIcon() {

    }

    @Override
    public void hidDelIcon() {

    }
}
