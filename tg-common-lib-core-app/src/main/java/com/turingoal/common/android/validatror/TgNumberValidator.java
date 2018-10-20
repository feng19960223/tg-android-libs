package com.turingoal.common.android.validatror;

import com.turingoal.common.android.bean.TgValidateResultBean;
import com.turingoal.common.android.util.lang.TgRegexUtil;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字校验
 */
public final class TgNumberValidator {
    /**
     * 保留两位小数正则
     */
    public static TgValidateResultBean isWith2decimal(final String number) {
        TgValidateResultBean result = new TgValidateResultBean();
        Matcher matcher = Pattern.compile("^\\d+\\.?\\d{0,2}$").matcher(number);
        if (!matcher.matches()) {
            result = new TgValidateResultBean("不是正确的数字格式！");
        }
        return result;
    }
}
