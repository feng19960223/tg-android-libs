package com.turingoal.common.android.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 校验结果
 */
@Data
public class TgValidateResultBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success = true; // 校验结果，true
    private String msg = "校验成功"; // 结果信息
    private String fieldName; // 字段名

    public TgValidateResultBean() {
        this.success = true;
    }

    public TgValidateResultBean(final String message) {
        this.success = false;
        this.msg = message;
    }

    public TgValidateResultBean(final String fineldName, final String message) {
        this.success = false;
        this.fieldName = fineldName;
        this.msg = message;
    }
}
