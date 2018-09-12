
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author softwareguild
 */
public class App {

    public static void main(String[] args) {
        double operand1;
        double operand2;
        String calculateAgain = "";
        String operator = "";

        Scanner scanner = new Scanner(System.in);
        SimpleCalculator1 mySimpleCalculator1 = new SimpleCalculator1();

        String stringOperand1 = "";
        String stringOperand2 = "";

        do {
            System.out.println("What operation do you want this calcultor to perform? add/subtract/multiply/divide/exit");
            String action = scanner.nextLine();

            if (action.equals("exit")) {
                break;
            }

            System.out.println("Please enter in a number.");
            stringOperand1 = scanner.nextLine();
            operand1 = Double.parseDouble(stringOperand1);

            System.out.println("Please enter in a second number");
            stringOperand2 = scanner.nextLine();
            operand2 = Double.parseDouble(stringOperand2);

            System.out.println("You entered in " + operand1 + " and " + operand2 + " equals ");

            if (action.equals("add")) {
                System.out.println(mySimpleCalculator1.add(operand1, operand2));
            } else if (action.equals("subtract")) {
                System.out.println(mySimpleCalculator1.subtract(operand1, operand2));
            } else if (action.equals("multiply")) {
                System.out.println(mySimpleCalculator1.multiply(operand1, operand2));
            } else if (action.equals("divide")) {
                System.out.println(mySimpleCalculator1.divide(operand1, operand2));
            }

        } while (true);

        System.out.println("Thank you and have a nice day.");
    }

}
