package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》是否
 */
public final class TgConstantYesNo {
    private TgConstantYesNo() {
        throw new Error("工具类不能实例化！");
    }

    public static final int ALL = 100; // 全部
    public static final int YES = 1; // 是
    public static final int NO = 2; // 否
    private static Map<Integer, String> map; // 是， 否
    private static Map<Integer, String> map4Success; // 成功， 失败
    private static Map<Integer, String> map4Pass; // 已通过， 未通过
    private static Map<Integer, String> map4Right; // 正确 ，错误
    private static Map<Integer, String> map4Truth; // 真，假
    private static Map<Integer, String> map4Have; // 有，无
    private static Map<Integer, String> map4On; // 开，关
    public static final List<TgKeyValueBean> DATA_LIST_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4SUCCESS_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4SUCCESS = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4PASS_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4PASS = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4RIGHT_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4RIGHT = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4TRUTH_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4TRUTH = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4HAVA_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4HAVE = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4ON_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST_4ON = new ArrayList<>();

    static {
        // 是否
        map = new HashMap<>();
        map.put(ALL, "全部");
        map.put(YES, "是");
        map.put(NO, "否");
        DATA_LIST_WITH_ALL.add(new TgKeyValueBean(ALL + "", map.get(ALL)));
        DATA_LIST_WITH_ALL.add(new TgKeyValueBean(YES + "", map.get(YES)));
        DATA_LIST_WITH_ALL.add(new TgKeyValueBean(NO + "", map.get(NO)));
        DATA_LIST.add(new TgKeyValueBean(YES + "", map.get(YES)));
        DATA_LIST.add(new TgKeyValueBean(NO + "", map.get(NO)));
        // 成功失败
        map4Success = new HashMap<>();
        map4Success.put(ALL, "全部");
        map4Success.put(YES, "成功");
        map4Success.put(NO, "失败");
        DATA_LIST_4SUCCESS_WITH_ALL.add(new TgKeyValueBean(ALL + "", map4Success.get(ALL)));
        DATA_LIST_4SUCCESS_WITH_ALL.add(new TgKeyValueBean(YES + "", map4Success.get(YES)));
        DATA_LIST_4SUCCESS_WITH_ALL.add(new TgKeyValueBean(NO + "", map4Success.get(NO)));
        DATA_LIST_4SUCCESS.add(new TgKeyValueBean(YES + "", map4Success.get(YES)));
        DATA_LIST_4SUCCESS.add(new TgKeyValueBean(NO + "", map4Success.get(NO)));
        // 已通过 未通过
        map4Pass = new HashMap<>();
        map4Pass.put(ALL, "全部");
        map4Pass.put(YES, "已通过");
        map4Pass.put(NO, "未通过");
        DATA_LIST_4PASS_WITH_ALL.add(new TgKeyValueBean(ALL + "", map4Pass.get(ALL)));
        DATA_LIST_4PASS_WITH_ALL.add(new TgKeyValueBean(YES + "", map4Pass.get(YES)));
        DATA_LIST_4PASS_WITH_ALL.add(new TgKeyValueBean(NO + "", map4Pass.get(NO)));
        DATA_LIST_4PASS.add(new TgKeyValueBean(YES + "", map4Pass.get(YES)));
        DATA_LIST_4PASS.add(new TgKeyValueBean(NO + "", map4Pass.get(NO)));
        // 正确错误
        map4Right = new HashMap<>();
        map4Right.put(ALL, "全部");
        map4Right.put(YES, "正确");
        map4Right.put(NO, "错误");
        DATA_LIST_4RIGHT_WITH_ALL.add(new TgKeyValueBean(ALL + "", map4Right.get(ALL)));
        DATA_LIST_4RIGHT_WITH_ALL.add(new TgKeyValueBean(YES + "", map4Right.get(YES)));
        DATA_LIST_4RIGHT_WITH_ALL.add(new TgKeyValueBean(NO + "", map4Right.get(NO)));
        DATA_LIST_4RIGHT.add(new TgKeyValueBean(YES + "", map4Right.get(YES)));
        DATA_LIST_4RIGHT.add(new TgKeyValueBean(NO + "", map4Right.get(NO)));
        // 真假
        map4Truth = new HashMap<>();
        map4Truth.put(ALL, "全部");
        map4Truth.put(YES, "真");
        map4Truth.put(NO, "假");
        DATA_LIST_4TRUTH_WITH_ALL.add(new TgKeyValueBean(ALL + "", map4Truth.get(ALL)));
        DATA_LIST_4TRUTH_WITH_ALL.add(new TgKeyValueBean(YES + "", map4Truth.get(YES)));
        DATA_LIST_4TRUTH_WITH_ALL.add(new TgKeyValueBean(NO + "", map4Truth.get(NO)));
        DATA_LIST_4TRUTH.add(new TgKeyValueBean(YES + "", map4Truth.get(YES)));
        DATA_LIST_4TRUTH.add(new TgKeyValueBean(NO + "", map4Truth.get(NO)));
        // 有无
        map4Have = new HashMap<>();
        map4Have.put(ALL, "全部");
        map4Have.put(YES, "有");
        map4Have.put(NO, "无");
        DATA_LIST_4HAVA_WITH_ALL.add(new TgKeyValueBean(ALL + "", map4Have.get(ALL)));
        DATA_LIST_4HAVA_WITH_ALL.add(new TgKeyValueBean(YES + "", map4Have.get(YES)));
        DATA_LIST_4HAVA_WITH_ALL.add(new TgKeyValueBean(NO + "", map4Have.get(NO)));
        DATA_LIST_4HAVE.add(new TgKeyValueBean(YES + "", map4Have.get(YES)));
        DATA_LIST_4HAVE.add(new TgKeyValueBean(NO + "", map4Have.get(NO)));
        // 开关
        map4On = new HashMap<>();
        map4On.put(ALL, "全部");
        map4On.put(YES, "开");
        map4On.put(NO, "关");
        DATA_LIST_4ON_WITH_ALL.add(new TgKeyValueBean(ALL + "", map4On.get(ALL)));
        DATA_LIST_4ON_WITH_ALL.add(new TgKeyValueBean(YES + "", map4On.get(YES)));
        DATA_LIST_4ON_WITH_ALL.add(new TgKeyValueBean(NO + "", map4On.get(NO)));
        DATA_LIST_4ON.add(new TgKeyValueBean(YES + "", map4On.get(YES)));
        DATA_LIST_4ON.add(new TgKeyValueBean(NO + "", map4On.get(NO)));
    }

    /**
     * 是否
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 成功失败
     */
    public static String getStr4Success(final int type) {
        return TgStringUtil.null2Length0(map4Success.get(type));
    }

    /**
     * 已通过 未通过
     */
    public static String getStr4Pass(final int type) {
        return TgStringUtil.null2Length0(map4Pass.get(type));
    }

    /**
     * 正确错误
     */
    public static String getStr4Right(final int type) {
        return TgStringUtil.null2Length0(map4Right.get(type));
    }

    /**
     * 真假
     */
    public static String getStr4Truth(final int type) {
        return TgStringUtil.null2Length0(map4Truth.get(type));
    }

    /**
     * 有无
     */
    public static String getStr4Have(final int type) {
        return TgStringUtil.null2Length0(map4Have.get(type));
    }

    /**
     * 开关
     */
    public static String getStr4On(final int type) {
        return TgStringUtil.null2Length0(map4On.get(type));
    }
}