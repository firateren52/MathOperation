package com.eren.obss.v2.operation;

import org.reflections.Reflections;

import java.util.HashSet;

import java.util.Set;

public class OperationFactory {
    private static final String BASE_PACKAGE_NAME = "com.eren.obss";
    static Set<Operation> operations = new HashSet<Operation>();

    static {
        Reflections reflections = new Reflections(BASE_PACKAGE_NAME);
        Set<Class<? extends Operation>> operationClasses = reflections.getSubTypesOf(Operation.class);
        for (Class c : operationClasses) {
            try {
                operations.add((Operation) c.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Operation getOperation(char operator) {
        return operations.stream().filter(op -> op.match(operator)).findFirst().
                orElseThrow(() -> new IllegalArgumentException(operator + " operator not supported!"));
    }
}
