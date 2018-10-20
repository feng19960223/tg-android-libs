package com.turingoal.common.android.biz.domain;

import com.turingoal.common.android.constants.TgConstantSystemDominTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;

import java.io.Serializable;

import lombok.Data;

/**
 * [快捷方式]
 */
@Data
public class TgShortcut implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 快捷方式
    private String codeNum; // 编码
    private String title; // 名称
    private String icon; // 图标
    private String url; // 操作路径
    private String premission; // 所需权限
    private String description; // 描述
    private Integer sortOrder = 1; // 排序
    private Integer editable = TgConstantYesNo.YES; // 是否可编辑
    private Integer deletable = TgConstantYesNo.YES; // 是否可删除
    private Integer enabled = TgConstantYesNo.YES; // 是否可用

    // 权限域
    private String domainType = TgConstantSystemDominTypes.DEFAULT; // 权限域， 前台 fore、后台 admin、中台 manager，默认 default：不区分，可以自定义

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