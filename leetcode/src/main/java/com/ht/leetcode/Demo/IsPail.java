package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

/**
 * 给定一个链表，请判断该链表是否为回文结构。
 *
 * 讲链表反转，在一个节点一个节点的比较
 */
public class IsPail {

    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur.next!= null){
            next = cur.next;
            cur.next = pre;
            pre= cur;
            cur = next;
        }
        return cur;
    }
    public static boolean isPail (ListNode head) {
        ListNode front = head;
        ListNode back = reverseList(head);
        while(front!=null){
            if(front.val==back.val){
                front=front.next;
                back = back.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
