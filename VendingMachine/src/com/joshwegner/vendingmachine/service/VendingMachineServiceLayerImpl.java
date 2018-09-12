/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.service;

import com.joshwegner.vendingmachine.dao.VendingMachineAuditDao;
import com.joshwegner.vendingmachine.dao.VendingMachineDao;
import com.joshwegner.vendingmachine.dao.VendingMachinePersistanceException;
import com.joshwegner.vendingmachine.dto.Change;
import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import com.joshwegner.vendingmachine.ui.UserInterface;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineAuditDao auditDao;
    VendingMachineDao dao;
    Change change;
    UserInterface io;
    private BigDecimal currentMoneyInVendingMachine = new BigDecimal("0.00");

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao, Change change, UserInterface io) {
        this.dao = dao;
        this.auditDao = auditDao;
        this.io = io;
        this.change = change;
    }

    VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
    }

    @Override
    public List<VendingMachineItem> getVendingMachineItems() throws VendingMachinePersistanceException {
        return dao.getVendingMachineItems();
    }

    public VendingMachineItem removeVendingMachineItemNoInventory(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachinePersistanceException, VendingMachineNoInventoryException {
        return dao.removeVendingMachineItemNoInventory(vendingMachineItem, itemName);
    }

    @Override
    public VendingMachineItem getItemFromVendingMachine(VendingMachineItem vendingMachineItem, String userInputFoodChoice) throws VendingMachinePersistanceException, VendingMachineNoInventoryException, VendingMachineDataValidationException {
        if (dao.getItemFromVendingMachine(vendingMachineItem, userInputFoodChoice) == null) {
            throw new VendingMachineDataValidationException("ERROR: INVALID ENTRY - YOU HAVE BEEN RETURNED TO THE MAIN MENU");
        }
        return dao.getItemFromVendingMachine(vendingMachineItem, userInputFoodChoice);
    }

    @Override
    public VendingMachineItem getInventoryAndTrackInventory(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachineNoInventoryException, VendingMachinePersistanceException {
        if (vendingMachineItem.getItemInventory() == 0) {
            throw new VendingMachineNoInventoryException("ERROR: NO INVENTORY - YOU HAVE BEEN RETURNED TO THE MAIN MENU");
        }
        return dao.getInventoryAndTrackInventory(vendingMachineItem, itemName);
    }

    @Override
    public void calculateMoney(VendingMachineItem vendingMachineItem, BigDecimal userMoney) throws VendingMachineInsufficientFundsException {

        io.print("You currently have $" + currentMoneyInVendingMachine + " in the vending machine");

        if (currentMoneyInVendingMachine.compareTo(vendingMachineItem.getItemPrice()) < 0) {
            throw new VendingMachineInsufficientFundsException("ERROR: INSUFFICIENT FUNDS - YOU HAVE BEEN RETURNED TO THE MAIN MENU");
        } else if (currentMoneyInVendingMachine.compareTo(vendingMachineItem.getItemPrice()) == 0) {
            io.print("=== SUCCSSFUL PURCHASE ===");
            io.print("You have just bought " + vendingMachineItem.getItemName() + " out of the vending machine. Thank you and have a nice day");
            currentMoneyInVendingMachine = currentMoneyInVendingMachine.subtract(vendingMachineItem.getItemPrice());
            io.print("$" + currentMoneyInVendingMachine);
            io.print("=== YOUR TRANSACTION IS COMPLETE ===");
            io.print("=== YOU HAVE BEEN RETURNED TO THE MAIN MENU ===");
        } else if (currentMoneyInVendingMachine.compareTo(vendingMachineItem.getItemPrice()) < 0) {
            io.print("You do not have enough money to buy that item. You only put in " + currentMoneyInVendingMachine);
            userMoney = vendingMachineItem.getItemPrice().subtract(currentMoneyInVendingMachine);
            io.print("You still need to put in " + userMoney + " to buy " + vendingMachineItem.getItemName());
        } else if (currentMoneyInVendingMachine.compareTo(vendingMachineItem.getItemPrice()) > 0) {
            change.calculate(vendingMachineItem, currentMoneyInVendingMachine);
            io.print("=== SUCCESSFUL PURCHASE ===");
            io.print("You have successfully purchased " + vendingMachineItem.getItemName() + " out of the vending machine.");
            io.print("=== CHANGE ===");
            io.print("Quarters: " + change.getQuarters());
            io.print("Dimes: " + change.getDimes());
            io.print("Nickels: " + change.getNickels());
            io.print("Pennies: " + change.getPennies());
            currentMoneyInVendingMachine = currentMoneyInVendingMachine.subtract(currentMoneyInVendingMachine);
            io.print("=== YOUR TRANSACTION IS COMPLETE ===");
            io.print("=== YOU HAVE BEEN RETURNED TO THE MAIN MENU ===");
        }
    }

    @Override
    public boolean checkUserInputFoodChoiceCaseToItemName(VendingMachineItem vendingMachineItem, String userInputFoodChoice) throws VendingMachineDataValidationException, VendingMachinePersistanceException {
        boolean userInputFoodChoiceCaseSensitive = userInputFoodChoice.equalsIgnoreCase(vendingMachineItem.getItemName());

        if (userInputFoodChoiceCaseSensitive = false) {
            throw new VendingMachineDataValidationException("ERROR: INVALID ENTRY - YOU HAVE BEEN RETURNED TO THE MAIN MENU");
        }
        return userInputFoodChoiceCaseSensitive;
    }

    @Override
    public BigDecimal addUserMoney() throws VendingMachineInsufficientFundsException {
        BigDecimal userMoney;
        userMoney = BigDecimal.valueOf(io.readDouble("Please enter in an amount of money between ", 0, 5));
        io.print("You currently have " + userMoney + " in the vending machine");
        currentMoneyInVendingMachine = currentMoneyInVendingMachine.add(userMoney);
        return currentMoneyInVendingMachine;
    }

    @Override
    public BigDecimal getMoreMoneyFromUser() throws VendingMachineInsufficientFundsException, VendingMachinePersistanceException {
        String action = io.readString("A1 - Exit to Main Menu / A2 - Enter in More Money");
        if (action.equalsIgnoreCase("A1")) {
        } else if (action.equalsIgnoreCase("A2")) {
            BigDecimal moreMoneyFromUser = BigDecimal.valueOf(io.readDouble("Please enter in a dollar amount between ", 0, 5));
            currentMoneyInVendingMachine = currentMoneyInVendingMachine.add(moreMoneyFromUser);
            io.print("The current amount of money you have in the vending machine is " + currentMoneyInVendingMachine);
        }
        return currentMoneyInVendingMachine;
    }
}
