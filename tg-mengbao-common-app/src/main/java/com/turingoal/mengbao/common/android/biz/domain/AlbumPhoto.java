package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [相册照片]
 */
@Data
public class AlbumPhoto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 相册详情
    private String albumId; // 相册id
    private String groupId; // 组id
    private String photo; // 图片
    private Integer type; // 类型
    private Long fileLength; // 文件大小
    private Long videoLength; // 视频时长
    private String createUserId; // 创建人
    private String createUserUsername; // 创建人用户名
    private String createUserRealname; // 创建人姓名
    private Date createTime; // 上传时间
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称

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