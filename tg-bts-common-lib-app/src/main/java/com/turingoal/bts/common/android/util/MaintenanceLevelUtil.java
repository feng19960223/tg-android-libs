package com.turingoal.bts.common.android.util;

import com.turingoal.bts.common.android.constants.ConstantMontorMaintenanceLevels;

/**
 * 检修任务工具类
 */
public final class MaintenanceLevelUtil {
    private MaintenanceLevelUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * /**
     * 通过检修任务得到修程，如I2，M2为二级修
     */
    public static String getMaintenanceLevelCodeNumByTaskName(final String maintenanceTaskName) {
        String maintenanceLevel = ConstantMontorMaintenanceLevels.OTHER; // 默认为其它
        if (maintenanceTaskName != null && !"".equals(maintenanceTaskName)) {
            if ("一级修".equals(maintenanceTaskName)) {
                maintenanceLevel = ConstantMontorMaintenanceLevels.LEVEL_1; // 一级修
            } else if ("I2".equals(maintenanceTaskName) || "M1".equals(maintenanceTaskName) || "M2".equals(maintenanceTaskName) || "M3".equals(maintenanceTaskName) || "M4".equals(maintenanceTaskName) || "S".equals(maintenanceTaskName)) {
                maintenanceLevel = ConstantMontorMaintenanceLevels.LEVEL_2; // 二级修
            }
        }
        return maintenanceLevel;
    }
}
