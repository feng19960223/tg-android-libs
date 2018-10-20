package com.turingoal.common.android.util.io;

import com.blankj.utilcode.util.FileUtils;
import com.turingoal.common.android.util.lang.TgStringUtil;
import com.turingoal.common.android.util.system.TgLogUtil;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;

/**
 * * Zip4j工具类
 */
public final class TgZip4jUtil {
    private TgZip4jUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 使用给定密码压缩指定文件夹到指定位置.
     */
    public static String zipFolderWithPassword(final String sourceDir, final String zipFile, final String pssword) {
        String result = null;
        if (FileUtils.isFileExists(sourceDir)) {
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // 压缩
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); // 压缩级别
            if (!TgStringUtil.isEmpty(pssword)) {
                parameters.setEncryptFiles(true); // 加密
                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
                parameters.setPassword(pssword);
            }
            try {
                new ZipFile(zipFile).addFolder(new File(sourceDir), parameters); // 压缩的是文件夹
                // new ZipFile(zipFile).addFile( new File(dir), parameters); // 压缩的是文件
                result = zipFile;
            } catch (ZipException e) {
            }
        } else {
            TgLogUtil.d("源文件不存在！");
        }
        return result;
    }
}