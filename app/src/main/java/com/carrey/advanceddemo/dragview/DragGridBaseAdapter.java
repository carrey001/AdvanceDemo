package com.carrey.advanceddemo.dragview;

/**
 * Created by caipengcheng on 2015/1/4.
 */
public interface DragGridBaseAdapter {
    /**
     * 重新排列数据
     * @param oldPosition
     * @param newPosition
     */
    public void reorderItems(int oldPosition, int newPosition);


    /**
     * 设置某个item隐藏
     * @param hidePosition
     */
    public void setHideItem(int hidePosition);
    /** 显示所有删除图标*/
    public void showDelIcon();
    /** 隐藏所有的删除图标*/
    public void hidDelIcon();



}

