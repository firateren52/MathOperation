package com.eren.obss.v1;

import java.util.Scanner;
import java.util.ServiceLoader;


public class ArithmeticOperation_v1 {
    private enum Operation{
        PLUS("+"), SUB("-"),MUL("*"), DIV("/");
        String op;

        Operation(String op) {
            this.op = op;
        }

        public String getOp() {
            return op;
        }
    };

    public double calculate(String statement) {
        Double result = new Double(0);
        for(Operation operation: ArithmeticOperation_v1.Operation.values()) {
            int index = statement.indexOf(operation.op);
            if(index > 0) {
                Integer first = Integer.parseInt(statement.substring(0, index));
                Integer second = Integer.parseInt(statement.substring(index + 1));
                if (ArithmeticOperation_v1.Operation.PLUS.equals(operation)) {
                    result = (double) (first + second);

                } else if (ArithmeticOperation_v1.Operation.SUB.equals(operation)) {
                    result = (double) (first - second);

                } else if (ArithmeticOperation_v1.Operation.MUL.equals(operation)) {
                    result = (double) (first * second);

                }
                if (ArithmeticOperation_v1.Operation.DIV.equals(operation)) {
                    result = (double)first / (double)second;
                }
                return result;
            }
        }
        return result;
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ArithmeticOperation_v1 arithmeticOperation = new ArithmeticOperation_v1();
        Double result = arithmeticOperation.calculate(input);
        System.out.println("input = " + result);
    }
}
