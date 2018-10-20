package com.turingoal.common.android.biz.domain;

import com.turingoal.common.android.constants.TgConstantYesNo;

import java.io.Serializable;

import lombok.Data;

/**
 * [自定义字段]
 */
@Data
public class TgCustomField implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 自定义字段
    private String codeNum; // 编码
    private Integer fieldType; // 输入类型
    private String fieldLabel; // 字段标签
    private String fieldPrompt; // 提示信息
    private String fieldDefaultValue; // 默认值
    private String fieldRegex; // 正则表达式
    private Integer fieldRequired; // 是否必填项
    private Integer fieldMaxLength; // 最大长度
    private Integer fieldMinLength; // 最小长度
    private Integer fieldMaxValue; // 最大值
    private Integer fieldMinValue; // 最小值
    private String dateFormat; // 日期格式
    private String checkboxOptions; // 可选项
    private Integer imgWidth; // 图片宽度
    private Integer imgHeight; // 图片高度
    private Integer imgCompress; // 图片压缩
    private Integer imgExtrude; // 图片拉伸
    private Integer imgWatermark; // 添加水印
    private Integer newline; // 是否独占一行
    private Integer sortOrder; // 顺序
    private Integer editable; // 是否可编辑
    private Integer deletable; // 是否可删除
    private Integer enabled; // 是否可用
    private String ownerType; // ownerType
    private String ownerId; // ownerId

    private String value; // 值
    private java.util.Date valueForDate; // 值-日期

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