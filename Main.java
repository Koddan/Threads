package com.company;


import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {

        /*Integer a = 5;
        Integer b = 6;
        MyThread one = new MyThread(a, b);
        MyThread two = new MyThread(b, a);
        one.start();
        two.start();*/

        TaskQueue queue = new TaskQueue();
        queue.push(new MyTask(1, 20));
        queue.push(new MyTask(20, 50));
        queue.push(new MyTask(1, 50));
        queue.find(5);
        out.println("Выполненные задания для разных интервалов");
        queue.showResult();
        out.println();

        TaskQueue queue1 = new TaskQueue();
        queue1.push(new MyTask(20, 10000));
        queue1.push(new MyTask(1, 10000));
        queue1.push(new MyTask(1, 10000));
        queue1.push(new MyTask(1, 10000));
        long start = currentTimeMillis();
        out.println("Время расчета для очереди из 4 интервалов на 10000 чисел с 1 потоком");
        queue1.find(1);
        long finish = currentTimeMillis();
        out.println(finish - start);
        start = currentTimeMillis();
        out.println("Время расчета для очереди из 4 интервалов на 10000 чисел с 2 потоками");
        queue1.find(2);
        finish = currentTimeMillis();
        out.println(finish - start);


    }
}