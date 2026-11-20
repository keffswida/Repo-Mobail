package com.example.inimobail.counter;

public class Counter {
    private int i = 0;

    public void plus() {
        i++;
    }

    public void min() {
        if (i > 0) {
            i--;
        }
    }

    public void reset() {
        i = 0;
    }

    public int getI() {
        return i;
    }
}
