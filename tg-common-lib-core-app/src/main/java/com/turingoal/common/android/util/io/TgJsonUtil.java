package com.turingoal.common.android.util.io;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.turingoal.common.android.bean.TgResponseBean;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工具类-》IO处理工具类-》 json 操作工具类
 * <p>
 * [依赖 gson.jar]
 * </p>
 */
public final class TgJsonUtil {
    private static final Gson GSON = createGson(true);
    private static final Gson GSON_NO_NULLS = createGson(false);

    private TgJsonUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 获取 Gson 对象
     */
    public static Gson getGson() {
        return getGson(true);
    }

    /**
     * 获取 Gson 对象
     */
    public static Gson getGson(final boolean serializeNulls) {
        return serializeNulls ? GSON_NO_NULLS : GSON;
    }

    /**
     * 将JSON解析成对象
     */
    public static <T> T json2Object(final String json, final Class<T> c) {
        T t = null;
        if (!android.text.TextUtils.isEmpty(json)) {
            t = GSON.fromJson(json, c);
        }
        return t;
    }

    /**
     * 将JSON解析成对象
     */
    public static <T> T json2Object(final String json, final Type type) {
        T t = null;
        if (!android.text.TextUtils.isEmpty(json)) {
            t = GSON.fromJson(json, type);
        }
        return t;
    }

    /**
     * 将JSON解析成对象
     */
    public static <T> T json2Object(final Reader reader, final Class<T> c) {
        return GSON.fromJson(reader, c);
    }

    /**
     * 将JSON解析成对象
     */
    public static <T> T json2Object(final Reader reader, final Type type) {
        return GSON.fromJson(reader, type);
    }

    /**
     * 将JSON解析成对象list
     */
    public static <T> List<T> json2List(final String json, final Class<T> c) {
        List<T> list = new ArrayList<>();
        if (!TextUtils.isEmpty(json)) {
            String jsonStr = warpJson2ListJson(json);
            list = GSON.fromJson(jsonStr, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 将JSON解析成map
     */
    public static <T> Map<String, T> json2Map(final String json) {
        Map<String, T> map = new HashMap<>();
        if (!android.text.TextUtils.isEmpty(json)) {
            map = GSON.fromJson(json, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * 将TgJsonResultBean 解析成List
     */
    public static <T> List<T> jsonResultBean2List(final TgResponseBean result, final Class<T> c) {
        List<T> list = new ArrayList<>();
        if (result.getData() != null) {
            list = GSON.fromJson(result.getData().toString(), new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }


    /**
     * 将TgJsonResultBean 解析成对象
     */
    public static <T> T jsonResultBean2Object(final TgResponseBean result, final Class<T> c) {
        T t = null;
        if (result.getData() != null) {
            t = GSON.fromJson(result.getData().toString(), c);
        }
        return t;
    }

    /**
     * 将字符串包装成json数组
     */
    public static String warpJson2ListJson(final String json) {
        String jsonStr = json;
        if (!TextUtils.isEmpty(json)) {
            if (!json.startsWith("[")) {
                jsonStr = "[" + json + "]";
            }
        }
        return jsonStr;
    }

    /**
     * 将对象转换成json
     */
    public static String object2Json(final Object object) {
        return object2Json(object, true);
    }

    /**
     * 将对象转换成json
     */
    public static String object2Json(final Object object, final boolean includeNulls) {
        return includeNulls ? GSON.toJson(object) : GSON_NO_NULLS.toJson(object);
    }

    /**
     * createGson
     */
    private static Gson createGson(final boolean serializeNulls) {
        final GsonBuilder builder = new GsonBuilder();
        if (serializeNulls) builder.serializeNulls();
        return builder.create();
    }
}