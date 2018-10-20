package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [成长明细] 
 */
@Data
public class GrowthDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 成长明细
    private Integer valueGrowth; // 成长值
    private Integer valueFlower; // 花朵
    private String userId; // 家长id
    private String userCodeNum; // 家长编号
    private String userRealname; // 家长姓名
    private String userAvatar; // 家长头像
    private String childId; // 孩子
    private String childCodeNum; // 孩子编号
    private String childRealname; // 孩子姓名
    private String schoolId; // 学校
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private String classId; // 班级
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名称
    private Integer classGrade; // 班级年级
    private Date createTime; // 创建时间
    private String origin; // 成长值来源
   
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