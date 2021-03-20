package com.ht.leetcode.Demo;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 */
public class Fibonacci {

    public static int Fibonacci(int n) {
        int[] array=new int[40];
        array[0]=0;
        array[1]=1;
        for(int i=2;i<=n;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array[n];
    }

    public static void main(String[] args) {
        Fibonacci(10);
    }
}
