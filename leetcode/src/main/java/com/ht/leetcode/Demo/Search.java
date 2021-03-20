package com.ht.leetcode.Demo;

/**
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * 二分查找
 *
 * int binarySearch(int[] nums, int target) {
 *     int left = 0;
 *     int right = nums.length - 1; // 注意
 *
 *     while(left <= right) { // 注意
 *         int mid = (right + left) / 2;
 *         if(nums[mid] == target)
 *             return mid;
 *         else if (nums[mid] < target)
 *             left = mid + 1; // 注意
 *         else if (nums[mid] > target)
 *             right = mid - 1; // 注意
 *         }
 *     return -1;
 * }
 */
public class Search {
    public int search (int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                //相同数据的判断
                while (mid != 0 && (nums[mid-1] == nums[mid])){
                    mid --;
                }
                return mid;
            }else if (nums[mid] > target){
                high = mid -1;
            }else if (nums[mid] <= target){
                low = mid +1;
            }
        }
        return -1;
    }
}
