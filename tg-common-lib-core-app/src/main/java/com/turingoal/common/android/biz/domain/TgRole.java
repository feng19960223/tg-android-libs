package com.turingoal.common.android.biz.domain;

import com.turingoal.common.android.constants.TgConstantSystemDominTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;

import java.io.Serializable;

import lombok.Data;

/**
 * [角色]
 */
@Data
public class TgRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 角色表
    private String codeNum; // 编码
    private String roleName; // 角色名称
    private String description; // 描述
    private Integer sortOrder = 1; // 排序
    private Integer editable = TgConstantYesNo.YES; // 是否可编辑
    private Integer deletable = TgConstantYesNo.YES; // 是否可删除
    private Integer enabled = TgConstantYesNo.YES; // 是否可用
    // 扩展属性
    private Boolean checked; // 是否选中。用对象类型转json是为null不输出
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