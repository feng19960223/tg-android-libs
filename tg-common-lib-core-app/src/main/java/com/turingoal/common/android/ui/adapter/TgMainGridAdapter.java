package com.turingoal.common.android.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.turingoal.common.android.base.TgBaseViewHolder;
import com.turingoal.common.android.bean.TgGridItem;

import java.util.List;

import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * 九宫格适配器
 */
public class TgMainGridAdapter extends BaseQuickAdapter<TgGridItem, TgBaseViewHolder> {
    public TgMainGridAdapter(final List<TgGridItem> data) {
        super(R.layout.tg_common_item_main_grid, data);
    }

    @Override
    protected void convert(final TgBaseViewHolder holder, final TgGridItem item) {
        holder.setText(R.id.tg_common_item_main_grid_ivImagetvTitle, item.getTitle()); // title
        ((ImageView) holder.getView(R.id.tg_common_item_main_grid_ivImage)).setImageResource(item.getImageId());
    }
}
