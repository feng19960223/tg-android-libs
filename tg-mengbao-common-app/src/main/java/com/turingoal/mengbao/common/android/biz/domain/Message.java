package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [消息] 
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 消息
    private String type; // 消息类型
    private String content; // 消息内容
    private String userId; // 用户
    private String userCodeNum; // 用户编号
    private String userRealname; // 用户姓名
    private String schoolId; // 学校
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private Integer classGrade; // 班级年级
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名字
    private Date createTime; // 发送时间
   
    /**
     * 发送时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 发送时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}