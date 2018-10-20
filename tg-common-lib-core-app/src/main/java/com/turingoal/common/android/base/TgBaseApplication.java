package com.turingoal.common.android.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.ALog;

import java.util.ArrayList;

/**
 * 主应用
 */
public abstract class TgBaseApplication extends Application {
    protected static Context appContext; //appContext
    private static ArrayList<Activity> signAtyList = new ArrayList<>(); // activity堆栈

    /**
     * 初始化Logger
     */
    protected void initLogger(final String logTag, final boolean debug) {
        ALog.Config config = ALog.init(this)
                .setLogSwitch(debug)// 设置 log 总开关，包括输出到控制台和文件，默认开
                .setConsoleSwitch(debug)// 设置是否输出到控制台开关，默认开
                .setGlobalTag(logTag)// 设置 log 全局标签，默认为空.当全局标签不为空时，我们输出的 log 全部为该 tag，为空时，如果传入的 tag 为空那就显示类名，否则显示 tag
                .setLogHeadSwitch(true)// 设置 log 头信息开关，默认为开
                .setLog2FileSwitch(false)// 打印 log 时是否存到文件的开关，默认关
                .setDir("")// 当自定义路径为空时，写入应用的 /cache/log/ 目录中
                .setFilePrefix("tg-log")// 当文件前缀为空时，默认为 "alog"，即写入文件为 "alog-MM-dd.txt"
                .setBorderSwitch(true)// 输出日志是否带边框开关，默认开
                .setSingleTagSwitch(true)// 一条日志仅输出一条，默认开，为美化 AS 3.1 的 Logcat
                .setConsoleFilter(ALog.V)// log 的控制台过滤器，和 logcat 过滤器同理，默认 Verbose
                .setFileFilter(ALog.V)// log 文件过滤器，和 logcat 过滤器同理，默认 Verbose
                .setStackDeep(1)// log 栈深度，默认为 1
                .setStackOffset(0)// 设置栈偏移，比如二次封装的话就需要设置，默认为 0
                .setSaveDays(3)// 设置日志可保留天数，默认为 -1 表示无限时长
                // 新增 ArrayList 格式化器，默认已支持 Array, Throwable, Bundle, Intent 的格式化输出
                .addFormatter(new ALog.IFormatter<ArrayList>() {
                    @Override
                    public String format(ArrayList list) {
                        return "Formatter ArrayList { " + list.toString() + " }";
                    }
                });
        ALog.d(config.toString());
    }

    /**
     * 初始化ARouter
     */
    protected void initARouter(final boolean debug) {
        if (debug) {
            ARouter.openLog();     // ARouter打印日志
            ARouter.openDebug();   // ARouter开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 初始化ARouter
    }

    /**
     * 添加 Activity 到堆栈
     */
    public static void addActivity(final Activity activity) {
        if (signAtyList != null) {
            boolean contains = signAtyList.contains(activity);
            if (contains) {
                signAtyList.remove(activity);
            }
            signAtyList.add(activity);
        }
    }

    /**
     * 从堆栈删除Activity
     */
    public static void deleteActivity(final Activity activity) {
        if (signAtyList != null) {
            boolean contains = signAtyList.contains(activity);
            if (contains) {
                signAtyList.remove(activity);
            }
        }
    }

    /**
     * 从堆栈finish Activity
     */
    public static void finishActivity(final Class<?> cls) {
        for (Activity activity : signAtyList) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
            }
        }
    }

    /**
     * 清空Activity堆栈
     */
    public static void clearActivitys() {
        if (signAtyList != null) {
            final int size = signAtyList.size();
            for (int i = 0; i < size; i++) {
                Activity aty = signAtyList.get(i);
                if (aty != null) {
                    aty.finish();
                }
            }
        }
    }

    /**
     * getContext
     */
    public static Context getContext() {
        return appContext;
    }
}
