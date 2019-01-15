package com.eren.obss.v2;

import com.eren.obss.v2.operation.Expression;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Expression expression = new Expression(input);
        double result = expression.execute();
        System.out.println(input + " = " + result);
    }

}