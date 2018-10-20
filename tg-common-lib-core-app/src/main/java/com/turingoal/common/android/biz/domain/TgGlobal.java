package com.turingoal.common.android.biz.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * [全局配置]
 */
@Data
public class TgGlobal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title; // 网站名称
    private String titleFull; // 网站全称
    private String domainName; // 域名
    private String copyInfo; // 版权信息
    private String sysProtocol; // 协议
    private Integer sysPort; // 服务端口号
    private String contextPath; // 上下文路径
    private String theme; // 主题
    private String icp; // ICP信息
    private String metaKeywords; // SEO关键字
    private String metaDescription; // SEO描述
}