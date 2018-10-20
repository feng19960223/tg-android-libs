package com.turingoal.common.android.support.workflow;

import com.turingoal.common.android.bean.TgBaseFormBean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 工作流业务
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class TgBaseWorkflowFormBean extends TgBaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    // 流程信息
    private String processInstanceId; // 流程id
    private String bizType; // 业务类型
    private String createUserId; // 创建人
    private String createUsername; // 创建人
    private String createUserRealname; // 创建人姓名
    private Date createTime; // 创建时间
    private Date startTime; // 开始时间
    private Date endTime; // 结束时间
    private Integer aduitStatus = TgConstantWorkflowAduitStatus.WAIT; // 审核状态
    private Integer betweenHoursLimit = 24; // 处理限制时间，默认24小时
    // 当前环节信息
    private String processCurrentTask; // 流程当前环节
    private String processCurrentTaskName; // 流程当前环节
    private Date processCurrentTaskStartTime; // 流程当前环节开始时间
    private String assigneeOrgCodeNum; // 指定部门
    private String assigneePostCodeNum; // 指定职务
    private String assigneeUsername; // 指定人
    private String assigneeRealname; // 指定人
    private Integer dealType; // 处理方式：1通过 2驳回
    private String dealRemarks; // 处理备注

    /**
     * 设置指定信息
     */
    public void setAssignInfo(final String deptCodeNumParm, final String postCodeNumParm, final String usernameParm, final String realnameParm) {
        this.setAssigneeOrgCodeNum(deptCodeNumParm); // 指定部门
        this.setAssigneePostCodeNum(postCodeNumParm); // 指定职务
        this.setAssigneeUsername(usernameParm); // 指定人
        this.setAssigneeRealname(realnameParm); // 指定人
    }

    /**
     * 驳回修改
     */
    public void setAduitReject(final String assigneeIdParm, final String assigneeUsernameParm, final String assigneeRealnameParm) {
        setAssignInfo(null, null, assigneeUsernameParm, assigneeRealnameParm); // 设置指定信息
        setProcessCurrentTask("rejectToEdit"); // 当前环节
        setProcessCurrentTaskName("驳回修改"); // 当前环节
        setProcessCurrentTaskStartTime(new Date()); // 当前任务开始时间
        setAduitStatus(TgConstantWorkflowAduitStatus.NO); // 驳回
    }

    /**
     * 审核开始
     */
    public void setAduitStart(final String processCurrentTaskParm, final String processCurrentTaskNameParm) {
        setProcessCurrentTask(processCurrentTaskParm); // 当前环节
        setProcessCurrentTaskName(processCurrentTaskNameParm); // 当前环节
        setProcessCurrentTaskStartTime(new Date()); // 当前任务开始时间
        setAduitStatus(TgConstantWorkflowAduitStatus.PROCESS); // 审核中
        setDealType(TgConstantWorkflowDealTypes.SUBMIT); // 处理方式，提交
    }

    /**
     * 审核中
     */
    public void setAduiting(final String processCurrentTaskParm, final String processCurrentTaskNameParm) {
        setProcessCurrentTask(processCurrentTaskParm); // 当前环节
        setProcessCurrentTaskName(processCurrentTaskNameParm); // 当前环节
        setProcessCurrentTaskStartTime(new Date()); // 当前任务开始时间
        setAduitStatus(TgConstantWorkflowAduitStatus.PROCESS); // 审核中
        setDealType(TgConstantWorkflowDealTypes.YES); // 处理方式，通过
    }

    /**
     * 审核完成
     */
    public void setAduitFinished() {
        setAssignInfo(null, null, null, null); // 设置指定信息
        setProcessCurrentTask("---"); // 当前环节
        setProcessCurrentTaskName("---"); // 当前环节
        setProcessCurrentTaskStartTime(new Date()); // 当前任务开始时间
        setAduitStatus(TgConstantWorkflowAduitStatus.YES); // 审核通过
    }
}