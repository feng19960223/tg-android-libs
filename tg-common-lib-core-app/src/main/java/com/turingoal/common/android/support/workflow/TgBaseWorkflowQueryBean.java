package com.turingoal.common.android.support.workflow;

import com.turingoal.common.android.bean.TgBaseQueryBean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 工作流业务
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class TgBaseWorkflowQueryBean extends TgBaseQueryBean implements Serializable {
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
    private Integer aduitStatus; // 审核状态
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
}