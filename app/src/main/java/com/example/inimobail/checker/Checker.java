package com.example.inimobail.checker;

public class Checker {
    private int i = 0;
    private boolean isGenap = false;

    public void setI(int i) {
        this.i = i;
    }

    public void checkNum() {
        if (i % 2 == 0) {
            isGenap = true;
        } else {
            isGenap = false;
        }
    }

    public int getI() {
        return i;
    }

    public boolean getBool() {
        return isGenap;
    }
}
