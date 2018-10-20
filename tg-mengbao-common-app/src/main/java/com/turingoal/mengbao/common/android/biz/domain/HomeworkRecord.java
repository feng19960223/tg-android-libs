package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [亲子作业记录] 
 */
@Data
public class HomeworkRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 亲子作业记录
    private String homeworkId; // 作业id
    private String homeworkTitle; // 标题
    private String filePath; // 附件
    private String userId; // 老师id
    private String userCodeNum; // 老师编号
    private String userRealname; // 老师姓名
    private String childId; // 孩子id
    private String childCodeNum; // 孩子编号
    private String childRealname; // 孩子姓名
    private String childAvatar; // 孩子头像
    private Integer score; // 评价分数
    private String content; // 评价内容
    private Integer submited; // 是否提交
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名字
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名字
    private Integer classGrade; // 班级年级
    private Integer flower; // 是否送花
    private Date createTime; // 提交时间
    private String homeworkContent; // 作业内容
   
    /**
     * 提交时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 提交时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}