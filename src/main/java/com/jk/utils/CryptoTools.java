package com.jk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码学相关
 */
public class CryptoTools {

    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_LOWER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_UPPER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /***
     * 利用Apache的工具类实现SHA-256加密
     * @param bytes
     * @return
     */
    public static String getSHA256Str(byte[] bytes){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(bytes);
            encdeStr = encodeHex(hash,true);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }


    /**
     * byte数组转hex字符串
     * @param data 待加密数据
     * @param lower 返回大写还是小写形式 true-全小写 false-全大写
     * @return hex字符串
     */
    public static String encodeHex(final byte[] data, boolean lower) {
        if(lower){
            return new String(encodeHex(data,DIGITS_LOWER));
        }else{
            return new String(encodeHex(data,DIGITS_UPPER));
        }
    }

    /**
     * byte数组转16进制数据
     * @param data 待转换数据
     * @param toDigits 大写或者小写
     * @return
     */
    public static char[] encodeHex(final byte[] data, final char[] toDigits) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }
}
