package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [考勤]
 */
@Data
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 考勤
    private String childId; // 孩子id
    private String childCodeNum; // 孩子编号
    private String childRealname; // 孩子名字
    private String attendanceType; // 考勤类型
    private String remakes; // 备注
    private Date createTime; // 考勤时间
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名称
    private Integer classGrade; // 班级年级
    private String createUserId; // 创建人
    private String createUserUsername; // 创建人用户名
    private String createUserRealname; // 创建人姓名

    /**
     * 考勤时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }

    /**
     * 考勤时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}