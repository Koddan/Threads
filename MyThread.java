package com.company;

import static java.lang.System.out;

public class MyThread extends Thread {

    private final Integer a;
    private final Integer b;

    MyThread(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {

        synchronized(a) {
            out.println(getName()+ " - locked");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(b) {
                out.println(b + getName()+ " - locked");
            }
        }
        out.println("HELLO WORLD");
    }

}
