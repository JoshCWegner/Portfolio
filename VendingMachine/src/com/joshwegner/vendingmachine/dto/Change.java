/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author softwareguild
 */
public class Change {

    private BigDecimal pennies;
    private BigDecimal nickels;
    private BigDecimal dimes;
    private BigDecimal quarters;
    private BigDecimal userMoneyInPennies;

    public Change(BigDecimal pennies, BigDecimal nickels, BigDecimal dimes, BigDecimal quarters) {
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
        this.quarters = quarters;
    }

    public Change() {
    }

    public void calculate(VendingMachineItem vendingMachineItem, BigDecimal userMoney) {
        BigDecimal getToPennies = new BigDecimal("100");
        BigDecimal q = new BigDecimal("25");
        BigDecimal d = new BigDecimal("10");
        BigDecimal n = new BigDecimal("5");
        BigDecimal p = new BigDecimal("1");
        userMoneyInPennies = (userMoney.subtract(vendingMachineItem.getItemPrice())).multiply(getToPennies);

        quarters = userMoneyInPennies.divide(q, 0, RoundingMode.DOWN);
        userMoneyInPennies = userMoneyInPennies.remainder(q);
        dimes = userMoneyInPennies.divide(d, 0, RoundingMode.DOWN);
        userMoneyInPennies = userMoneyInPennies.remainder(d);
        nickels = userMoneyInPennies.divide(n, 0, RoundingMode.DOWN);
        userMoneyInPennies = userMoneyInPennies.remainder(n);
        pennies = userMoneyInPennies.divide(p, 0, RoundingMode.DOWN);
    }

    public BigDecimal getPennies() {
        return pennies;
    }

    public BigDecimal getNickels() {
        return nickels;
    }

    public BigDecimal getDimes() {
        return dimes;
    }

    public BigDecimal getQuarters() {
        return quarters;
    }

    public BigDecimal getUserMoneyInPennies() {
        return userMoneyInPennies;
    }
}
