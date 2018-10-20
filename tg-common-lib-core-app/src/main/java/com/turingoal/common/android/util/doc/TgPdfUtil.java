package com.turingoal.common.android.util.doc;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.github.barteksc.pdfviewer.PDFView;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.List;

/**
 * pdf工具类
 */
public final class TgPdfUtil {
    private TgPdfUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 从Asset加载pdf
     */
    public static void loadPdfFromAsset(final PDFView pdfView, final String pdfFileName) {
        pdfView.fromAsset(pdfFileName)
                .defaultPage(0) // 默认页面
                .enableSwipe(true) // 触摸滑动
                .swipeHorizontal(false) // 水平滑动
                .load();
    }
}