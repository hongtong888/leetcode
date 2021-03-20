package com.ht.leetcode.Demo;

import java.util.HashMap;

public class MaxLength {

    public static int maxLength (int[] arr) {
        int n = arr.length;
        if(n < 2) return n;
        int res = 0;
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        int i = 0, j = 0;
        while (j < n) {
            if (!map.containsKey(arr[j])) {
                map.put(arr[j], j);
            } else {
                i = Math.max(i, map.get(arr[j])+1);
                map.put(arr[j], j);
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,4,3,3};
        System.out.println(maxLength(arr));
    }
}
