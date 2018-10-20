package com.turingoal.common.android.util.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.turingoal.android.photopicker.manager.GlideApp;

import java.security.MessageDigest;

import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * Glide工具类
 */

public class TgGlideUtil {
    /**
     * 普通加载
     */
    public static void load(final Context context, final String url, final ImageView imageView) {
        load(context, url, imageView, R.drawable.tg_common_ic_iv_vector);
    }

    /**
     * 普通加载,url resid
     */
    public static void load(final Context context, final String url, final ImageView imageView, int resId) {
        GlideApp.with(context)
                .load(url)
                .centerCrop()
                .error(resId) // 错误图片
                .fallback(resId) // 座位图
                .placeholder(resId) // url空图
                .into(imageView);
    }

    /**
     * 普通加载,bitmap
     */
    public static void load(final Context context, final Bitmap bitmap, final ImageView imageView) {
        GlideApp.with(context)
                .load(bitmap)
                .centerCrop()
                .error(R.drawable.tg_common_ic_iv_vector) // 错误图片
                .fallback(R.drawable.tg_common_ic_iv_vector) // 座位图
                .placeholder(R.drawable.tg_common_ic_iv_vector) // url空图
                .into(imageView);
    }

    /**
     * 加载圆型图片
     */
    public static void loadCircle(final Context context, final String url, final ImageView imageView) {
        GlideApp.with(context)
                .load(url)
                .circleCrop() // 圆
                .error(R.drawable.tg_common_ic_iv_default) // 错误图片
                .fallback(R.drawable.tg_common_ic_iv_default) // 座位图
                .placeholder(R.drawable.tg_common_ic_iv_default) // url空图
                .into(imageView);
    }

    /**
     * 普通加载
     */
    public static void loadInside(final Context context, final String url, final ImageView imageView) {
        loadInside(context, url, imageView, R.drawable.tg_common_ic_iv_vector);
    }

    /**
     * 普通加载,url resId
     */
    public static void loadInside(final Context context, final String url, final ImageView imageView, int resId) {
        GlideApp.with(context)
                .load(url)
                .centerInside()
                .error(resId) // 错误图片
                .fallback(resId) // 座位图
                .placeholder(resId) // url空图
                .into(imageView);
    }

    /**
     * 高斯模糊普通加载
     */
    public static void loadBlur(final Context context, final String url, final ImageView imageView) {
        GlideApp.with(context)
                .load(url)
                .centerCrop()
                .error(R.drawable.tg_common_ic_iv_default) // 错误图片
                .fallback(R.drawable.tg_common_ic_iv_default) // 座位图
                .placeholder(R.drawable.tg_common_ic_iv_default) // url空图
                .apply(RequestOptions.bitmapTransform(new GlideBlurformation(context))) // 圆形高斯模糊
                .into(imageView);
    }

    public static void loadBanner(final Context context, final Object object, final ImageView imageView) {
        GlideApp.with(context).load(object).into(imageView);
    }
}

/**
 * 高斯模糊
 */
class GlideBlurformation extends BitmapTransformation {
    private Context context;

    public GlideBlurformation(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmap = TgBlurBitmapUtil.instance().blurBitmap(context, toTransform, 25, outWidth, outHeight); // 高斯模糊
        return bitmap;
        // return ImageUtils.toRound(bitmap); // 转为圆形,如果是高斯模糊加圆形，必须要在这里转圆形，在Glide转，没用
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
