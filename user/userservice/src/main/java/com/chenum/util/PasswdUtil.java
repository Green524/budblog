package com.chenum.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswdUtil {

    public static String sha512(String rawPassword) {
        MessageDigest md = DigestUtils.getSha512Digest();
        return Hex.encodeHexString(md.digest(rawPassword.getBytes(StandardCharsets.UTF_8)));
    }

}
