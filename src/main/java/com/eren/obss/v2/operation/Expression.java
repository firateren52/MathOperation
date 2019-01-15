package com.eren.obss.v2.operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private int firstOperand;
    private int secondOperand;
    private Operation operation;
    private Pattern pattern = Pattern.compile("-?\\d+");


    public Expression(String input) {
        String matchedNumber = findFirstMatchedNumber(input);
        this.firstOperand = Integer.parseInt(matchedNumber);

        int operatorIndex = input.indexOf(matchedNumber) + matchedNumber.length();
        char operator = input.charAt(operatorIndex);
        this.operation = OperationFactory.getOperation(operator);

        this.secondOperand = Integer.parseInt(findFirstMatchedNumber(input.substring(operatorIndex + 1)));
    }

    public double execute() {
        return operation.execute(firstOperand, secondOperand);
    }

    private String findFirstMatchedNumber(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new IllegalArgumentException("No numbers found in" + input);
        }
    }
}
