package com.ht.leetcode.Demo;

/**
 * 给定一个数组，请你编写一个函数，返回该数组排序后的形式。
 */
public class MySort {
    public static void main(String[] args) {
        int[] arr = {2,4,2,3,1,6,5};
        int[] sort = MySort(arr);
        for (int i : sort) {
            System.out.println(i);
        }
    }
    /**
     * 采用快速排序
     * @param arr
     * @return
     */
    public static int[] MySort (int[] arr) {
        if (arr.length == 0){
            return new int[0];
        }
        quickSort(arr, 0, arr.length-1);
        return arr;

    }

    public static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);
            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }
    }

    /**
     * 分割数组，找到分割点
     */
    public static int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            //从右往左比较，知道找到小于基准的数
            while (left < right && list[right] >= first) {
                right--;
            }

            // 将小于基础的数，替换数组最左边的数
            list[left] = list[right];

            //从左往右比较，比较出大于基准的数
            while (left < right && list[left] <= first) {
                left++;
            }
            list[right] = list[left];
        }
        list[left] = first;
        // 返回分割点所在的位置
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
