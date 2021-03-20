package com.ht.leetcode.Demo;

import com.ht.leetcode.Model.ListNode;

public class SortInList {

    public ListNode sortInList (ListNode head) {
        if (head==null && head.next==null){
            return head;
        }
        ListNode move = head;
        while (move.next !=null) {
            ListNode temp = move.next;
            while (temp.next !=null){
                //如果下一个节点比头结点小，则进行替换
                if (temp.val < move.val){
                    int val = temp.val;
                    temp.val = move.val;
                    move.val = val;
                }
                temp = temp.next;
            }
            move = move.next;
        }
        return head;
    }
}
