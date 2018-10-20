package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.constants.TgMengbaoConstantYesNo;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [公告]
 */
@Data
public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 公告id
    private String title; // 标题
    private String category; // 类型
    private String content; // 内容
    private Integer sticky = TgMengbaoConstantYesNo.NO; // 1 置顶，2取消（初始值为2）
    private String filePath; // 附件文件地址
    private String fileName; // 附件文件名称
    private String ownerType; // 拥有者类型
    private String ownerId; // 拥有者id
    private String bizOrgId; // 商户id
    private String bizOrgCodeNum; // 商户编码
    private String bizOrgName; // 商户名称
    private String orgId; // 组织机构id
    private String orgCodeNum; // 组织机构编码
    private String orgName; // 组织机构名称
    private Date publishTime; // 发布时间
    private String publishUserId; // 发布人
    private String publishUserUsername; // 发布人用户名
    private String publishUserRealname; // 发布人姓名
    private Date updateTime; // 更新时间
    private String updateUserId; // 更新人
    private String updateUserUsername; // 更新人用户名
    private String updateUserRealname; // 更新人姓名

    /**
     * 是否置顶
     */
    public String getStickyStr() {
        return TgMengbaoConstantYesNo.getStr(sticky);
    }

    /**
     * 发布时间
     */
    public String getPublishTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(publishTime);
    }

    /**
     * 发布时间
     */
    public String getPublishTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(publishTime);
    }

    /**
     * 更新时间
     */
    public String getUpdateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(updateTime);
    }

    /**
     * 更新时间
     */
    public String getUpdateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(updateTime);
    }
}