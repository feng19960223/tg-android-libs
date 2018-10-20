package com.turingoal.common.android.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 分组
 */
@Data
public class TgSqlGroupBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String property; // 分组字段
}
