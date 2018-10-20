package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantLocomotiveWorkGroupTypes;
import com.turingoal.bts.common.android.constants.ConstantMontorWorkGroupTypes;
import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.common.android.constants.TgConstantStaffTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;

import lombok.Data;

/**
 * [检修班组]
 */
@Data
public class WorkGroup {
    private String id; // 检修班组
    private String codeNum; // 编码
    private String title; // 单位名称
    private Integer trainSetType; // 类型 1动车 2机车
    private String groupTypeCodeNum; // 班组类型编码
    private Integer staffType; // 编制 1编内 2编外
    private String contactPersonId; // 联系人id
    private String contactPersonUsername; // 联系人用户名
    private String contactPersonRealname; // 联系人真实姓名
    private String contactPhone; // 联系电话
    private String contactEmail; // 联系邮箱
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
     * 班组类型
     */
    public String getGroupTypeStr() {
        if (trainSetType == ConstantTrainSetTypes.MONTOR) {
            return ConstantMontorWorkGroupTypes.getStr(groupTypeCodeNum);
        } else {
            return ConstantLocomotiveWorkGroupTypes.getStr(groupTypeCodeNum);
        }
    }
    /**
     * 获得编制类型名称
     */
    public String getStaffTypeStr() {
        return TgConstantStaffTypes.getStr(staffType);
    }

    /**
     * 获得编制类型名称
     */
    public String getStaffTypeShortStr() {
        return TgConstantStaffTypes.getShortStr(staffType);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }
}