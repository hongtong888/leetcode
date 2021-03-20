package com.ht.leetcode.Demo;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。  [1,3,5,2,2],5,3
 */
public class FindKth {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,2};
        findKth(arr,5,3);
    }

    public static int findKth(int[] a, int n, int K) {
        return findK(a, 0, n-1, K);
    }

    private static int findK(int[] a, int left, int right, int k) {
        if (left<= right){
            //寻找中间数
            int point = partion(a, left, right);
            if (point == k -1){
                return a[point];
            }else if (point < k-1 ){
                findK(a, point+1,right,k);
            }else{
                findK(a,left,point-1,k);
            }
        }
        return -1;
    }

    private static int partion(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
