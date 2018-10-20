package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》文件类型
 */
public final class TgConstantFileTypes {
    private TgConstantFileTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String FILE_TYPE_IMG = "img"; // 图片
    public static final String FILE_TYPE_VIDEO = "video"; // 视频
    public static final String FILE_TYPE_AUDIO = "audio"; // 音频
    public static final String FILE_TYPE_DOC = "doc"; // 文档
    public static final String FILE_TYPE_RAR = "rar"; // 压缩文件
    public static final String FILE_TYPE_OTHER = "other"; // 其它

    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(FILE_TYPE_IMG, "图片");
        map.put(FILE_TYPE_VIDEO, "视频");
        map.put(FILE_TYPE_AUDIO, "音频");
        map.put(FILE_TYPE_DOC, "文档");
        map.put(FILE_TYPE_RAR, "压缩文件");
        map.put(FILE_TYPE_OTHER, "其它");
        DATA_LIST.add(new TgKeyValueBean(FILE_TYPE_IMG, map.get(FILE_TYPE_IMG)));
        DATA_LIST.add(new TgKeyValueBean(FILE_TYPE_VIDEO, map.get(FILE_TYPE_VIDEO)));
        DATA_LIST.add(new TgKeyValueBean(FILE_TYPE_AUDIO, map.get(FILE_TYPE_AUDIO)));
        DATA_LIST.add(new TgKeyValueBean(FILE_TYPE_DOC, map.get(FILE_TYPE_DOC)));
        DATA_LIST.add(new TgKeyValueBean(FILE_TYPE_RAR, map.get(FILE_TYPE_RAR)));
        DATA_LIST.add(new TgKeyValueBean(FILE_TYPE_OTHER, map.get(FILE_TYPE_OTHER)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
