package com.turingoal.common.android.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.turingoal.common.android.ui.fragment.TgPhotoFragment;

import java.util.List;

/**
 * 照片ViewPagerAdapter
 */
public class TgPhotoViewPagerAdapter extends FragmentPagerAdapter {
    private List<TgPhotoFragment> fragments;

    public TgPhotoViewPagerAdapter(final FragmentManager fragmentManager, final List<TgPhotoFragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(final int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
