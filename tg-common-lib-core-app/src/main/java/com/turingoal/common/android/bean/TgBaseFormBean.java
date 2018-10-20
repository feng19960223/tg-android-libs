package com.turingoal.common.android.bean;

import com.turingoal.common.android.constants.TgConstantYesNo;
import com.turingoal.common.android.util.math.TgIdentitieUtil;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 基本form属性
 * <p>
 * 包含一些基本常见属性。id通过uuid自动生成。
 * </p>
 */
@Data
public abstract class TgBaseFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id = TgIdentitieUtil.uuidWithoutUnderline(); // 封装JDK自带的UUID, 通过Random数字生成, 中间无"-"分割.
    private String codeNum; // 编码
    private Integer priority = 1; // 优先级，一般从大到小，默认1
    private Integer sortOrder = 1; // 排序，一般从小到大，默认1
    private Integer editable = TgConstantYesNo.YES; // 是否可编辑，默认可以
    private Integer deletable = TgConstantYesNo.YES; // 是否删除，默认可以
    private Integer enabled = TgConstantYesNo.YES; // 是否启用，默认是
    private Date createDataTime = new Date(); // 数据创建时间
    private String createDataUsername; // 创建者username
    private Date updateDataTime = new Date(); // 数据修改时间
    private String updateDataUsername; // 修改者username
}
