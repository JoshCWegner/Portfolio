/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary;

import com.joshwegner.dvdlibrary1.controller.DVDLibrary1Controller;
import com.joshwegner.dvdlibrary1.dao.DVDLibrary1Dao;
import com.joshwegner.dvdlibrary1.dao.DVDLibrary1DaoFileImpl;
import com.joshwegner.dvdlibrary1.ui.ConsoleImplementationUserInterface;
import com.joshwegner.dvdlibrary1.ui.DVDLibrary1View;
import com.joshwegner.dvdlibrary1.ui.UserInterface;

/**
 *
 * @author softwareguild
 */
public class App {

    public static void main(String[] args) {

        UserInterface myIo = new ConsoleImplementationUserInterface();
        DVDLibrary1View myView = new DVDLibrary1View(myIo);
        DVDLibrary1Dao myDao = new DVDLibrary1DaoFileImpl();
        DVDLibrary1Controller controller = new DVDLibrary1Controller(myDao, myView);
        controller.run();
    }

}
