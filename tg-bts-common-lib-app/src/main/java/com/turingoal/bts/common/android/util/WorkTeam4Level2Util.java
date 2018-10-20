package com.turingoal.bts.common.android.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.turingoal.bts.common.android.constants.ConstantMontorWorkGroup4Level2;

/**
 * 二级修班组工具类
 */
public final class WorkTeam4Level2Util {
    private static final String[] I2_CRH2A = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] I2_CRH2C = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] I2_CRH380B = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] M1_CRH2A = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] M1_CRH2C = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] M1_CRH380B = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] M2_CRH2A = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] M2_CRH2C = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] M2_CRH380B = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE };
    private static final String[] M3_CRH2A = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE };
    private static final String[] M3_CRH2C = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_SERVICE };
    private static final String[] M3_CRH380B = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_CONTROL };
    private static final String[] S_CRH2A = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] S_CRH2C = { ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_DRIVING, ConstantMontorWorkGroup4Level2.GROUP_SPECIAL_ELECTRIC, ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static final String[] S_CRH380B = { ConstantMontorWorkGroup4Level2.GROUP_OUTSOURCING };
    private static Map<String, String[]> teamMap;
    static {
        teamMap = new HashMap<>();
        teamMap.put("I2_CRH2A", I2_CRH2A);
        teamMap.put("I2_CRH2C", I2_CRH2C);
        teamMap.put("I2_CRH380B", I2_CRH380B);
        teamMap.put("M1_CRH2A", M1_CRH2A);
        teamMap.put("M1_CRH2C", M1_CRH2C);
        teamMap.put("M1_CRH380B", M1_CRH380B);
        teamMap.put("M2_CRH2A", M2_CRH2A);
        teamMap.put("M2_CRH2C", M2_CRH2C);
        teamMap.put("M2_CRH380B", M2_CRH380B);
        teamMap.put("M3_CRH2A", M3_CRH2A);
        teamMap.put("M3_CRH2C", M3_CRH2C);
        teamMap.put("M3_CRH380B", M3_CRH380B);
        teamMap.put("S_CRH2A", S_CRH2A);
        teamMap.put("S_CRH2C", S_CRH2C);
        teamMap.put("S_CRH380B", S_CRH380B);
    }

    private WorkTeam4Level2Util() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 根据车型和二级修包判断是否需要对应的班组参与
     */
    public static boolean checkWorkGroupByTrainSetModelLevel2(final String trainSetModel, final String subPackage, final String workGroup) {
        boolean result = false;
        String[] teams = teamMap.get(subPackage + "_" + trainSetModel);
        if (teams != null) {
            result = Arrays.asList(teams).contains(workGroup);
        }
        return result;
    }
}
