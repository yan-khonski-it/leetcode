package com.yk.training.leetcode.merge_sorted_lists;

import java.util.PriorityQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * <p>
 * Runtime: 5 ms, faster than 47.08% of Java online submissions for Merge k Sorted Lists.
 * Memory Usage: 40.6 MB, less than 53.56% of Java online submissions for Merge k Sorted Lists.
 */
public class PriorityQueueSolution {

    private final PriorityQueue<Pair> queue = new PriorityQueue<>();

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
        // Initialize the cache with first elements of the lists.
        if (queue.isEmpty()) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.add(new Pair(lists[i].val, i));
                }
            }
        }

        final Pair min = queue.poll();
        Integer index = min.index;
        Integer value = min.value;

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
        lists[index] = lists[index].next;

        // Move index list to the next element
        if (lists[index] != null) {
            queue.offer(new Pair(lists[index].val, index));
        }

        return value;
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

class Pair implements Comparable<Pair> {
    Integer value;
    Integer index;

    public Pair(Integer value, Integer index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        return value - o.value;
    }
}

class ListNode {
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
