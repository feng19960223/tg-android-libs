package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.common.android.constants.TgConstantYesNo;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * 作业记录项
 */
@Data
public class WorkRecordItem {
    private String id; // 作业记录项
    private String workNum; // 编号
    private String workItem; // 作业项目
    private String workDesc; // 作业内容
    private String carriage; // 车厢
    private Integer electricalType; // 1有电 2无电
    private String standardImgPath; // 标准图片
    private String standardImgUrl; // 标准图片
    private String workImgPath; // 作业图片
    private String workImgUrl; // 作业图片
    private Integer step; // 步骤
    private Double compareResult; // 对比结果
    private Integer weight; // 权重
    private Double score; // 打分
    private String userId; // userId
    private Date startTime; // 开始时间
    private Date finishTime; // 完成时间
    private String workRecordId; // 作业记录Id

    /**
     * 有电无电类型名称
     */
    public String getElectricalTypeStr() {
        return TgConstantYesNo.getStr4Have(electricalType);
    }

    /**
     * 有电无电类型名称
     */
    public String getElectricalTypeShortStr() {
        return TgConstantYesNo.getStr4Have(electricalType);
    }

    /**
     * 开始时间
     */
    public String getStartTimeStr() {
        return TgDateUtil.dateTime2String(startTime);
    }

    /**
     * 开始时间
     */
    public String getStartTimeShortStr() {
        return TgDateUtil.time2String(startTime);
    }

    /**
     * 结束时间
     */
    public String getFinishTimeStr() {
        return TgDateUtil.dateTime2String(finishTime);
    }

    /**
     * 结束时间
     */
    public String getFinishTimeShortStr() {
        return TgDateUtil.time2String(finishTime);
    }
}