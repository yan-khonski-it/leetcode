package com.yk.training.leetcode.algorithms.swap_nodes_in_pairs;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 * <p>
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Solution {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode swapPairs(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode futureHead = head.next;

        head.next = head.next.next;
        futureHead.next = head;

        if (futureHead.next.next != null) {
            futureHead.next.next = swapPairs(futureHead.next.next);
        }


        return futureHead;
    }

    public static void main(final String[] args) {
        final ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        final ListNode swappedList = swapPairs(list);
        printList(swappedList);
    }

    private static void printList(final ListNode list) {
        ListNode current = list;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;

        }
    }
}
