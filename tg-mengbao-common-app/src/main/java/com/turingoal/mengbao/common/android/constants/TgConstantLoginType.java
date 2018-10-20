package com.turingoal.mengbao.common.android.constants;

/**
 * 第三方登录类型
 */
public final class TgConstantLoginType {
    private TgConstantLoginType() {
        throw new Error("不能实例化！");
    }

    public static final int TYPE_QQ = 1; // qq
    public static final int TYPE_WECHAT = 2; // 微信
    public static final int TYPE_SINA = 3; // 新浪

    /**
     * 是否是QQ
     */
    public static boolean isQQ(final int type) {
        return type == TYPE_QQ;
    }

    /**
     * 是否是微信
     */
    public static boolean isWeChat(final int type) {
        return type == TYPE_WECHAT;
    }

    /**
     * 是否是新浪
     */
    public static boolean isSina(final int type) {
        return type == TYPE_SINA;
    }
}
