
import java.util.Random;
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
public class RockPaperScissors5 {

    int rock = 1;
    int paper = 2;
    int scissors = 3;
    int userNumberOfWins = 0;
    int userNumberOfLosses = 0;
    int computerNumberOfWins = 0;
    int computerNumberOfLosses = 0;
    int userInputNumberOfRoundsToPlay;
    int usersChoiceRockPaperScissors;
    int userNumberOfTies = 0;
    int computerNumberOfTies = 0;
    int computersChoiceRockPaperScissors;

    public void playRockPaperScissors() {
        String stringUsersChoiceRockPaperScissors = "";
        String stringComputersChoiceRockPaperScissors = "";
        String stringRock = "";
        String stringPaper = "";
        String stringScissors = "";
        String stringUserInputNumberOfRoundsToPlay = "";
        String playAgain = "";
        int numberOfTies = 0;
        double moneyWonOnAGame;
        double userEnterMoneyWageredOnGame = 0;
        String stringUserEnterMoneyWageredOnGame = "";
        double currentAccountBalance;
        double userEnterInDollorAmountIntoAccount = 0;

        Scanner scanner = new Scanner(System.in);

        do {

            Random random = new Random();

            System.out.println("Enter in an amount of money you want to bet on Rock, Paper, Scissors");
            stringUserEnterMoneyWageredOnGame = scanner.nextLine();
            userEnterMoneyWageredOnGame = Double.parseDouble(stringUserEnterMoneyWageredOnGame);

            System.out.println("Enter a number from 1-10 for how many rounds of rock, paper, scissors you want to play.");
            stringUserInputNumberOfRoundsToPlay = scanner.nextLine();
            userInputNumberOfRoundsToPlay = Integer.parseInt(stringUserInputNumberOfRoundsToPlay);

            System.out.println("You bet $" + userEnterMoneyWageredOnGame + " on " + stringUserInputNumberOfRoundsToPlay
                    + " of Rock, Paper, Scissors ===GOOD LUCK===");

            System.out.println("You want to play " + userInputNumberOfRoundsToPlay + " rounds of rock, paper, scissors.");

            for (int numberOfRoundsOfRockPaperScissors = 0; numberOfRoundsOfRockPaperScissors < userInputNumberOfRoundsToPlay; numberOfRoundsOfRockPaperScissors++) {

                System.out.println("Enter 1 for rock, 2 for paper or 3 for scissors");
                stringUsersChoiceRockPaperScissors = scanner.nextLine();
                usersChoiceRockPaperScissors = Integer.parseInt(stringUsersChoiceRockPaperScissors);

                System.out.println("You chose " + usersChoiceRockPaperScissors);

                computersChoiceRockPaperScissors = random.nextInt(3) + 1;
                System.out.println("The computer chose " + computersChoiceRockPaperScissors);

                if (usersChoiceRockPaperScissors == 1 && computersChoiceRockPaperScissors == 3) {
                    userNumberOfWins++;
                    computerNumberOfLosses++;
                    System.out.println("The user wins");
                } else if (computersChoiceRockPaperScissors == 1 && usersChoiceRockPaperScissors == 3) {
                    computerNumberOfWins++;
                    userNumberOfLosses++;
                    System.out.println("The computer wins.");
                } else if (usersChoiceRockPaperScissors == 3 && computersChoiceRockPaperScissors == 2) {
                    userNumberOfWins++;
                    computerNumberOfLosses++;
                    System.out.println("The user wins");
                } else if (computersChoiceRockPaperScissors == 3 && usersChoiceRockPaperScissors == 2) {
                    computerNumberOfWins++;
                    userNumberOfLosses++;
                    System.out.println("The computer wins.");
                } else if (usersChoiceRockPaperScissors == 2 && computersChoiceRockPaperScissors == 1) {
                    userNumberOfWins++;
                    computerNumberOfLosses++;
                    System.out.println("The user wins.");
                } else if (computersChoiceRockPaperScissors == 2 && usersChoiceRockPaperScissors == 1) {
                    computerNumberOfWins++;
                    userNumberOfLosses++;
                    System.out.println("The computer wins.");
                } else {
                    userNumberOfTies++;
                    computerNumberOfTies++;
                    numberOfTies++;
                    System.out.println("It's a tie.");

                }
            }

            if (userNumberOfWins > computerNumberOfWins) {
                moneyWonOnAGame = (userEnterMoneyWageredOnGame * 2);
                System.out.println("The user had " + userNumberOfWins + " wins, " + userNumberOfLosses + " losses and " + userNumberOfTies + " ties.");
                System.out.println("You have won $" + moneyWonOnAGame + " while playing " + userInputNumberOfRoundsToPlay + " of Rock, Paper, Scissors");
                currentAccountBalance = moneyWonOnAGame + userEnterInDollorAmountIntoAccount;
                System.out.println("Your ===CURRENT ACCOUNT BALANCE=== is $" + currentAccountBalance);
            } else if (computerNumberOfWins > userNumberOfWins) {
                moneyWonOnAGame = (userEnterMoneyWageredOnGame * 0);
                System.out.println("The computer had " + computerNumberOfWins + " wins, " + computerNumberOfLosses + " losses and " + computerNumberOfTies + " ties.");
                System.out.println("You have won $" + moneyWonOnAGame + " while playing " + userInputNumberOfRoundsToPlay + " of Rock, Paper, Scissors");
                currentAccountBalance = moneyWonOnAGame + userEnterInDollorAmountIntoAccount;
                System.out.println("Your ===CURRENT ACCOUNT BALANCE=== is $" + currentAccountBalance);
            } else if (userNumberOfTies == numberOfTies) {
                moneyWonOnAGame = (userEnterMoneyWageredOnGame * 1);
                System.out.println("They tied in " + numberOfTies + " ties in " + userInputNumberOfRoundsToPlay + " rounds.");
                System.out.println("You have won $" + moneyWonOnAGame + " while playing " + userInputNumberOfRoundsToPlay + " of Rock, Paper, Scissors");
                currentAccountBalance = moneyWonOnAGame + userEnterInDollorAmountIntoAccount;
                System.out.println("Your ===CURRENT ACCOUNT BALANCE=== is $" + currentAccountBalance);
            }

            System.out.println("Do you want to play another game? yes / no");
            playAgain = scanner.nextLine();

        } while (playAgain.equals("yes"));

        System.out.println("Game Over, thank you have a nice day.");
    }
}
