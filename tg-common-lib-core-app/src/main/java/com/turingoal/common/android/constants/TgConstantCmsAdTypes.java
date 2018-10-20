package com.turingoal.common.android.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

/**
 * 广告类型
 */
public final class TgConstantCmsAdTypes {
    private TgConstantCmsAdTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String IMAGE = "image"; // 图片
    public static final String VIDEO = "video"; // 视频
    public static final String SCRIPT = "script"; // 代码
    public static final String TEXT = "text"; // 文本
    public static final String OTHER = "other"; // 其它
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(IMAGE, "图片");
        map.put(VIDEO, "视频");
        map.put(SCRIPT, "代码");
        map.put(TEXT, "文本");
        map.put(OTHER, "其它");
        DATA_LIST.add(new TgKeyValueBean(IMAGE, map.get(IMAGE)));
        DATA_LIST.add(new TgKeyValueBean(VIDEO, map.get(VIDEO)));
        DATA_LIST.add(new TgKeyValueBean(SCRIPT, map.get(SCRIPT)));
        DATA_LIST.add(new TgKeyValueBean(TEXT, map.get(TEXT)));
        DATA_LIST.add(new TgKeyValueBean(OTHER, map.get(OTHER)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
