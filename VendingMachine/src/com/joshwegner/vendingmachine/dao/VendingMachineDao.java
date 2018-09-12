/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.dao;

import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import com.joshwegner.vendingmachine.service.VendingMachineDataValidationException;
import com.joshwegner.vendingmachine.service.VendingMachineNoInventoryException;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public interface VendingMachineDao {

    VendingMachineItem getItemFromVendingMachine(VendingMachineItem vendingMachineItem, String userInputFoodChoice)
            throws VendingMachineDataValidationException,
            VendingMachinePersistanceException;

    List<VendingMachineItem> getVendingMachineItems()
            throws VendingMachinePersistanceException;

    VendingMachineItem removeVendingMachineItemNoInventory(VendingMachineItem vendingMachineItem, String itemName)
            throws VendingMachinePersistanceException;

    VendingMachineItem getInventoryAndTrackInventory(VendingMachineItem vendingMachineItem, String itemName)
            throws VendingMachineNoInventoryException,
            VendingMachinePersistanceException;
}
