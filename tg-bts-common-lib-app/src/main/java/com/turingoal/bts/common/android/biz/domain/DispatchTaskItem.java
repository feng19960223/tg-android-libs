package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantDispatchTaskTypes;
import com.turingoal.bts.common.android.constants.ConstantLocomotiveMaintenanceLevels;
import com.turingoal.bts.common.android.constants.ConstantLocomotiveWorkGroupTypes;
import com.turingoal.bts.common.android.constants.ConstantMontorMaintenanceLevels;
import com.turingoal.bts.common.android.constants.ConstantMontorWorkGroupTypes;
import com.turingoal.bts.common.android.constants.ConstantStatus4Work;
import com.turingoal.bts.common.android.constants.ConstantTrainSetLengthTypes;
import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.bts.common.android.constants.ConstantWorkShiftTypes;
import com.turingoal.common.android.constants.TgConstantStaffTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * [派工任务项]
 */
@Data
public class DispatchTaskItem {
    private String id; // 调度任务
    private Date taskDate; // 任务日期
    private Integer workShiftType; // 班次类型
    private Integer dispatchTaskType; // 调度派工，故障派工
    private String trackCodeNum; // 股道编号
    private Integer trackRowNum; // 列位
    private String trainSetCodeNum; // 车号
    private String trainFrequencyIn; // 入所车次
    private String trainFrequencyOut; // 出所车次
    private String trainSetModel; // 车型
    private Integer trainSetStaffType = TgConstantStaffTypes.INTERNAL; // 编制 1编内 2编外
    private Integer trainSetLengthType; // 编组类型 1短编组 2长编组
    private Date arriveTime; // 进站时间
    private Date outboundTime; // 出站时间
    private Integer trainSetType; // 类型 1动车 2机车
    private String maintenanceLevelCodeNum; // 修程：1 一级修 2 二级修
    private String maintenanceTask; // 检修任务
    private String maintenanceTaskItem; // 检修任务作业项目
    private String workGroupCodeNum; // 检修班组id
    private String workGroupName; // 检修班组名称
    // private Integer workTeamType; // 作业小组, 如 A
    // private Integer workNum; // 作业编号, 如1
    private String workNum; // 作业编号, 如A1
    private String workUserId; // 作业员id
    private String workUserUsername; // 作业员用户名
    private String workUserRealname; // 作业员真实姓名
    private String breakdownId; // 故障id
    private String status; // 状态
    private Date dispatchPlanStartTime; // 派工计划任务开始时间
    private Date dispatchPlanFinishTime; // 派工计划任务结束时间
    private Integer acceptStatus; // 接受状态
    private Date acceptTime; // 接受时间
    private Date startTime; // 任务开始时间
    private Date finishTime; // 任务结束时间
    private Integer step; // 步骤
    private Integer evaluateResult; // 评价结果：1合格，2不合格
    private Double score; // 打分
    private String schedulingOrderNum; // 调度任务单号
    private String schedulingTaskGroupCodeNum; // 调度总任务组单号
    private String schedulingTaskGeneralCodeNum; // 调度总任务单号
    private String schedulingTaskCodeNum; // 调度任务编码

    /**
     * 车组类型
     */
    public String getTrainSetTypeStr() {
        return ConstantTrainSetLengthTypes.getStr(trainSetType);
    }

    /**
     * 车组类型
     */
    public String getTrainSetTypeShortStr() {
        return ConstantTrainSetTypes.getShortStr(trainSetType);
    }

    /**
     * 班组类型
     */
    public String getWorkGroupTypeStr() {
        if (trainSetType == ConstantTrainSetTypes.MONTOR) {
            return ConstantMontorWorkGroupTypes.getStr(workGroupCodeNum);
        } else {
            return ConstantLocomotiveWorkGroupTypes.getStr(workGroupCodeNum);
        }
    }

    /**
     * 修程
     */
    public String getMaintenanceLevelStr() {
        if (trainSetType == ConstantTrainSetTypes.MONTOR) {
            return ConstantMontorMaintenanceLevels.getStr(maintenanceLevelCodeNum);
        } else {
            return ConstantLocomotiveMaintenanceLevels.getStr(maintenanceLevelCodeNum);
        }
    }

    /**
     * 修程
     */
    public String getMaintenanceLevelShortStr() {
        if (trainSetType == ConstantTrainSetTypes.MONTOR) {
            return ConstantMontorMaintenanceLevels.getShortStr(maintenanceLevelCodeNum);
        } else {
            return ConstantLocomotiveMaintenanceLevels.getShortStr(maintenanceLevelCodeNum);
        }
    }

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
     * 派工任务类型，调度派工，故障派工
     */
    public String getDispatchTaskTypeStr() {
        return ConstantDispatchTaskTypes.getStr(dispatchTaskType);
    }

    /**
     * 获得编制类型名称
     */
    public String getTrainSetStaffTypeStr() {
        return TgConstantStaffTypes.getStr(trainSetStaffType);
    }

    /**
     * 获得编制类型名称
     */
    public String getTrainSetStaffTypeShortStr() {
        return TgConstantStaffTypes.getShortStr(trainSetStaffType);
    }

    /**
     * 获得编组类型名称
     */
    public String getTrainSetLengthTypeStr() {
        return ConstantTrainSetLengthTypes.getStr(trainSetLengthType);
    }

    /**
     * 获得编组类型名称
     */
    public String getTrainSetLengthTypeShortStr() {
        return ConstantTrainSetLengthTypes.getShortStr(trainSetLengthType);
    }

    /**
     * 状态
     */
    public String getStatusStr() {
        return ConstantStatus4Work.getStr(status);
    }

    /**
     * 接受状态
     */
    public String getAcceptStatusStr() {
        return TgConstantYesNo.getStr(acceptStatus);
    }

    /**
     * 接受时间
     */
    public String getAcceptTimeStr() {
        return TgDateUtil.dateTime2String(acceptTime);
    }

    /**
     * 接受时间
     */
    public String getAcceptTimeShortStr() {
        return TgDateUtil.time2String(acceptTime);
    }

    /**
     * 进站时间
     */
    public String getArriveTimeStr() {
        return TgDateUtil.dateTime2String(arriveTime);
    }

    /**
     * 进站时间
     */
    public String getArriveTimeShortStr() {
        return TgDateUtil.time2String(arriveTime);
    }

    /**
     * 出站时间
     */
    public String getOutboundTimeStr() {
        return TgDateUtil.dateTime2String(outboundTime);
    }

    /**
     * 出站时间
     */
    public String getOutboundTimeShortStr() {
        return TgDateUtil.time2String(outboundTime);
    }

    /**
     * 派工计划任务开始时间
     */
    public String getDispatchPlanStartTimeStr() {
        return TgDateUtil.dateTime2String(dispatchPlanStartTime);
    }

    /**
     * 派工计划任务开始时间
     */
    public String getDispatchPlanStartTimeShortStr() {
        return TgDateUtil.time2String(dispatchPlanStartTime);
    }

    /**
     * 派工计划任务开始时间
     */
    public String getDispatchPlanFinishTimeStr() {
        return TgDateUtil.dateTime2String(dispatchPlanFinishTime);
    }

    /**
     * 派工计划任务开始时间
     */
    public String getDispatchPlanFinishTimeShortStr() {
        return TgDateUtil.time2String(dispatchPlanFinishTime);
    }

    /**
     * 任务开始时间
     */
    public String getStartTimeStr() {
        return TgDateUtil.dateTime2String(startTime);
    }

    /**
     * 任务开始时间
     */
    public String getStartTimeShortStr() {
        return TgDateUtil.time2String(startTime);
    }

    /**
     * 任务结束时间
     */
    public String getFinishTimeStr() {
        return TgDateUtil.dateTime2String(finishTime);
    }

    /**
     * 任务结束时间
     */
    public String getFinishTimeShortStr() {
        return TgDateUtil.time2String(finishTime);
    }

    /**
     * 评价结果
     */
    public String getEvaluateResultStr() {
        return TgConstantYesNo.getStr4Pass(evaluateResult);
    }
}