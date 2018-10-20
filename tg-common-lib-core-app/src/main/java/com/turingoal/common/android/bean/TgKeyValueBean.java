package com.turingoal.common.android.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 简单keyValue对象
 */
@Data
public class TgKeyValueBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String key;
    private Object value;

    public TgKeyValueBean() {
        super();
    }

    public TgKeyValueBean(final String k, final Object v) {
        this.key = k;
        this.value = v;
    }

    /**
     * 得到String
     */
    public String getStringValue() {
        if (value != null) {
            return (String) value;
        } else {
            return null;
        }
    }

    /**
     * 得到Integer
     */
    public Integer getIntegerValue() {
        if (value != null) {
            return (Integer) value;
        } else {
            return null;
        }
    }

    /**
     * 得到Long
     */
    public Long getLongValue() {
        if (value != null) {
            return (Long) value;
        } else {
            return null;
        }
    }

    /**
     * 得到Float
     */
    public Float getFloatValue() {
        if (value != null) {
            return (Float) value;
        } else {
            return null;
        }
    }

    /**
     * 得到Double
     */
    public Double getDoubleValue() {
        if (value != null) {
            return (Double) value;
        } else {
            return null;
        }
    }
}
