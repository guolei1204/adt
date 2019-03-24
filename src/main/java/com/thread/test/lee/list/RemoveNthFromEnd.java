package com.thread.test.lee.list;

import com.thread.test.data.ListNode;

public class RemoveNthFromEnd {

    public  static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i =1 ;i <= n + 1; i++){
            first = first.next;
        }

        while (first !=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return  dummy.next;
    }


    public static void main(String[] args) {
        ListNode ll = new ListNode(new int[]{1,2,3,4,5,6});
        ListNode rr = removeNthFromEnd(ll, 2);
        System.out.println(rr.toString());
    }
}
