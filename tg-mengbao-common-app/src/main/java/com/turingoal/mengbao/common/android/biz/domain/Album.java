package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [相册]
 */
@Data
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 相册
    private String title; // 名称
    private String description; // 描述
    private String coverImage; // 封面图
    private Integer photoSize; // 包含照片数量
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