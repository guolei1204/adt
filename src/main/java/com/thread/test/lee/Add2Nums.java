package com.thread.test.lee;

import com.thread.test.data.ListNode;

public class Add2Nums {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.value + l2.value;
        int swiftLeft = sum / 10;
        ListNode result = new ListNode(sum % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode tmp = result;
        while (l1 != null || l2 != null || swiftLeft > 0) {
            sum = swiftLeft;
            if (l1 != null) {
                sum += l1.value;
            }
            if (l2 != null) {
                sum += l2.value;
            }
            tmp.next = new ListNode(sum % 10);
            swiftLeft = sum / 10;
            tmp = tmp.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(new ListNode(new int[]{9, 9, 3}), new ListNode(new int[]{6, 7, 7, 3}));
        System.out.println(result);
    }
}
