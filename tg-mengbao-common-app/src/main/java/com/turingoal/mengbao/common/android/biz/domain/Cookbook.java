package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [食谱]
 */
@Data
public class Cookbook implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 食谱
    private String breakfast1; // 早餐
    private String earlyLunch1; // 早中
    private String lunch1; // 午餐
    private String earlyDinner1; // 午中
    private String dinner1; // 晚餐
    private String breakfast2; // 早餐
    private String earlyLunch2; // 早中
    private String lunch2; // 午餐
    private String earlyDinner2; // 午中
    private String dinner2; // 晚餐
    private String breakfast3; // 早餐
    private String earlyLunch3; // 早中
    private String lunch3; // 午餐
    private String earlyDinner3; // 午中
    private String dinner3; // 晚餐
    private String breakfast4; // 早餐
    private String earlyLunch4; // 早中
    private String lunch4; // 午餐
    private String earlyDinner4; // 午中
    private String dinner4; // 晚餐
    private String breakfast5; // 早餐
    private String earlyLunch5; // 早中
    private String lunch5; // 午餐
    private String earlyDinner5; // 午中
    private String dinner5; // 晚餐
    private String breakfast6; // 早餐
    private String earlyLunch6; // 早中
    private String lunch6; // 午餐
    private String earlyDinner6; // 午中
    private String dinner6; // 晚餐
    private String breakfast7; // 早餐
    private String earlyLunch7; // 早中
    private String lunch7; // 午餐
    private String earlyDinner7; // 午中
    private String dinner7; // 晚餐
    private Date startTime; // 食谱开始时间
    private Date endTime; // 食谱结束时间
    private Integer weeks; // 第几周
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private Date createTime; // 创建时间

    /**
     * 食谱开始时间
     */
    public String getStartTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(startTime);
    }

    /**
     * 食谱结束时间
     */
    public String getEndTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(endTime);
    }

    /**
     * 创建时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }

    /**
     * 创建时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}