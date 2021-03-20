package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

import java.util.ArrayList;

/**
 * 合并\ k k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
 *
 采用分治 讲集合列表划分成两个集合进行合并
 */
public class MergeKLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        return mergeKLists(lists,0,lists.size()-1);
    }

    private ListNode mergeKLists(ArrayList<ListNode> lists, int low, int high) {
        //分治  讲list集合看成是两个集合，在将两个集合进行合并
        if (high <= low){
            return lists.get(low);
        }
        int mid = low + (high - low)/2;
        ListNode leftNode = mergeKLists(lists, low, mid);
        ListNode rightNode = mergeKLists(lists, mid + 1, high);
        return mergeTwoList(leftNode,rightNode);
    }

    private ListNode mergeTwoList(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null || rightNode == null){
            return leftNode == null? rightNode:leftNode;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (leftNode!=null && rightNode !=null){

            if (leftNode.val < rightNode.val){
                dummy.next = leftNode;
                dummy = dummy.next;
                leftNode = leftNode.next;

            }else {
                dummy.next = rightNode;
                dummy = dummy.next;
                rightNode = rightNode.next;
            }
            if (leftNode == null){
                dummy.next = rightNode;
            }
            if (rightNode == null){
                dummy.next = leftNode;
            }
        }
        return temp.next;
    }
}
