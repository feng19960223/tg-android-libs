package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantTrainSetLengthTypes;
import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.common.android.constants.TgConstantStaffTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * [车组]
 */
@Data
public class TrainSet {
    private String id; // 车组
    private String codeNum; // 车组编号
    private Integer trainSetType; // 类型 1动车 2机车
    private String trainSetModel; // 车型
    private Integer trainSetLengthType; // 编组类型 1短编组 2长编组
    private Integer trainSetStaffType; // 编制 1编内 2编外
    private Date productionDate; // 生产日期
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
     * 获得编组类型名称
     */
    public String getTrainSetLengthTypeStr() {
        return ConstantTrainSetLengthTypes.getStr(trainSetLengthType);
    }

    /**
     * 获得编组类型名称
     */
    public String getTrainSetLengthTypeShortStr() {
        return ConstantTrainSetLengthTypes.getShortStr(trainSetLengthType);
    }

    /**
     * 获得编制类型名称
     */
    public String getTrainSetStaffTypeStr() {
        return TgConstantStaffTypes.getStr(trainSetStaffType);
    }

    /**
     * 获得编制类型名称
     */
    public String getTrainSetStaffTypeShortStr() {
        return TgConstantStaffTypes.getShortStr(trainSetStaffType);
    }

    /**
     * 生产日期
     */
    public String getProductionDateStr() {
        return TgDateUtil.date2String(productionDate);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }
}