package com.turingoal.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;

import com.turingoal.common.android.util.lang.TgDateUtil;
import lombok.Data;

/**
 * [文件]
 */
@Data
public class TgFile implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // id
    private String fileName; // 文件名称
    private String filePath; // 文件地址
    private String fileUrl; // 文件url
    private String fileType; // 文件类型
    private String fileFormat; // 文件格式
    private Long fileLength; // 文件长度
    private String fileMd5; // 文件md5
    private Date uploadTime; // 上传时间

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
}
