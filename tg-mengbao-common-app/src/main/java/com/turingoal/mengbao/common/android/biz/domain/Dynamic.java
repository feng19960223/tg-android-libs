package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [获奖动态] 
 */
@Data
public class Dynamic implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 获奖动态
    private String childId; // 孩子id
    private String childCodeNum; // 孩子编号
    private String childRealname; // 孩子姓名
    private Integer valueFlower; // 花朵数
    private Date createTime; // 获奖时间
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名称
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
   
    /**
     * 获奖时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 获奖时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}