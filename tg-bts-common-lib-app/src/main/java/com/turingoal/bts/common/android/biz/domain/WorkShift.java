package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantWorkShiftTypes;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * [班次]
 */
@Data
public class WorkShift {
    private String workShiftName; // 班次名称
    private Integer workShiftType; // 类型
    private Date startTime; // 开始时间
    private Date endTime; // 结束时间

    public WorkShift(final String workShiftNameParm, final Integer workShiftTypeParm) {
        this.workShiftName = workShiftNameParm;
        this.workShiftType = workShiftTypeParm;
    }

    /**
     * 获得班次类型名称
     */
    public String getWorkShiftTypeStr() {
        return ConstantWorkShiftTypes.getStr(workShiftType);
    }

    /**
     * 获得班次类型名称缩写
     */
    public String getWorkShiftTypeShortStr() {
        return ConstantWorkShiftTypes.getShortStr(workShiftType);
    }

    /**
     * 开始时间字符串
     */
    public String getStartTimeStr() {
        return TgDateUtil.time2String(startTime);
    }

    /**
     * 结束时间字符串
     */
    public String getEndTimeStr() {
        return TgDateUtil.time2String(endTime);
    }
}