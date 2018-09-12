/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.service;

import com.joshwegner.vendingmachine.dao.VendingMachinePersistanceException;
import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public interface VendingMachineServiceLayer {

    VendingMachineItem getItemFromVendingMachine(VendingMachineItem vendingMachineItem, String itemName) throws
            VendingMachineDataValidationException,
            VendingMachineNoInventoryException,
            VendingMachinePersistanceException;

    List<VendingMachineItem> getVendingMachineItems() throws
            VendingMachinePersistanceException;

    VendingMachineItem removeVendingMachineItemNoInventory(VendingMachineItem vendingMachineItem, String itemName) throws
            VendingMachineNoInventoryException,
            VendingMachinePersistanceException;

    VendingMachineItem getInventoryAndTrackInventory(VendingMachineItem vendingMachineItem, String itemName) throws
            VendingMachineNoInventoryException,
            VendingMachinePersistanceException;

    public void calculateMoney(VendingMachineItem vendingMachineItem, BigDecimal userMoney) throws
            VendingMachineInsufficientFundsException;

    BigDecimal addUserMoney() throws
            VendingMachineInsufficientFundsException;

    boolean checkUserInputFoodChoiceCaseToItemName(VendingMachineItem vendingMachineItem, String userInputFoodeChoice)
            throws VendingMachineDataValidationException,
            VendingMachinePersistanceException;

    BigDecimal getMoreMoneyFromUser()
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistanceException;
}
