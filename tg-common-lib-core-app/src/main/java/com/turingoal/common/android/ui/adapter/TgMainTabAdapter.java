package com.turingoal.common.android.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * 如果ViewPager里面显示的是Fragment，则适配器用FragmentPagerAdapter会比较简单
 */
public class TgMainTabAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList;
    private static int[] icons;

    public TgMainTabAdapter(final FragmentManager fm, final ArrayList<Fragment> list, final int[] iconsParm) {
        super(fm);
        fragmentList = list;
        icons = iconsParm;
    }

    @Override
    public Fragment getItem(final int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * 自定义方法，提供自定义Tab
     *
     * @param position 位置
     * @return 返回Tab的View
     */
    public View getTabView(final int position, final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tg_common_item_main_tab, null);
        //TextView textView = (TextView) v.findViewById(R.id.tv_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        //textView.setText(titles[position]);
        imageView.setImageResource(icons[position]); // 添加一行，设置颜色
        return view;
    }
}
