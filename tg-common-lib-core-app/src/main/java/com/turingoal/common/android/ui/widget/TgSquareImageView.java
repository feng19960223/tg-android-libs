package com.turingoal.common.android.ui.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 正方形ImageView
 */
public class TgSquareImageView extends AppCompatImageView {

    public TgSquareImageView(Context context) {
        super(context);
    }

    public TgSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TgSquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
