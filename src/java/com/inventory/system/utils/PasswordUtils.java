/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ayeola
 */
public class PasswordUtils {
    
    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        byte[] passwordBytes = password.getBytes();
        byte[] digest = sha512.digest(passwordBytes);
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        for (byte b : digest){
            s = Integer.toHexString((int)b & 0xff).toUpperCase();
            if(s.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
    
    
    public String generatePassword(){
        Random rd = new Random();
        int n = 10;
        char lowerChars[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char upperChars[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char numbers[] = "0123456789".toCharArray();
        char specialChars[] = "!@#$%&".toCharArray();
        List<Character> pwdLst = new ArrayList<Character>();
        for(int g = 0; g < 4; g++){
            for(int z = 0; z < 1; z++){
                if(g == 0){
                    pwdLst.add(numbers[rd.nextInt(10)]);
                }
                else if(g == 1){
                    pwdLst.add(lowerChars[rd.nextInt(26)]);
                }
                else if(g == 2){
                    pwdLst.add(upperChars[rd.nextInt(26)]);
                }
                else if(g == 3){
                    pwdLst.add(specialChars[rd.nextInt(6)]);
                }
            }
            if(pwdLst.size() == n){
                break;
            }
            if(g + 1 == 4){
                g = (int) Math.random() * 5;
            }
        }
        StringBuilder password = new StringBuilder();
        Collections.shuffle(pwdLst);
        for(int c = 0; c < pwdLst.size(); c++){
            password.append(pwdLst.get(c));
        }
        return password.toString();
    }
}
