
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
public class InterestCalculator1 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        double initialInvestment = 0;
        double interestRate = 0;
        double monthBalance = 0;
        double quarterBalance = 0;
        double year;
        double yearInterest = 0;
        double interest = 0;
        double endPrincipal = 0;
 
        
        System.out.println("Please enter in you initial investment: ");
        initialInvestment = scanner.nextDouble();
        System.out.println("Please enter in the annual interest rate you want: ");
        interestRate = scanner.nextDouble();
        System.out.println("Please enter the number is years you want you money to stay in the mutual fund: ");
        year = scanner.nextDouble();
        
        quarterBalance = initialInvestment * (1 + (interestRate / 4) / 100);
        monthBalance = initialInvestment * (1 + (interestRate / 12) / 100);
        interest = initialInvestment * (1 + (interestRate * year));
        endPrincipal = initialInvestment * (1 + (interestRate) / 100);
      
        System.out.println("Your initial investment of $" + initialInvestment + " is $" + quarterBalance + " afer the first quarter.");
        System.out.println("Your initial investment of $" + initialInvestment + " is $" + monthBalance + " after the first month.");
        System.out.println("In year " + year);
        System.out.println("Your principal at the beginning of the year is $" + initialInvestment);
        System.out.println("You have erned a total of " + interest + " interest in one year");
        System.out.println("Your your principal at the end of the year is $" + endPrincipal);
    }
}
