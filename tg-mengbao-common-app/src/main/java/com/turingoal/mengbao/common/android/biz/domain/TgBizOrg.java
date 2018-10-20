package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.constants.TgMengbaoConstantYesNo;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [商户]
 */
@Data
public class TgBizOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 商户表
    private String codeNum; // 编码
    private String orgName; // 商户名称
    private String orgAlias; // 别名
    private String logo; // logo
    private String address; // 地址
    private String contactPhone; // 联系电话
    private String email; // 邮箱
    private String website; // 官网
    private String description; // 介绍
    private String managerUserId; // 负责人
    private String managerUsername; // 负责用户名
    private String managerRealname; // 负责人姓名
    private String managerPhoneNum; // 负责人联系电话、
    private String managerEmail; // 负责人邮箱
    private Date registerTime; // 开通时间
    private Integer sortOrder = 1; // 排序
    private Integer editable = TgMengbaoConstantYesNo.YES; // 是否可编辑
    private Integer deletable = TgMengbaoConstantYesNo.YES; // 是否可删除
    private Integer enabled = TgMengbaoConstantYesNo.YES; // 是否可用

    /**
     * 开通时间
     */
    public String getRegisterTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(registerTime);
    }

    /**
     * 开通时间
     */
    public String getRegisterTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(registerTime);
    }

    /**
     * 是否可编辑
     */
    public String getEditableStr() {
        return TgMengbaoConstantYesNo.getStr(editable);
    }

    /**
     * 是否可删除
     */
    public String getDeletableStr() {
        return TgMengbaoConstantYesNo.getStr(deletable);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgMengbaoConstantYesNo.getStr(enabled);
    }
}