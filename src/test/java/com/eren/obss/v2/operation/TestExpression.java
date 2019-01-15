package com.eren.obss.v2.operation;

import org.junit.Assert;
import org.junit.Test;

public class TestExpression {

    @Test
    public void testAddOperation() {
        Expression expression = new Expression("+50+3");
        Assert.assertEquals(53, expression.execute(), 0);

        expression = new Expression("+1+-3");
        Assert.assertEquals(-2, expression.execute(), 0);
    }

    @Test
    public void testSubOperation() {
        Expression expression = new Expression("+5-3");
        Assert.assertEquals(2, expression.execute(), 0);

        expression = new Expression("-10--3");
        Assert.assertEquals(-7, expression.execute(), 0);
    }

    @Test
    public void testMulOperation() {
        Expression expression = new Expression("+5*-3");
        Assert.assertEquals(-15, expression.execute(), 0);

        expression = new Expression("0*-3");
        Assert.assertEquals(0, expression.execute(), 0);
    }

    @Test
    public void testDivOperation() {
        Expression expression = new Expression("9/-2");
        Assert.assertEquals(-4.5, expression.execute(), 0);

        expression = new Expression("0/-3");
        Assert.assertEquals(0, expression.execute(), 0);
    }

    @Test
    public void testModOperation() {
        Expression expression = new Expression("19%4");
        Assert.assertEquals(3, expression.execute(), 0);

        expression = new Expression("385%50");
        Assert.assertEquals(35, expression.execute(), 0);
    }

}
