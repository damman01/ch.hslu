/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw06;

/**
 *
 * @author domin
 */
public class Calculator implements CalculatorInterface {

    @Override
    public long sum(int sum1, int sum2) {
        return sum1+sum2;
    }
    
}
