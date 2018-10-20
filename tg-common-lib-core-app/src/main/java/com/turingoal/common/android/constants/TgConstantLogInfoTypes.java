package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》日志类型
 */
public final class TgConstantLogInfoTypes {
    private TgConstantLogInfoTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String LOGIN_LOG = "login";
    public static final String LOGOUT_LOG = "logout";
    public static final String OPERATE_LOG = "operate";
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(LOGIN_LOG, "登录");
        map.put(LOGOUT_LOG, "退出");
        map.put(OPERATE_LOG, "操作");
        DATA_LIST.add(new TgKeyValueBean(LOGIN_LOG, map.get(LOGIN_LOG)));
        DATA_LIST.add(new TgKeyValueBean(LOGOUT_LOG, map.get(LOGOUT_LOG)));
        DATA_LIST.add(new TgKeyValueBean(OPERATE_LOG, map.get(OPERATE_LOG)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
