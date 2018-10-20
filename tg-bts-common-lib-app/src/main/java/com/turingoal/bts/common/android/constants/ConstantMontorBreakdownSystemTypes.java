package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 故障系统分类
 */
public final class ConstantMontorBreakdownSystemTypes {
    private ConstantMontorBreakdownSystemTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String CTJCDLJ = "CTJCDLJ"; // 车体及车端连接
    public static final String CTMC = "CTMC"; // 车体门窗
    public static final String ZXJ = "ZXJ"; // 转向架
    public static final String GYQYXT = "GYQYXT"; // 高压牵引系统
    public static final String WZDQXT = "WZDQXT"; // 辅助电气系统
    public static final String GFJZDXT = "GFJZDXT"; // 供风及制动系统
    public static final String WLKZST = "WLKZST"; // 网络控制系统
    public static final String LKXXXT = "LKXXXT"; // 旅客信息系统
    public static final String CNHJKZXT = "CNHJKZXT"; // 车内环境控制系统
    public static final String JPSJWSXT = "JPSJWSXT"; // 给排水及卫生系统
    public static final String CNSS = "CNSS"; // 车内设施
    public static final String JSSS = "JSSS"; // 驾驶设施
    public static final String LJCZSB = "LJCZSB"; // 列控车载设备
    public static final String QITA = "QITA"; // 其他
    public static final String KTXT = "KTXT"; // 空调系统
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(CTJCDLJ, "车体及车端连接");
        map.put(CTMC, "车体门窗");
        map.put(ZXJ, "转向架");
        map.put(GYQYXT, "高压牵引系统");
        map.put(WZDQXT, "辅助电气系统");
        map.put(GFJZDXT, "供风及制动系统");
        map.put(WLKZST, "网络控制系统");
        map.put(LKXXXT, "旅客信息系统");
        map.put(CNHJKZXT, "车内环境控制系统");
        map.put(JPSJWSXT, "给排水及卫生系统");
        map.put(CNSS, "车内设施");
        map.put(JSSS, "驾驶设施");
        map.put(LJCZSB, "列控车裂设备");
        map.put(QITA, "其他");
        map.put(KTXT, "空调系统");
        DATA_LIST.add(new TgKeyValueBean(CTJCDLJ, map.get(CTJCDLJ)));
        DATA_LIST.add(new TgKeyValueBean(CTMC, map.get(CTMC)));
        DATA_LIST.add(new TgKeyValueBean(ZXJ, map.get(ZXJ)));
        DATA_LIST.add(new TgKeyValueBean(GYQYXT, map.get(GYQYXT)));
        DATA_LIST.add(new TgKeyValueBean(WZDQXT, map.get(WZDQXT)));
        DATA_LIST.add(new TgKeyValueBean(GFJZDXT, map.get(GFJZDXT)));
        DATA_LIST.add(new TgKeyValueBean(WLKZST, map.get(WLKZST)));
        DATA_LIST.add(new TgKeyValueBean(LKXXXT, map.get(LKXXXT)));
        DATA_LIST.add(new TgKeyValueBean(CNHJKZXT, map.get(CNHJKZXT)));
        DATA_LIST.add(new TgKeyValueBean(JPSJWSXT, map.get(JPSJWSXT)));
        DATA_LIST.add(new TgKeyValueBean(CNSS, map.get(CNSS)));
        DATA_LIST.add(new TgKeyValueBean(JSSS, map.get(JSSS)));
        DATA_LIST.add(new TgKeyValueBean(LJCZSB, map.get(LJCZSB)));
        DATA_LIST.add(new TgKeyValueBean(QITA, map.get(QITA)));
        DATA_LIST.add(new TgKeyValueBean(KTXT, map.get(KTXT)));
    }

    /**
     * 故障系统分类
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}