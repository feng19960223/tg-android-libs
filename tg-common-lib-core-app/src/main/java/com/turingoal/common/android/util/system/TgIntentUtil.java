package com.turingoal.common.android.util.system;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;

import com.blankj.utilcode.util.IntentUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.Manifest.permission.CALL_PHONE;

/**
 * Intent工具类
 */
public final class TgIntentUtil {
    private TgIntentUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 判断意图是否可用
     */
    public static boolean isIntentAvailable(final Intent intent) {
        return IntentUtils.isIntentAvailable(intent);
    }

    /**
     * 获取安装 App（支持 6.0）的意图
     *
     * @param filePath The path of file.
     */
    public static Intent getInstallAppIntent(final String filePath) {
        return IntentUtils.getInstallAppIntent(filePath);
    }

    /**
     * 获取安装 App（支持 6.0）的意图
     *
     * @param file The file.
     */
    public static Intent getInstallAppIntent(final File file) {
        return IntentUtils.getInstallAppIntent(file);
    }

    /**
     * 获取安装 App（支持 6.0）的意图
     *
     * @param filePath  The path of file.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getInstallAppIntent(final String filePath, final boolean isNewTask) {
        return IntentUtils.getInstallAppIntent(filePath, isNewTask);
    }

    /**
     * 获取安装 App（支持 6.0）的意图
     *
     * @param file      The file.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getInstallAppIntent(final File file, final boolean isNewTask) {
        return IntentUtils.getInstallAppIntent(file, isNewTask);
    }

    /**
     * 获取卸载 App 的意图
     *
     * @param packageName The name of the package.
     */
    public static Intent getUninstallAppIntent(final String packageName) {
        return IntentUtils.getUninstallAppIntent(packageName);
    }

    /**
     * 获取卸载 App 的意图
     *
     * @param packageName The name of the package.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    public static Intent getUninstallAppIntent(final String packageName, final boolean isNewTask) {
        return IntentUtils.getUninstallAppIntent(packageName, isNewTask);
    }

    /**
     * 获取打开 App 的意图
     *
     * @param packageName The name of the package.
     */
    public static Intent getLaunchAppIntent(final String packageName) {
        return IntentUtils.getLaunchAppIntent(packageName);
    }

    /**
     * 获取打开 App 的意图
     *
     * @param packageName The name of the package.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    public static Intent getLaunchAppIntent(final String packageName, final boolean isNewTask) {
        return IntentUtils.getLaunchAppIntent(packageName, isNewTask);
    }

    /**
     * 获取 App 具体设置的意图
     *
     * @param packageName The name of the package.
     */
    public static Intent getLaunchAppDetailsSettingsIntent(final String packageName) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(packageName);
    }

    /**
     * 获取 App 具体设置的意图
     *
     * @param packageName The name of the package.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    public static Intent getLaunchAppDetailsSettingsIntent(final String packageName, final boolean isNewTask) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(packageName, isNewTask);
    }

    /**
     * 获取分享文本的意图
     *
     * @param content The content.
     */
    public static Intent getShareTextIntent(final String content) {
        return IntentUtils.getShareTextIntent(content);
    }

    /**
     * 获取分享文本的意图
     *
     * @param content   The content.
     * @param isNewTask True to add flag of new task, false otherwise.
     */

    public static Intent getShareTextIntent(final String content, final boolean isNewTask) {
        return IntentUtils.getShareTextIntent(content, isNewTask);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content   The content.
     * @param imagePath The path of image.
     */
    public static Intent getShareImageIntent(final String content, final String imagePath) {
        return IntentUtils.getShareImageIntent(content, imagePath);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content   The content.
     * @param imagePath The path of image.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getShareImageIntent(final String content, final String imagePath, final boolean isNewTask) {
        return IntentUtils.getShareImageIntent(content, imagePath, isNewTask);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content The content.
     * @param image   The file of image.
     */
    public static Intent getShareImageIntent(final String content, final File image) {
        return IntentUtils.getShareImageIntent(content, image);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content   The content.
     * @param image     The file of image.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getShareImageIntent(final String content, final File image, final boolean isNewTask) {
        return IntentUtils.getShareImageIntent(content, image, isNewTask);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content The content.
     * @param uri     The uri of image.
     */
    public static Intent getShareImageIntent(final String content, final Uri uri) {
        return IntentUtils.getShareImageIntent(content, uri);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content   The content.
     * @param uri       The uri of image.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getShareImageIntent(final String content, final Uri uri, final boolean isNewTask) {
        return IntentUtils.getShareImageIntent(content, uri, isNewTask);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content    The content.
     * @param imagePaths The paths of images.
     */
    public static Intent getShareImageIntent(final String content, final LinkedList<String> imagePaths) {
        return IntentUtils.getShareImageIntent(content, imagePaths);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content    The content.
     * @param imagePaths The paths of images.
     * @param isNewTask  True to add flag of new task, false otherwise.
     */
    public static Intent getShareImageIntent(final String content, final LinkedList<String> imagePaths, final boolean isNewTask) {
        return IntentUtils.getShareImageIntent(content, imagePaths, isNewTask);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content The content.
     * @param images  The files of images.
     */
    public static Intent getShareImageIntent(final String content, final List<File> images) {
        return IntentUtils.getShareImageIntent(content, images);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content   The content.
     * @param images    The files of images.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getShareImageIntent(final String content, final List<File> images, final boolean isNewTask) {
        return IntentUtils.getShareImageIntent(content, images, isNewTask);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content The content.
     * @param uris    The uris of images.
     */
    public static Intent getShareImageIntent(final String content, final ArrayList<Uri> uris) {
        return IntentUtils.getShareImageIntent(content, uris);
    }

    /**
     * 获取分享图片的意图
     *
     * @param content   The content.
     * @param uris      The uris of image.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getShareImageIntent(final String content, final ArrayList<Uri> uris, final boolean isNewTask) {
        return IntentUtils.getShareImageIntent(content, uris, isNewTask);
    }

    /**
     * 获取其他应用组件的意图
     *
     * @param packageName The name of the package.
     * @param className   The name of class.
     */
    public static Intent getComponentIntent(final String packageName, final String className) {
        return IntentUtils.getComponentIntent(packageName, className);
    }

    /**
     * 获取其他应用组件的意图
     *
     * @param packageName The name of the package.
     * @param className   The name of class.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    public static Intent getComponentIntent(final String packageName, final String className, final boolean isNewTask) {
        return IntentUtils.getComponentIntent(packageName, className, isNewTask);
    }

    /**
     * 获取其他应用组件的意图
     *
     * @param packageName The name of the package.
     * @param className   The name of class.
     * @param bundle      The Bundle of extras to add to this intent.
     */
    public static Intent getComponentIntent(final String packageName, final String className, final Bundle bundle) {
        return IntentUtils.getComponentIntent(packageName, className, bundle);
    }

    /**
     * 获取其他应用组件的意图
     *
     * @param packageName The name of the package.
     * @param className   The name of class.
     * @param bundle      The Bundle of extras to add to this intent.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    public static Intent getComponentIntent(final String packageName, final String className, final Bundle bundle, final boolean isNewTask) {
        return IntentUtils.getComponentIntent(packageName, className, bundle, isNewTask);
    }

    /**
     * 获取关机的意图
     */
    public static Intent getShutdownIntent() {
        return IntentUtils.getShutdownIntent();
    }

    /**
     * 获取关机的意图
     *
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getShutdownIntent(final boolean isNewTask) {
        return IntentUtils.getShutdownIntent(isNewTask);
    }

    /**
     * 拨号意图
     *
     * @param phoneNumber The phone number.
     */
    public static Intent getDialIntent(final String phoneNumber) {
        return IntentUtils.getDialIntent(phoneNumber);
    }

    /**
     * 拨号意图
     *
     * @param phoneNumber The phone number.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    public static Intent getDialIntent(final String phoneNumber, final boolean isNewTask) {
        return IntentUtils.getDialIntent(phoneNumber, isNewTask);
    }

    /**
     * 打电话意图
     *
     * @param phoneNumber The phone number.
     */
    @RequiresPermission(CALL_PHONE)
    public static Intent getCallIntent(final String phoneNumber) {
        return IntentUtils.getCallIntent(phoneNumber);
    }

    /**
     * 打电话意图
     *
     * @param phoneNumber The phone number.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    @RequiresPermission(CALL_PHONE)
    public static Intent getCallIntent(final String phoneNumber, final boolean isNewTask) {
        return IntentUtils.getCallIntent(phoneNumber, isNewTask);
    }

    /**
     * 获取发送短信意图
     *
     * @param phoneNumber The phone number.
     * @param content     The content of SMS.
     */
    public static Intent getSendSmsIntent(final String phoneNumber, final String content) {
        return IntentUtils.getSendSmsIntent(phoneNumber, content);
    }

    /**
     * 获取发送短信意图
     *
     * @param phoneNumber The phone number.
     * @param content     The content of SMS.
     * @param isNewTask   True to add flag of new task, false otherwise.
     */
    public static Intent getSendSmsIntent(final String phoneNumber, final String content, final boolean isNewTask) {
        return IntentUtils.getSendSmsIntent(phoneNumber, content, isNewTask);
    }

    /**
     * 获取拍照的意图
     */
    public static Intent getCaptureIntent(final Uri outUri) {
        return IntentUtils.getCaptureIntent(outUri);
    }

    /**
     * 获取拍照的意图
     *
     * @param outUri    The uri of output.
     * @param isNewTask True to add flag of new task, false otherwise.
     */
    public static Intent getCaptureIntent(final Uri outUri, final boolean isNewTask) {
        return IntentUtils.getCaptureIntent(outUri, isNewTask);
    }
}