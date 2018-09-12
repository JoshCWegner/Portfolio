/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.dao;

import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    private VendingMachineItem onlyVendingMachineItem;
    private List<VendingMachineItem> vendingMachineItems = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        onlyVendingMachineItem = new VendingMachineItem();
        onlyVendingMachineItem.setItemName("Chips");
        onlyVendingMachineItem.setItemPrice(BigDecimal.ZERO);
        onlyVendingMachineItem.setItemInventory(4);

        vendingMachineItems.add(onlyVendingMachineItem);
    }

    @Override
    public VendingMachineItem getItemFromVendingMachine(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachinePersistanceException {
        if (itemName.equals(onlyVendingMachineItem.getItemName())) {
            return onlyVendingMachineItem;
        } else {
            return null;
        }
    }

    @Override
    public List<VendingMachineItem> getVendingMachineItems() throws VendingMachinePersistanceException {
        return vendingMachineItems;
    }

    @Override
    public VendingMachineItem getInventoryAndTrackInventory(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachinePersistanceException {
        if (vendingMachineItem.getItemInventory() >= 1) {
            return vendingMachineItem;
        } else {
            return null;
        }
    }

    @Override
    public VendingMachineItem removeVendingMachineItemNoInventory(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachinePersistanceException {
        if (vendingMachineItem.getItemInventory() >= 1) {
            return vendingMachineItem;
        } else {
            return null;
        }
    }
}
