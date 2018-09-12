/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.vendingmachine;

import com.joshwegner.vendingmachine.controller.VendingMachineController;
import com.joshwegner.vendingmachine.dao.VendingMachineAuditDao;
import com.joshwegner.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.joshwegner.vendingmachine.dao.VendingMachineDao;
import com.joshwegner.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.joshwegner.vendingmachine.dto.Change;
import com.joshwegner.vendingmachine.service.VendingMachineServiceLayer;
import com.joshwegner.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.joshwegner.vendingmachine.ui.ConsoleImplementationUserInterface;
import com.joshwegner.vendingmachine.ui.UserInterface;
import com.joshwegner.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author softwareguild
 */
public class App {

    public static void main(String[] args) {

        Change myChange = new Change();
        UserInterface myIo = new ConsoleImplementationUserInterface();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao, myChange, myIo);
        VendingMachineController controller = new VendingMachineController(myService, myView);
        controller.run();

    }
}
