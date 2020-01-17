/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Formatter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;

/**
 *
 * @author alikhyatti
 */
public class HashUtil {

    private static Cipher cipher ;

    
    public static String encryptPassword(String password) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return data;
    }

//    public static String decryptPassword(final byte[] hash) {
//        String sha1 = "";
//        try {
//            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
//            crypt.reset();
//           
//            crypt.update(password.getBytes("UTF-8"));
//            sha1 = byteToHex(crypt.digest());
//        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        return sha1;
//    }
    public static String encrypt(String plainText)
            throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // block size is 128bits
        SecretKey secretKey = keyGenerator.generateKey();
        
        cipher = Cipher.getInstance("AES");

        byte[] plainTextByte = plainText.getBytes();
        getCipher().init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = getCipher().doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText)
            throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128); // block size is 128bits
        SecretKey secretKey = keyGenerator.generateKey();

        cipher = Cipher.getInstance("AES");
        
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        getCipher().init(Cipher.DECRYPT_MODE, secretKey);
//        byte[] decryptedByte = getCipher().doFinal(encryptedTextByte);
//byte[] base64decodedTokenArr = Base64.decodeBase64(encryptedTextByte);
//byte[] decryptedPassword = cipher.doFinal(base64decodedTokenArr);
String decryptedPassword = new String(cipher.doFinal(encryptedText.getBytes("UTF-8")));
        String decryptedText = new String(decryptedPassword);
//        String decryptedText;
//        decryptedText = Arrays.toString(new BASE64Decoder().decodeBuffer(encryptedText));
        return decryptedText;

    }
//    Key key = create symmetric encryption key;
//    private Key getAesKey() throws Exception {
//    return new SecretKeySpec(Arrays.copyOf(key.getBytes("UTF-8"), 16), "AES");
//}
//
//private Cipher getMutual() throws Exception {
//    Cipher cipher = Cipher.getInstance("AES");
//    return cipher;// cipher.doFinal(pass.getBytes());
//}
//
//public byte[] getEncryptedPass(String pass) throws Exception {
//    Cipher cipher = getMutual();
//    cipher.init(Cipher.ENCRYPT_MODE, getAesKey());
//    byte[] encrypted = cipher.doFinal(pass.getBytes("UTF-8"));
//    return encrypted;
//
//}
//
//public String getDecryptedPass(byte[] encrypted) throws Exception {
//    Cipher cipher = getMutual();
//    cipher.init(Cipher.DECRYPT_MODE, getAesKey());
//    String realPass = new String(cipher.doFinal(encrypted));
//    return realPass;
//}

    /**
     * @return the cipher
     */
    public static Cipher getCipher() {
        return cipher;
    }

    /**
     * @param aCipher the cipher to set
     */
    public static void setCipher(Cipher aCipher) {
        cipher = aCipher;
    }
}
