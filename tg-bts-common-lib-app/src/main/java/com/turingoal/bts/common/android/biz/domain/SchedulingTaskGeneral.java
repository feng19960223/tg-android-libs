package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantLocomotiveMaintenanceLevels;
import com.turingoal.bts.common.android.constants.ConstantMontorMaintenanceLevels;
import com.turingoal.bts.common.android.constants.ConstantTrainSetLengthTypes;
import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.bts.common.android.constants.ConstantWorkShiftTypes;
import com.turingoal.common.android.constants.TgConstantStaffTypes;
import com.turingoal.common.android.constants.TgConstantTaskStatus;
import com.turingoal.common.android.constants.TgConstantYesNo;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * [调度总任务] 如：一级修 包括无电作业和有电作业
 */
@Data
public class SchedulingTaskGeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 调度任务
    private String codeNum; // 调度任务单号
    private Date taskDate; // 任务日期
    private Integer workShiftType; // 班次类型
    private String trackCodeNum; // 股道编号
    private Integer trackRowNum; // 列位
    private String trackCodeNumMatch; // 联检股道编号
    private Integer trackRowNumMatch; // 联检股道列位
    private Integer trainSetType; // 车组类型
    private String trainSetModel; // 车型
    private String trainSetCodeNum; // 车号
    private String trainFrequencyIn; // 入所车次
    private String trainFrequencyOut; // 出所车次
    private Integer trainSetStaffType = TgConstantStaffTypes.INTERNAL; // 编制 1编内 2编外
    private Integer trainSetLengthType; // 编组类型 1短编组 2长编组
    private Date arriveTime; // 进站时间
    private Date outboundTime; // 出站时间
    private String maintenanceLevelCodeNum; // 修程编码
    private String maintenanceTask; // 检修任务
    private String workGroupCodeNum; // 检修班组编码
    private String workGroupName; // 检修班组名称
    private Integer dispatchStatus; // 派工状态：1 已派工 2未派工
    private Integer status; // 状态
    private Date schedulingPlanStartTime; // 调度计划任务开始时间
    private Date schedulingPlanFinishTime; // 调度计划任务结束时间
    private Date startTime; // 开始时间
    private Date finishTime; // 结束时间
    private String orgCodeNum; // 组织机构编码
    private String schedulingOrderNum; // 调度任务单号
    private String schedulingTaskGroupCodeNum; // 调度总任务组单号
    private List<SchedulingTask> tasksList; // 任务
    private String sortOrder; // 排序

    /**
     * 车组类型
     */
    public String getTrainSetTypeStr() {
        return ConstantTrainSetTypes.getStr(trainSetType);
    }

    /**
     * 车组类型
     */
    public String getTrainSetTypeShortStr() {
        return ConstantTrainSetTypes.getShortStr(trainSetType);
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
     * 调度计划任务开始时间
     */
    public String getSchedulingPlanStartTimeStr() {
        return TgDateUtil.dateTime2String(schedulingPlanStartTime);
    }

    /**
     * 调度计划任务开始时间
     */
    public String getSchedulingPlanStartTimeShortStr() {
        return TgDateUtil.time2String(schedulingPlanStartTime);
    }

    /**
     * 调度计划任务结束时间
     */
    public String getSchedulingPlanFinishTimeStr() {
        return TgDateUtil.dateTime2String(schedulingPlanFinishTime);
    }

    /**
     * 调度计划任务结束时间
     */
    public String getSchedulingPlanFinishTimeShortStr() {
        return TgDateUtil.time2String(schedulingPlanFinishTime);
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
     * 获得派工状态名称
     */
    public String getDispatchStatusStr() {
        return TgConstantYesNo.getStr(dispatchStatus);
    }

    /**
     * 获得状态名称
     */
    public String getStatusStr() {
        return TgConstantTaskStatus.getStr(status);
    }
}