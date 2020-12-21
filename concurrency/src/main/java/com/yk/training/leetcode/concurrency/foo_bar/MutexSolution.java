package com.yk.training.leetcode.concurrency.foo_bar;

import java.util.concurrent.Semaphore;

public class MutexSolution {

    public static void main(final String[] args) {
        final Runnable printFoo = () -> System.out.println("Foo");
        final Runnable printBar = () -> System.out.println("Bar");

        final int n = 5;
        final FooBar fooBar = new FooBar(n);

        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted.", e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted.", e);
            }
        });

        t2.start();
        t1.start();
    }
}


class FooBar {

    private final Semaphore fooSemaphore = new Semaphore(1);
    private final Semaphore barSemaphore = new Semaphore(0);

    private int n;

    public FooBar(final int n) {
        this.n = n;
    }

    public void foo(final Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

            barSemaphore.release();
        }
    }

    public void bar(final Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();

            fooSemaphore.release();
        }
    }
}