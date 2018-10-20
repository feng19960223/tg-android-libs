package com.turingoal.bts.common.android.biz.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * [故障记录]
 */
@Data
public class BreakdownRecord {
    private String id; // id
    private String source; // 故障来源
    private Date taskDate; // 日期
    private Integer workShiftType; // 班次类型
    private String trainFrequency; // 车次
    private String trainSetCodeNum; // 车组
    private Date createTime;  // 创建时间
    private String workGroupCodeNum;  // 检修班组编号
    private String workGroupName;  // 检修班组名称
    private String createUserId; // 创建用户id
    private String createUserUsername; // 创建用户名
    private String createUserCodeNum; // 创建用户工号
    private String createUserRealname; // 创建用户姓名
    private List<BreakdownRecordItem> breakdownRecordItems; // 故障记录项
    private String schedulingOrderNum; // 调度任务单号
    private String schedulingTaskGroupCodeNum; // 调度总任务组单号
    private String schedulingTaskGeneralCodeNum; // 调度总任务单号
    private String schedulingTaskCodeNum; // 调度任务编码
}