package com.turingoal.common.android.util.system;

import com.blankj.utilcode.util.PathUtils;

/**
 * 路径工具类
 */
public final class TgPathUtil {
    private TgPathUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 获取根路径
     *
     * @return the path of /system
     */
    public static String getRootPath() {
        return PathUtils.getRootPath();
    }

    /**
     * 获取数据路径
     *
     * @return the path of /data
     */
    public static String getDataPath() {
        return PathUtils.getDataPath();
    }

    /**
     * 获取下载缓存路径
     *
     * @return the path of /cache
     */
    public static String getDownloadCachePath() {
        return PathUtils.getDownloadCachePath();
    }

    /**
     * 获取内存应用数据路径
     *
     * @return the path of /data/data/package
     */
    public static String getInternalAppDataPath() {
        return PathUtils.getInternalAppDataPath();
    }

    /**
     * 获取内存应用代码缓存路径
     *
     * @return the path of /data/data/package/code_cache
     */
    public static String getInternalAppCodeCacheDir() {
        return PathUtils.getInternalAppCodeCacheDir();
    }

    /**
     * 获取内存应用缓存路径
     *
     * @return the path of /data/data/package/cache
     */
    public static String getInternalAppCachePath() {
        return PathUtils.getInternalAppCachePath();
    }

    /**
     * 获取内存应用数据库路径
     *
     * @return the path of /data/data/package/databases
     */
    public static String getInternalAppDbsPath() {
        return PathUtils.getInternalAppDbsPath();
    }

    /**
     * 获取内存应用数据库路径
     *
     * @param name The name of database.
     * @return the path of /data/data/package/databases/name
     */
    public static String getInternalAppDbPath(String name) {
        return PathUtils.getInternalAppDbPath(name);
    }

    /**
     * 获取内存应用文件路径
     *
     * @return the path of /data/data/package/files
     */
    public static String getInternalAppFilesPath() {
        return PathUtils.getInternalAppFilesPath();
    }

    /**
     * 获取内存应用 SP 路径
     *
     * @return the path of /data/data/package/shared_prefs
     */
    public static String getInternalAppSpPath() {
        return PathUtils.getInternalAppSpPath();
    }

    /**
     * 获取内存应用未备份文件路径
     *
     * @return the path of /data/data/package/no_backup
     */
    public static String getInternalAppNoBackupFilesPath() {
        return PathUtils.getInternalAppNoBackupFilesPath();
    }

    /**
     * 获取外存路径
     *
     * @return the path of /storage/emulated/0
     */
    public static String getExternalStoragePath() {
        return PathUtils.getExternalStoragePath();
    }

    /**
     * 获取外存音乐路径
     *
     * @return the path of /storage/emulated/0/Music
     */
    public static String getExternalMusicPath() {
        return PathUtils.getExternalMusicPath();
    }

    /**
     * 获取外存播客路径
     *
     * @return the path of /storage/emulated/0/Podcasts
     */
    public static String getExternalPodcastsPath() {
        return PathUtils.getExternalPodcastsPath();
    }

    /**
     * 获取外存铃声路径
     *
     * @return the path of /storage/emulated/0/Ringtones
     */
    public static String getExternalRingtonesPath() {
        return PathUtils.getExternalRingtonesPath();
    }

    /**
     * 获取外存闹铃路径
     */
    public static String getExternalAlarmsPath() {
        return PathUtils.getExternalAlarmsPath();
    }

    /**
     * 获取外存通知路径
     *
     * @return the path of /storage/emulated/0/Notifications
     */
    public static String getExternalNotificationsPath() {
        return PathUtils.getExternalNotificationsPath();
    }

    /**
     * 获取外存图片路径
     *
     * @return the path of /storage/emulated/0/Pictures
     */
    public static String getExternalPicturesPath() {
        return PathUtils.getExternalPicturesPath();
    }

    /**
     * 获取外存影片路径
     *
     * @return the path of /storage/emulated/0/Movies
     */
    public static String getExternalMoviesPath() {
        return PathUtils.getExternalMoviesPath();
    }

    /**
     * 获取外存下载路径
     *
     * @return the path of /storage/emulated/0/Download
     */
    public static String getExternalDownloadsPath() {
        return PathUtils.getExternalDownloadsPath();
    }

    /**
     * 获取外存数码相机图片路径
     *
     * @return the path of /storage/emulated/0/DCIM
     */
    public static String getExternalDcimPath() {
        return PathUtils.getExternalDcimPath();
    }

    /**
     * 获取外存文档路径
     *
     * @return the path of /storage/emulated/0/Documents
     */
    public static String getExternalDocumentsPath() {
        return PathUtils.getExternalDocumentsPath();
    }

    /**
     * 获取外存应用数据路径
     *
     * @return the path of /storage/emulated/0/Android/data/package
     */
    public static String getExternalAppDataPath() {
        return PathUtils.getExternalAppDataPath();
    }

    /**
     * 获取外存应用缓存路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/cache
     */
    public static String getExternalAppCachePath() {
        return PathUtils.getExternalAppCachePath();
    }

    /**
     * 获取外存应用文件路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files
     */
    public static String getExternalAppFilesPath() {
        return PathUtils.getExternalAppFilesPath();
    }

    /**
     * 获取外存应用音乐路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Music
     */
    public static String getExternalAppMusicPath() {
        return PathUtils.getExternalAppMusicPath();
    }

    /**
     * 获取外存应用播客路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Podcasts
     */
    public static String getExternalAppPodcastsPath() {
        return PathUtils.getExternalAppPodcastsPath();
    }

    /**
     * 获取外存应用铃声路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Ringtones
     */
    public static String getExternalAppRingtonesPath() {
        return PathUtils.getExternalAppRingtonesPath();
    }

    /**
     * 获取外存应用闹铃路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Alarms
     */
    public static String getExternalAppAlarmsPath() {
        return PathUtils.getExternalAppAlarmsPath();
    }

    /**
     * 获取外存应用通知路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Notifications
     */
    public static String getExternalAppNotificationsPath() {
        return PathUtils.getExternalAppNotificationsPath();
    }

    /**
     * 获取外存应用图片路径
     *
     * @return path of /storage/emulated/0/Android/data/package/files/Pictures
     */
    public static String getExternalAppPicturesPath() {
        return PathUtils.getExternalAppPicturesPath();
    }

    /**
     * 获取外存应用影片路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Movies
     */
    public static String getExternalAppMoviesPath() {
        return PathUtils.getExternalAppMoviesPath();
    }

    /**
     * 获取外存应用下载路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Download
     */
    public static String getExternalAppDownloadPath() {
        return PathUtils.getExternalAppDownloadPath();
    }

    /**
     * 获取外存应用数码相机图片路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/DCIM
     */
    public static String getExternalAppDcimPath() {
        return PathUtils.getExternalAppDcimPath();
    }

    /**
     * 获取外存应用文档路径
     *
     * @return the path of /storage/emulated/0/Android/data/package/files/Documents
     */
    public static String getExternalAppDocumentsPath() {
        return PathUtils.getExternalAppDocumentsPath();
    }

    /**
     * 获取外存应用 OBB 路径
     *
     * @return the path of /storage/emulated/0/Android/obb/package
     */
    public static String getExternalAppObbPath() {
        return PathUtils.getExternalAppObbPath();
    }
}
