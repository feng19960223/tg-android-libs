package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantTrackLengthTypes;
import com.turingoal.bts.common.android.constants.ConstantTrackOutTypes;
import com.turingoal.bts.common.android.constants.ConstantTrackTypes;
import com.turingoal.bts.common.android.constants.ConstantTrainSetLengthTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;
import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * [股道]
 */
@Data
public class Track {
    private String id; // 股道
    private String codeNum; // 股道编号
    private Integer workType; // 类型：1 检修股道，2 临修股道
    private Integer outType; // 出库方式：1、 1进1出 ， 2 、1进2出，即贯通股道
    private Integer lengthType; // 长度类型 ： 1 、短 ，即只有1个列位， 2、 长，即有两个列位
    private Integer statusRow1; // 1列位状态：1有车 2无车
    private Integer statusRow2; // 2列位状态：1有车 2无车
    private String trainSetCodeNumRow1; // 1列位车号
    private String trainSetCodeNumRow2; // 2列位车号
    private Date arriveTimeRow1; // 1列位进站时间
    private Date arriveTimeRow2; // 2列位进站时间
    private Date outboundTimeRow1; // 1列位出站时间
    private Date outboundTimeRow2; // 2列位出站时间
    private Integer trainSetLengthTypeRow2; // 2列位车号编组类型。先通过1列位，进入2列位，优先停2列位
    private String description; // 描述
    private Integer sortOrder; // 排序
    private Integer enabled; // 是否可用

    /**
     * 获得作业类型名称
     */
    public String getWorkTypeStr() {
        return ConstantTrackTypes.getStr(workType);
    }

    /**
     * 出站方式
     */
    public String getOutTypeStr() {
        return ConstantTrackOutTypes.getStr(outType);
    }

    /**
     * 获得长度类型名称
     */
    public String getLengthTypeStr() {
        return ConstantTrackLengthTypes.getStr(lengthType);
    }

    /**
     * 获得长度类型名称
     */
    public String getLengthTypeShortStr() {
        return ConstantTrackLengthTypes.getShortStr(lengthType);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }

    /**
     * 1列位状态
     */
    public String getStatusRow1Str() {
        return TgConstantYesNo.getStr4Have(statusRow1);
    }

    /**
     * 2列位状态
     */
    public String getStatusRow2Str() {
        return TgConstantYesNo.getStr4Have(statusRow2);
    }

    /**
     * 1列位进站时间
     */
    public String getArriveTimeRow1Str() {
        return TgDateUtil.dateTime2String(arriveTimeRow1);
    }

    /**
     * 1列位进站时间
     */
    public String getArriveTimeRow1ShortStr() {
        return TgDateUtil.time2String(arriveTimeRow1);
    }

    /**
     * 2列位进站时间
     */
    public String getArriveTimeRow2Str() {
        return TgDateUtil.dateTime2String(arriveTimeRow2);
    }

    /**
     * 2列位进站时间
     */
    public String getArriveTimeRow2ShortStr() {
        return TgDateUtil.time2String(arriveTimeRow2);
    }

    /**
     * 1列位出站时间
     */
    public String getOutboundTimeRow1Str() {
        return TgDateUtil.dateTime2String(outboundTimeRow1);
    }

    /**
     * 1列位出站时间
     */
    public String getOutboundTimeRow1ShortStr() {
        return TgDateUtil.time2String(outboundTimeRow1);
    }

    /**
     * 2列位出站时间
     */
    public String getOutboundTimeRow2Str() {
        return TgDateUtil.dateTime2String(outboundTimeRow2);
    }

    /**
     * 2列位出站时间
     */
    public String getOutboundTimeRow2ShortStr() {
        return TgDateUtil.time2String(outboundTimeRow2);
    }

    /**
     * 2列位车号编组类型
     */
    public String getTrainSetLengthTypeRow2Str() {
        return ConstantTrainSetLengthTypes.getStr(trainSetLengthTypeRow2);
    }

    /**
     * 2列位车号编组类型
     */
    public String getTrainSetLengthTypeRow2ShortStr() {
        return ConstantTrainSetLengthTypes.getShortStr(trainSetLengthTypeRow2);
    }
}