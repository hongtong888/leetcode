package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

public class AddInList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);

        node2.next = node3;
        node1.next = node2;

        ListNode nod1 = new ListNode(6);
        ListNode nod2 = new ListNode(3);

        nod1.next = nod2;

        ListNode listNode = addInList(node1, nod1);

    }

    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        head1 = reverse(head1);
        head2 = reverse(head2);

        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carry;
            int val = sum%10;
            carry = sum/10;

            tail.next = new ListNode(val);
            tail = tail.next;

            head1 = head1.next;
            head2 = head2.next;
        }

        ListNode last = head1 != null ? head1 : head2;
        while (last != null) {
            int sum = last.val + carry;
            carry = sum/10;
            tail.next = new ListNode(sum%10);
            tail = tail.next;

            last = last.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }

    private static ListNode reverse(ListNode head) {
        ListNode dummy = null;
        while (head !=null){
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}
