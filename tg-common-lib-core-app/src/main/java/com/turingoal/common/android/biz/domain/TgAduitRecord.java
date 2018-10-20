package com.turingoal.common.android.biz.domain;

import com.turingoal.common.android.support.workflow.TgConstantWorkflowDealTypes;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * [审核记录]
 * <p>
 * 通用审核记录，通过bizType来区分。bizType在ConstantAduitBizTypes中定义。
 * </p>
 */
@Data
public class TgAduitRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 审核记录
    private String bizType; // 业务类型
    private String bizId; // 业务id
    private String bizCodeNum; // 业务编码
    private String taskCodeNum; // 任务节点编码
    private String taskName; // 任务节点名称
    private String aduitUserId; // 当前审核人
    private String aduitUserUsername; // 当前审核人用户名
    private String aduitUserRealname; // 当前审核人姓名
    private Integer aduitDealResult; // 审核结果：1通过 2不通过
    private Date startTime; // 开始时间
    private Date dealTime; // 审核时间
    private Long betweenHours; // 间隔时间
    private Integer aduitOvertimeStatus; // 审核超时状态
    private String dealRemarks; // 处理意见

    /**
     * 开始时间
     */
    public String getStartTimeStr4Date() {
        return TgDateUtil.date2String(startTime);
    }

    /**
     * 开始时间
     */
    public String getStartTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(startTime);
    }

    /**
     * 审核时间
     */
    public String getDealTimeStr4Date() {
        return TgDateUtil.date2String(dealTime);
    }

    /**
     * 审核时间
     */
    public String getDealTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(dealTime);
    }

    /**
     * 审核结果
     */
    public String getAduitDealResultStr() {
        return TgConstantWorkflowDealTypes.getStr(aduitDealResult);
    }
}