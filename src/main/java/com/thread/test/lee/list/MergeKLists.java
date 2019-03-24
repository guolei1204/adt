package com.thread.test.lee.list;

import com.thread.test.data.ListNode;

//#23
public class MergeKLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(new int[]{1, 4, 5});
        ListNode n2 = new ListNode(new int[]{1, 3, 4});
        ListNode n3 = new ListNode(new int[]{2, 6});
        ListNode rr = m1(new ListNode[]{n1, n2, n3});
        System.out.println(rr);
    }

    private static ListNode m1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return work(lists, 0, lists.length - 1);
    }

    private static ListNode work(ListNode[] lists, int l, int r) {
        int mid = (l + r) / 2;
        if (l < r) {
            ListNode l1 = work(lists, l, mid);
            ListNode l2 = work(lists, mid + 1, r);
            return mergeTwo(l1, l2);
        }
        return lists[l];
    }

    private static ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.value < l2.value) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l2.next, l1);
            return l2;
        }
    }
}
