package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

/**
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node1.next = node2;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node5.next = node6;
        node4.next = node5;

        ListNode node = mergeTwoLists(node1, node4);
    }

    //解法一  进行迭代
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode ans = node;
        while (l1!=null && l2!=null){
            if (l1.val <l2.val){
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
            if (l1 == null){
                node.next = l2;
            }
            if (l2 == null){
                node.next = l1;
            }
        }
        return  ans.next;
    }

    //递归
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l2.next, l1);
            return l2;
        }
    }

}
