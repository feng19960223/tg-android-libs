package com.turingoal.common.android.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 * 通用ViewHolder
 */
public class TgBaseViewHolder extends com.chad.library.adapter.base.BaseViewHolder {
    public TgBaseViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}