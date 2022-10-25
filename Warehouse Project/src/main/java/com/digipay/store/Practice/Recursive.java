package com.digipay.store.Practice;

public class Recursive implements AddNumber{
    public int addNumber(int x) {
        if (x > 0) {
            return x + addNumber(x - 1);

        } else {
            return 0;
        }
    }
}
