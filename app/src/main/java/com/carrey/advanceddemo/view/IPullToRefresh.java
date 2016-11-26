package com.carrey.advanceddemo.view;

import android.view.View;

/**
 * class:  IPullToRefresh
 * auth:  carrey
 * date: 16-11-25.
 * desc:
 */

public interface IPullToRefresh<T extends View> {

    public void setPullRefreshEnabled(boolean pullRefreshEnabled);

    public void setLoadMoreEnabled(boolean loadMoreEnabled);

    public void setScrollLoadEnabled(boolean scrollLoadEnabled);

    public boolean isPullRefreshEnabled();

    public boolean isLoadMoreEnabled();

    public boolean isScrollLoadEnabled();

    public void setOnFooterRefreshListener(OnHeaderRefreshListener<T> refreshListener);

    public void setOnHeaderRefreshListener(OnFooterRefreshListener<T> refreshListener);

    public void onHeaderRefreshComplete();

    public void onFooterRefreshComplete();

    public T getRefreshableView();

    public LoadingLayout getHeaderLoadingLayout();

    public LoadingLayout getFooterLoadingLayout();

    public void setLastUpdatedLabel(CharSequence label);

    public interface OnHeaderRefreshListener<T extends View> {
        public void onHeaderRefresh(T view);
    }

    public interface OnFooterRefreshListener<T extends View> {
        public void onFooterRefresh(T view);
    }
}
