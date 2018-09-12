/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.dao;

import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import com.joshwegner.vendingmachine.service.VendingMachineNoInventoryException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, VendingMachineItem> vendingMachineItems = new HashMap<>();

    public static final String ITEMS_FILE = "items.txt";
    public static final String DELIMITER = "::";

    private void loadVendingMachineItems() throws VendingMachinePersistanceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistanceException("-_- Could not load vending machine items into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            VendingMachineItem vendingMachineItem = new VendingMachineItem();
            vendingMachineItem.setItemName(currentTokens[0]);
            vendingMachineItem.setItemPrice(new BigDecimal(currentTokens[1]));
            vendingMachineItem.setItemInventory(Integer.parseInt(currentTokens[2]));

            vendingMachineItems.put(vendingMachineItem.getItemName().toLowerCase(), vendingMachineItem);
        }

        scanner.close();
    }

    private void writeVendingMachineItems() throws VendingMachinePersistanceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistanceException("Could not save vending machine items.", e);
        }

        List<VendingMachineItem> vendingMachineItems = this.getVendingMachineItems();
        for (VendingMachineItem vendingMachineItem : vendingMachineItems) {
            out.println(vendingMachineItem.getItemName().toLowerCase() + DELIMITER
                    + vendingMachineItem.getItemPrice() + DELIMITER
                    + vendingMachineItem.getItemInventory());

            out.flush();
        }
        out.close();
    }

    @Override
    public VendingMachineItem getItemFromVendingMachine(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachinePersistanceException {
        loadVendingMachineItems();
        return vendingMachineItems.get(itemName.toLowerCase());
    }

    @Override
    public List<VendingMachineItem> getVendingMachineItems() throws VendingMachinePersistanceException {
        loadVendingMachineItems();
        return new ArrayList<VendingMachineItem>(vendingMachineItems.values());
    }

    @Override
    public VendingMachineItem removeVendingMachineItemNoInventory(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachinePersistanceException {
        loadVendingMachineItems();
        return vendingMachineItem;
    }

    @Override
    public VendingMachineItem getInventoryAndTrackInventory(VendingMachineItem vendingMachineItem, String itemName) throws VendingMachineNoInventoryException, VendingMachinePersistanceException {
        loadVendingMachineItems();
        int itemInventoryNumberToCalculate = vendingMachineItem.getItemInventory();
        itemInventoryNumberToCalculate = itemInventoryNumberToCalculate - 1;
        vendingMachineItem.setItemInventory(itemInventoryNumberToCalculate);
        vendingMachineItems.put(itemName.toLowerCase(), vendingMachineItem);
        writeVendingMachineItems();
        return vendingMachineItem;
    }
}
