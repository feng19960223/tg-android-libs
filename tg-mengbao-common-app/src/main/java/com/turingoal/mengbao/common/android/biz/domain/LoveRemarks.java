package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [爱心备注] 
 */
@Data
public class LoveRemarks implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 爱心备注
    private String title; // 标题
    private String content; // 内容
    private Integer type; // 类型：1、请假 2、喂药 3、忌口 4、其他
    private String userId; // 家长id
    private String userCodeNum; // 家长编号
    private String userRealname; // 家长姓名
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
    private Integer status; // 状态：是否确认：1、老师已确认2、老师未确认
    private Date createTime; // 创建时间
   
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