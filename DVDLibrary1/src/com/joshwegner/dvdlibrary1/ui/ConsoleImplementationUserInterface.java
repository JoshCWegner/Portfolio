/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary1.ui;

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
    public double readDouble(String prompt) {
        double userInput = 0;
        do {
            try {
                prompt = scanner.nextLine();
                userInput = Double.parseDouble(prompt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number between 1.0 - 6.0");
            }
        } while (true);

        return userInput;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double userInput = 0;
        do {
            System.out.println("Enter in a number between 1.0 - 6.0");
            prompt = scanner.nextLine();
            userInput = Double.parseDouble(prompt);

        } while (userInput < 1.0 || userInput > 6.0);

        return userInput;
    }

    @Override
    public float readFloat(String prompt) {
        float userInput = 0;
        do {
            try {
                prompt = scanner.nextLine();
                userInput = Float.parseFloat(prompt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number between 1.0 - 6.0");
            }
        } while (true);

        return userInput;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float userInput = 0;
        do {
            System.out.println("Enter in a number between 1.0 - 6.0");
            prompt = scanner.nextLine();
            userInput = Float.parseFloat(prompt);

        } while (userInput < 1.0 || userInput > 6.0);

        return userInput;
    }

    @Override
    public int readInt(String prompt) {
        int userInput = 0;
        do {
            try {
                prompt = scanner.nextLine();
                userInput = Integer.parseInt(prompt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number between 1.0 - 6.0");
            }
        } while (true);

        return userInput;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int userInput = 0;
        do {
            System.out.println("Enter in a number between 1 - 6");
            prompt = scanner.nextLine();
            userInput = Integer.parseInt(prompt);

        } while (userInput < 1 || userInput > 100);

        return userInput;
    }

    @Override
    public long readLong(String prompt) {
        long userInput = 0;
        do {
            try {
                prompt = scanner.nextLine();
                userInput = Long.parseLong(prompt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number between 1.0 - 6.0");
            }
        } while (true);

        return userInput;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long userInput = 0;
        do {
            System.out.println("Enter in a number between 1.0 - 6.0");
            prompt = scanner.nextLine();
            userInput = Long.parseLong(prompt);

        } while (userInput < 1.0 || userInput > 6.0);

        return userInput;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

}
