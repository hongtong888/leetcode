package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  二叉树的遍历主要有三种：
 *
 * （1）先(根)序遍历（根左右）
 * （2）中(根)序遍历（左根右）
 * （3）后(根)序遍历（左右根）
 */
public class ThreeOrders {

    List<Integer> preEachList = new ArrayList<Integer>();
    List<Integer> inOrderEachList = new ArrayList<Integer>();
    List<Integer> afterEachList = new ArrayList<Integer>();

    public int[][] threeOrders (TreeNode root) {
        // 前序排序
        List<Integer> prevEachList = preEach(root);
        // 中序排序
        // 中序
        List<Integer> inEachList = inOrderEach(root);
        // 后序排序
        List<Integer> afterOfEachList = afterEach(root);

        int[][] result = new int[3][prevEachList.size()];
        result[0] = convertToInt(prevEachList);
        result[1] = convertToInt(inEachList);
        result[2] = convertToInt(afterOfEachList);
        return result;
    }

    private List<Integer> preEach(TreeNode root) {
        if (root == null){
            return preEachList;
        }
        preEachList.add(root.val);
        preEach(root.left);
        preEach(root.right);
        return preEachList;
    }

    private List<Integer> inOrderEach(TreeNode root) {
        if (root == null) {
            return inOrderEachList;
        }
        inOrderEach(root.left);
        inOrderEachList.add(root.val);
        inOrderEach(root.right);
        return inOrderEachList;
    }

    private List<Integer> afterEach(TreeNode root) {
        if (root == null){
            return afterEachList;
        }
        afterEach(root.left);
        afterEach(root.right);
        afterEachList.add(root.val);
        return afterEachList;
    }

    // 转换成int数组
    public int[] convertToInt(List<Integer> list){
        if(list == null || list.size()==0){
            return null;
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

}
