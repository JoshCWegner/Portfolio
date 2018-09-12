/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.fizzbuzzandfizzbuzzinteractive;

import com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.controller.FizzBuzzAndFizzBuzzInteractiveController;
import com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui.ConsoleImplementationUserInterface;
import com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui.FizzBuzzAndFizzBuzzInteractiveView;
import com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui.UserInterface;

/**
 *
 * @author softwareguild
 */
public class App {

    public static void main(String[] args) {
        UserInterface myIo = new ConsoleImplementationUserInterface();
        FizzBuzzAndFizzBuzzInteractiveView myView = new FizzBuzzAndFizzBuzzInteractiveView(myIo);
        FizzBuzzAndFizzBuzzInteractiveController controller = new FizzBuzzAndFizzBuzzInteractiveController(myView);
        controller.run();
    }
}
