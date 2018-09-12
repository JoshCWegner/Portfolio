/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.controller;

import com.joshwegner.vendingmachine.dao.VendingMachinePersistanceException;
import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import com.joshwegner.vendingmachine.service.VendingMachineDataValidationException;
import com.joshwegner.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.joshwegner.vendingmachine.service.VendingMachineNoInventoryException;
import com.joshwegner.vendingmachine.service.VendingMachineServiceLayer;
import com.joshwegner.vendingmachine.ui.ConsoleImplementationUserInterface;
import com.joshwegner.vendingmachine.ui.UserInterface;
import com.joshwegner.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class VendingMachineController {

    private VendingMachineServiceLayer service;
    private VendingMachineView view;
    private UserInterface io = new ConsoleImplementationUserInterface();

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            List<VendingMachineItem> vendingMachineItems = service.getVendingMachineItems();
            view.displayItemsInMainMenu(vendingMachineItems);

            BigDecimal userMoney = service.addUserMoney();

            while (keepGoing) {
                menuSelection = view.printMenuAndGetSelection();
                switch (menuSelection) {
                    case 1:
                        purchase(userMoney);
                        break;
                    case 2:
                        enterInMoreMoney(userMoney);
                        break;
                    case 3:
                        exitMessage();
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
        } catch (VendingMachineNoInventoryException | VendingMachineDataValidationException | VendingMachinePersistanceException | VendingMachineInsufficientFundsException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void purchase(BigDecimal userMoney) throws VendingMachinePersistanceException, VendingMachineInsufficientFundsException, VendingMachineDataValidationException, VendingMachineNoInventoryException {
        boolean hasErrors = false;

        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        try {
            String userInputFoodChoice = view.getVendingMachineItemChoiceFromUser();
            vendingMachineItem = service.getItemFromVendingMachine(vendingMachineItem, userInputFoodChoice);
            service.checkUserInputFoodChoiceCaseToItemName(vendingMachineItem, userInputFoodChoice);
            service.getInventoryAndTrackInventory(vendingMachineItem, userInputFoodChoice);
            service.calculateMoney(vendingMachineItem, userMoney);
            List<VendingMachineItem> vendingMachineItems = service.getVendingMachineItems();
            view.displayItemsInMainMenu(vendingMachineItems);
            hasErrors = false;
        } catch (VendingMachineDataValidationException | VendingMachineInsufficientFundsException | VendingMachineNoInventoryException e) {
            hasErrors = true;
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() throws VendingMachinePersistanceException {
        view.displayExitMessage();
    }

    private void enterInMoreMoney(BigDecimal userMoney) throws VendingMachinePersistanceException, VendingMachineInsufficientFundsException, VendingMachineDataValidationException, VendingMachineNoInventoryException {
        boolean hasErrors = false;

        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        try {
            service.getMoreMoneyFromUser();
            hasErrors = false;
        } catch (VendingMachineInsufficientFundsException e) {
            hasErrors = true;
            view.displayErrorMessage(e.getMessage());
        }

    }

}
