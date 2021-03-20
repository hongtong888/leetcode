package com.ht.leetcode.Demo;

/**
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 */
public class LCS {

    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(LCS1(str1, str2));
    }

    public static String LCS (String str1, String str2) {
        if(str1.length() == 0 ||str2.length() == 0 ){
            return "-1";
        }
        int lenOfStr1 = str1.length();
        int lenOfStr2 = str2.length();
        int dp[] = new int[lenOfStr2];
        int max = 0;
        int indexOfMax = 0;
        for(int i = 0 ;i < lenOfStr1 ;i++ ){
            int previous = 0;//记录修改前的dp数值，因为后面一个dp元素需要用到，初始时，第一个元素的前一个元素是0
            for(int j = 0 ;j < lenOfStr2 ;j++ ){
                int temp = dp[j];//记录修改前的dp数值，因为后面一个dp元素需要用到
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[j] = previous + 1;
                }else{
                    dp[j] = 0;
                }
                previous = temp;//记录修改前的dp数值，因为后面一个dp元素需要用到
                if(dp[j] > max){
                    max = dp[j];
                    indexOfMax = j;
                }
            }
        }
        if(max != 0)
            return str2.substring(indexOfMax-max+1,indexOfMax+1);
        return "-1";
    }

    public static String LCS1 (String str1, String str2) {
        String result = "";
        int start = 0;
        int end = 1;
        while(end<=str2.length()){
            String subStr = str2.substring(start,end);
            if(str1.contains(subStr)){
                result = subStr;
            }else{
                start++;
            }
            end++;
        }
        return result;
    }
}
