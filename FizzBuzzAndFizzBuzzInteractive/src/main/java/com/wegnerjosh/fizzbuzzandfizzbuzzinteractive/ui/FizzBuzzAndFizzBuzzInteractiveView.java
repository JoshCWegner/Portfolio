/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui;

/**
 *
 * @author softwareguild
 */
public class FizzBuzzAndFizzBuzzInteractiveView {

    private UserInterface io;

    public FizzBuzzAndFizzBuzzInteractiveView(UserInterface io) {
        this.io = io;
    }

    public int printAndGetMenuSelection() {
        io.print("=== MAIN MENU ===");
        io.print("1. Regular Fizz Buzz");
        io.print("2. Interactive Fizz BUzz");
        io.print("3. Exit");

        return io.readInt("Enter in a selection from the above choices ", 1, 3);
    }

    public void displayFizzBuzzRules() {
        io.print("Fizz Buzz is a typical program that counts from 1 - 30");
        io.print("If a number is divisible by 3 Fizz will print out");
        io.print("If a number is divisible by 5 Buzz will print out");
        io.print("If a number is divisible by 3 and 5 Fizz Buzz will print out");
    }

    public void displayRegularFizzBuzz() {
        for (int i = 1; i <= 30; i++) {
        }
    }

    public int getMinFromUserInteractiveFizzBuzz(int userInputMinNumberForInteractiveFizzBuzz) {

        userInputMinNumberForInteractiveFizzBuzz = Integer.valueOf(io.readString("Enter in a number to start Fizz Buzz"));//fix

        io.print("Min: " + userInputMinNumberForInteractiveFizzBuzz);

        return userInputMinNumberForInteractiveFizzBuzz;
    }

    public int getMaxFromUserInteractiveFizzBuzz(int userInputMaxNumberForInteractiveFizzBuzz) {

        userInputMaxNumberForInteractiveFizzBuzz = Integer.valueOf(io.readString("Enter in a number to end Fizz Buzz"));//fix

        io.print("Min: " + userInputMaxNumberForInteractiveFizzBuzz);

        return userInputMaxNumberForInteractiveFizzBuzz;
    }

    public void runForLoopWithUserInputMinMaxInteractiveFizzBuzz(int userInputMinNumberForInteractiveFizzBuzz,
            int userInputMaxNumberForInteractiveFizzBuzz) {

        for (int i = userInputMinNumberForInteractiveFizzBuzz; i <= userInputMaxNumberForInteractiveFizzBuzz; i++) {
        }
    }

    public void calculationForFizzBuzz() {
        int i = 1;
        if (0 == i % 3 && 0 == i % 5) {
            System.out.println("Fizz Buzz");
        } else if (0 == i % 3) {
            System.out.println("Fizz");
        } else if (0 == i % 5) {
            System.out.println("Buzz");
        } else {
            System.out.println(i);
        }
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public void displayExitMessage() {
        io.print("Thank you and have a nice day.");
    }

    public void selectEnterForMainMenu() {
        io.readString("Hit === ENTER === to return to the === MAIN MENU ===");
    }
}
