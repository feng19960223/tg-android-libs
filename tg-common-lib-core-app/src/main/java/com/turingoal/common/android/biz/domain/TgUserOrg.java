package com.turingoal.common.android.biz.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * [用户部门]
 */
@Data
public class TgUserOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 用户机构职务
    private String userId; // 用户id
    private String username; // 用户名
    private String realname; // 用户姓名
    private String orgId; // 机构id
    private String orgCodeNum; // 机构编码
    private String orgName; // 机构名称
}