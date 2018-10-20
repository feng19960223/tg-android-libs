package com.turingoal.common.android.exception;

/**
 * DeleteException 删除异常
 */
public class TgDataDeleteException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TgDataDeleteException() {
        super();
    }

    public TgDataDeleteException(final String s) {
        super(s);
    }

    public TgDataDeleteException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TgDataDeleteException(final Throwable cause) {
        super(cause);
    }
}
