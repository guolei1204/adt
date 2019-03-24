package com.thread.test.lee.list;

import com.thread.test.data.ListNode;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode in = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNode rr = reverse(in,4);
        System.out.println(rr);
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProcess = 0;
        int count = 0;
        while (canProcess < k && check != null) {
            check = check.next;
            canProcess++;
        }
        if (canProcess == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count++;
            }
            if (next != null){
                head.next = reverse(next,k);
            }
            return pre;
        } else {
            return head;
        }
    }
}
