package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        //设置当前节点为头节点，前节点和后节点
        ListNode cur = null;
        while (head!= null){
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
}
