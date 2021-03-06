/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.ui;

import java.math.BigDecimal;

/**
 *
 * @author softwareguild
 */
public interface UserInterface_1 {

    void print(String message);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt, long min, long max);

    BigDecimal readBigDecimal(String prompt);

    String readString(String prompt);
}
