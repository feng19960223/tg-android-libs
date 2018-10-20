package com.turingoal.common.android.bean;

import lombok.Data;

/**
 * html img bean
 */
@Data
public class TgImageBean {
    private String title; // 标题
    private String url; // url路径
    private Boolean newWindow;  // 新窗口打开
    private String src; // src路径
    private Integer width; // 宽度
    private Integer height; // 高度
}
