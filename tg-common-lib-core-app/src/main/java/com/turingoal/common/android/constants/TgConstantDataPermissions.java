package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》授权类型
 */
public final class TgConstantDataPermissions {
    private TgConstantDataPermissions() {
        throw new Error("工具类不能实例化！");
    }

    public static final String PERMISSION_CREATE = "create"; // 创建
    public static final String PERMISSION_UPDATE = "update"; // 更新
    public static final String PERMISSION_DELETE = "delete"; // 删除
    public static final String PERMISSION_VIEW = "view"; // 查看

    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(PERMISSION_CREATE, "创建");
        map.put(PERMISSION_UPDATE, "更新");
        map.put(PERMISSION_DELETE, "删除");
        map.put(PERMISSION_VIEW, "查看");
        DATA_LIST.add(new TgKeyValueBean(PERMISSION_CREATE, map.get(PERMISSION_CREATE)));
        DATA_LIST.add(new TgKeyValueBean(PERMISSION_UPDATE, map.get(PERMISSION_UPDATE)));
        DATA_LIST.add(new TgKeyValueBean(PERMISSION_DELETE, map.get(PERMISSION_DELETE)));
        DATA_LIST.add(new TgKeyValueBean(PERMISSION_VIEW, map.get(PERMISSION_VIEW)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
