package com.turingoal.common.android.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 排序
 */
@Data
public class TgSqlSortBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String property; // 排序字段
    private String direction; // 排序方式 大写的ASC or DESC
}
