/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary1.controller;

import com.joshwegner.dvdlibrary1.dao.DVDLibrary1Dao;
import com.joshwegner.dvdlibrary1.dao.DVDLibrary1DaoException;
import com.joshwegner.dvdlibrary1.dto.Dvd;
import com.joshwegner.dvdlibrary1.ui.ConsoleImplementationUserInterface;
import com.joshwegner.dvdlibrary1.ui.DVDLibrary1View;
import com.joshwegner.dvdlibrary1.ui.UserInterface;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class DVDLibrary1Controller {

    DVDLibrary1View view;
    DVDLibrary1Dao dao;

    public DVDLibrary1Controller(DVDLibrary1Dao dao, DVDLibrary1View view) {
        this.dao = dao;
        this.view = view;
    }
    private UserInterface io = new ConsoleImplementationUserInterface();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        listAllDvds();
                        break;
                    case 4:
                        editDvdInformation();
                        break;
                    case 5:
                        listDvdInformation();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknown();
                }
            }

            exitMessage();
        } catch (DVDLibrary1DaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void addDvd() throws DVDLibrary1DaoException {
        view.displayCreateDvdBanner();
        Dvd dvd = view.getDvdInformation();
        dao.addDvd(dvd.getMovieTitle(), dvd);
        view.displayCreateDvdSuccessBanner();
    }

    private void removeDvd() throws DVDLibrary1DaoException {
        view.displayRemoveDvdBanner();
        String movieTitle = view.getMovieTitleChoice();
        Dvd dvdLibrary = dao.removeDvd(movieTitle);
        view.displayRemoveDvdSuccessBanner(dvdLibrary);
    }

    private void listAllDvds() throws DVDLibrary1DaoException {
        view.displayAllDvdsBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void editDvdInformation() throws DVDLibrary1DaoException {
        view.displayEditDvdInformationBanner();
        String movieTitle = view.getMovieTitleChoice();
        Dvd currentDvd = dao.listAllDvdInformation(movieTitle);
        Dvd dvd = view.getAndEditDvdInformation(movieTitle, currentDvd);
        dao.editDvdInformation(movieTitle, dvd);
        view.displayMovieTitleInformation(dvd);
    }

    private void listDvdInformation() throws DVDLibrary1DaoException {
        view.displayAllDvdInformationBanner();
        String movieTitle = view.getMovieTitleChoice();
        Dvd dvd = dao.listAllDvdInformation(movieTitle);
        view.displayMovieTitleInformation(dvd);
    }

    private void unknown() {
        view.displayUnknownCommand();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
//test
