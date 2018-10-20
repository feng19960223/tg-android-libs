package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [相册组]
 */
@Data
public class AlbumGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 相册组
    private String albumId; // 相册id
    private String title; // 名称
    private String address; // 地点
    private String description; // 描述
    private String createUserId; // 创建人
    private String createUserUsername; // 创建人用户名
    private String createUserRealname; // 创建人姓名
    private Date createTime; // 创建时间
    private String schoolId; // 学校id
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private List<AlbumPhoto> albumPhotos; // 照片

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