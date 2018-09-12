/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.dao;

import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author softwareguild
 */
public class VendingMachineDaoTest {

    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<VendingMachineItem> vendingMachineItems = dao.getVendingMachineItems();
        for (VendingMachineItem vendingMachineItem : vendingMachineItems) {
            dao.removeVendingMachineItemNoInventory(vendingMachineItem, vendingMachineItem.getItemName());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getItemFromVendingMachine method, of class VendingMachineDao.
     */
    @Test
    public void testGetItemFromVendingMachine() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem.setItemName("Chips");
        vendingMachineItem.setItemPrice(BigDecimal.ZERO);
        vendingMachineItem.setItemInventory(4);

        dao.getVendingMachineItems();

        VendingMachineItem fromDao = dao.getItemFromVendingMachine(vendingMachineItem, vendingMachineItem.getItemName());
        assertEquals(vendingMachineItem, fromDao);
    }

    /**
     * Test of getVendingMachineItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetVendingMachineItems() throws Exception {
        VendingMachineItem vendingMachineItem1 = new VendingMachineItem();
        vendingMachineItem1.setItemName("Soda");
        vendingMachineItem1.setItemPrice(BigDecimal.ZERO);
        vendingMachineItem1.setItemInventory(3);

        dao.getItemFromVendingMachine(vendingMachineItem1, vendingMachineItem1.getItemName());
        VendingMachineItem vendingMachineItem2 = new VendingMachineItem();
        vendingMachineItem2.setItemName("Candy");
        vendingMachineItem2.setItemPrice(BigDecimal.ZERO);
        vendingMachineItem2.setItemInventory(1);

        dao.getItemFromVendingMachine(vendingMachineItem2, vendingMachineItem2.getItemName());
        assertEquals(2, dao.getVendingMachineItems().size());

    }

    /**
     * Test of removeVendingMachineItemNoInventory method, of class
     * VendingMachineDao.
     */
    @Test
    public void testRemoveVendingMachineItemNoInventory() throws Exception {
        VendingMachineItem vendingMachineItem1 = new VendingMachineItem();
        vendingMachineItem1.setItemName("Soda");
        vendingMachineItem1.setItemPrice(BigDecimal.ZERO);
        vendingMachineItem1.setItemInventory(3);

        dao.getItemFromVendingMachine(vendingMachineItem1, vendingMachineItem1.getItemName());
        VendingMachineItem vendingMachineItem2 = new VendingMachineItem();
        vendingMachineItem2.setItemName("Candy");
        vendingMachineItem2.getItemPrice();
        vendingMachineItem2.setItemInventory(1);

        dao.getItemFromVendingMachine(vendingMachineItem2, vendingMachineItem2.getItemName());
        dao.removeVendingMachineItemNoInventory(vendingMachineItem1, vendingMachineItem1.getItemName());
        assertEquals(1, dao.getVendingMachineItems().size());
        assertNull(dao.getItemFromVendingMachine(vendingMachineItem1, vendingMachineItem1.getItemName()));

        dao.removeVendingMachineItemNoInventory(vendingMachineItem2, vendingMachineItem1.getItemName());
        assertEquals(0, dao.getVendingMachineItems().size());
        assertNull(dao.getItemFromVendingMachine(vendingMachineItem2, vendingMachineItem2.getItemName()));
    }

    /**
     * Test of getInventoryAndTrackInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetInventoryAndTrackInventory() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem.setItemName("Chips");
        vendingMachineItem.getItemPrice();
        vendingMachineItem.setItemInventory(4);

        dao.getInventoryAndTrackInventory(vendingMachineItem, vendingMachineItem.getItemName());

        VendingMachineItem fromDao = dao.getInventoryAndTrackInventory(vendingMachineItem, vendingMachineItem.getItemName());

        assertEquals(vendingMachineItem, fromDao);
    }
}
