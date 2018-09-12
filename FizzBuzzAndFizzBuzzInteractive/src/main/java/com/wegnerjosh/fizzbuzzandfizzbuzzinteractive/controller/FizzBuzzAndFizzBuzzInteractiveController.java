/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.controller;

import com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui.ConsoleImplementationUserInterface;
import com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui.FizzBuzzAndFizzBuzzInteractiveView;
import com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui.UserInterface;

/**
 *
 * @author softwareguild
 */
public class FizzBuzzAndFizzBuzzInteractiveController {

    private FizzBuzzAndFizzBuzzInteractiveView view;
    private UserInterface io = new ConsoleImplementationUserInterface();

    public FizzBuzzAndFizzBuzzInteractiveController(FizzBuzzAndFizzBuzzInteractiveView view) {
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = view.printAndGetMenuSelection();

        while (keepGoing) {
            switch (menuSelection) {
                case 1:
                    fizzBuzzRegular();
                    break;
                case 2:
                    interactiveFizzBuzz();
                    break;
                case 3:
                    exit();
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
    }

    private void fizzBuzzRegular() {
    }

    private void interactiveFizzBuzz() {
        view.getMaxFromUserInteractiveFizzBuzz(0);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exit() {
        view.displayExitMessage();
    }

    private int getMenuSelection() {
        return view.printAndGetMenuSelection();
    }
}
