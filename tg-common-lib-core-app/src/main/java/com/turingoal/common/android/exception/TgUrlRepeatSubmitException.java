package com.turingoal.common.android.exception;

/**
 * url重复请求异常
 */
public class TgUrlRepeatSubmitException extends Exception {
    private static final long serialVersionUID = 1L;

    public TgUrlRepeatSubmitException() {
        super("请不要重复提交请求！");
    }
}
