package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantLocomotiveMaintenanceLevels;
import com.turingoal.bts.common.android.constants.ConstantMontorMaintenanceLevels;
import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;

import lombok.Data;

/**
 * [检修任务]
 */
@Data
public class MaintenanceTask {
    private String id; // 检修任务
    private String codeNum; // 编码
    private String title; // 名称
    private Integer trainSetType; // 类型 1动车 2机车
    private String maintenanceLevelCodeNum; // 修程：1 一级修 2 二级修
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
     * 修程
     */
    public String getMaintenanceLevelStr() {
        if (trainSetType == ConstantTrainSetTypes.MONTOR) {
            return ConstantMontorMaintenanceLevels.getStr(maintenanceLevelCodeNum);
        } else {
            return ConstantLocomotiveMaintenanceLevels.getStr(maintenanceLevelCodeNum);
        }
    }

    /**
     * 修程
     */
    public String getMaintenanceLevelShortStr() {
        if (trainSetType == ConstantTrainSetTypes.MONTOR) {
            return ConstantMontorMaintenanceLevels.getShortStr(maintenanceLevelCodeNum);
        } else {
            return ConstantLocomotiveMaintenanceLevels.getShortStr(maintenanceLevelCodeNum);
        }
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }
}