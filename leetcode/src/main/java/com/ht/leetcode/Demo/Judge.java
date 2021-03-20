package com.ht.leetcode.Demo;

public class Judge {

    public static boolean judge (String str) {
        int len = str.length();
        for(int i = 0 ; i < len/2 ;i++){
            if(str.charAt(i)!=str.charAt(len-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(judge("abceda"));
    }
}
