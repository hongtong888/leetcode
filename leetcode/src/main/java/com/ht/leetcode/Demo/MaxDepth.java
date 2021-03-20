package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.TreeNode;

/**
 * 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 */
public class MaxDepth {

    public int maxDepth (TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);

    }
}
