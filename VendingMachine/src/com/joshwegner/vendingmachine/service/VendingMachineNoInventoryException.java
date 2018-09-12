/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.service;

/**
 *
 * @author softwareguild
 */
public class VendingMachineNoInventoryException extends Exception {

    public VendingMachineNoInventoryException(String message) {
        super(message);
    }

    public VendingMachineNoInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
