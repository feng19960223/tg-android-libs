package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [点评] 
 */
@Data
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 点评
    private String content; // 点评内容
    private String userIdTeacher; // 老师id
    private String userCodeNumTeacher; // 老师编号
    private String userRealnameTeacher; // 老师姓名
    private String userAvatar; // 老师头像
    private String userIdParent; // 家长id
    private String userCodeNumParent; // 家长编号
    private String userRealnameParent; // 家长姓名
    private String childId; // 孩子id
    private String childCodeNum; // 孩子编号
    private String childRealname; // 孩子姓名
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名称
    private Integer classGrade; // 班级年级
    private String parentReply; // 家长回复内容
    private Integer flower; // 是否送花
    private Integer commentStatus; // 是否已点评
    private Date createTime; // 点评时间
   
    /**
     * 点评时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 点评时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}