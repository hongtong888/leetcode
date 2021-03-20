package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class IsBalancedTree {

    private boolean flag = true ;

    public boolean IsBalanced_Solution(TreeNode root) {
        judge(root);
        return flag ;
    }

    public int judge(TreeNode r){
        if(r == null) return 0 ;
        int left = judge(r.left) ;
        int right = judge(r.right) ;
        if((left-right)>1 || (right-left)>1){
            flag = false ;
            return -1 ;
        }
        return left>right?left+1:right+1;
    }
}
