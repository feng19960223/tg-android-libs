package com.turingoal.common.android.ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import libs.android.turingoal.com.tg_common_lib_core_app.R;


/**
 * 设置title和context的LinearLayout
 */
public class TgTitleContextLinearLayout extends LinearLayout {
    private TextView tvItemTitle;
    private TextView tvItemContext;

    public TgTitleContextLinearLayout(Context context) {
        this(context, null, 0);
    }

    public TgTitleContextLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TgTitleContextLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.tg_common_item_detail_view, this);
        tvItemTitle = findViewById(R.id.tg_common_item_detail_view_tvItemTitle);
        tvItemContext = findViewById(R.id.tg_common_item_detail_view_tvItemContext);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TgTitleContextLinearLayout);
        tvItemTitle.setText(typedArray.getString(R.styleable.TgTitleContextLinearLayout_titleTextStr));
        tvItemContext.setText(typedArray.getString(R.styleable.TgTitleContextLinearLayout_contextTextStr));
        typedArray.recycle();
    }

    public TextView setTitleTextColor(int color) {
        tvItemTitle.setTextColor(color);
        return tvItemTitle;
    }

    public TextView setContextTextColor(int color) {
        tvItemContext.setTextColor(color);
        return tvItemContext;
    }

    public TextView setTitleStr(String title) {
        tvItemTitle.setText(title);
        return tvItemTitle;
    }

    public TextView setContextStr(String context) {
        tvItemContext.setText(context);
        return tvItemContext;
    }

    public TextView setTitleStr(@StringRes int title) {
        tvItemTitle.setText(title);
        return tvItemTitle;
    }

    public TextView setContextStr(@StringRes int context) {
        tvItemContext.setText(context);
        return tvItemContext;
    }

    public void setTitleAndContext(String title, String context) {
        tvItemTitle.setText(title);
        tvItemContext.setText(context);
    }

    public void setTitleAndContext(@StringRes int title, String context) {
        tvItemTitle.setText(title);
        tvItemContext.setText(context);
    }

    public void setTitleAndContext(@StringRes int title, @StringRes int context) {
        tvItemTitle.setText(title);
        tvItemContext.setText(context);
    }
}
