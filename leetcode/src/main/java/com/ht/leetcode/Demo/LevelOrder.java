package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 通过队列 Queue 的数据结构，存一下，在取一下
 */
public class LevelOrder {
    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // 借助队列进行层次遍历
        ArrayList<ArrayList<Integer>> Res = new ArrayList<ArrayList<Integer>>();//存放遍历结果

        Queue<TreeNode> Q = new LinkedList<TreeNode>();//创建队列
        Q.add(root);
        if(root==null){
            return Res;
        }
        while(!Q.isEmpty()){
            ArrayList<Integer> result = new ArrayList<Integer>();
            int size = Q.size();//当前队列中的元素个数(当前层)

            for(int i=1;i<=size;i++){ //将当前层的节点出队，并且将其相应的孩子节点出队
                TreeNode temp = Q.poll();//出队
                result.add(temp.val);
                if(temp.left!=null){
                    Q.add(temp.left);
                }
                if(temp.right!=null){
                    Q.add(temp.right);
                }
            }
            Res.add(result);//将当前层的遍历结果存放到Res

        }
        return Res;
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
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(treeNode);
    }
}
