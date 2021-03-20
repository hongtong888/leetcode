package com.ht.leetcode.Demo;

/**
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 *
 * 1.动态规划：dp[i][j]表示(0,0)到(i,j)位置的最小路径和
 * 2.初始状态：dp[i][0] = dp[i-1][0] + matrix[i][0]；dp[0][i] = dp[0][i-1] + matrix[0][i]
 * 3.过渡公式：dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j]；到(i,j)的最小路径和等于上方和左方的较小路径和加上当前位置值
 */
public class MinPathSum {

    public static int minPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        int minPathSum = minPathSum(arr);
    }
}
