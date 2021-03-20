package com.ht.leetcode.Demo;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 *
 * 采用动态规划思路
 *
 * 用一个一维数组 dp [ i ] 表示以下标 i 结尾的子数组的元素的最大的和，也就是这个子数组最后一个元素是下边为 i 的元素，并且这个子数组是所有以 i 结尾的子数组中，和最大的。
 *
 * 这样的话就有两种情况，
 *
 * 如果 dp [ i - 1 ] < 0，那么 dp [ i ] = nums [ i ]。
 * 如果 dp [ i - 1 ] >= 0，那么 dp [ i ] = dp [ i - 1 ] + nums [ i ]。
 */

public class MaxsumofSubarray {

    public static void main(String[] args) {
        int[] nums = {-3, -2, 3, -1, -2, 6, -1};
        System.out.println(maxsumofSubarray(nums));
    }

    public static int maxsumofSubarray (int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //分两种情况  一种上一位的dp数组是否大于0
            if (dp[i-1] <0 ){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1]+nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return  max;
    }
}
