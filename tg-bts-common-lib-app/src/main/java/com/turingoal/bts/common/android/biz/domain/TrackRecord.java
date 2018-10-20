package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * [股道记录]
 */
@Data
public class TrackRecord {
    private String id; // 股道记录
    private String trackCodeNum; // 股道编号
    private Integer trackRowNum; // 列位
    private String trainSetCodeNum; // 车号
    private Date arriveTime; // 进站时间
    private Date outboundTime; // 出站时间

    /**
     * 进站时间
     */
    public String getArriveTimeStr() {
        return TgDateUtil.dateTime2String(arriveTime);
    }

    /**
     * 出站时间
     */
    public String getOutboundTimeStr() {
        return TgDateUtil.dateTime2String(outboundTime);
    }
}