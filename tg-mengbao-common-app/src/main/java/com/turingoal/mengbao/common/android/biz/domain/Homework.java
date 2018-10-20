package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [亲子作业] 
 */
@Data
public class Homework implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 亲子作业
    private String title; // 标题
    private String content; // 内容
    private String file; // 附件
    private String userId; // 老师id
    private String userCodeNum; // 老师编号
    private String userRealname; // 老师真实姓名
    private Date deadline; // 提交截止时间
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名字
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名字
    private Integer classGrade; // 班级年级
    private Integer completed; // 已完成人数
    private Integer undone; // 未完成人数
    private Date createTime; // 作业发布时间
   
    /**
     * 提交截止时间
     */
    public String getDeadlineStr4Date() {
        return TgMengBaoDateUtil.date2String(deadline);
    }
    
    /**
     * 提交截止时间
     */
    public String getDeadlineStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(deadline);
    }
            
    /**
     * 作业发布时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 作业发布时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}