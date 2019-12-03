package com.company;

import java.util.*;

public class MyTask {

    private int start;
    private int end;
    private ArrayList<Integer> answers;

    MyTask(int start, int end) {
        answers = new ArrayList<Integer>();
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public void addAnswer(int a) {
        this.answers.add(a);
    }

    public String toString() {
        return answers.toString();
    }

}