package com.yk.training.leetcode.algorithms.print_in_order;

import java.util.concurrent.Semaphore;

public class SolutionUsingMutex {

    private final Semaphore mutex1 = new Semaphore(0);
    private final Semaphore mutex2 = new Semaphore(0);

    public SolutionUsingMutex() {
    }

    public static void main(final String[] args) {
        final Runnable print1 = buildPrintRunnable("first");
        final Runnable print2 = buildPrintRunnable("second");
        final Runnable print3 = buildPrintRunnable("third");

        final SolutionUsingMutex solution = new SolutionUsingMutex();

        final Thread t1 = new Thread(() -> {
            try {
                solution.first(print1);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted.", e);
            }
        });

        final Thread t2 = new Thread(() -> {
            try {
                solution.second(print2);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted.", e);
            }
        });

        final Thread t3 = new Thread(() -> {
            try {
                solution.third(print3);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted.", e);
            }
        });

        t3.start();
        t2.start();
        t1.start();
    }

    private static Runnable buildPrintRunnable(final String textToPrint) {
        return () -> System.out.println(textToPrint);
    }

    public void first(final Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        mutex1.release();
    }

    public void second(final Runnable printSecond) throws InterruptedException {
        mutex1.acquire();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        mutex2.release();
    }

    public void third(final Runnable printThird) throws InterruptedException {
        mutex2.acquire();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
