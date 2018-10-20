package com.turingoal.common.android.base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 用户数据_参数保存服务
 */
public abstract class TgBaseUserPreferences {
    protected SharedPreferences sharedPreferences;

    public TgBaseUserPreferences() {
        super();
    }

    public TgBaseUserPreferences(final Context context, final String spName) {
        sharedPreferences = context.getSharedPreferences(spName, Context.MODE_PRIVATE); //name 在TgSystemConfig中统一配置
    }

    /*** 清空信息 */
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
