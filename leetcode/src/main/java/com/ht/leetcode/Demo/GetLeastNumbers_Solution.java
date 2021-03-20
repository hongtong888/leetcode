package com.ht.leetcode.Demo;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 第一种简单解法，先进行排序，然后在取出前K个数
 */
public class GetLeastNumbers_Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input.length == 0 || k == 0 || input.length < k){
            return result;
        }

        for(int i = 1; i < input.length; i++){
            if(input[i] < input[i-1]){
                int j = i-1;
                while(j >= 0){
                    if(input[j] > input[j+1]){
                        int temp = input[j+1];
                        input[j+1] = input[j];
                        input[j] = temp;
                    }
                    j--;
                }
            }
        }

        for(int i = 0; i < k; i++){
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution(input, 3);

    }
}
