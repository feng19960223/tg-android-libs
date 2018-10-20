package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [课程] 
 */
@Data
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 课程
    private String amContent1; // 上午内容
    private String pmContent1; // 下午内容
    private String userIdAm1; // 上午上课老师id
    private String userIdPm1; // 下午上课老师id
    private String amUserRealname1; // 上午上课老师姓名
    private String pmUserRealname1; // 下午上课老师姓名
    private String amContent2; // 上午内容
    private String pmContent2; // 下午内容
    private String userIdAm2; // 上午上课老师id
    private String userIdPm2; // 下午上课老师id
    private String amUserRealname2; // 上午上课老师姓名
    private String pmUserRealname2; // 下午上课老师姓名
    private String amContent3; // 上午内容
    private String pmContent3; // 下午内容
    private String userIdAm3; // 上午上课老师id
    private String userIdPm3; // 下午上课老师id
    private String amUserRealname3; // 上午上课老师姓名
    private String pmUserRealname3; // 下午上课老师姓名
    private String amContent4; // 上午内容
    private String pmContent4; // 下午内容
    private String userIdAm4; // 上午上课老师id
    private String userIdPm4; // 下午上课老师id
    private String amUserRealname4; // 上午上课老师姓名
    private String pmUserRealname4; // 下午上课老师姓名
    private String amContent5; // 上午内容
    private String pmContent5; // 下午内容
    private String userIdAm5; // 上午上课老师id
    private String userIdPm5; // 下午上课老师id
    private String amUserRealname5; // 上午上课老师姓名
    private String pmUserRealname5; // 下午上课老师姓名
    private String amContent6; // 上午内容
    private String pmContent6; // 下午内容
    private String userIdAm6; // 上午上课老师id
    private String userIdPm6; // 下午上课老师id
    private String amUserRealname6; // 上午上课老师姓名
    private String pmUserRealname6; // 下午上课老师姓名
    private String amContent7; // 上午内容
    private String pmContent7; // 下午内容
    private String userIdAm7; // 上午上课老师id
    private String userIdPm7; // 下午上课老师id
    private String amUserRealname7; // 上午上课老师姓名
    private String pmUserRealname7; // 下午上课老师姓名
    private Date startTime; // 课程开始时间
    private Date endTime; // 课程结束时间
    private Integer weeks; // 第几周
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名字
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名字
    private Integer classGrade; // 班级年级
    private Date currentData; // 当前时间
    private Date createTime; // 创建时间
   
    /**
     * 课程开始时间
     */
    public String getStartTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(startTime);
    }
    
    /**
     * 课程开始时间
     */
    public String getStartTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(startTime);
    }
            
    /**
     * 课程结束时间
     */
    public String getEndTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(endTime);
    }
    
    /**
     * 课程结束时间
     */
    public String getEndTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(endTime);
    }
            
    /**
     * 当前时间
     */
    public String getCurrentDataStr4Date() {
        return TgMengBaoDateUtil.date2String(currentData);
    }
    
    /**
     * 当前时间
     */
    public String getCurrentDataStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(currentData);
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