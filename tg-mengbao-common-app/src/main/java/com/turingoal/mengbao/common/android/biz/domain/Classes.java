package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [班级] 
 */
@Data
public class Classes implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 班级
    private String title; // 名称
    private String codeNum; // 编码
    private String description; // 描述
    private String schoolId; // 学校
    private String schoolCodeNum; // 学校编码
    private String schoolTitle; // 学校名称
    private Integer grade; // 年级
    private String classTeacher; // 班主任
    private String classTeacherPhone; // 班主任电话
    private Date createTime; // 开班时间
   
    /**
     * 开班时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 开班时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}