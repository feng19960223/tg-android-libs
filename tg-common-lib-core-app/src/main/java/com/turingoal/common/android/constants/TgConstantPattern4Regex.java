package com.turingoal.common.android.constants;

import java.util.Set;

/**
 * 常量-》正则表达式
 */
public interface TgConstantPattern4Regex {
    /**
     * 身份证号 15位:^[1-9]/d{7}((0/d)|(1[0-2]))(([0|1|2]/d)|3[0-1])/d{3}$
     */
    String ID_CARD_15 = "^[1-9]/d{7}((0/d)|(1[0-2]))(([0|1|2]/d)|3[0-1])/d{3}$";
    /**
     * 身份证号 18位:^[1-9]/d{5}[1-9]/d{3}((0/d)|(1[0-2]))(([0|1|2]/d)|3[0-1])/d{4}$
     */
    String ID_CARD_18 = "^[1-9]/d{5}[1-9]/d{3}((0/d)|(1[0-2]))(([0|1|2]/d)|3[0-1])/d{4}$";
    /**
     * 邮箱:^(/w)+(/./w+)*@(/w)+((/./w{2,3}){1,3})$
     */
    String EMAIL = "^(/w)+(/./w+)*@(/w)+((/./w{2,3}){1,3})$";
    /**
     * 国内电话号码:^(/(/d{3,4}-)|/d{3.4}-)?/d{7,8}$
     */
    String PHONE = "^(/(/d{3,4}-)|/d{3.4}-)?/d{7,8}$";
    /**
     * 手机号:^1[3|4|5|8]/d{9}$
     */
    String CELLPHONE = "^1[3|4|5|8]/d{9}$";
    /**
     * 中国邮政编码:[1-9]/d{5}(?!/d)
     */
    String POSTAL_CODE = "[1-9]/d{5}(?!/d)";
    /**
     * ip v4:/d+/./d+/./d+/./d+
     */
    String IP_V4 = "/d+/./d+/./d+/./d+";
    /**
     * ip v6:/d+/./d+/./d+/./d+./d+./d+
     */
    String IP_V6 = "/d+/./d+/./d+/./d+./d+./d+";
    /**
     * URL:[a-zA-z]+://[^/s]*
     */
    String URL = "[a-zA-z]+://[^/s]*";
    /**
     * 正则表达式匹配中文汉字:[/u4e00-/u9fa5]
     */
    String CHINESE = "[\u4E00-\u9FFF]";
    /**
     * 正则表达式匹配中文字符串
     */
    String CHINESE_STR = CHINESE + "+";
    /**
     * 正则中需要被转义的关键字
     */
}
