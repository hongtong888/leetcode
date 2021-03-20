package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

/**
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 *
 * 思路：
 * 对比于链表，我们设定两个指针，先让第一个指针遍历 n 步，然后再让它俩同时开始遍历，
 * 这样的话，当第一个指针到头的时候，第二个指针就离第一个指针有 n 的距离，所以第二个指针的位置就刚好是倒数第 n 个结点。
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        //先让第一个链表走n
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        //然后两个链表遍历，当第一个链表遍历完，第二个链表跟第一个链表差距为n
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        //删除链表的倒数第n个节点
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        removeNthFromEnd(node1,3);

    }
}
