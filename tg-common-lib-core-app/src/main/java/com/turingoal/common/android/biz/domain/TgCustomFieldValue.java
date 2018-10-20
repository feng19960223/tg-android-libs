package com.turingoal.common.android.biz.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * [自定义字段值]
 */
@Data
public class TgCustomFieldValue implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 自定义字段值
    private String fieldDefinedId; // 字段定义id
    private String keyStr; // 名称
    private String valueStr; // 值
    private String ownerType; // 类型
    private String ownerId; // 外表id
}