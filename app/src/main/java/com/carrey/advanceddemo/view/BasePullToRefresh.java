package com.carrey.advanceddemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * class:  BasePullToRefresh
 * auth:  carrey
 * date: 16-11-25.
 * desc:
 */

public abstract class BasePullToRefresh<T extends View> extends LinearLayout implements IPullToRefresh {

    //refresh states
    private static final int PULL_TO_REFRESH = 2;
    private static final int RELEASE_TO_REFRESH = 3;
    private static final int REFRESHING = 4;
    //pull status
    private static final int PULL_UP_STATE = 0;// 向上
    private static final int PULL_DOWN_STATE = 1;//向下


    private OnHeaderRefreshListener mHeaderRefreshListener;
    private OnFooterRefreshListener mFooterRefreshListener;

    private int mLastMotionY;
    private MotionEvent mLastMotionEvent;
    private boolean mRefreshEnable = true;
    private boolean mLoadMoreEnable = true;
    private boolean mRefreshing;

    /**
     * pull state,pull up or pull down;PULL_UP_STATE or PULL_DOWN_STATE
     */
    private int mPullState;
    private int mHeaderState;
    private int mFooterState;


    public BasePullToRefresh(Context context) {
        this(context, null);
    }

    public BasePullToRefresh(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BasePullToRefresh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    int delata;
    private Scroller mScroller;
    private LayoutInflater mInflater;

    private void init() {
        delata = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        mScroller = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
        mInflater = LayoutInflater.from(getContext());
        addHeaderView();
    }

    private void addHeaderView() {


    }


    /**
     * Header
     */
    public void createHeaderLoaddingLayout() {

    }

    /**
     * Footer
     */
    public void createFooterLoaddingLayout() {

    }

    /**
     * 创建可以刷新的View
     *
     * @param context context
     * @param attrs   属性
     * @return View
     */
    protected abstract T createRefreshableView(Context context, AttributeSet attrs);

    /**
     * 判断刷新的View是否滑动到顶部
     *
     * @return true表示已经滑动到顶部，否则false
     */
    protected abstract boolean isReadyForPullDown();

    /**
     * 判断刷新的View是否滑动到底
     *
     * @return true表示已经滑动到底部，否则false
     */
    protected abstract boolean isReadyForPullUp();

    @Override
    public View getRefreshableView() {
        return null;
    }

    @Override
    public LoadingLayout getFooterLoadingLayout() {
        return null;
    }

    @Override
    public LoadingLayout getHeaderLoadingLayout() {
        return null;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {//计算Y坐标
        int y = (int) ev.getRawY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionY = y;//上一次下拉的距离
                break;
            case MotionEvent.ACTION_MOVE:
                mLastMotionEvent = ev;
                //deltay >0 下拉
                int deltay = y - mLastMotionY;
                if (isRefreshViewScroll(deltay)) {
                    return true;//拦截
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP://// TODO: 16-11-25 离开屏幕

                break;

        }


        return super.onInterceptTouchEvent(ev);
    }

    private boolean mLock;

    @Override
    public boolean onTouchEvent(MotionEvent event) {//处理touch 事件
        if (mLock) {
            return true;
        }
        int y = (int) event.getRawY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN://按下手指

                break;
            case MotionEvent.ACTION_MOVE:
                int deltaY = y - mLastMotionY;
//                if (mRefreshEnable){
//
//                }
//
                mLastMotionY = y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL://放开

                break;
        }
        return super.onTouchEvent(event);
    }


    /**
     * 计算是否正在滑动
     */
    private boolean isRefreshViewScroll(int deltay) {
        //正在加载数据的时候 拦截事件
        if (REFRESHING == mHeaderState || REFRESHING == mFooterState) {
            return true;
        }



        return false;
    }

}
