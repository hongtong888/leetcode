package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 *
 * 这是
 */
public class ReConstructTreeAndGetRightView {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        int[] solve = solve(pre, in);
    }

    public static int[] solve (int[] xianxu, int[] zhongxu) {
        //先根据前序和中序排序获取到原节点
        TreeNode treeNode = ReConstructTreeAndGetRightView(xianxu, zhongxu);
        //在打印出右视图
        List<Integer> list = getRightView(treeNode);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static List<Integer> getRightView(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            TreeNode cur = null;
            while (size > 0) {
                size--;
                cur = list.removeFirst();
                if (cur.left != null) {
                    list.add(cur.left);
                }
                if (cur.right != null) {
                    list.add(cur.right);
                }
            }
            res.add(cur.val);
        }
        return res;
    }


    public static TreeNode ReConstructTreeAndGetRightView(int[] pre, int[] in){
        //前序序列的第一个元素为根
        TreeNode root = new TreeNode(pre[0]);
        int length = pre.length;
        if (length == 1){
            //只有一个元素就直接返回
            return root;
        }
        //找到中序序列的根节点位置
        int rootVal = root.val; //
        //跟节点的值就是中序序列的根节点位置
        int i;
        for ( i = 0; i < length; i++) {
            if (rootVal == in[i]){
                break;
            }
        }
        //创建左子数
        if(i>0){
            //左子树的前序序列，和中序序列
            int[] pr = new int[i];
            int[] in0 = new int[i];
            for (int j = 0; j < i; j++) {
                pr[j] = pre[j+1];
            }
            for (int j = 0; j < i; j++) {
                in0[j] = in[j];
            }
            root.left = ReConstructTreeAndGetRightView(pr, in0);
        }else {
            root.left = null;
        }

        if(length-i-1>0){
            int[] pr=new int[length-i-1];
            int[] ino=new int[length-i-1];
            for(int j=i+1;j<length;j++){
                ino[j-i-1]=in[j];
                pr[j-i-1]=pre[j];
            }
            root.right=ReConstructTreeAndGetRightView(pr,ino);
        }else{
            root.right=null;
        }
        return root;
    }
}
