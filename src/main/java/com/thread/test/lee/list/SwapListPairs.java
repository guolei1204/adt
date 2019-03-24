package com.thread.test.lee.list;

import com.thread.test.data.ListNode;

public class SwapListPairs {
    public static void main(String[] args) {
        ListNode in = new ListNode(new int[]{1, 3, 7, 9, 14, 13, 18});
//        ListNode rr = swapPairs(in);
//        System.out.println(rr);
        ListNode r2 = swapPairs2(in);
        System.out.println(r2);
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    private static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur, first, second,tmp;
        cur = dummy;
        while (cur.next != null) {
            first = cur.next;
            second = cur.next.next;
            if(second == null){
                break;
            }
            tmp = second.next;
            first.next = tmp;
            second.next = first;
            cur.next= second;
            cur = cur.next.next.next;
        }
        return dummy.next;
    }
}
