package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantWorkShiftTypes;

import lombok.Data;

/**
 * [一级修派工任务默认配置]
 */
@Data
public class DispatchMontorTaskLevel1Default {
    private String id; // id
    private Integer workShiftType; // 班次类型
    private String trainSetModel; // 车型
    private String workUserA1; // workUserA1
    private String workUserA2; // workUserA2
    private String workUserA3; // workUserA3
    private String workUserA4; // workUserA4
    private String workUserA1Username; // workUserA1
    private String workUserA2Username; // workUserA2
    private String workUserA3Username; // workUserA3
    private String workUserA4Username; // workUserA4
    private String workUserA1Realname; // workUserA1
    private String workUserA2Realname; // workUserA2
    private String workUserA3Realname; // workUserA3
    private String workUserA4Realname; // workUserA4
    private String workUserB1; // workUserB1
    private String workUserB2; // workUserB2
    private String workUserB3; // workUserB3
    private String workUserB4; // workUserB4
    private String workUserB1Username; // workUserB1
    private String workUserB2Username; // workUserB2
    private String workUserB3Username; // workUserB3
    private String workUserB4Username; // workUserB4
    private String workUserB1Realname; // workUserB1
    private String workUserB2Realname; // workUserB2
    private String workUserB3Realname; // workUserB3
    private String workUserB4Realname; // workUserB4

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