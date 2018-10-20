package com.turingoal.common.android.exception;

/**
 * 序列号无效异常
 */
public class TgLicenseInvalidException extends Exception {
    private static final long serialVersionUID = 1L;

    public TgLicenseInvalidException(final String msg) {
        super(msg);
    }
}
