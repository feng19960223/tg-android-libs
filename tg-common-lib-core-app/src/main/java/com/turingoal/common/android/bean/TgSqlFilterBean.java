package com.turingoal.common.android.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 过滤条件
 */
@Data
public class TgSqlFilterBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String property; // 属性
    private String operator; // 操作方式
    private Object value; // 值
}