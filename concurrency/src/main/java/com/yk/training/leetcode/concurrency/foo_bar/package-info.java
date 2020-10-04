/**
 * https://leetcode.com/problems/print-foobar-alternately/
 *
 * <code><pre>
 *     class FooBar {
 *         public void foo() {
 *             for (int i = 0; i < n; i++) {
 *                 print("foo");
 *             }
 *         }
 *
 *     public void bar() {
 *         for (int i = 0; i < n; i++) {
 *             print("bar");
 *         }
 *     }
 * }
 * </pre></code>
 *
 * The same instance of FooBar will be passed to two different threads.
 * Thread A will call foo() while thread B will call bar().
 * Modify the given program to output "foobar" n times.
 */
package com.yk.training.leetcode.concurrency.foo_bar;