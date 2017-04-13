package com.bj58.chr.data.spider.zhilian.jobmv;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bj58.chr.data.spider.util.StringUtil;
import com.google.common.base.Preconditions;

public class DesUtil {

    private static final Logger logger = LoggerFactory.getLogger(DesUtil.class);

    public final static String DES_KEY_STRING = "ABSujsuu";

    public static String encrypt(String message, String key) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            return encodeBase64(cipher.doFinal(message.getBytes("UTF-8")));
        } catch (Exception e) {
            logger.error("encrypt error", e);
        }
        return null;
    }

    public static String decrypt(String message, String key) {
        try {
            Preconditions.checkState(StringUtil.isNotNullOrEmpty(message));

            byte[] bytesrc = decodeBase64(message);//convertHexString(message);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            System.out.println(bytesrc.length);
            byte[] retByte = cipher.doFinal(bytesrc);
            return new String(retByte);
        } catch (Exception e) {
            logger.error("decrypt error", e);
        }
        return null;
    }

    public static byte[] convertHexString(String ss) {
        byte digest[] = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }

        return digest;
    }

    public static String toHexString(byte b[]) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2)
                plainText = "0" + plainText;
            hexString.append(plainText);
        }
        return hexString.toString();
    }

    public static String encodeBase64(byte[] b) {
        return Base64.encodeBase64String(b);
    }

    private static byte[] decodeBase64(String base64String) throws IOException {
        return Base64.decodeBase64(base64String);
    }

}