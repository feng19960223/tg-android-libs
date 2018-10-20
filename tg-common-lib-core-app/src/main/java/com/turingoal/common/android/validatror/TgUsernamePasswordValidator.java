package com.turingoal.common.android.validatror;

import com.turingoal.common.android.bean.TgValidateResultBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.regex.Pattern;

/**
 * 用户名密码校验
 */
public final class TgUsernamePasswordValidator {
    public static final int MIN_USERNAME_LEN = 3; // 用户名最小长度
    public static final int MAX_USERNAME_LEN = 30; // 用户名最大长度
    public static final int MIN_PASSWORD_LEN = 6; // 密码最小长度
    public static final int MAX_PASSWORD_LEN = 30; // 密码最大长度
    public static final String FIELD_NAME_USERNAME = "username"; // 用户名
    public static final String FIELD_NAME_PASSWORRD = "password"; // 密码
    public static final String FIELD_NAME_OLD_PASSWORRD = "oldPassword"; // 原密码
    public static final String FIELD_NAME_NEW_PASSWORRD = "newPassword"; // 新密码
    public static final String FIELD_NAME_CONFIRM_PASSWORRD = "confirmPassword"; // 确认密码

    private TgUsernamePasswordValidator() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 校验用户名
     */
    public static TgValidateResultBean validateUsername(final String username) {
        TgValidateResultBean result = new TgValidateResultBean();
        if (TgStringUtil.isBlank(username)) {
            result = new TgValidateResultBean("请输入用户名！");
        } else if (username.length() < MIN_USERNAME_LEN) {
            result = new TgValidateResultBean("用户名不能小于3个字符！");
        } else if (username.length() > MAX_USERNAME_LEN) {
            result = new TgValidateResultBean("用户名不能超过30个字符！");
        } else if (!isGereralCharacters(username)) {
            result = new TgValidateResultBean("用户名只能包含数字、字母或下划线！");
        }
        return result;
    }

    /**
     * 校验密码
     */
    public static TgValidateResultBean validatePassword(final String passwrod) {
        TgValidateResultBean result = new TgValidateResultBean();
        if (TgStringUtil.isBlank(passwrod)) {
            result = new TgValidateResultBean("请输入密码！");
        } else if (passwrod.length() < MIN_PASSWORD_LEN) {
            result = new TgValidateResultBean("密码不能小于6个字符！");
        } else if (passwrod.length() > MAX_PASSWORD_LEN) {
            result = new TgValidateResultBean("密码不能超过30个字符！");
        } else if (!isGereralCharacters(passwrod)) {
            result = new TgValidateResultBean("密码只能包含数字、字母或下划线！");
        }
        return result;
    }

    /**
     * 校验用户名密码
     */
    public static TgValidateResultBean validateUsernameAndPassword(final String username, final String passwrod) {
        TgValidateResultBean result = validateUsername(username); // 先校验用户名
        result.setFieldName(FIELD_NAME_USERNAME);
        if (result.isSuccess()) { // 用户名没问题，校验密码
            result = validatePassword(passwrod);
            result.setFieldName(FIELD_NAME_PASSWORRD);
        }
        return result;
    }

    /**
     * 校验密码和确认密码
     */
    public static TgValidateResultBean validatePassword(final String oldPassword, final String newPassword, final String confirmPassword) {
        TgValidateResultBean result = new TgValidateResultBean();
        if (TgStringUtil.isBlank(oldPassword)) {
            result = new TgValidateResultBean(FIELD_NAME_OLD_PASSWORRD, "请输入原密码！");
        } else if (oldPassword.length() < MIN_PASSWORD_LEN || oldPassword.length() > MAX_PASSWORD_LEN) {
            result = new TgValidateResultBean(FIELD_NAME_OLD_PASSWORRD, "原密码为6到30个字符！");
        } else if (!isGereralCharacters(oldPassword)) {
            result = new TgValidateResultBean(FIELD_NAME_OLD_PASSWORRD, "密码只能包含数字、字母或下划线！");
        } else {
            if (TgStringUtil.isBlank(newPassword)) {
                result = new TgValidateResultBean(FIELD_NAME_NEW_PASSWORRD, "请输入新密码！");
            } else if (newPassword.length() < MIN_PASSWORD_LEN || newPassword.length() > MAX_PASSWORD_LEN) {
                result = new TgValidateResultBean(FIELD_NAME_NEW_PASSWORRD, "新密码为6到30个字符！");
            } else if (!isGereralCharacters(newPassword)) {
                result = new TgValidateResultBean(FIELD_NAME_NEW_PASSWORRD, "密码只能包含数字、字母或下划线！");
            } else {
                if (TgStringUtil.isBlank(confirmPassword)) {
                    result = new TgValidateResultBean(FIELD_NAME_CONFIRM_PASSWORRD, "请输入确认密码！");
                } else if (confirmPassword.length() < MIN_PASSWORD_LEN || confirmPassword.length() > MAX_PASSWORD_LEN) {
                    result = new TgValidateResultBean(FIELD_NAME_CONFIRM_PASSWORRD, "确认密码为6到30个字符！");
                } else if (!isGereralCharacters(confirmPassword)) {
                    result = new TgValidateResultBean(FIELD_NAME_CONFIRM_PASSWORRD, "密码只能包含数字、字母或下划线！");
                } else {
                    if (!newPassword.equals(confirmPassword)) {
                        result = new TgValidateResultBean(FIELD_NAME_CONFIRM_PASSWORRD, "两次输入的密码不一致！");
                    }
                }
            }
        }
        return result;
    }

    /**
     * 数字—字母-下划线
     */
    public static boolean isGereralCharacters(final String str) {
        return Pattern.compile("^[a-zA-Z0-9_]+").matcher(str).matches();
    }
}
