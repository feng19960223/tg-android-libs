package com.turingoal.common.android.bean;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基本带批量提交的表单,继承BaseFormWithGridBean
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class TgBaseFormWithGridBean extends TgBaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String romovedIds; // 批量删除ids。","分割
    private String modifiedObjs; // 批量修改的对象json格式。收到后通过TgJsonUtil转成对应的对象
    private String newObjs; // 批量新增的对象json格式。收到后通过TgJsonUtil转成对应的对象
}
