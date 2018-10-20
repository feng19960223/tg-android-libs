package com.turingoal.bts.common.android.util;

import com.turingoal.bts.common.android.constants.ConstantTrainSetLengthTypes;
import com.turingoal.common.android.util.lang.TgStringUtil;

/**
 * 车组工具类
 */
public final class TrainSetUtil {
    private TrainSetUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 通过车号全称获得车型，如CRH380B-3640，获得车型CRH380B
     */
    public static String getTrainSetModelByFullNum(final String trainSetFullNum) {
        String trainSetModel = null;
        if (!TgStringUtil.isBlank(trainSetFullNum)) {
            trainSetModel = trainSetFullNum.split("-")[0];
        }
        return trainSetModel;
    }

    /**
     * 通过车型获得编组类型，如CRH2B得到编组类型为ConstantTrainSetLengthType.LONG 2
     */
    public static int getTrainSetLengthTypeByModel(final String trainSetModel) {
        int trainSetLengthType = ConstantTrainSetLengthTypes.SHORT; // 默认为8编组的短编组
        if (!TgStringUtil.isBlank(trainSetModel)) {
            if (trainSetModel.startsWith("CRH380")) { // 380的单独处理
                if (trainSetModel.endsWith("L")) { // 后缀带L的是16编组长编组
                    trainSetLengthType = ConstantTrainSetLengthTypes.LONG;
                }
            } else {
                if (trainSetModel.endsWith("B") || trainSetModel.endsWith("E")) { // 后缀带B或E的是16编组长编组
                    trainSetLengthType = ConstantTrainSetLengthTypes.LONG;
                }
            }
        }
        return trainSetLengthType;
    }

    /**
     * 通过车号全称获得编组类型，如CRH2B-9527得到编组类型为ConstantTrainSetLengthType.LONG 2 长编组， CRH380B-3564+9527 得到编组类型为ConstantTrainSetLengthType.CONNECTED 10 重连车组
     */
    public static int getTrainSetLengthTypeByFullNum(final String trainSetFullNum) {
        String trainSetModel = getTrainSetModelByFullNum(trainSetFullNum); // 获得车型
        int trainSetLengthType = getTrainSetLengthTypeByModel(trainSetModel); // 获得编组类型
        if (trainSetFullNum.contains("+")) { // 重连情况
            trainSetLengthType = ConstantTrainSetLengthTypes.CONNECTED;
        }
        return trainSetLengthType;
    }
}
