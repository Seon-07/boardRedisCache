package com.seon.board1.common.util;

import java.util.Base64;

public class Base64Util {

    public static String encodeBase64(String input) {
        return Base64.getUrlEncoder().encodeToString(input.getBytes());
    }
}
