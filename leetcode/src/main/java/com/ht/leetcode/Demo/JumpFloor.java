package com.ht.leetcode.Demo;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {

    public static int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        //距离目标差一步的有两种，目标差两部的有一种方式
        int pre2 = 1, pre1 = 2;
        for (int i = 3; i <= target; i++){
            //可能性就是差一步和差两步之和
            int cur = pre2 + pre1;
            //下一次循环，差一步的值就变成上一步差两步的值
            pre2 = pre1;
            //下一次循环差一步的值就是当前的可能值
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {
        JumpFloor(4);
    }
}
