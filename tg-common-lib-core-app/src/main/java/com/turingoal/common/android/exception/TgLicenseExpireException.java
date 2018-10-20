package com.turingoal.common.android.exception;

/**
 * 序列号过期异常
 */
public class TgLicenseExpireException extends Exception {
    private static final long serialVersionUID = 1L;

    public TgLicenseExpireException(final String msg) {
        super(msg);
    }
}
