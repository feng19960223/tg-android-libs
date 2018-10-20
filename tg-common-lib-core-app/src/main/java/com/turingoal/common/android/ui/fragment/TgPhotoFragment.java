package com.turingoal.common.android.ui.fragment;

import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;
import com.turingoal.common.android.base.TgBaseFragment;
import com.turingoal.common.android.bean.TgPhotoGroupBean;
import com.turingoal.common.android.util.media.TgGlideUtil;

import java.util.ArrayList;
import java.util.List;

import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * 图片查看fragment
 */
public class TgPhotoFragment extends TgBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.tg_common_layout_photo_fragment;
    }

    @Override
    protected void initialized() {
        PhotoView photoView = getRootView().findViewById(R.id.tg_common_layout_photo_photoView);
        TgGlideUtil.loadInside(getContext(), getArguments().getString("tgPhoto"), photoView);
    }

    /**
     * createPhotoFragments
     */
    public static List<TgPhotoFragment> createPhotoFragments(final List<String> photos) {
        List<TgPhotoFragment> fragments = null;
        if (photos != null && photos.size() > 0) {
            fragments = new ArrayList<>();
            for (int i = 0, size = photos.size(); i < size; i++) {
                TgPhotoFragment fragment = new TgPhotoFragment();
                Bundle bundle = new Bundle();
                bundle.putString("tgPhoto", photos.get(i));
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
        }
        return fragments;
    }

    /**
     * createPhotoFragments
     */
    public static List<TgPhotoFragment> createPhotoFragments(TgPhotoGroupBean photoBean) {
        List<String> photos = photoBean.getPhotos(); // 所有图片
        return createPhotoFragments(photos);
    }
}
