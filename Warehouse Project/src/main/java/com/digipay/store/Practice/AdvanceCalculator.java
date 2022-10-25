package com.digipay.store.Practice;

public class AdvanceCalculator implements AddNumber{

        public int addNumber(int x) {
            int sum = 0;
            for (int i = 1; i <= x; i++) {
                sum += i;
            }
            return sum;
        }
    }

