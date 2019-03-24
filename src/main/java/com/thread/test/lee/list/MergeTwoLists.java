package com.thread.test.lee.list;

import com.thread.test.data.ListNode;

//#21
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode rr = m1(new ListNode(new int[]{1, 3, 5}), new ListNode(new int[]{2, 4, 6}));
        System.out.println(rr.toString());
    }
    public static ListNode m1(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null){
            if(l1.value < l2.value){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }else {
            cur.next  = l1;
        }
        return dummy.next;
    }
}
