package com.turingoal.common.android.biz.domain;

import com.turingoal.common.android.constants.TgConstantYesNo;

import java.io.Serializable;

import lombok.Data;

/**
 * [数据字典]
 */
@Data
public class TgDict implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 数据字典
    private String codeNum; // 编码
    private String dictType; // 字典类型
    private String dictName; // 字典名称
    private String dictValue; // 字典值
    private String description; // 描述
    private Integer sortOrder = 1; // 排序
    private Integer editable = TgConstantYesNo.YES; // 是否可编辑
    private Integer deletable = TgConstantYesNo.YES; // 是否可删除
    private Integer enabled = TgConstantYesNo.YES; // 是否可用

    /**
     * 是否可编辑
     */
    public String getEditableStr() {
        return TgConstantYesNo.getStr(editable);
    }

    /**
     * 是否可删除
     */
    public String getDeletableStr() {
        return TgConstantYesNo.getStr(deletable);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }
}