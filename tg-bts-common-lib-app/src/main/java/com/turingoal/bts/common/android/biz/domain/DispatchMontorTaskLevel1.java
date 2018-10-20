package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * [一级修派工任务]
 */
@Data
public class DispatchMontorTaskLevel1 {
    private String id; // 总任务
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
    private String workUserA1Status; // workUserA1Status
    private String workUserA2Status; // workUserA2Status
    private String workUserA3Status; // workUserA3Status
    private String workUserA4Status; // workUserA4Status
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
    private String workUserB1Status; // workUserB1Status
    private String workUserB2Status; // workUserB2Status
    private String workUserB3Status; // workUserB3Status
    private String workUserB4Status; // workUserB4Status
    private String createUserId; // 任务创建人
    private String createUserUsername; // 任务创建人
    private String createUserRealname; // 任务创建人
    private Date createTime; // 创建时间
    private Integer electricType; // 有电作业 无电作业
    private String schedulingOrderNum; // 调度任务单号
    private String schedulingTaskGroupCodeNum; // 调度总任务组单号
    private String schedulingTaskGeneralCodeNum; // 调度总任务单号
    private String schedulingTaskCodeNum; // 调度任务编码

    /**
     * 创建时间
     */
    public String getCreateTimeStr() {
        return TgDateUtil.dateTime2String(createTime);
    }

    /**
     * 创建时间
     */
    public String getCreateTimeShortStr() {
        return TgDateUtil.time2String(createTime);
    }
}