package com.turingoal.common.android.util.system;

import android.annotation.SuppressLint;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;

import com.blankj.utilcode.util.PhoneUtils;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.SEND_SMS;

/**
 * 权限工具类
 */
public final class TgPhoneUtil {
    private TgPhoneUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 判断设备是否是手机
     */
    public static boolean isPhone() {
        return PhoneUtils.isPhone();
    }

    /**
     * 获取设备码
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(READ_PHONE_STATE)
    public static String getDeviceId() {
        return PhoneUtils.getDeviceId();
    }

    /**
     * 获取序列号
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(READ_PHONE_STATE)
    public static String getSerial() {
        return PhoneUtils.getSerial();
    }

    /**
     * 获取 IMEI 码
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(READ_PHONE_STATE)
    public static String getIMEI() {
        return PhoneUtils.getIMEI();
    }

    /**
     * 获取 MEID 码
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(READ_PHONE_STATE)
    public static String getMEID() {
        return PhoneUtils.getMEID();
    }

    /**
     * 获取 IMSI 码
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(READ_PHONE_STATE)
    public static String getIMSI() {
        return PhoneUtils.getIMSI();
    }

    /**
     * 获取移动终端类型
     * <ul>
     * <li>{@link TelephonyManager#PHONE_TYPE_NONE}</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_GSM }</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_CDMA}</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_SIP }</li>
     * </ul>
     */
    public static int getPhoneType() {
        return PhoneUtils.getPhoneType();
    }

    /**
     * 判断 sim 卡是否准备好
     */
    public static boolean isSimCardReady() {
        return PhoneUtils.isSimCardReady();
    }

    /**
     * 获取 Sim 卡运营商名称
     */
    public static String getSimOperatorName() {
        return PhoneUtils.getSimOperatorName();
    }

    /**
     * 获取 Sim 卡运营商名称
     */
    public static String getSimOperatorByMnc() {
        return PhoneUtils.getSimOperatorName();
    }

    /**
     * 获取手机状态信息
     *
     * @return DeviceId = 99000311726612<br>
     * DeviceSoftwareVersion = 00<br>
     * Line1Number =<br>
     * NetworkCountryIso = cn<br>
     * NetworkOperator = 46003<br>
     * NetworkOperatorName = 中国电信<br>
     * NetworkType = 6<br>
     * PhoneType = 2<br>
     * SimCountryIso = cn<br>
     * SimOperator = 46003<br>
     * SimOperatorName = 中国电信<br>
     * SimSerialNumber = 89860315045710604022<br>
     * SimState = 5<br>
     * SubscriberId(IMSI) = 460030419724900<br>
     * VoiceMailNumber = *86<br>
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(READ_PHONE_STATE)
    public static String getPhoneStatus() {
        return PhoneUtils.getPhoneStatus();
    }

    /**
     * 跳至拨号界面
     */
    public static void dial(final String phoneNumber) {
        PhoneUtils.dial(phoneNumber);
    }

    /**
     * 拨打 phoneNumber
     */
    @RequiresPermission(CALL_PHONE)
    public static void call(final String phoneNumber) {
        PhoneUtils.call(phoneNumber);
    }

    /**
     * 跳至发送短信界面
     */
    public static void sendSms(final String phoneNumber, final String content) {
        PhoneUtils.sendSms(phoneNumber, content);
    }

    /**
     * 发送短信
     */
    @RequiresPermission(SEND_SMS)
    public static void sendSmsSilent(final String phoneNumber, final String content) {
        PhoneUtils.sendSmsSilent(phoneNumber, content);
    }
}