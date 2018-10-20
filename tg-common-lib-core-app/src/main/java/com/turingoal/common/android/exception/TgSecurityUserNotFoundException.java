package com.turingoal.common.android.exception;

/**
 * 用户不存在
 */
public class TgSecurityUserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public TgSecurityUserNotFoundException() {
        super("用户不存在！");
    }
}
