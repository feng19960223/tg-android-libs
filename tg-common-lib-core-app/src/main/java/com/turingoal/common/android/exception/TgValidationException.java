package com.turingoal.common.android.exception;

/**
 * TgValidationException 数据校验异常
 */
public class TgValidationException extends Exception {
    private static final long serialVersionUID = 1L;

    public TgValidationException(final String errorMsg) {
        super(errorMsg);
    }
}
