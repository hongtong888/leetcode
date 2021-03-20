package com.ht.leetcode.Demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标。
 *
 * 第一种暴力遍历
 * 第二种，用一个map map的key是数组的值，value 是数组的长度
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums =  {110, 20, 70, 150};
        int[] twoSum = twoSum(nums, 90);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(map.containsKey(sub)){
                return new int[]{i+1,map.get(sub)+1};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
