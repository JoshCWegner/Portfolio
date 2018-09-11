/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        max = 5;
        double userInput = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInput = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInput < min || userInput > max);
        return userInput;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        min = 1;
        max = 5;
        float userInput = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInput = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInput < min || userInput > max);
        return userInput;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        min = 1;
        max = 5;
        int userInput = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInput = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInput < min || userInput > max);
        return userInput;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        min = 1;
        max = 5;
        long userInput = 0;
        do {
            try {
                System.out.println(prompt + min + " - " + max);
                userInput = Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter in a valid number");
            }
        } while (userInput < min || userInput > max);
        return userInput;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

}
