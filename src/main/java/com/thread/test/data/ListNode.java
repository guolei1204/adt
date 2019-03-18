package com.thread.test.data;

public class ListNode {
    public ListNode next;
    public int value;

    public ListNode(int i) {
        value = i;
    }

    public ListNode(int[] list) {
        value = list[0];
        ListNode tmp = this;
        for (int i = 1; i < list.length; i++) {
            tmp.next = new ListNode(list[i]);
            tmp = tmp.next;
        }
    }

    @Override
    public String toString() {
        ListNode tmp = this.next;
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.value);
        while (tmp != null) {
            sb.append("->").append(tmp.value);
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(new int[]{3, 2, 9});
        System.out.println(nodes.toString());
    }
}
