package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [通知记录] 
 */
@Data
public class NoticeRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 通知记录
    private String noticeId; // 通知id
    private String noticeTitle; // 标题
    private String userId; // 用户id
    private String userRealname; // 用户真实姓名
    private Integer status; // 状态[家长是否已经查看]
    private String content; // 内容
    private Integer sticky; // 是否置顶
    private String fileName; // 附件文件名称
    private String filePath; // 附件文件地址
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名字
    private Date createTime; // 发布时间
    
    /**
     * 发布时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 发布时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}