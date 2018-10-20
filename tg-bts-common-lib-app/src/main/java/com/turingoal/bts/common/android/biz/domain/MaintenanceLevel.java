package com.turingoal.bts.common.android.biz.domain;


import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;

import java.io.Serializable;

import lombok.Data;

/**
 * [修程]
 */
@Data
public class MaintenanceLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 修程
    private Integer trainSetType; // 类型 1动车 2机车
    private String codeNum; // 编码
    private String title; // 名称
    private String description; // 描述
    private Integer sortOrder; // 排序
    private Integer enabled; // 是否可用

    /**
     * 车组类型
     */
    public String getTrainSetTypeStr() {
        return ConstantTrainSetTypes.getStr(trainSetType);
    }

    /**
     * 车组类型
     */
    public String getTrainSetTypeShortStr() {
        return ConstantTrainSetTypes.getShortStr(trainSetType);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }
}