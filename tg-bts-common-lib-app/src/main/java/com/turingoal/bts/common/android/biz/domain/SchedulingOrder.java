package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantWorkShiftTypes;
import com.turingoal.common.android.support.workflow.TgConstantWorkflowAduitStatus;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * [调度任务总单]
 */
@Data
public class SchedulingOrder {
    private String id; // 调度任务总单
    private String codeNum; // 调度任务单号
    private Date taskDate; // 任务日期
    private Integer workShiftType; // 班次类型
    private String schedulingUserId; // 调度员id
    private String schedulingUserUsername; // 调度员用户名
    private String schedulingUserCodeNum; // 调度员工号
    private String schedulingUserRealname; // 调度员真实姓名
    private String keyBreakdownDesc; // 重点故障描述
    private String keyTasksDesc; // 重点任务描述
    private String keyAttentionDesc; // 注意事项
    private String editorId; // 编制人id
    private String editorUsername; // 编制人用户名
    private String editorCodeNum; // 编制人工号
    private String editorRealname; // 编制人真实姓名
    private String auditorId; // 审核人
    private String auditorUsername; // 审核人用户名
    private String auditorCodeNum; // 审核人工号
    private String auditorRealname; // 审核人真实姓名
    private String directorId; // 值班所长
    private String directorUsername; // 值班所长用户名
    private String directorCodeNum; // 值班所长工号
    private String directorRealname; // 值班所长真实姓名
    private Integer aduitStatus; // 审核状态
    private Integer status; // 状态
    private List<SchedulingTaskGroup> taskGroupsList; // 任务组
    private List<SchedulingTaskGeneral> taskGeneralsList; // 总任务
    private List<SchedulingTask> tasksList; // 任务

    /**
     * 任务日期
     */
    public String getTaskDateStr() {
        return TgDateUtil.date2String(taskDate);
    }

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

    /**
     * 审核状态
     */
    public String getAduitStatusStr() {
        return TgConstantWorkflowAduitStatus.getStr(aduitStatus);
    }
}