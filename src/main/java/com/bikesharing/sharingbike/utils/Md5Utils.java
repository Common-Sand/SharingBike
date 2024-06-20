package com.bikesharing.sharingbike.utils;
import java.nio.charset.StandardCharsets;

public class Md5Utils {
    public static String Md5(String str) {
        return org.springframework.util.DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
    }
}
