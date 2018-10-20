package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantTrainSetLengthTypes;

import java.util.Date;

import lombok.Data;

/**
 * 监控
 */
@Data
public class WorkMonitorItem {
    private String trackCodeNum; // 股道编号
    private String trainSetCodeNum1; // 1列位车号
    private String trainSetCodeNum2; // 2列位车号
    private Integer trainSetLengthType2; // 2列位编组类型：1短编组，2长编组
    private Date arriveTime1; // 1列位进站时间
    private Date arriveTime2; // 2列位进站时间
    private Date startTime1; // 1列位作业开始时间
    private Date startTime2; // 2列位作业开始时间
    private Date electrolesStartTime1; // 1列位无电作业开始时间
    private Date electrolesStartTime2; // 2列位无电作业开始时间
    private Date electrolesEndTime1; // 1列位无电作业结束时间
    private Date electrolesEndTime2; // 2列位无电作业结束时间
    private Date electricalStartTime1; // 1列位有电作业开始时间
    private Date electricalStartTime2; // 2列位有电作业开始时间
    private Date electricalEndTime1; // 2列位有电作业结束时间
    private Date electricalEndTime2; // 2列位有电作业结束时间
    private String workUserA1Row1; // workUserA1
    private String workUserA2Row1; // workUserA2
    private String workUserA3Row1; // workUserA3
    private String workUserA4Row1; // workUserA4
    private String workUserB1Row1; // workUserB1
    private String workUserB2Row1; // workUserB2
    private String workUserB3Row1; // workUserB3
    private String workUserB4Row1; // workUserB4
    private String workUserA1NameRow1; // workUserA1
    private String workUserA2NameRow1; // workUserA2
    private String workUserA3NameRow1; // workUserA3
    private String workUserA4NameRow1; // workUserA4
    private String workUserB1NameRow1; // workUserB1
    private String workUserB2NameRow1; // workUserB2
    private String workUserB3NameRow1; // workUserB3
    private String workUserB4NameRow1; // workUserB4

    private String workUserA1Row2; // workUserA1
    private String workUserA2Row2; // workUserA2
    private String workUserA3Row2; // workUserA3
    private String workUserA4Row2; // workUserA4
    private String workUserA1NameRow2; // workUserA1
    private String workUserA2NameRow2; // workUserA2
    private String workUserA3NameRow2; // workUserA3
    private String workUserA4NameRow2; // workUserA4

    private String taskStatus1; // 1列位状态
    private String taskStatus2; // 2列位状态

    /**
     * 获得编组类型名称
     */
    public String getTrainSetLengthType2Str() {
        return ConstantTrainSetLengthTypes.getStr(trainSetLengthType2);
    }

    /**
     * 获得编组类型名称
     */
    public String getTrainSetLengthType2ShortStr() {
        return ConstantTrainSetLengthTypes.getShortStr(trainSetLengthType2);
    }
}