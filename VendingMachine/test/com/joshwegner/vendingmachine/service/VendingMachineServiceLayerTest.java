/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine.service;

import com.joshwegner.vendingmachine.dao.VendingMachineAuditDao;
import com.joshwegner.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.joshwegner.vendingmachine.dao.VendingMachineDao;
import com.joshwegner.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.joshwegner.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author softwareguild
 */
public class VendingMachineServiceLayerTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerTest() throws VendingMachineInsufficientFundsException, VendingMachineDataValidationException {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();

        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getItemFromVendingMachine method, of class
     * VendingMachineServiceLayer.
     */
    @Test
    public void testGetItemFromVendingMachine() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem = service.getItemFromVendingMachine(vendingMachineItem, vendingMachineItem.getItemName());
        assertNotNull(vendingMachineItem);
        vendingMachineItem = service.getItemFromVendingMachine(vendingMachineItem, vendingMachineItem.getItemName());
        assertNull(vendingMachineItem);
    }

    /**
     * Test of getVendingMachineItems method, of class
     * VendingMachineServiceLayer.
     */
    @Test
    public void testGetVendingMachineItems() throws Exception {
        assertEquals(1, service.getVendingMachineItems().size());
    }

    /**
     * Test of removeVendingMachineItemNoInventory method, of class
     * VendingMachineServiceLayer.
     */
    public void testRemoveVendingMachineItemNoInventory() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem = service.removeVendingMachineItemNoInventory(vendingMachineItem, vendingMachineItem.getItemName());
        assertNotNull(vendingMachineItem);
        vendingMachineItem = service.removeVendingMachineItemNoInventory(vendingMachineItem, vendingMachineItem.getItemName());
        assertNull(vendingMachineItem);
    }

    /**
     * Test of getInventoryAndTrackInventory method, of class
     * VendingMachineServiceLayer.
     */
    @Test
    public void testGetInventoryAndTrackInventory() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem = service.getInventoryAndTrackInventory(vendingMachineItem, vendingMachineItem.getItemName());
        assertNotNull(vendingMachineItem);
        vendingMachineItem = service.getInventoryAndTrackInventory(vendingMachineItem, vendingMachineItem.getItemName());
        assertNull(vendingMachineItem);
    }

    /**
     * Test of calculateMoney method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testCalculateMoney() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem.setItemName("Chips");
        vendingMachineItem.setItemPrice(BigDecimal.ZERO);
        vendingMachineItem.setItemInventory(4);

        try {
            service.calculateMoney(vendingMachineItem, BigDecimal.ZERO);
            fail("Excepted VendingMachineInsufficientFundsException was not thrown");
        } catch (VendingMachineInsufficientFundsException e) {
            throw new VendingMachineInsufficientFundsException("ERROR: You do not have enough money to buy that item");
        }
        return;
    }

    @Test
    public void testCheckUserInputFoodChoiceCaseToItemName() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem.setItemName("Chips");
        vendingMachineItem.setItemPrice(BigDecimal.ZERO);
        vendingMachineItem.setItemInventory(4);

        try {
            String userInputFoodeChoice = "";
            boolean checkUserInputFoodChoiceCaseToItemName = service.checkUserInputFoodChoiceCaseToItemName(vendingMachineItem, userInputFoodeChoice);
            fail("Excepted VendingMachineDataValidationException was not thrown");
        } catch (VendingMachineDataValidationException e) {
            throw new VendingMachineDataValidationException("ERROR: That item is not in the vending machine");
        }
        return;
    }

    @Test
    public void testAddUserMoney() throws Exception {
        VendingMachineItem vendingMachineItem = new VendingMachineItem();
        vendingMachineItem = service.removeVendingMachineItemNoInventory(vendingMachineItem, vendingMachineItem.getItemName());
        assertNotNull(vendingMachineItem);
        vendingMachineItem = service.removeVendingMachineItemNoInventory(vendingMachineItem, vendingMachineItem.getItemName());
        assertNull(vendingMachineItem);
    }
}
