package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [学校相册] 
 */
@Data
public class SchoolPhoto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 学校相册
    private String photo; // 照片
    private String discription; // 描述
    private String userId; // 用户id
    private String userCodeNum; // 用户编号
    private String userRealname; // 用户姓名
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private Date createTime; // 上传时间
   
    /**
     * 上传时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 上传时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}