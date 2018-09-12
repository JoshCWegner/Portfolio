/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.ui;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class ConsoleImplementationUserInterface implements UserInterface {

    Scanner scanner = new Scanner(System.in);
    PrintStream out = System.out;

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        min = 1;
        max = 3;
        double userInputSelectionFizzBuzzOfInteractiveFizzBuzz = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInputSelectionFizzBuzzOfInteractiveFizzBuzz = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInputSelectionFizzBuzzOfInteractiveFizzBuzz < min || userInputSelectionFizzBuzzOfInteractiveFizzBuzz > max);
        return userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        min = 1;
        max = 3;
        float userInputSelectionFizzBuzzOfInteractiveFizzBuzz = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInputSelectionFizzBuzzOfInteractiveFizzBuzz = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInputSelectionFizzBuzzOfInteractiveFizzBuzz < min || userInputSelectionFizzBuzzOfInteractiveFizzBuzz > max);
        return userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        min = 1;
        max = 3;
        int userInputSelectionFizzBuzzOfInteractiveFizzBuzz = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInputSelectionFizzBuzzOfInteractiveFizzBuzz = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInputSelectionFizzBuzzOfInteractiveFizzBuzz < min || userInputSelectionFizzBuzzOfInteractiveFizzBuzz > max);
        return userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        min = 1;
        max = 3;
        long userInputSelectionFizzBuzzOfInteractiveFizzBuzz = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInputSelectionFizzBuzzOfInteractiveFizzBuzz = Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInputSelectionFizzBuzzOfInteractiveFizzBuzz < min || userInputSelectionFizzBuzzOfInteractiveFizzBuzz > max);
        return userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String userInputSelectionFizzBuzzOfInteractiveFizzBuzz = scanner.nextLine();
        return userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    }

}
