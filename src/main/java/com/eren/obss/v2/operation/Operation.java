package com.eren.obss.v2.operation;

public interface Operation {

    default boolean match(char sign) {
        return getOperator() == sign;
    }

    char getOperator();

    double execute(int first, int second);
}
