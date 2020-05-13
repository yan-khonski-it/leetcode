package com.yk.training.leetcode.merge_sorted_lists;

/**
 * Runtime: 248 ms, faster than 9.60% of Java online submissions for Merge k Sorted Lists.
 * Memory Usage: 41.1 MB, less than 43.17% of Java online submissions for Merge k Sorted Lists.
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/discuss/630517/Simple-and-easy-Java-but-not-the-fastest
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode res = null;
        ListNode nextNode = null;

        while (notFinished(lists)) {
            int nextValue = iterateToNextElement(lists);
            if (res == null) {
                res = new ListNode(nextValue);
                nextNode = res;
            } else {
                nextNode.next = new ListNode(nextValue);
                nextNode = nextNode.next;
            }
        }

        return res;
    }

    private int iterateToNextElement(ListNode[] lists) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0;i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }
        }

        lists[minIndex] = lists[minIndex].next;

        return minValue;
    }

    private boolean notFinished(final ListNode[] lists) {
        for (ListNode listNode : lists) {
            if (listNode != null) {
                return true;
            }
        }

        return false;
    }
}
