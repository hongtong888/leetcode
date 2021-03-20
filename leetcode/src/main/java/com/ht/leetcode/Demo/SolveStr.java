package com.ht.leetcode.Demo;

/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 开辟一个和str长度大小相同的一个字符串ans，把传入的str倒序赋值到ans字符串上
 */
public class SolveStr {

    public String solve (String str) {
        char[] ans = str.toCharArray();
        int len = str.length();
        for(int i = 0 ; i < len ;i++){
            ans[i] = str.charAt(len-1-i);
        }
        return new String(ans);
    }
}
