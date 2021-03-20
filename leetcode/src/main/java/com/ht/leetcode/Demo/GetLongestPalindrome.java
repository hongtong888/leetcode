package com.ht.leetcode.Demo;

/**
 *
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class GetLongestPalindrome {

    public static int getLongestPalindrome(String A, int n) {
        if(n == 0)
            return 0;
        int maxLen = 1;
        //中心枚举到n-2位置
        for(int i = 0; i < n-1; i++){
            // 比较以i为中心扩散的回文子串 && 以i和i+1为中心扩散的回文子串 哪个大取哪个
            int len = centerSpread(A,i,i) > centerSpread(A,i,i+1)? centerSpread(A,i,i):centerSpread(A,i,i+1);
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }

    //若left==right 则扩散中点为一个，此时的回文子串为奇数
    //若left!=right，则扩散的中点为 left和right，此时的回文子串为偶数
    public static int centerSpread(String s, int left, int right){
        int len = s.length();
        int l = left;
        int r = right;
        while(l >= 0 && r <= len-1){
            //若相等则继续扩散
            if(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }else{
                break;
            }
        }
        //为什么还要减2  因为上面while循环终止了，此时s.charAt(l) != s.charAt(r)
        //所以此时的回文子串的左右边界其实是  l-1，  r-1
        return r-l+1-2;
    }

    public static void main(String[] args) {
        getLongestPalindrome("abc1234321ab", 12);
    }
}
