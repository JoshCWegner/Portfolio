/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.ui;

import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class VendingMachineView {

    private UserInterface io;

    public VendingMachineView(UserInterface io) {
        this.io = io;
    }

    public void displayItemsInMainMenu(List<VendingMachineItem> vendingMachineItems) {
        for (VendingMachineItem currentVendingMachineItem : vendingMachineItems) {
            io.print("Item Name: " + currentVendingMachineItem.getItemName() + " | "
                    + "Item Price: " + currentVendingMachineItem.getItemPrice() + " | "
                    + "Item Inventory: " + currentVendingMachineItem.getItemInventory());
        }
    }

    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. Make a Purchase");
        io.print("2. Enter in More Money");
        io.print("3. Exit");

        return io.readInt("Please select from the above choices ", 1, 3);
    }

    public BigDecimal getMoneyFromUser() {
        BigDecimal userMoney;
        userMoney = BigDecimal.valueOf(io.readDouble("Please enter in a dollar amount between ", 0, 5));
        return userMoney;
    }

    public String getVendingMachineItemChoiceFromUser() {
        String userInputFoodChoice = io.readString("Please enter in your food choice from the above list");
        return userInputFoodChoice.toLowerCase();
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public void displayExitMessage() {
        io.print("Thank you and have a nice day.");
    }

}
