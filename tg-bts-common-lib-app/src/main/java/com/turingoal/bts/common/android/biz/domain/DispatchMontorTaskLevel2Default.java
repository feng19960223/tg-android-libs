package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantWorkShiftTypes;

import lombok.Data;

/**
 * [二级修派工任务默认配置]配置
 */
@Data
public class DispatchMontorTaskLevel2Default {
    private String id; // id
    private Integer workShiftType; // 班次类型
    private String trainSetModel; // 车型
    // 司控组
    private Integer groupSpecialControlNeed = 2; // 是否需要司控组参与，默认 否
    private String workUserS1; // workUserS1
    private String workUserS2; // workUserS2
    private String workUserS3; // workUserS3
    private String workUserS4; // workUserS4
    private String workUserS1Username; // workUserS1
    private String workUserS2Username; // workUserS2
    private String workUserS3Username; // workUserS3
    private String workUserS4Username; // workUserS4
    private String workUserS1Realname; // workUserS1
    private String workUserS2Realname; // workUserS2
    private String workUserS3Realname; // workUserS3
    private String workUserS4Realname; // workUserS4
    // 电气组
    private Integer groupSpecialElectricNeed = 2; // 是否需要电气组参与，默认 否
    private String workUserD1; // workUserD1
    private String workUserD2; // workUserD2
    private String workUserD3; // workUserD3
    private String workUserD4; // workUserD4
    private String workUserD1Username; // workUserD1
    private String workUserD2Username; // workUserD2
    private String workUserD3Username; // workUserD3
    private String workUserD4Username; // workUserD4
    private String workUserD1Realname; // workUserD1
    private String workUserD2Realname; // workUserD2
    private String workUserD3Realname; // workUserD3
    private String workUserD4Realname; // workUserD4
    // 客服组
    private Integer groupSpeciaServiceNeed = 2; // 是否需要客服组参与，默认 否
    private String workUserC1; // workUserC1
    private String workUserC2; // workUserC2
    private String workUserC3; // workUserC3
    private String workUserC4; // workUserC4
    private String workUserC1Username; // workUserC1
    private String workUserC2Username; // workUserC2
    private String workUserC3Username; // workUserC3
    private String workUserC4Username; // workUserC4
    private String workUserC1Realname; // workUserC1
    private String workUserC2Realname; // workUserC2
    private String workUserC3Realname; // workUserC3
    private String workUserC4Realname; // workUserC4
    // 行车组
    private Integer groupSpeciaDrivingNeed = 2; // 是否需要行车组参与，默认 否
    private String workUserZ1; // workUserZ1
    private String workUserZ2; // workUserZ2
    private String workUserZ3; // workUserZ3
    private String workUserZ4; // workUserZ4
    private String workUserZ5; // workUserZ5
    private String workUserZ6; // workUserZ6
    private String workUserZ7; // workUserZ7
    private String workUserZ8; // workUserZ8
    private String workUserZ1Username; // workUserZ1
    private String workUserZ2Username; // workUserZ2
    private String workUserZ3Username; // workUserZ3
    private String workUserZ4Username; // workUserZ4
    private String workUserZ5Username; // workUserZ5
    private String workUserZ6Username; // workUserZ6
    private String workUserZ7Username; // workUserZ7
    private String workUserZ8Username; // workUserZ8
    private String workUserZ1Realname; // workUserZ1
    private String workUserZ2Realname; // workUserZ2
    private String workUserZ3Realname; // workUserZ3
    private String workUserZ4Realname; // workUserZ4
    private String workUserZ5Realname; // workUserZ5
    private String workUserZ6Realname; // workUserZ6
    private String workUserZ7Realname; // workUserZ7
    private String workUserZ8Realname; // workUserZ8
    // 轮轴组
    private Integer groupWheelNeed = 2; // 是否需要轮轴组参与，默认 否
    // 地勤组
    private Integer groupGroundNeed = 2; // 是否需要地勤组参与，默认 否
    // 临修组
    private Integer groupTemporaryNeed = 2; // 是否需要临修组参与，默认 否
    // 外协组
    private Integer groupOutsourcingNeed = 2; // 是否需要外协组参与，默认 否

    /**
     * 获得班次类型名称
     */
    public String getWorkShiftTypeStr() {
        return ConstantWorkShiftTypes.getStr(workShiftType);
    }

    /**
     * 获得班次类型名称
     */
    public String getWorkShiftTypeShortStr() {
        return ConstantWorkShiftTypes.getShortStr(workShiftType);
    }
}