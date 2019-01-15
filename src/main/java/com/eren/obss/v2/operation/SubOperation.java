package com.eren.obss.v2.operation;

public class SubOperation implements Operation {
    private char OPERATOR = '-';

    @Override
    public char getOperator() {
        return OPERATOR;
    }

    @Override
    public double execute(int first, int second) {
        return (double) (first - second);
    }
}
