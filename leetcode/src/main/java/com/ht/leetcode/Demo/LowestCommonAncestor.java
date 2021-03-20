package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.TreeNode;

/**
 * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 * 思路，假如两个节点在左子树中的最近共同祖先是 r，那么当前树的最近公共祖先也就是 r，所以我们可以用递归的方式去解决。
 */
public class LowestCommonAncestor {

    public static int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        TreeNode node = lowestAcnestor(root,o1 ,o2 );
        return node.val;

    }

    public static TreeNode lowestAcnestor(TreeNode head,int o1,int o2){
        if (head == null || head.val == o1 || head.val == o2){
            return head;
        }
        //先从左子树查找目标点
        TreeNode leftNode = lowestAcnestor(head.left, o1, o2);
        //早从右子树查找目标点
        TreeNode rightNode = lowestAcnestor(head.right, o1, o2);
        //左子树和右子树都查到说明最近公共节点是根节点
        if (leftNode!=null && rightNode!=null){
            return head;
        }
        return leftNode!=null? leftNode:rightNode;
    }
}
