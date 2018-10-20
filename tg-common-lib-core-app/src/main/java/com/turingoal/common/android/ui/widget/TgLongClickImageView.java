package com.turingoal.common.android.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 图片长按
 */
public class TgLongClickImageView extends AppCompatImageView {
    private int startX;
    private int startY;
    private Handler mHandler = new Handler();
    private LongClickListener mListener; // 长按监听
    private static final int CLICK_TIME = 2000;

    public TgLongClickImageView(final Context context) {
        super(context);
    }

    public TgLongClickImageView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
    }

    public TgLongClickImageView(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                startY = (int) event.getY();
                // 长按操作
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mListener != null) {
                            mListener.longClick();
                        }
                    }
                }, CLICK_TIME);
                break;
            case MotionEvent.ACTION_MOVE:
                int lastX = (int) event.getX();
                int lastY = (int) event.getY();
                if (Math.abs(lastX - startX) > 20 || Math.abs(lastY - startY) > 20) {
                    mHandler.removeCallbacksAndMessages(null);
                }
                break;
            case MotionEvent.ACTION_UP:
                mHandler.removeCallbacksAndMessages(null);
                break;
            default:
                break;
        }
        return true;
    }


    public void setClickListenere(final LongClickListener longClickistener) {
        mListener = longClickistener;
    }

    /**
     * 长按Listener
     */
    public interface LongClickListener {
        /**
         * 长按
         */
        void longClick();
    }
}
