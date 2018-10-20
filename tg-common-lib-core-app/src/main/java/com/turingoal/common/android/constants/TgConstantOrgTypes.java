package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》部门类型
 */
public final class TgConstantOrgTypes {
    private TgConstantOrgTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String GROUP = "group"; // 集团
    public static final String COMP = "company"; // 公司
    public static final String CENTER = "center"; // 中心
    public static final String DEPT = "department"; // 部门
    public static final String TEAM = "team"; // 小组
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(GROUP, "集团");
        map.put(COMP, "公司");
        map.put(CENTER, "中心");
        map.put(DEPT, "部门");
        map.put(TEAM, "小组");
        DATA_LIST.add(new TgKeyValueBean(GROUP, map.get(GROUP)));
        DATA_LIST.add(new TgKeyValueBean(COMP, map.get(COMP)));
        DATA_LIST.add(new TgKeyValueBean(CENTER, map.get(CENTER)));
        DATA_LIST.add(new TgKeyValueBean(DEPT, map.get(DEPT)));
        DATA_LIST.add(new TgKeyValueBean(TEAM, map.get(TEAM)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
