package com.turingoal.common.android.util.io;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.List;

/**
 * * File工具类
 */
public final class TgFileUtil {
    private TgFileUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 获得文件md5
     */
    public static String fileMd5(final String filePath) {
        String result = null;
        if (filePath != null && FileUtils.isFileExists(filePath)) { // 判断文件是否存在
            result = EncryptUtils.encryptMD5File2String(filePath); // 文件得到md5
        }
        return result;
    }

    /**
     * 获得md5，加上key以后再次获得md5，获得了两次
     */
    public static String fileMd5AndMd5(final String filePath, final String key) {
        String result = fileMd5(filePath);
        if (!TgStringUtil.isEmpty(result)) {
            result = EncryptUtils.encryptMD5ToString(key + result); // 再次md5
        }
        return result;
    }

    /**
     * 获得文件md5并且重命名文件。加上_{md5}。获得md5，加上key以后再次获得md5，获得了两次
     */
    public static String renameAddFilesMd5AndMd5(final String filePath, final String key) {
        String result = fileMd5AndMd5(filePath, key);
        if (filePath != null && FileUtils.isFileExists(filePath)) { // 判断文件是否存在
            String newName = FileUtils.getFileNameNoExtension(filePath) + "_" + result + "." + FileUtils.getFileExtension(filePath);
            if (FileUtils.rename(filePath, newName)) { // 文件重命名
                result = FileUtils.getDirName(filePath) + newName; // 返回新的文件名字
            }
        }
        return result;
    }

    /**
     * 根据文件路径获取文件
     */
    public static File getFileByPath(final String filePath) {
        return FileUtils.getFileByPath(filePath);
    }

    /**
     * 判断文件是否存在
     */
    public static boolean isFileExists(final String filePath) {
        return FileUtils.isFileExists(filePath);
    }

    /**
     * 判断文件是否存在
     */
    public static boolean isFileExists(final File file) {
        return FileUtils.isFileExists(file);
    }

    /**
     * 重命名文件
     */
    public static boolean rename(final String filePath, final String newName) {
        return FileUtils.rename(filePath, newName);
    }

    /**
     * 重命名文件
     */
    public static boolean rename(final File file, final String newName) {
        return FileUtils.rename(file, newName);
    }

    /**
     * 判断是否是目录
     */
    public static boolean isDir(final String dirPath) {
        return FileUtils.isDir(dirPath);
    }

    /**
     * 判断是否是目录
     */
    public static boolean isDir(final File file) {
        return FileUtils.isDir(file);
    }

    /**
     * 判断是否是文件
     */
    public static boolean isFile(final String filePath) {
        return FileUtils.isFile(filePath);
    }

    /**
     * 判断是否是文件
     */
    public static boolean isFile(final File file) {
        return FileUtils.isFile(file);
    }

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     */
    public static boolean createOrExistsDir(final String dirPath) {
        return FileUtils.createOrExistsDir(dirPath);
    }

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     */
    public static boolean createOrExistsDir(final File file) {
        return FileUtils.createOrExistsDir(file);
    }

    /**
     * 判断文件是否存在，不存在则判断是否创建成功
     */
    public static boolean createOrExistsFile(final String filePath) {
        return FileUtils.createOrExistsFile(filePath);
    }

    /**
     * 判断文件是否存在，不存在则判断是否创建成功
     */
    public static boolean createOrExistsFile(final File file) {
        return FileUtils.createOrExistsFile(file);
    }

    /**
     * 判断文件是否存在，存在则在创建之前删除
     */
    public static boolean createFileByDeleteOldFile(final String filePath) {
        return FileUtils.createFileByDeleteOldFile(filePath);
    }

    /**
     * 判断文件是否存在，存在则在创建之前删除
     */
    public static boolean createFileByDeleteOldFile(final File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    /**
     * 复制目录
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     */
    public static boolean copyDir(final String srcDirPath, final String destDirPath) {
        return FileUtils.copyDir(srcDirPath, destDirPath);
    }

    /**
     * 复制目录
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     * @param listener    The replace listener.
     */
    public static boolean copyDir(final String srcDirPath, final String destDirPath, final FileUtils.OnReplaceListener listener) {
        return FileUtils.copyDir(srcDirPath, destDirPath, listener);
    }

    /**
     * 复制目录
     *
     * @param srcDir  The source directory.
     * @param destDir The destination directory.
     */
    public static boolean copyDir(final File srcDir, final File destDir) {
        return FileUtils.copyDir(srcDir, destDir);
    }

    /**
     * 复制文件
     *
     * @param srcDir   The source directory.
     * @param destDir  The destination directory.
     * @param listener The replace listener.
     */
    public static boolean copyDir(final File srcDir, final File destDir, final FileUtils.OnReplaceListener listener) {
        return FileUtils.copyFile(srcDir, destDir, listener);
    }

    /**
     * 复制文件
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     */
    public static boolean copyFile(final String srcFilePath, final String destFilePath) {
        return FileUtils.copyFile(srcFilePath, destFilePath);
    }

    /**
     * 复制文件
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     * @param listener     The replace listener.
     */
    public static boolean copyFile(final String srcFilePath, final String destFilePath, final FileUtils.OnReplaceListener listener) {
        return FileUtils.copyFile(srcFilePath, destFilePath, listener);
    }

    /**
     * 复制文件
     *
     * @param srcFile  The source file.
     * @param destFile The destination file.
     */
    public static boolean copyFile(final File srcFile, final File destFile) {
        return FileUtils.copyFile(srcFile, destFile);
    }

    /**
     * 复制文件
     *
     * @param srcFile  The source file.
     * @param destFile The destination file.
     * @param listener The replace listener.
     */
    public static boolean copyFile(final File srcFile, final File destFile, final FileUtils.OnReplaceListener listener) {
        return FileUtils.copyFile(srcFile, destFile, listener);
    }

    /**
     * 移动目录
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     */
    public static boolean moveDir(final String srcDirPath, final String destDirPath) {
        return FileUtils.moveDir(srcDirPath, destDirPath);
    }

    /**
     * 移动目录
     *
     * @param srcDirPath  The path of source directory.
     * @param destDirPath The path of destination directory.
     * @param listener    The replace listener.
     */
    public static boolean moveDir(final String srcDirPath, final String destDirPath, final FileUtils.OnReplaceListener listener) {
        return FileUtils.moveDir(srcDirPath, destDirPath, listener);
    }

    /**
     * 移动目录
     *
     * @param srcDir  The source directory.
     * @param destDir The destination directory.
     */
    public static boolean moveDir(final File srcDir, final File destDir) {
        return FileUtils.moveDir(srcDir, destDir);
    }

    /**
     * 移动目录
     *
     * @param srcDir   The source directory.
     * @param destDir  The destination directory.
     * @param listener The replace listener.
     */
    public static boolean moveDir(final File srcDir, final File destDir, final FileUtils.OnReplaceListener listener) {
        return FileUtils.moveDir(srcDir, destDir, listener);
    }

    /**
     * 移动文件
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     */
    public static boolean moveFile(final String srcFilePath, final String destFilePath) {
        return FileUtils.moveFile(srcFilePath, destFilePath);
    }

    /**
     * 移动文件
     *
     * @param srcFilePath  The path of source file.
     * @param destFilePath The path of destination file.
     * @param listener     The replace listener.
     */
    public static boolean moveFile(final String srcFilePath, final String destFilePath, final FileUtils.OnReplaceListener listener) {
        return FileUtils.moveFile(srcFilePath, destFilePath, listener);
    }

    /**
     * 移动文件
     */
    public static boolean moveFile(final File srcFile, final File destFile) {
        return FileUtils.moveFile(srcFile, destFile);
    }

    /**
     * 移动文件
     *
     * @param srcFile  The source file.
     * @param destFile The destination file.
     * @param listener The replace listener.
     */
    public static boolean moveFile(final File srcFile, final File destFile, final FileUtils.OnReplaceListener listener) {
        return FileUtils.moveFile(srcFile, destFile, listener);
    }


    /**
     * 删除目录
     */
    public static boolean deleteDir(final String dirPath) {
        return FileUtils.deleteDir(dirPath);
    }

    /**
     * 删除目录
     */
    public static boolean deleteDir(final File dir) {
        return FileUtils.deleteDir(dir);
    }

    /**
     * 删除文件
     */
    public static boolean deleteFile(final String srcFilePath) {
        return FileUtils.deleteFile(srcFilePath);
    }

    /**
     * 删除文件
     */
    public static boolean deleteFile(final File file) {
        return FileUtils.deleteFile(file);
    }

    /**
     * 删除目录下所有东西
     */
    public static boolean deleteAllInDir(final String dirPath) {
        return FileUtils.deleteAllInDir(dirPath);
    }

    /**
     * 删除目录下所有东西
     */
    public static boolean deleteAllInDir(final File dir) {
        return FileUtils.deleteAllInDir(dir);
    }

    /**
     * 删除目录下所有文件
     */
    public static boolean deleteFilesInDir(final String dirPath) {
        return FileUtils.deleteFilesInDir(dirPath);
    }

    /**
     * 删除目录下所有文件
     */
    public static boolean deleteFilesInDir(final File dir) {
        return FileUtils.deleteFilesInDir(dir);
    }

    /**
     * 删除目录下所有过滤的文件
     */
    public static boolean deleteFilesInDirWithFilter(final String dirPath, final FileFilter filter) {
        return FileUtils.deleteFilesInDirWithFilter(dirPath, filter);
    }

    /**
     * 删除目录下所有过滤的文件
     */
    public static boolean deleteFilesInDirWithFilter(final File dir, final FileFilter filter) {
        return FileUtils.deleteFilesInDirWithFilter(dir, filter);
    }

    /**
     * 获取目录下所有文件
     */
    public static List<File> listFilesInDir(final String dirPath) {
        return FileUtils.listFilesInDir(dirPath);
    }

    /**
     * 获取目录下所有文件
     */
    public static List<File> listFilesInDir(final File dir) {
        return FileUtils.listFilesInDir(dir);
    }

    /**
     * 获取目录下所有文件
     *
     * @param isRecursive True to traverse subdirectories, false otherwise.
     */
    public static List<File> listFilesInDir(final String dirPath, final boolean isRecursive) {
        return FileUtils.listFilesInDir(dirPath, isRecursive);
    }

    /**
     * 获取目录下所有文件
     *
     * @param isRecursive True to traverse subdirectories, false otherwise.
     */
    public static List<File> listFilesInDir(final File dir, final boolean isRecursive) {
        return FileUtils.listFilesInDir(dir, isRecursive);
    }

    /**
     * 获取目录下所有过滤的文件
     *
     * @param dirPath The path of directory.
     * @param filter  The filter.
     */
    public static List<File> listFilesInDirWithFilter(final String dirPath, final FileFilter filter) {
        return FileUtils.listFilesInDirWithFilter(dirPath, filter);
    }

    /**
     * 获取目录下所有过滤的文件
     *
     * @param dir    The directory.
     * @param filter The filter.
     */
    public static List<File> listFilesInDirWithFilter(final File dir, final FileFilter filter) {
        return FileUtils.listFilesInDirWithFilter(dir, filter);
    }

    /**
     * 获取目录下所有过滤的文件
     *
     * @param dirPath     The path of directory.
     * @param filter      The filter.
     * @param isRecursive True to traverse subdirectories, false otherwise.
     */
    public static List<File> listFilesInDirWithFilter(final String dirPath, final FileFilter filter, final boolean isRecursive) {
        return FileUtils.listFilesInDirWithFilter(dirPath, filter, isRecursive);
    }

    /**
     * 获取目录下所有过滤的文件
     *
     * @param dir         The directory.
     * @param filter      The filter.
     * @param isRecursive True to traverse subdirectories, false otherwise.
     */
    public static List<File> listFilesInDirWithFilter(final File dir, final FileFilter filter, final boolean isRecursive) {
        return FileUtils.listFilesInDirWithFilter(dir, filter, isRecursive);
    }

    /**
     * 获取文件最后修改的毫秒时间戳
     */
    public static long getFileLastModified(final String filePath) {
        return FileUtils.getFileLastModified(filePath);
    }

    /**
     * 获取文件最后修改的毫秒时间戳
     */
    public static long getFileLastModified(final File file) {
        return FileUtils.getFileLastModified(file);
    }

    /**
     * 简单获取文件编码格式
     */
    public static String getFileCharsetSimple(final String filePath) {
        return FileUtils.getFileCharsetSimple(filePath);
    }

    /**
     * 简单获取文件编码格式
     */
    public static String getFileCharsetSimple(final File file) {
        return FileUtils.getFileCharsetSimple(file);
    }

    /**
     * 获取文件行数
     */
    public static int getFileLines(final String filePath) {
        return FileUtils.getFileLines(filePath);
    }

    /**
     * 获取文件行数
     */
    public static int getFileLines(final File file) {
        return FileUtils.getFileLines(file);
    }

    /**
     * 获取目录大小
     */
    public static String getDirSize(final String dirPath) {
        return FileUtils.getDirSize(dirPath);
    }

    /**
     * 获取目录大小
     */
    public static String getDirSize(final File dir) {
        return FileUtils.getDirSize(dir);
    }

    /**
     * 获取文件大小
     */
    public static String getFileSize(final String filePath) {
        return FileUtils.getFileSize(filePath);
    }

    /**
     * 获取文件大小
     */
    public static String getFileSize(final File file) {
        return FileUtils.getFileSize(file);
    }

    /**
     * 获取目录长度
     */
    public static long getDirLength(final String dirPath) {
        return FileUtils.getDirLength(dirPath);
    }

    /**
     * 获取目录长度
     */
    public static long getDirLength(final File dir) {
        return FileUtils.getDirLength(dir);
    }

    /**
     * 获取文件长度
     */
    public static long getFileLength(final String filePath) {
        return FileUtils.getFileLength(filePath);
    }

    /**
     * 获取文件长度
     */
    public static long getFileLength(final File file) {
        return FileUtils.getFileLength(file);
    }

    /**
     * 获取文件的 MD5 校验码
     */
    public static String getFileMD5ToString(final String filePath) {
        return FileUtils.getFileMD5ToString(filePath);
    }

    /**
     * 获取文件的 MD5 校验码
     */
    public static String getFileMD5ToString(final File file) {
        return FileUtils.getFileMD5ToString(file);
    }

    /**
     * 获取文件的 MD5 校验码
     */
    public static byte[] getFileMD5(final String filePath) {
        return FileUtils.getFileMD5(filePath);
    }

    /**
     * 获取文件的 MD5 校验码
     */
    public static byte[] getFileMD5(final File file) {
        return FileUtils.getFileMD5(file);
    }

    /**
     * 根据全路径获取最长目录
     */
    public static String getDirName(final File file) {
        return FileUtils.getDirName(file);
    }

    /**
     * 根据全路径获取最长目录
     */
    public static String getDirName(final String filePath) {
        return FileUtils.getDirName(filePath);
    }

    /**
     * 根据全路径获取文件名
     */
    public static String getFileName(final File file) {
        return FileUtils.getFileName(file);
    }

    /**
     * 根据全路径获取文件名
     */
    public static String getFileName(final String filePath) {
        return FileUtils.getFileName(filePath);
    }

    /**
     * 根据全路径获取文件名不带拓展名
     */
    public static String getFileNameNoExtension(final File file) {
        return FileUtils.getFileNameNoExtension(file);
    }

    /**
     * 根据全路径获取文件名不带拓展名
     */
    public static String getFileNameNoExtension(final String filePath) {
        return FileUtils.getFileNameNoExtension(filePath);
    }

    /**
     * 获取文件拓展名
     */
    public static String getFileExtension(final File file) {
        return FileUtils.getFileExtension(file);
    }

    /*
     *获取文件拓展名
     */
    public static String getFileExtension(final String filePath) {
        return FileUtils.getFileExtension(filePath);
    }

    /**
     * 将输入流写入文件
     */
    public static boolean writeFileFromIS(final String filePath, final InputStream is) {
        return FileIOUtils.writeFileFromIS(filePath, is);
    }

    /**
     * 将输入流写入文件
     */
    public static boolean writeFileFromIS(final String filePath, final InputStream is, final boolean append) {
        return FileIOUtils.writeFileFromIS(filePath, is, append);
    }

    /**
     * 将输入流写入文件
     */
    public static boolean writeFileFromIS(final File file, final InputStream is) {
        return FileIOUtils.writeFileFromIS(file, is);
    }

    /**
     * 将字节数组写入文件
     *
     * @param append True to append, false otherwise.
     */
    public static boolean writeFileFromIS(final File file, final InputStream is, final boolean append) {
        return FileIOUtils.writeFileFromIS(file, is, append);
    }

    /**
     * 将字节数组写入文件
     */
    public static boolean writeFileFromBytesByStream(final String filePath, final byte[] bytes) {
        return FileIOUtils.writeFileFromBytesByStream(filePath, bytes);
    }

    /**
     * 将字节数组写入文件
     *
     * @param append True to append, false otherwise.
     */
    public static boolean writeFileFromBytesByStream(final String filePath, final byte[] bytes, final boolean append) {
        return FileIOUtils.writeFileFromBytesByStream(filePath, bytes, append);
    }

    /**
     * 将字节数组写入文件
     */
    public static boolean writeFileFromBytesByStream(final File file, final byte[] bytes) {
        return FileIOUtils.writeFileFromBytesByStream(file, bytes);
    }

    /**
     * 将字节数组写入文件
     *
     * @param append True to append, false otherwise.
     */
    public static boolean writeFileFromBytesByStream(final File file, final byte[] bytes, final boolean append) {
        return FileIOUtils.writeFileFromBytesByStream(file, bytes, append);
    }

    /**
     * 将字节数组写入文件
     *
     * @param isForce 是否写入文件
     */
    public static boolean writeFileFromBytesByChannel(final String filePath, final byte[] bytes, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByChannel(filePath, bytes, isForce);
    }

    /**
     * 将字节数组写入文件
     *
     * @param append  True to append, false otherwise.
     * @param isForce True to force write file, false otherwise.
     */
    public static boolean writeFileFromBytesByChannel(final String filePath, final byte[] bytes, final boolean append, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByChannel(filePath, bytes, append, isForce);
    }

    /**
     * 将字节数组写入文件
     *
     * @param isForce True to force write file, false otherwise.
     */
    public static boolean writeFileFromBytesByChannel(final File file, final byte[] bytes, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByChannel(file, bytes, isForce);
    }

    /**
     * 将字节数组写入文件
     *
     * @param append  True to append, false otherwise.
     * @param isForce True to force write file, false otherwise.
     */
    public static boolean writeFileFromBytesByChannel(final File file, final byte[] bytes, final boolean append, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByChannel(file, bytes, append, isForce);
    }

    /**
     * 将字节数组写入文件
     *
     * @param isForce True to force write file, false otherwise.
     */
    public static boolean writeFileFromBytesByMap(final String filePath, final byte[] bytes, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByMap(filePath, bytes, isForce);
    }

    /**
     * 将字节数组写入文件
     *
     * @param append  True to append, false otherwise.
     * @param isForce True to force write file, false otherwise.
     */
    public static boolean writeFileFromBytesByMap(final String filePath, final byte[] bytes, final boolean append, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByMap(filePath, bytes, append, isForce);
    }

    /**
     * 将字节数组写入文件
     *
     * @param isForce True to force write file, false otherwise.
     */
    public static boolean writeFileFromBytesByMap(final File file, final byte[] bytes, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByMap(file, bytes, isForce);
    }

    /**
     * 将字节数组写入文件
     *
     * @param append  True to append, false otherwise.
     * @param isForce True to force write file, false otherwise.
     */
    public static boolean writeFileFromBytesByMap(final File file, final byte[] bytes, final boolean append, final boolean isForce) {
        return FileIOUtils.writeFileFromBytesByMap(file, bytes, append, isForce);
    }

    /**
     * 将字符串写入文件
     */
    public static boolean writeFileFromString(final String filePath, final String content) {
        return FileIOUtils.writeFileFromString(filePath, content);
    }

    /**
     * 将字符串写入文件
     *
     * @param append True to append, false otherwise.
     */
    public static boolean writeFileFromString(final String filePath, final String content, final boolean append) {
        return FileIOUtils.writeFileFromString(filePath, content, append);
    }

    /**
     * 将字符串写入文件
     */
    public static boolean writeFileFromString(final File file, final String content) {
        return FileIOUtils.writeFileFromString(file, content);
    }

    /**
     * 将字符串写入文件
     *
     * @param append True to append, false otherwise.
     */
    public static boolean writeFileFromString(final File file, final String content, final boolean append) {
        return FileIOUtils.writeFileFromString(file, content, append);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final String filePath) {
        return FileIOUtils.readFile2List(filePath);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final String filePath, final String charsetName) {
        return FileIOUtils.readFile2List(filePath, charsetName);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final File file) {
        return FileIOUtils.readFile2List(file);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final File file, final String charsetName) {
        return FileIOUtils.readFile2List(file, charsetName);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final String filePath, final int st, final int end) {
        return FileIOUtils.readFile2List(filePath, st, end);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final String filePath, final int st, final int end, final String charsetName) {
        return FileIOUtils.readFile2List(filePath, st, end, charsetName);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final File file, final int st, final int end) {
        return FileIOUtils.readFile2List(file, st, end);
    }

    /**
     * 读取文件到字符串链表中
     */
    public static List<String> readFile2List(final File file, final int st, final int end, final String charsetName) {
        return FileIOUtils.readFile2List(file, st, end, charsetName);
    }

    /**
     * 读取文件到字符串中
     */
    public static String readFile2String(final String filePath) {
        return FileIOUtils.readFile2String(filePath);
    }

    /**
     * 读取文件到字符串中
     */
    public static String readFile2String(final String filePath, final String charsetName) {
        return FileIOUtils.readFile2String(filePath, charsetName);
    }

    /**
     * 读取文件到字符串中
     */
    public static String readFile2String(final File file) {
        return FileIOUtils.readFile2String(file);
    }

    /**
     * 读取文件到字符串中
     */
    public static String readFile2String(final File file, final String charsetName) {
        return FileIOUtils.readFile2String(file, charsetName);
    }

    /**
     * 读取文件到字节数组中
     */
    public static byte[] readFile2BytesByStream(final String filePath) {
        return FileIOUtils.readFile2BytesByStream(filePath);
    }

    /**
     * 读取文件到字节数组中
     */
    public static byte[] readFile2BytesByStream(final File file) {
        return FileIOUtils.readFile2BytesByStream(file);
    }

    /**
     * 读取文件到字节数组中
     */
    public static byte[] readFile2BytesByChannel(final String filePath) {
        return FileIOUtils.readFile2BytesByChannel(filePath);
    }

    /**
     * 读取文件到字节数组中
     */
    public static byte[] readFile2BytesByChannel(final File file) {
        return FileIOUtils.readFile2BytesByChannel(file);
    }

    /**
     * 读取文件到字节数组中
     */
    public static byte[] readFile2BytesByMap(final String filePath) {
        return FileIOUtils.readFile2BytesByMap(filePath);
    }

    /**
     * 读取文件到字节数组中
     */
    public static byte[] readFile2BytesByMap(final File file) {
        return FileIOUtils.readFile2BytesByMap(file);
    }

    /**
     * 设置缓冲区尺寸
     */
    public static void setBufferSize(final int bufferSize) {
        FileIOUtils.setBufferSize(bufferSize);
    }
}