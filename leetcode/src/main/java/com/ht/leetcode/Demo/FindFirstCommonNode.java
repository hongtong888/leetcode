package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FindFirstCommonNode {

    public static ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null){
            return null;
        }
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != node2){
            if (node1 == null){
                node1 = node2;
            }else{
                node1 = node1.next;
            }
            if (node2 == null){
                node2 = node1;
            }else{
                node2 = node2.next;
            }
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(3);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        ListNode nod1 = new ListNode(4);
        ListNode nod2 = new ListNode(3);

        nod1.next = nod2;
        ListNode node = FindFirstCommonNode(node1, nod1);
    }
}
