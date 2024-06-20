package com.bikesharing.sharingbike.utils;

import org.apache.commons.codec.binary.Hex;

public class ByteUtils {
    // 将字节数组转换为十六进制字符串
    public static String toHexString(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

    // 将十六进制字符串转换为字节数组
    public static byte[] fromHexString(String hexString) {
        try {
            return Hex.decodeHex(hexString.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert hex string to byte array", e);
        }
    }
}
