package com.turingoal.common.android.util.math;

import com.blankj.utilcode.util.EncryptUtils;

import java.io.File;

/**
 * 加密算法的工具类.
 */
public final class TgEncryptUtil {
    private TgEncryptUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * encryptMD2ToString
     */
    public static String encryptMD2ToString(final String data) {
        return EncryptUtils.encryptMD2ToString(data);
    }

    /**
     * encryptMD2ToString
     */
    public static String encryptMD2ToString(final byte[] data) {
        return EncryptUtils.encryptMD2ToString(data);
    }

    /**
     * encryptMD2
     */
    public static byte[] encryptMD2(final byte[] data) {
        return EncryptUtils.encryptMD2(data);
    }

    /**
     * encryptMD5ToString
     */
    public static String encryptMD5ToString(final String data) {
        return EncryptUtils.encryptMD5ToString(data);
    }

    /**
     * encryptMD5ToString
     */
    public static String encryptMD5ToString(final String data, final String salt) {
        return EncryptUtils.encryptMD5ToString(data, salt);
    }

    /**
     * encryptMD5ToString
     */
    public static String encryptMD5ToString(final byte[] data) {
        return EncryptUtils.encryptMD5ToString(data);
    }

    /**
     * encryptMD5ToString
     */
    public static String encryptMD5ToString(final byte[] data, final byte[] salt) {
        return EncryptUtils.encryptMD5ToString(data, salt);
    }

    /**
     * encryptMD5
     */
    public static byte[] encryptMD5(final byte[] data) {
        return EncryptUtils.encryptMD5(data);
    }

    /**
     * encryptMD5File2String
     */
    public static String encryptMD5File2String(final String filePath) {
        return EncryptUtils.encryptMD5File2String(filePath);
    }

    /**
     * encryptMD5File
     */
    public static byte[] encryptMD5File(final String filePath) {
        return EncryptUtils.encryptMD5File(filePath);
    }

    /**
     * encryptMD5File2String
     */
    public static String encryptMD5File2String(final File file) {
        return EncryptUtils.encryptMD5File2String(file);
    }

    /**
     * encryptMD5File
     */
    public static byte[] encryptMD5File(final File file) {
        return EncryptUtils.encryptMD5File(file);
    }

    /**
     * encryptSHA1ToString
     */
    public static String encryptSHA1ToString(final String data) {
        return EncryptUtils.encryptSHA1ToString(data);
    }

    /**
     * encryptSHA1ToString
     */
    public static String encryptSHA1ToString(final byte[] data) {
        return EncryptUtils.encryptSHA1ToString(data);
    }

    /**
     * encryptSHA1
     */
    public static byte[] encryptSHA1(final byte[] data) {
        return EncryptUtils.encryptSHA1(data);
    }

    /**
     * encryptSHA224ToString
     */
    public static String encryptSHA224ToString(final String data) {
        return EncryptUtils.encryptSHA224ToString(data);
    }

    /**
     * encryptSHA224ToString
     */
    public static String encryptSHA224ToString(final byte[] data) {
        return EncryptUtils.encryptSHA224ToString(data);
    }

    /**
     * encryptSHA224
     */
    public static byte[] encryptSHA224(final byte[] data) {
        return EncryptUtils.encryptSHA224(data);
    }

    /**
     * encryptSHA256ToString
     */
    public static String encryptSHA256ToString(final String data) {
        return EncryptUtils.encryptSHA256ToString(data);
    }

    /**
     * encryptSHA256ToString
     */
    public static String encryptSHA256ToString(final byte[] data) {
        return EncryptUtils.encryptSHA256ToString(data);
    }

    /**
     * encryptSHA256
     */
    public static byte[] encryptSHA256(final byte[] data) {
        return EncryptUtils.encryptSHA256(data);
    }

    /**
     * encryptSHA384ToString
     */
    public static String encryptSHA384ToString(final String data) {
        return EncryptUtils.encryptSHA384ToString(data);
    }

    /**
     * encryptSHA384ToString
     */
    public static String encryptSHA384ToString(final byte[] data) {
        return EncryptUtils.encryptSHA384ToString(data);
    }

    /**
     * encryptSHA384
     */
    public static byte[] encryptSHA384(final byte[] data) {
        return EncryptUtils.encryptSHA384(data);
    }

    /**
     * encryptSHA512ToString
     */
    public static String encryptSHA512ToString(final String data) {
        return EncryptUtils.encryptSHA512ToString(data);
    }

    /**
     * encryptSHA512ToString
     */
    public static String encryptSHA512ToString(final byte[] data) {
        return EncryptUtils.encryptSHA512ToString(data);
    }

    /**
     * encryptSHA512
     */
    public static byte[] encryptSHA512(final byte[] data) {
        return EncryptUtils.encryptSHA512(data);
    }

    /**
     * encryptHmacMD5ToString
     */
    public static String encryptHmacMD5ToString(final String data, final String key) {
        return EncryptUtils.encryptHmacMD5ToString(data, key);
    }

    /**
     * encryptHmacMD5ToString
     */
    public static String encryptHmacMD5ToString(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacMD5ToString(data, key);
    }

    /**
     * encryptHmacMD5
     */
    public static byte[] encryptHmacMD5(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacMD5(data, key);
    }

    /**
     * encryptHmacSHA1ToString
     */
    public static String encryptHmacSHA1ToString(final String data, final String key) {
        return EncryptUtils.encryptHmacSHA1ToString(data, key);
    }

    /**
     * encryptHmacSHA1ToString
     */
    public static String encryptHmacSHA1ToString(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA1ToString(data, key);
    }

    /**
     * encryptHmacSHA1
     */
    public static byte[] encryptHmacSHA1(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA1(data, key);
    }

    /**
     * encryptHmacSHA224ToString
     */
    public static String encryptHmacSHA224ToString(final String data, final String key) {
        return EncryptUtils.encryptHmacSHA224ToString(data, key);
    }

    /**
     * encryptHmacSHA224ToString
     */
    public static String encryptHmacSHA224ToString(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA224ToString(data, key);
    }

    /**
     * encryptHmacSHA224
     */
    public static byte[] encryptHmacSHA224(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA224(data, key);
    }

    /**
     * encryptHmacSHA256ToString
     */
    public static String encryptHmacSHA256ToString(final String data, final String key) {
        return EncryptUtils.encryptHmacSHA256ToString(data, key);
    }

    /**
     * encryptHmacSHA256ToString
     */
    public static String encryptHmacSHA256ToString(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA256ToString(data, key);
    }

    /**
     * encryptHmacSHA256
     */
    public static byte[] encryptHmacSHA256(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA256(data, key);
    }

    /**
     * encryptHmacSHA384ToString
     */
    public static String encryptHmacSHA384ToString(final String data, final String key) {
        return EncryptUtils.encryptHmacSHA384ToString(data, key);
    }

    /**
     * encryptHmacSHA384ToString
     */
    public static String encryptHmacSHA384ToString(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA384ToString(data, key);
    }

    /**
     * encryptHmacSHA384
     */
    public static byte[] encryptHmacSHA384(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA384(data, key);
    }

    /**
     * encryptHmacSHA512ToString
     */
    public static String encryptHmacSHA512ToString(final String data, final String key) {
        return EncryptUtils.encryptHmacSHA512ToString(data, key);
    }

    /**
     * encryptHmacSHA512ToString
     */
    public static String encryptHmacSHA512ToString(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA512ToString(data, key);
    }

    /**
     * encryptHmacSHA512
     */
    public static byte[] encryptHmacSHA512(final byte[] data, final byte[] key) {
        return EncryptUtils.encryptHmacSHA512(data, key);
    }

    /**
     * encryptDES2Base64
     */
    public static byte[] encryptDES2Base64(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encryptDES2Base64(data, key, transformation, iv);
    }

    /**
     * encryptDES2HexString
     */
    public static String encryptDES2HexString(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encryptDES2HexString(data, key, transformation, iv);
    }


    /**
     * decryptBase64DES
     */
    public static byte[] decryptBase64DES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptBase64DES(data, key, transformation, iv);
    }

    /**
     * decryptHexStringDES
     */
    public static byte[] decryptHexStringDES(final String data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptHexStringDES(data, key, transformation, iv);
    }

    /**
     * decryptDES
     */
    public static byte[] decryptDES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptDES(data, key, transformation, iv);
    }

    /**
     * encrypt3DES2Base64
     */
    public static byte[] encrypt3DES2Base64(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encrypt3DES2Base64(data, key, transformation, iv);
    }

    /**
     * encrypt3DES2HexString
     */
    public static String encrypt3DES2HexString(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encrypt3DES2HexString(data, key, transformation, iv);
    }

    /**
     * encrypt3DES
     */
    public static byte[] encrypt3DES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encrypt3DES(data, key, transformation, iv);
    }

    /**
     * decryptBase64_3DES
     */
    public static byte[] decryptBase64_3DES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptBase64_3DES(data, key, transformation, iv);
    }

    /**
     * decryptHexString3DES
     */
    public static byte[] decryptHexString3DES(final String data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptHexString3DES(data, key, transformation, iv);
    }

    /**
     * decrypt3DES
     */
    public static byte[] decrypt3DES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decrypt3DES(data, key, transformation, iv);
    }

    /**
     * encryptAES2Base64
     */
    public static byte[] encryptAES2Base64(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encryptAES2Base64(data, key, transformation, iv);
    }

    /**
     * encryptAES2HexString
     */
    public static String encryptAES2HexString(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encryptAES2HexString(data, key, transformation, iv);
    }

    /**
     * encryptAES
     */
    public static byte[] encryptAES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.encryptAES(data, key, transformation, iv);
    }

    /**
     * decryptBase64AES
     */
    public static byte[] decryptBase64AES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptBase64AES(data, key, transformation, iv);
    }

    /**
     * decryptHexStringAES
     */
    public static byte[] decryptHexStringAES(final String data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptHexStringAES(data, key, transformation, iv);
    }

    /**
     * decryptAES
     */
    public static byte[] decryptAES(final byte[] data, final byte[] key, final String transformation, final byte[] iv) {
        return EncryptUtils.decryptAES(data, key, transformation, iv);
    }


    ///////////////////////////////////////////////////////////////////////////
    // RSA encryption
    ///////////////////////////////////////////////////////////////////////////

    /**
     * encryptRSA2Base64
     */
    public static byte[] encryptRSA2Base64(final byte[] data, final byte[] key, final boolean isPublicKey, final String transformation) {
        return EncryptUtils.encryptRSA2Base64(data, key, isPublicKey, transformation);
    }

    /**
     * encryptRSA2HexString
     */
    public static String encryptRSA2HexString(final byte[] data, final byte[] key, final boolean isPublicKey, final String transformation) {
        return EncryptUtils.encryptRSA2HexString(data, key, isPublicKey, transformation);
    }

    /**
     * encryptRSA
     */
    public static byte[] encryptRSA(final byte[] data, final byte[] key, final boolean isPublicKey, final String transformation) {
        return EncryptUtils.encryptRSA(data, key, isPublicKey, transformation);
    }

    /**
     * decryptBase64RSA
     */
    public static byte[] decryptBase64RSA(final byte[] data, final byte[] key, final boolean isPublicKey, final String transformation) {
        return EncryptUtils.decryptBase64RSA(data, key, isPublicKey, transformation);
    }

    /**
     * decryptHexStringRSA
     */
    public static byte[] decryptHexStringRSA(final String data, final byte[] key, final boolean isPublicKey, final String transformation) {
        return EncryptUtils.decryptHexStringRSA(data, key, isPublicKey, transformation);
    }

    /**
     * decryptRSA
     */
    public static byte[] decryptRSA(final byte[] data, final byte[] key, final boolean isPublicKey, final String transformation) {
        return EncryptUtils.decryptRSA(data, key, isPublicKey, transformation);
    }
}
