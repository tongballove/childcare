/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.childcare.util;

import java.security.MessageDigest;

/**
 *
 * @author Le Hoang Phong
 */
public class HashMD5 {

    public HashMD5() {
    }

    public String hashmd5(String pass) {
        byte[] hash;
        String strTemp = "";
        try {
            //MD5 have keysize : 16
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(pass.getBytes("UTF8"));
            for (int i = 0; i < hash.length; i++) {
                strTemp += Byte.toString(hash[i]);
            }
        } catch (java.security.NoSuchAlgorithmException ex) {
            return strTemp;
        } catch (java.io.UnsupportedEncodingException x) {
            return strTemp;
        }
        return strTemp;
    }
}
