package com.ht.leetcode.Demo;


import com.ht.leetcode.Model.ListNode;

/**
 * 判断链表是否有环，有环的话指出入口
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null){
            return null; //说明没有环
        }
        //快节点跟相遇节点都走一步，相遇就是入口节点
        ListNode fast = head;
        ListNode slow = meetingNode;
        while (slow !=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode meetingNode(ListNode head) {
        //定义两个节点 一个快节点  一个慢节点
        ListNode fast = head;
        ListNode slow = head;
        //快节点走两步，慢节点走一步，能相等就表示有环
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return  slow;
            }
        }
        return null;
    }
}




