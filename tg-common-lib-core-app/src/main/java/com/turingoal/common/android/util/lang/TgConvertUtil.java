package com.turingoal.common.android.util.lang;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.blankj.utilcode.constant.MemoryConstants;
import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.ConvertUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 转换相关工具类
 */
public final class TgConvertUtil {
    private TgConvertUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * bytes2Bits
     */
    public static String bytes2Bits(final byte[] bytes) {
        return ConvertUtils.bytes2Bits(bytes);
    }

    /**
     * bits2Bytes
     */
    public static byte[] bits2Bytes(String bits) {
        return ConvertUtils.bits2Bytes(bits);
    }

    /**
     * bytes2Chars
     */
    public static char[] bytes2Chars(final byte[] bytes) {
        return ConvertUtils.bytes2Chars(bytes);
    }

    /**
     * chars2Bytes
     */
    public static byte[] chars2Bytes(final char[] chars) {
        return ConvertUtils.chars2Bytes(chars);
    }

    /**
     * bytes2HexString
     */
    public static String bytes2HexString(final byte[] bytes) {
        return ConvertUtils.bytes2HexString(bytes);
    }

    /**
     * hexString2Bytes
     */
    public static byte[] hexString2Bytes(String hexString) {
        return ConvertUtils.hexString2Bytes(hexString);
    }

    /**
     * memorySize2Byte
     *
     * @param memorySize Size of memory.
     * @param unit       The unit of memory size.
     *                   <ul>
     *                   <li>{@link MemoryConstants#BYTE}</li>
     *                   <li>{@link MemoryConstants#KB}</li>
     *                   <li>{@link MemoryConstants#MB}</li>
     *                   <li>{@link MemoryConstants#GB}</li>
     *                   </ul>
     * @return size of byte
     */
    public static long memorySize2Byte(final long memorySize, @MemoryConstants.Unit final int unit) {
        return ConvertUtils.memorySize2Byte(memorySize, unit);
    }

    /**
     * byte2MemorySize
     *
     * @param byteSize Size of byte.
     * @param unit     The unit of memory size.
     *                 <ul>
     *                 <li>{@link MemoryConstants#BYTE}</li>
     *                 <li>{@link MemoryConstants#KB}</li>
     *                 <li>{@link MemoryConstants#MB}</li>
     *                 <li>{@link MemoryConstants#GB}</li>
     *                 </ul>
     * @return size of memory in unit
     */
    public static double byte2MemorySize(final long byteSize, @MemoryConstants.Unit final int unit) {
        return ConvertUtils.byte2MemorySize(byteSize, unit);
    }

    /**
     * byte2FitMemorySize
     * <p>to three decimal places</p>
     *
     * @param byteSize Size of byte.
     * @return fit size of memory
     */
    @SuppressLint("DefaultLocale")
    public static String byte2FitMemorySize(final long byteSize) {
        return ConvertUtils.byte2FitMemorySize(byteSize);
    }

    /**
     * timeSpan2Millis
     *
     * @param timeSpan The time span.
     * @param unit     The unit of time span.
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}</li>
     *                 <li>{@link TimeConstants#SEC }</li>
     *                 <li>{@link TimeConstants#MIN }</li>
     *                 <li>{@link TimeConstants#HOUR}</li>
     *                 <li>{@link TimeConstants#DAY }</li>
     *                 </ul>
     * @return milliseconds
     */
    public static long timeSpan2Millis(final long timeSpan, @TimeConstants.Unit final int unit) {
        return ConvertUtils.timeSpan2Millis(timeSpan, unit);
    }

    /**
     * millis2TimeSpan
     *
     * @param millis The milliseconds.
     * @param unit   The unit of time span.
     *               <ul>
     *               <li>{@link TimeConstants#MSEC}</li>
     *               <li>{@link TimeConstants#SEC }</li>
     *               <li>{@link TimeConstants#MIN }</li>
     *               <li>{@link TimeConstants#HOUR}</li>
     *               <li>{@link TimeConstants#DAY }</li>
     *               </ul>
     * @return time span in unit
     */
    public static long millis2TimeSpan(final long millis, @TimeConstants.Unit final int unit) {
        return ConvertUtils.millis2TimeSpan(millis, unit);
    }

    /**
     * millis2FitTimeSpan
     *
     * @param millis    The milliseconds.
     *                  <p>millis &lt;= 0, return null</p>
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0, return null</li>
     *                  <li>precision = 1, return 天</li>
     *                  <li>precision = 2, return 天, 小时</li>
     *                  <li>precision = 3, return 天, 小时, 分钟</li>
     *                  <li>precision = 4, return 天, 小时, 分钟, 秒</li>
     *                  <li>precision &gt;= 5，return 天, 小时, 分钟, 秒, 毫秒</li>
     *                  </ul>
     * @return fit time span
     */
    @SuppressLint("DefaultLocale")
    public static String millis2FitTimeSpan(long millis, int precision) {
        return ConvertUtils.millis2FitTimeSpan(millis, precision);

    }

    /**
     * input2OutputStream
     */
    public static ByteArrayOutputStream input2OutputStream(final InputStream is) {
        return ConvertUtils.input2OutputStream(is);
    }

    /**
     * inputStream2Bytes
     */
    public static byte[] inputStream2Bytes(final InputStream is) {
        return ConvertUtils.inputStream2Bytes(is);
    }

    /**
     * bytes2InputStream
     */
    public static InputStream bytes2InputStream(final byte[] bytes) {
        return ConvertUtils.bytes2InputStream(bytes);
    }

    /**
     * outputStream2Bytes
     */
    public static byte[] outputStream2Bytes(final OutputStream out) {
        return ConvertUtils.outputStream2Bytes(out);
    }

    /**
     * bytes2OutputStream
     */
    public static OutputStream bytes2OutputStream(final byte[] bytes) {
        return ConvertUtils.bytes2OutputStream(bytes);
    }

    /**
     * inputStream2String
     */
    public static String inputStream2String(final InputStream is, final String charsetName) {
        return ConvertUtils.inputStream2String(is, charsetName);
    }

    /**
     * string2InputStream
     */
    public static InputStream string2InputStream(final String string, final String charsetName) {
        return ConvertUtils.string2InputStream(string, charsetName);
    }

    /**
     * outputStream2String
     */
    public static String outputStream2String(final OutputStream out, final String charsetName) {
        return ConvertUtils.outputStream2String(out, charsetName);
    }

    /**
     * string2OutputStream
     */
    public static OutputStream string2OutputStream(final String string, final String charsetName) {
        return ConvertUtils.string2OutputStream(string, charsetName);
    }

    /**
     * bitmap2Bytes
     */
    public static byte[] bitmap2Bytes(final Bitmap bitmap, final Bitmap.CompressFormat format) {
        return ConvertUtils.bitmap2Bytes(bitmap, format);
    }

    /**
     * bytes2Bitmap
     */
    public static Bitmap bytes2Bitmap(final byte[] bytes) {
        return ConvertUtils.bytes2Bitmap(bytes);
    }

    /**
     * drawable2Bitmap
     */
    public static Bitmap drawable2Bitmap(final Drawable drawable) {
        return ConvertUtils.drawable2Bitmap(drawable);
    }

    /**
     * bitmap2Drawable
     */
    public static Drawable bitmap2Drawable(final Bitmap bitmap) {
        return ConvertUtils.bitmap2Drawable(bitmap);
    }

    /**
     * drawable2Bytes
     */
    public static byte[] drawable2Bytes(final Drawable drawable, final Bitmap.CompressFormat format) {
        return ConvertUtils.drawable2Bytes(drawable, format);
    }

    /**
     * bytes2Drawable
     */
    public static Drawable bytes2Drawable(final byte[] bytes) {
        return ConvertUtils.bytes2Drawable(bytes);
    }

    /**
     * view 转 Bitmap
     */
    public static Bitmap view2Bitmap(final View view) {
        return ConvertUtils.view2Bitmap(view);
    }

    /**
     * dp2px
     */
    public static int dp2px(final float dpValue) {
        return ConvertUtils.dp2px(dpValue);
    }


    /**
     * px2dp
     */
    public static int px2dp(final float pxValue) {
        return ConvertUtils.px2dp(pxValue);
    }

    /**
     * sp2px
     */
    public static int sp2px(final float spValue) {
        return ConvertUtils.sp2px(spValue);
    }

    /**
     * px2sp
     */
    public static int px2sp(final float pxValue) {
        return ConvertUtils.px2sp(pxValue);
    }
}