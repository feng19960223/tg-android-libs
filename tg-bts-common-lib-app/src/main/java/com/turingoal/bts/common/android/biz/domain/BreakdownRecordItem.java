package com.turingoal.bts.common.android.biz.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * [故障记录条目]
 */
@Data
public class BreakdownRecordItem {
    private String id; // id
    private String source; // 故障来源
    private Date taskDate; // 作业日期
    private Integer workShiftType; // 班次类型
    private String trainFrequency; // 车次
    private String trainSetCodeNum; // 车组
    private String carriage; // 车厢号
    private String systemType; // 故障类型
    private String pattern; // 故障模式
    private String breakdownCode; // 故障代码
    private String description; // 故障描述
    private String reason; // 故障原因
    private Date discoveryTime; // 发现时间
    private Integer indexNum; // 序号，这是第几个故障
    private Date createTime;  // 创建时间
    private String createUserId; // 创建用户id
    private String createUserUsername; // 创建用户名
    private String createUserCodeNum; // 创建用户工号
    private String createUserRealname; // 创建用户姓名
    private String breakdownRecordId; // 故障记录id
    // 派工
    private String dispatchUserId; // 派工人id
    private String dispatchUserUsername; // 派工人用户名
    private String dispatchUserCodeNum; // 派工人工号
    private String dispatchUserRealname; // 派工人真实姓名
    private Date dispatchTime; // 派工时间
    private Integer dispatchStatus; // 派工状态
    private String dispatchDesc; // 派工描述
    private Date dispatchPlanStartTime; // 派工计划开始时间
    private Date dispatchPlanFinishTime; // 派工计划完成时间
    // 处理
    private String handlerGroupCodeNum;  // 处理班组编号
    private String handlerGroupName;  // 处理班组名称
    private String handlerUserId; // 处理人id
    private String handlerUserUsername; // 处理人用户名
    private String handlerUserCodeNum; // 处理人工号
    private String handlerUserRealname; // 处理人真实姓名
    private Date handlingStartTime; // 处理开始时间
    private Date handlingFinishTime; // 处理完成时间
    private String handlingStatus; // 处理结果
    private String handlingDesc; // 处理描述
    private Date followUpDate; // 引继日期
    private String fittingsReplaceDesc; // 配件更换情况
    // 质检
    private String qcUserId; // 质检人id
    private String qcUserUsername; // 质检人用户名
    private String qcUserCodeNum; // 质检人工号
    private String qcUserRealname; // 质检人真实姓名
    private Date qcStartTime; // 质检开始时间
    private Date qcFinishTime; // 质检完成时间
    private String qcResult; // 质检结果
    private String qcDesc; // 质检描述
    // 其它
    private String remarks; // 备注
    private List<String> filePaths; // 文件
    private String schedulingOrderNum; // 调度任务总单号
    private String schedulingTaskGroupCodeNum; // 调度总任务组单号
    private String schedulingTaskGeneralCodeNum; // 调度总任务单号
    private String schedulingTaskCodeNum; // 调度任务编码
}