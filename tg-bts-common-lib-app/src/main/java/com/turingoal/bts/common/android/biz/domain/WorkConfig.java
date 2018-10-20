package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantMontorMaintenanceLevels;
import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;

import lombok.Data;

/**
 * [作业配置]
 */
@Data
public class WorkConfig {
    private String id; // 作业配置
    private Integer trainSetType; // 车组类型
    private String maintenanceLevelCodeNum; // 修程：1 一级修 2 二级修
    private String maintenanceTask; // 检修任务
    private String trainSetModel; // 车型
    private Integer workTeam; // 作业队，长编组相当于两个队同时做
    private String workNum; // 编号
    private String workItem; // 作业点
    private String workDesc; // 作业内容
    private String carriage; // 车厢
    private Integer electricalType; // 1有电 2无电
    private String standardImgPath; // 标准图片
    private Integer weight; // 权重
    private Integer step; // 步骤
    private Integer enabled = 1; // 是否可用

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
        return ConstantMontorMaintenanceLevels.getStr(maintenanceLevelCodeNum);
    }

    /**
     * 修程
     */
    public String getMaintenanceLevelShortStr() {
        return ConstantMontorMaintenanceLevels.getShortStr(maintenanceLevelCodeNum);
    }

    /**
     * 有电无电类型名称
     */
    public String getElectricalTypeStr() {
        return TgConstantYesNo.getStr4Have(electricalType);
    }

    /**
     * 有电无电类型名称
     */
    public String getElectricalTypeShortStr() {
        return TgConstantYesNo.getStr4Have(electricalType);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }
}