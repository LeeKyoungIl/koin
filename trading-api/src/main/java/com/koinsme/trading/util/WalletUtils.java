package com.koinsme.trading.util;

import com.koinsme.trading.util.enums.Algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WalletUtils {

    public static String generateWalletHashValue(String email) {
        return getHashValue(email, Algorithm.SHA_256);
    }

    public static String generatePasswod (String password) {
        return getHashValue(password, Algorithm.MD5);
    }

    private static String getHashValue (String strValue, Algorithm algorithm) {
        String walletShaHashCode = "";
        try{
            MessageDigest sh = MessageDigest.getInstance(algorithm.getAlgorithm());
            sh.update(strValue.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();

            for(int i = 0 ; i < byteData.length ; i++){
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }

            walletShaHashCode = sb.toString();
        } catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            walletShaHashCode = null;
        }

        return walletShaHashCode;
    }


}
