package com.turingoal.common.android.util.io;

import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.ZipUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Zip工具类
 */
public class TgZipUtil {
    private TgZipUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 批量压缩文件
     */
    public static boolean zipFiles(final Collection<String> srcFiles, final String zipFilePath) throws IOException {
        return ZipUtils.zipFiles(srcFiles, zipFilePath);
    }

    /**
     * 批量压缩文件
     */
    public static boolean zipFiles(final Collection<String> srcFilePaths, final String zipFilePath, final String comment) throws IOException {
        return ZipUtils.zipFiles(srcFilePaths, zipFilePath, comment);
    }

    /**
     * 批量压缩文件
     */
    public static boolean zipFiles(final Collection<File> srcFiles, final File zipFile) throws IOException {
        return ZipUtils.zipFiles(srcFiles, zipFile);
    }

    /**
     * 批量压缩文件
     */
    public static boolean zipFiles(final Collection<File> srcFiles, final File zipFile, final String comment) throws IOException {
        return ZipUtils.zipFiles(srcFiles, zipFile, comment);
    }

    /**
     * 压缩文件
     */
    public static boolean zipFile(final String srcFilePath, final String zipFilePath) throws IOException {
        return ZipUtils.zipFile(srcFilePath, zipFilePath);
    }

    /**
     * 压缩文件
     */
    public static boolean zipFile(final String srcFilePath, final String zipFilePath, final String comment) throws IOException {
        return ZipUtils.zipFile(srcFilePath, zipFilePath, comment);
    }

    /**
     * 压缩文件
     */
    public static boolean zipFile(final File srcFile, final File zipFile) throws IOException {
        return ZipUtils.zipFile(srcFile, zipFile);
    }

    /**
     * 压缩文件
     */
    public static boolean zipFile(final File srcFile, final File zipFile, final String comment) throws IOException {
        return ZipUtils.zipFile(srcFile, zipFile, comment);
    }

    /**
     * 解压文件
     */
    public static List<File> unzipFile(final String zipFilePath, final String destDirPath) throws IOException {
        return ZipUtils.unzipFile(zipFilePath, destDirPath);
    }

    /**
     * 解压文件
     */
    public static List<File> unzipFile(final File zipFile, final File destDir) throws IOException {
        return ZipUtils.unzipFile(zipFile, destDir);
    }

    /**
     * 解压带有关键字的文件
     */
    public static List<File> unzipFileByKeyword(final String zipFilePath, final String destDirPath, final String keyword) throws IOException {
        return ZipUtils.unzipFileByKeyword(zipFilePath, destDirPath, keyword);
    }

    /**
     * 解压带有关键字的文件
     */
    public static List<File> unzipFileByKeyword(final File zipFile, final File destDir, final String keyword) throws IOException {
        return ZipUtils.unzipFileByKeyword(zipFile, destDir, keyword);
    }

    /**
     * 获取压缩文件中的文件路径链表
     */
    public static List<String> getFilesPath(final String zipFilePath) throws IOException {
        return ZipUtils.getFilesPath(zipFilePath);
    }

    /**
     * 获取压缩文件中的文件路径链表
     */
    public static List<String> getFilesPath(final File zipFile) throws IOException {
        return ZipUtils.getFilesPath(zipFile);
    }

    /**
     * 获取压缩文件中的注释链表
     */
    public static List<String> getComments(final String zipFilePath) throws IOException {
        return ZipUtils.getComments(zipFilePath);
    }

    /**
     * 获取压缩文件中的注释链表
     */
    public static List<String> getComments(final File zipFile) throws IOException {
        return ZipUtils.getComments(zipFile);
    }
}
