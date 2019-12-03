package com.company;

import java.util.*;
import java.util.logging.Logger;

public class TaskQueue {

    private LinkedList<MyTask> tasks;
    private static Logger logger = Logger.getLogger(TaskQueue.class.getName());

    TaskQueue() {
        tasks = new LinkedList<MyTask>();
    }

    public void push(MyTask obj) {
        tasks.push(obj);
    }

    private MyTask pop() {
        return tasks.removeLast();
    }

    public static class FindPrimes extends Thread {

        final MyTask task;

        FindPrimes(MyTask task) {
            this.task = task;
        }

        @Override
        public void run() {
            for (int i = task.getStart(); i < task.getEnd(); i++) {
                int flag = 1;
                int j = i - 1;
                while (j > 1) {
                    if ((i % j) == 0) {
                        flag = 0;
                        break;
                    }
                    j--;
                }
                if (flag == 1) {
                    task.addAnswer(i);
                }
            }

        }

        private MyTask getResult() {
            return this.task;
        }

    }

    void find(int a) {
        FindPrimes[] threads = new FindPrimes[a];
        int counter = 0;
        int size = tasks.size();
        LinkedList<MyTask> completeTasks = new LinkedList<MyTask>();
        while (counter != size) {
            int flag = 0;
            for (int i = 0; i < a; i++) {
                if (counter < size) {
                    threads[i] = new FindPrimes(this.pop());
                    threads[i].start();
                    counter++;
                    flag++;
                }
            }
            try {
                for (int i = 0; i < a; i++) {
                    if (i == flag) {
                        break;
                    }
                    threads[i].join();
                    completeTasks.push(threads[i].getResult());
                }
            }
            catch (InterruptedException e) {
                logger.info("Threads fail");
            }
        }
        this.tasks = completeTasks;
    }

    void showResult() {
        for (MyTask task : tasks) {
            System.out.println(task);
        }
    }

}