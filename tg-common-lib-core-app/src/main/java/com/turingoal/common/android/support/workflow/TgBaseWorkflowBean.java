package com.turingoal.common.android.support.workflow;

import com.turingoal.common.android.util.lang.TgDateUtil;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 工作流业务
 */
@Data
public abstract class TgBaseWorkflowBean implements Serializable {
    private static final long serialVersionUID = 1L;
    // 流程信息
    private String bizType; // 业务类型
    private String processInstanceId; // 流程id
    private String createUserId; // 创建人
    private String createUsername; // 创建人
    private String createUserRealname; // 创建人姓名
    private Date createTime; // 创建时间
    private Date startTime; // 开始时间
    private Date endTime; // 结束时间
    private Integer aduitStatus; // 审核结果：1通过 2不通过
    // 当前环节信息
    private String processCurrentTask; // 流程当前环节
    private String processCurrentTaskName; // 流程当前环节
    private Date processCurrentTaskStartTime; // 流程当前环节开始时间
    private String assigneeDept; // 指定部门
    private String assigneePost; // 指定职务
    private String assignee; // 指定人

    /**
     * 审核结果
     */
    public String getAduitStatusStr() {
        return TgConstantWorkflowAduitStatus.getStr(aduitStatus);
    }

    /**
     * 创建时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(createTime);
    }

    /**
     * 创建时间
     */
    public String getCreateTimeStr4Date() {
        return TgDateUtil.date2String(createTime);
    }

    /**
     * 开始时间
     */
    public String getStartTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(startTime);
    }

    /**
     * 开始时间
     */
    public String getStartTimeStr4Date() {
        return TgDateUtil.date2String(startTime);
    }

    /**
     * 结束时间
     */
    public String getEndTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(endTime);
    }

    /**
     * 结束时间
     */
    public String getEndTimeStr4Date() {
        return TgDateUtil.date2String(endTime);
    }

    /**
     * 流程当前环节开始时间
     */
    public String getProcessCurrentTaskStartTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(processCurrentTaskStartTime);
    }

    /**
     * 流程当前环节开始时间
     */
    public String getProcessCurrentTaskStartTimeStr4Date() {
        return TgDateUtil.date2String(processCurrentTaskStartTime);
    }
}