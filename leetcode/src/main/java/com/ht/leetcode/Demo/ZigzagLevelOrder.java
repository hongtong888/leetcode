package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 *
 * 通过队列 Queue 的数据结构，存一下，在取一下。在给个标示位，交替添加
 */
public class ZigzagLevelOrder {

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        if (root == null){
            return  result;
        }

        boolean flag = false;
        while (!queue.isEmpty()){
            ArrayList<Integer> res = new ArrayList<Integer>();
            int size = queue.size();

            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left !=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            if (flag){
                Collections.reverse(res);
                flag = false;
            }else{
                flag = true;
            }
            result.add(res);
        }
        return  result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        ArrayList<ArrayList<Integer>> arrayLists = zigzagLevelOrder(treeNode);
    }
}
