package com.turingoal.common.android.validatror;

import com.turingoal.common.android.bean.TgValidateResultBean;
import com.turingoal.common.android.util.lang.TgRegexUtil;
import com.turingoal.common.android.util.lang.TgStringUtil;

/**
 * 用户名密码校验
 */
public final class TgNetValidator {
    public static final Integer MAX_PORT = 65535;
    public static final String FIELD_NAME_IP = "ip"; // ip
    public static final String FIELD_NAME_PORT = "port"; // 端口

    private TgNetValidator() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 校验ip
     */
    public static TgValidateResultBean validateIp(final String ipStr) {
        TgValidateResultBean result = new TgValidateResultBean();
        if (TgStringUtil.isBlank(ipStr)) {
            result = new TgValidateResultBean("IP地址不能为空！");
        } else {
            if (!TgRegexUtil.isIP(ipStr)) {
                result = new TgValidateResultBean("请输入正确的ip格式！");
            }
        }
        return result;
    }

    /**
     * 校验端口
     */
    public static TgValidateResultBean validatePort(final String portStr) {
        TgValidateResultBean result = new TgValidateResultBean();
        if (TgStringUtil.isBlank(portStr)) {
            result = new TgValidateResultBean("端口不能为空！");
        } else {
            int port = Integer.parseInt(portStr);
            if (port < 0 || port > MAX_PORT) {
                result = new TgValidateResultBean("端口范围为0到" + MAX_PORT + "！");
            }
        }
        return result;
    }

    /**
     * 校验IP和端口
     */
    public static TgValidateResultBean validateIpAndPort(final String ip, final String port) {
        TgValidateResultBean result = validateIp(ip); // 先校验ip
        result.setFieldName(FIELD_NAME_IP);
        if (result.isSuccess()) { // 用户名没问题，校验密码
            result = validatePort(port);
            result.setFieldName(FIELD_NAME_PORT);
        }
        return result;
    }
}
