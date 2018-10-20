package com.turingoal.bts.common.android.biz.domain;

import com.turingoal.bts.common.android.constants.ConstantTrainSetLengthTypes;
import com.turingoal.bts.common.android.constants.ConstantTrainSetTypes;
import com.turingoal.common.android.constants.TgConstantYesNo;

import lombok.Data;

/**
 * [车型]
 */
@Data
public class TrainSetModel {
    private String id; // 车型
    private String codeNum; // 车型编码
    private Integer trainSetType; // 类型 1动车 2机车
    private Integer trainSetLengthType; // 编组类型 1短编组 2长编组
    private String cookbookPath; // 作业指导书
    private String cookbookUrl; // 作业指导书
    private String imgPath; // 图片路径
    private String imgUrl; // 图片路径
    private String description; // 描述
    private Integer sortOrder; // 排序
    private Integer enabled; // 是否可用

    /**
     * 车组类型
     */
    public String getTrainSetTypeStr() {
        return ConstantTrainSetTypes.getStr(trainSetType);
    }

    /**
     * 车组类型
     */
    public String getTrainSetTypeShortStr() {
        return ConstantTrainSetTypes.getShortStr(trainSetType);
    }

    /**
     * 获得编组类型名称
     */
    public String getTrainSetLengthTypeStr() {
        return ConstantTrainSetLengthTypes.getStr(trainSetLengthType);
    }

    /**
     * 获得编组类型名称
     */
    public String getTrainSetLengthTypeShortStr() {
        return ConstantTrainSetLengthTypes.getShortStr(trainSetLengthType);
    }

    /**
     * 是否启用
     */
    public String getEnabledStr() {
        return TgConstantYesNo.getStr(enabled);
    }
}