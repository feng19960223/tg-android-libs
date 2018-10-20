package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.common.android.util.lang.TgDateUtil;

import java.util.Date;

import lombok.Data;

/**
 * [技术资料]
 */
@Data
public class TechnicalDoc {
    private String id; // 技术资料
    private String title; // 标题
    private String description; // 描述
    private String docFile; // 文件路径
    private String docFileUrl; // 文件路径
    private Date uploadTime; // 上传时间
    private Date updateTime; // 更新时间

    /**
     * 上传时间
     */
    public String getUploadTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(uploadTime);
    }

    /**
     * 上传时间
     */
    public String getUploadTimeStr4Date() {
        return TgDateUtil.date2String(uploadTime);
    }

    /**
     * 更新时间
     */
    public String getUpdateTimeStr4DateTime() {
        return TgDateUtil.dateTime2String(updateTime);
    }

    /**
     * 更新时间
     */
    public String getUpdateTimeStr4Date() {
        return TgDateUtil.date2String(updateTime);
    }
}