/**
 * https://leetcode.com/problems/print-in-order/
 *
 * <code><pre>
 *     public class Foo {
 *         public void first() { print("first"); }
 *         public void second() { print("second"); }
 *         public void third() { print("third"); }
 *     }
 * </pre></code>
 * <p>
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure
 * that second() is executed after first(),
 * and third() is executed after second().
 */


package com.yk.training.leetcode.algorithms.print_in_order;