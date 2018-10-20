package com.turingoal.common.android.util.io;

import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import com.blankj.utilcode.util.UriUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.ZipUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Uri工具类
 */
public class TgUriUtil {
    private TgUriUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * file 转 uri
     */
    public static Uri file2Uri(final File file) {
        return UriUtils.file2Uri(file);
    }

    /**
     * uri 转 file
     */
    public static File uri2File(final Uri uri, final String columnName) {
        return UriUtils.uri2File(uri, columnName);
    }
}
