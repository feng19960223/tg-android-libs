package com.turingoal.common.android.util.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.InputStream;

/**
 * 图片工具类
 */
public class TgImageUtil {
    private TgImageUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * bitmap2Bytes
     */
    public static byte[] bitmap2Bytes(final Bitmap bitmap, final Bitmap.CompressFormat format) {
        return ImageUtils.bitmap2Bytes(bitmap, format);
    }

    /**
     * bytes2Bitmap
     */
    public static Bitmap bytes2Bitmap(final byte[] bytes) {
        return ImageUtils.bytes2Bitmap(bytes);
    }

    /**
     * drawable2Bitmap
     */
    public static Bitmap drawable2Bitmap(final Drawable drawable) {
        return ImageUtils.drawable2Bitmap(drawable);
    }

    /**
     * bitmap2Drawable
     */
    public static Drawable bitmap2Drawable(final Bitmap bitmap) {
        return ImageUtils.bitmap2Drawable(bitmap);
    }

    /**
     * drawable2Bytes
     */
    public static byte[] drawable2Bytes(final Drawable drawable, final Bitmap.CompressFormat format) {
        return ImageUtils.drawable2Bytes(drawable, format);
    }

    /**
     * bytes2Drawable
     */
    public static Drawable bytes2Drawable(final byte[] bytes) {
        return ImageUtils.bytes2Drawable(bytes);
    }

    /**
     * view 转 bitmap
     */
    public static Bitmap view2Bitmap(final View view) {
        return ImageUtils.view2Bitmap(view);
    }

    /**
     * 获取 bitmap
     */
    public static Bitmap getBitmap(final File file) {
        return ImageUtils.getBitmap(file);
    }

    /**
     * 获取 bitmap
     *
     * @param file      The file.
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     */
    public static Bitmap getBitmap(final File file, final int maxWidth, final int maxHeight) {
        return ImageUtils.getBitmap(file, maxWidth, maxHeight);
    }

    /**
     * 获取 bitmap
     */
    public static Bitmap getBitmap(final String filePath) {
        return ImageUtils.getBitmap(filePath);
    }

    /**
     * 获取 bitmap
     *
     * @param filePath  The path of file.
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     */
    public static Bitmap getBitmap(final String filePath, final int maxWidth, final int maxHeight) {
        return ImageUtils.getBitmap(filePath, maxWidth, maxHeight);
    }

    /**
     * 获取 bitmap
     */
    public static Bitmap getBitmap(final InputStream is) {
        return ImageUtils.getBitmap(is);
    }

    /**
     * 获取 bitmap
     *
     * @param is        The input stream.
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     */
    public static Bitmap getBitmap(final InputStream is, final int maxWidth, final int maxHeight) {
        return ImageUtils.getBitmap(is, maxWidth, maxHeight);
    }

    /**
     * 获取 bitmap
     *
     * @param data   The data.
     * @param offset The offset.
     */
    public static Bitmap getBitmap(final byte[] data, final int offset) {
        return ImageUtils.getBitmap(data, offset);
    }

    /**
     * 获取 bitmap
     *
     * @param data      The data.
     * @param offset    The offset.
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     */
    public static Bitmap getBitmap(final byte[] data, final int offset, final int maxWidth, final int maxHeight) {
        return ImageUtils.getBitmap(data, offset, maxWidth, maxHeight);
    }

    /**
     * 获取 bitmap
     */
    public static Bitmap getBitmap(@DrawableRes final int resId) {
        return ImageUtils.getBitmap(resId);
    }

    /**
     * 获取 bitmap
     *
     * @param resId     The resource id.
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     */
    public static Bitmap getBitmap(@DrawableRes final int resId, final int maxWidth, final int maxHeight) {
        return ImageUtils.getBitmap(resId, maxWidth, maxHeight);
    }

    /**
     * 获取 bitmap
     */
    public static Bitmap getBitmap(final FileDescriptor fd) {
        return ImageUtils.getBitmap(fd);
    }

    /**
     * 获取 bitmap
     *
     * @param fd        The file descriptor
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     */
    public static Bitmap getBitmap(final FileDescriptor fd, final int maxWidth, final int maxHeight) {
        return ImageUtils.getBitmap(fd, maxWidth, maxHeight);
    }

    /**
     * RdrawColor
     *
     * @param color The color.
     */
    public static Bitmap drawColor(@NonNull final Bitmap src, @ColorInt final int color) {
        return ImageUtils.drawColor(src, color);
    }

    /**
     * drawColor.
     *
     * @param color   The color.
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap drawColor(@NonNull final Bitmap src, @ColorInt final int color, final boolean recycle) {
        return ImageUtils.drawColor(src, color, recycle);
    }

    /**
     * 缩放图片
     *
     * @param newWidth  The new width.
     * @param newHeight The new height.
     */
    public static Bitmap scale(final Bitmap src, final int newWidth, final int newHeight) {
        return ImageUtils.scale(src, newWidth, newHeight);
    }

    /**
     * 缩放图片
     *
     * @param newWidth  The new width.
     * @param newHeight The new height.
     * @param recycle   True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap scale(final Bitmap src, final int newWidth, final int newHeight, final boolean recycle) {
        return ImageUtils.scale(src, newWidth, newHeight, recycle);
    }

    /**
     * 缩放图片
     *
     * @param scaleWidth  The scale of width.
     * @param scaleHeight The scale of height.
     */
    public static Bitmap scale(final Bitmap src, final float scaleWidth, final float scaleHeight) {
        return ImageUtils.scale(src, scaleWidth, scaleHeight);
    }

    /**
     * 缩放图片
     *
     * @param scaleWidth  The scale of width.
     * @param scaleHeight The scale of height.
     * @param recycle     True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap scale(final Bitmap src, final float scaleWidth, final float scaleHeight, final boolean recycle) {
        return ImageUtils.scale(src, scaleWidth, scaleHeight, recycle);
    }

    /**
     * 裁剪图片
     *
     * @param x      The x coordinate of the first pixel.
     * @param y      The y coordinate of the first pixel.
     * @param width  The width.
     * @param height The height.
     */
    public static Bitmap clip(final Bitmap src, final int x, final int y, final int width, final int height) {
        return ImageUtils.clip(src, x, y, width, height);
    }

    /**
     * 裁剪图片
     *
     * @param x       The x coordinate of the first pixel.
     * @param y       The y coordinate of the first pixel.
     * @param width   The width.
     * @param height  The height.
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap clip(final Bitmap src, final int x, final int y, final int width, final int height, final boolean recycle) {
        return ImageUtils.clip(src, x, y, width, height, recycle);
    }

    /**
     * 倾斜图片
     *
     * @param kx The skew factor of x.
     * @param ky The skew factor of y.
     */
    public static Bitmap skew(final Bitmap src, final float kx, final float ky) {
        return ImageUtils.skew(src, kx, ky);
    }

    /**
     * 倾斜图片
     *
     * @param kx      The skew factor of x.
     * @param ky      The skew factor of y.
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap skew(final Bitmap src, final float kx, final float ky, final boolean recycle) {
        return ImageUtils.skew(src, kx, ky, recycle);
    }

    /**
     * 倾斜图片
     *
     * @param kx The skew factor of x.
     * @param ky The skew factor of y.
     * @param px The x coordinate of the pivot point.
     * @param py The y coordinate of the pivot point.
     */
    public static Bitmap skew(final Bitmap src, final float kx, final float ky, final float px, final float py) {
        return ImageUtils.skew(src, kx, ky, px, py);
    }

    /**
     * 倾斜图片
     *
     * @param kx      The skew factor of x.
     * @param ky      The skew factor of y.
     * @param px      The x coordinate of the pivot point.
     * @param py      The y coordinate of the pivot point.
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap skew(final Bitmap src, final float kx, final float ky, final float px, final float py, final boolean recycle) {
        return ImageUtils.skew(src, kx, ky, px, py, recycle);
    }

    /**
     * 旋转图片.
     *
     * @param degrees The number of degrees.
     * @param px      The x coordinate of the pivot point.
     * @param py      The y coordinate of the pivot point.
     */
    public static Bitmap rotate(final Bitmap src, final int degrees, final float px, final float py) {
        return ImageUtils.rotate(src, degrees, px, py);
    }

    /**
     * 旋转图片
     *
     * @param degrees The number of degrees.
     * @param px      The x coordinate of the pivot point.
     * @param py      The y coordinate of the pivot point.
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap rotate(final Bitmap src, final int degrees, final float px, final float py, final boolean recycle) {
        return ImageUtils.rotate(src, degrees, px, py, recycle);
    }

    /**
     * 获取图片旋转角度
     */
    public static int getRotateDegree(final String filePath) {
        return ImageUtils.getRotateDegree(filePath);
    }

    /**
     * 转为圆形图片
     */
    public static Bitmap toRound(final Bitmap src) {
        return ImageUtils.toRound(src);
    }

    /**
     * 转为圆形图片
     *
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap toRound(final Bitmap src, final boolean recycle) {
        return ImageUtils.toRound(src, recycle);
    }

    /**
     * 转为圆形图片
     *
     * @param borderSize  The size of border.
     * @param borderColor The color of border.
     */
    public static Bitmap toRound(final Bitmap src, @IntRange(from = 0) int borderSize, @ColorInt int borderColor) {
        return ImageUtils.toRound(src, borderSize, borderColor);
    }

    /**
     * 转为圆形图片
     *
     * @param recycle     True to recycle the source of bitmap, false otherwise.
     * @param borderSize  The size of border.
     * @param borderColor The color of border.
     */
    public static Bitmap toRound(final Bitmap src, @IntRange(from = 0) int borderSize, @ColorInt int borderColor, final boolean recycle) {
        return ImageUtils.toRound(src, borderSize, borderColor, recycle);
    }

    /**
     * 转为圆角图片
     *
     * @param radius The radius of corner.
     */
    public static Bitmap toRoundCorner(final Bitmap src, final float radius) {
        return ImageUtils.toRoundCorner(src, radius);
    }

    /**
     * 转为圆角图片.
     *
     * @param radius  The radius of corner.
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap toRoundCorner(final Bitmap src, final float radius, final boolean recycle) {
        return ImageUtils.toRoundCorner(src, radius, recycle);
    }

    /**
     * 转为圆角图片
     *
     * @param radius      The radius of corner.
     * @param borderSize  The size of border.
     * @param borderColor The color of border.
     */
    public static Bitmap toRoundCorner(final Bitmap src, final float radius, @IntRange(from = 0) int borderSize, @ColorInt int borderColor) {
        return ImageUtils.toRoundCorner(src, radius, borderSize, borderColor);
    }

    /**
     * 转为圆角图片
     *
     * @param radius      The radius of corner.
     * @param borderSize  The size of border.
     * @param borderColor The color of border.
     * @param recycle     True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap toRoundCorner(final Bitmap src, final float radius, @IntRange(from = 0) int borderSize, @ColorInt int borderColor, final boolean recycle) {
        return ImageUtils.toRoundCorner(src, radius, borderSize, borderColor, recycle);
    }

    /**
     * 添加圆角边框
     *
     * @param borderSize   The size of border.
     * @param color        The color of border.
     * @param cornerRadius The radius of corner.
     */
    public static Bitmap addCornerBorder(final Bitmap src, @IntRange(from = 1) final int borderSize, @ColorInt final int color, @FloatRange(from = 0) final float cornerRadius) {
        return ImageUtils.addCornerBorder(src, borderSize, color, cornerRadius);
    }

    /**
     * 添加圆角边框
     *
     * @param borderSize   The size of border.
     * @param color        The color of border.
     * @param cornerRadius The radius of corner.
     * @param recycle      True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap addCornerBorder(final Bitmap src, @IntRange(from = 1) final int borderSize, @ColorInt final int color, @FloatRange(from = 0) final float cornerRadius, final boolean recycle) {
        return ImageUtils.addCornerBorder(src, borderSize, color, cornerRadius, recycle);
    }

    /**
     * 添加圆形边框
     *
     * @param borderSize The size of border.
     * @param color      The color of border.
     */
    public static Bitmap addCircleBorder(final Bitmap src, @IntRange(from = 1) final int borderSize, @ColorInt final int color) {
        return ImageUtils.addCircleBorder(src, borderSize, color);
    }

    /**
     * 添加圆形边框
     *
     * @param borderSize The size of border.
     * @param color      The color of border.
     * @param recycle    True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap addCircleBorder(final Bitmap src, @IntRange(from = 1) final int borderSize, @ColorInt final int color, final boolean recycle) {
        return ImageUtils.addCircleBorder(src, borderSize, color, recycle);
    }


    /**
     * 添加倒影
     *
     * @param reflectionHeight The height of reflection.
     */
    public static Bitmap addReflection(final Bitmap src, final int reflectionHeight) {
        return ImageUtils.addReflection(src, reflectionHeight);
    }

    /**
     * 添加倒影
     *
     * @param reflectionHeight The height of reflection.
     * @param recycle          True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap addReflection(final Bitmap src, final int reflectionHeight, final boolean recycle) {
        return ImageUtils.addReflection(src, reflectionHeight, recycle);
    }

    /**
     * 添加文字水印
     *
     * @param src      The source of bitmap.
     * @param content  The content of text.
     * @param textSize The size of text.
     * @param color    The color of text.
     * @param x        The x coordinate of the first pixel.
     * @param y        The y coordinate of the first pixel.
     */
    public static Bitmap addTextWatermark(final Bitmap src, final String content, final int textSize, @ColorInt final int color, final float x, final float y) {
        return ImageUtils.addTextWatermark(src, content, textSize, color, x, y);
    }

    /**
     * 添加文字水印
     *
     * @param src      The source of bitmap.
     * @param content  The content of text.
     * @param textSize The size of text.
     * @param color    The color of text.
     * @param x        The x coordinate of the first pixel.
     * @param y        The y coordinate of the first pixel.
     * @param recycle  True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap addTextWatermark(final Bitmap src, final String content, final float textSize, @ColorInt final int color, final float x, final float y, final boolean recycle) {
        return ImageUtils.addTextWatermark(src, content, textSize, color, x, y, recycle);
    }

    /**
     * 添加图片水印
     *
     * @param src       The source of bitmap.
     * @param watermark The image watermarking.
     * @param x         The x coordinate of the first pixel.
     * @param y         The y coordinate of the first pixel.
     * @param alpha     The alpha of watermark.
     */
    public static Bitmap addImageWatermark(final Bitmap src, final Bitmap watermark, final int x, final int y, final int alpha) {
        return ImageUtils.addImageWatermark(src, watermark, x, y, alpha);
    }

    /**
     * 添加图片水印
     *
     * @param src       The source of bitmap.
     * @param watermark The image watermarking.
     * @param x         The x coordinate of the first pixel.
     * @param y         The y coordinate of the first pixel.
     * @param alpha     The alpha of watermark.
     * @param recycle   True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap addImageWatermark(final Bitmap src, final Bitmap watermark, final int x, final int y, final int alpha, final boolean recycle) {
        return ImageUtils.addImageWatermark(src, watermark, x, y, alpha, recycle);
    }

    /**
     * 转为 alpha 位图
     */
    public static Bitmap toAlpha(final Bitmap src) {
        return ImageUtils.toAlpha(src);
    }

    /**
     * 转为 alpha 位图
     *
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap toAlpha(final Bitmap src, final Boolean recycle) {
        return ImageUtils.toAlpha(src, recycle);
    }

    /**
     * 转为灰度图片
     */
    public static Bitmap toGray(final Bitmap src) {
        return ImageUtils.toGray(src);
    }

    /**
     * 转为灰度图片
     *
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap toGray(final Bitmap src, final boolean recycle) {
        return ImageUtils.toGray(src, recycle);
    }

    /**
     * 快速模糊
     *
     * @param scale  The scale(0...1).
     * @param radius The radius(0...25).
     */
    public static Bitmap fastBlur(final Bitmap src, @FloatRange(from = 0, to = 1, fromInclusive = false) final float scale, @FloatRange(from = 0, to = 25, fromInclusive = false) final float radius) {
        return ImageUtils.fastBlur(src, scale, radius);
    }

    /**
     * 快速模糊
     *
     * @param scale   The scale(0...1).
     * @param radius  The radius(0...25).
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap fastBlur(final Bitmap src, @FloatRange(from = 0, to = 1, fromInclusive = false) final float scale, @FloatRange(from = 0, to = 25, fromInclusive = false) final float radius, final boolean recycle) {
        return ImageUtils.fastBlur(src, scale, radius, recycle);
    }

    /**
     * 模糊图片
     *
     * @param src    The source of bitmap.
     * @param radius The radius(0...25).
     */
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static Bitmap renderScriptBlur(final Bitmap src, @FloatRange(from = 0, to = 25, fromInclusive = false) final float radius) {
        return ImageUtils.renderScriptBlur(src, radius);
    }

    /**
     * 模糊图片
     *
     * @param radius  The radius(0...25).
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static Bitmap renderScriptBlur(final Bitmap src, @FloatRange(from = 0, to = 25, fromInclusive = false) final float radius, final boolean recycle) {
        return ImageUtils.renderScriptBlur(src, radius, recycle);
    }

    /**
     * stack 模糊图片
     */
    public static Bitmap stackBlur(final Bitmap src, final int radius) {
        return ImageUtils.stackBlur(src, radius);
    }

    /**
     * stack 模糊图片
     */
    public static Bitmap stackBlur(final Bitmap src, int radius, final boolean recycle) {
        return ImageUtils.stackBlur(src, radius, recycle);
    }

    /**
     * 保存图片
     */
    public static boolean save(final Bitmap src, final String filePath, final Bitmap.CompressFormat format) {
        return ImageUtils.save(src, filePath, format);
    }

    /**
     * 保存图片
     */
    public static boolean save(final Bitmap src, final File file, final Bitmap.CompressFormat format) {
        return ImageUtils.save(src, file, format);
    }

    /**
     * 保存图片
     *
     * @param filePath The path of file.
     * @param format   The format of the image.
     * @param recycle  True to recycle the source of bitmap, false otherwise.
     */
    public static boolean save(final Bitmap src, final String filePath, final Bitmap.CompressFormat format, final boolean recycle) {
        return ImageUtils.save(src, filePath, format, recycle);
    }

    /**
     * 保存图片
     */
    public static boolean save(final Bitmap src, final File file, final Bitmap.CompressFormat format, final boolean recycle) {
        return ImageUtils.save(src, file, format, recycle);
    }

    /**
     * 根据文件名判断文件是否为图片
     */
    public static boolean isImage(final File file) {
        return ImageUtils.isImage(file);
    }

    /**
     * 根据文件名判断文件是否为图片
     */
    public static boolean isImage(final String filePath) {
        return ImageUtils.isImage(filePath);
    }

    /**
     * 获取图片类型
     */
    public static String getImageType(final String filePath) {
        return ImageUtils.getImageType(filePath);
    }

    /**
     * 获取图片类型
     */
    public static String getImageType(final File file) {
        return ImageUtils.getImageType(file);
    }

    /**
     * 按缩放压缩
     *
     * @param newWidth  The new width.
     * @param newHeight The new height.
     */
    public static Bitmap compressByScale(final Bitmap src, final int newWidth, final int newHeight) {
        return ImageUtils.compressByScale(src, newWidth, newHeight);
    }

    /**
     * 按缩放压缩
     *
     * @param newWidth  The new width.
     * @param newHeight The new height.
     * @param recycle   True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap compressByScale(final Bitmap src, final int newWidth, final int newHeight, final boolean recycle) {
        return ImageUtils.compressByScale(src, newWidth, newHeight, recycle);
    }

    /**
     * 按缩放压缩
     *
     * @param scaleWidth  The scale of width.
     * @param scaleHeight The scale of height.
     */
    public static Bitmap compressByScale(final Bitmap src, final float scaleWidth, final float scaleHeight) {
        return ImageUtils.compressByScale(src, scaleWidth, scaleHeight);
    }

    /**
     * 按缩放压缩
     *
     * @param scaleWidth  The scale of width.
     * @param scaleHeight The scale of height.
     * @param recycle     True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap compressByScale(final Bitmap src, final float scaleWidth, final float scaleHeight, final boolean recycle) {
        return ImageUtils.compressByScale(src, scaleWidth, scaleHeight, recycle);
    }

    /**
     * 按质量压缩
     *
     * @param quality The quality.
     */
    public static Bitmap compressByQuality(final Bitmap src, @IntRange(from = 0, to = 100) final int quality) {
        return ImageUtils.compressByQuality(src, quality);
    }

    /**
     * 按质量压缩
     *
     * @param quality The quality.
     * @param recycle True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap compressByQuality(final Bitmap src, @IntRange(from = 0, to = 100) final int quality, final boolean recycle) {
        return ImageUtils.compressByQuality(src, quality, recycle);
    }

    /**
     * 按质量压缩
     *
     * @param maxByteSize The maximum size of byte.
     */
    public static Bitmap compressByQuality(final Bitmap src, final long maxByteSize) {
        return ImageUtils.compressByQuality(src, maxByteSize);
    }

    /**
     * 按质量压缩
     *
     * @param maxByteSize The maximum size of byte.
     * @param recycle     True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap compressByQuality(final Bitmap src, final long maxByteSize, final boolean recycle) {
        return ImageUtils.compressByQuality(src, maxByteSize, recycle);
    }

    /**
     * 按采样大小压缩
     *
     * @param src        The source of bitmap.
     * @param sampleSize The sample size.
     */

    public static Bitmap compressBySampleSize(final Bitmap src, final int sampleSize) {
        return ImageUtils.compressBySampleSize(src, sampleSize);
    }

    /**
     * 按采样大小压缩
     *
     * @param sampleSize The sample size.
     * @param recycle    True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap compressBySampleSize(final Bitmap src, final int sampleSize, final boolean recycle) {
        return ImageUtils.compressBySampleSize(src, sampleSize, recycle);
    }

    /**
     * 按采样大小压缩
     *
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     */
    public static Bitmap compressBySampleSize(final Bitmap src, final int maxWidth, final int maxHeight) {
        return ImageUtils.compressBySampleSize(src, maxWidth, maxHeight);
    }

    /**
     * 按采样大小压缩
     *
     * @param maxWidth  The maximum width.
     * @param maxHeight The maximum height.
     * @param recycle   True to recycle the source of bitmap, false otherwise.
     */
    public static Bitmap compressBySampleSize(final Bitmap src, final int maxWidth, final int maxHeight, final boolean recycle) {
        return ImageUtils.compressBySampleSize(src, maxWidth, maxHeight, recycle);
    }
}
