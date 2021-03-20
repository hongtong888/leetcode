package com.ht.leetcode.Demo;


import com.ht.leetcode.Model.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    /**
     * 前序遍历，所谓的前序遍历就是先访问根节点，再访问左节点，最后访问右节点，
     * 中序遍历，所谓的中序遍历就是先访问左节点，再访问根节点，最后访问右节点，
     *
     * 思路：则根据二叉树前序和中序的规律：
     * 前序序列的第一个元素即为根节点，根据根节点的值在中序序列找到根节点的位置假定为i
     * 前序序列索引1~i构成子数列为根节点左子树的前序序列，i+1~n1构成子数列为根节点右子树的前序序列（n1为前序序列的长度）；
     * 中序序列索引0~i-1构成子数列为根节点左子树的中序序列，i+1~n1构成子数列为根节点右子树的中序序列（n1为前序序列的长度）；
     * 根节点的左节点为左子树的根节点，根节点的右节点为右子树的根节点
     * 根据这样的规律一直递归下去，直到序列为空。
     * @param args
     */
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructTree(pre, in);
    }

    public static TreeNode reConstructTree(int[] pre, int[] in){
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
            root.left = reConstructTree(pr, in0);
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
            root.right=reConstructTree(pr,ino);
        }else{
            root.right=null;
        }
        return root;
    }
}

