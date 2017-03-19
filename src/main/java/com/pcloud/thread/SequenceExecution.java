package com.pcloud.thread;

import java.util.concurrent.Semaphore;

/**
 * Given class Foo with three methods first, second, third. The same instance of Foo will be passed into 3 threads.
 * Thread A will call method first(). Thread B will call method second(). Thread C will call method third().
 * Design class Foo to ensure that first() is called before second(), second() is called before third().
 */
public class SequenceExecution {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.first();
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.second();
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.third();
            }
        });

        threadC.start();
        threadB.start();
        threadA.start();
    }
}

class Foo {
    private Semaphore sm1 = new Semaphore(1);
    private Semaphore sm2 = new Semaphore(1);
    private Semaphore sm3 = new Semaphore(1);

    public Foo() {
        try {
            // initially acquire lock
            sm1.acquire();
            sm2.acquire();
            sm3.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first() {
        try {
            System.out.println("First called");
            Thread.sleep(1000);
            sm1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void second() {
        try {
            sm1.acquire();
            sm1.release();

            System.out.println("Second called");
            Thread.sleep(1000);
            sm2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            sm2.acquire();
            sm2.release();

            System.out.println("Third called");
            Thread.sleep(1000);
            sm3.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
