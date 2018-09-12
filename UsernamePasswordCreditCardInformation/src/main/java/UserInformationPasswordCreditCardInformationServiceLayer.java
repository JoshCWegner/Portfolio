
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
public class UserInformationPasswordCreditCardInformationServiceLayer {

    UserInterface io = new ConsoleImplementationUserInterface();

    public void getCreditCardInformationFromUser() {
        int userInputCVVCodeCount = 0;
        int userInputCreditCardNumberCount = 0;
        int userEnterInputCreditCardCVVCode;
        String stringUserEnterInputCreditCardCVVCode = "";
        long userEnterInputCreditCardNumber;
        String stringUserEnterInputCreditCardNumber = "";
        int userEnterInputCreditCardNumberExpirationDateMonth;
        String stringUserEnterInputCreditCardNumberExpirationDateMonth = "";
        int userEnterInputCreditCardNumberExpirationDateYear;
        String stringUserEnterInCreditCardNumberExpirationDateYear = "";
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Enter in your Credit Card Number");
            stringUserEnterInputCreditCardNumber = scanner.nextLine();
            userEnterInputCreditCardNumber = Long.parseLong(stringUserEnterInputCreditCardNumber);

            System.out.println("Please enter in the 2-digit Month");
            stringUserEnterInputCreditCardNumberExpirationDateMonth = scanner.nextLine();
            userEnterInputCreditCardNumberExpirationDateMonth = Integer.parseInt(stringUserEnterInputCreditCardNumberExpirationDateMonth);

            System.out.println("Please enter in the 2-digit Year");
            stringUserEnterInCreditCardNumberExpirationDateYear = scanner.nextLine();
            userEnterInputCreditCardNumberExpirationDateYear = Integer.parseInt(stringUserEnterInCreditCardNumberExpirationDateYear);

            System.out.println("Please enter in the 3-digit CVV Code that is on the back of your Credit Card");
            stringUserEnterInputCreditCardCVVCode = scanner.nextLine();
            userEnterInputCreditCardCVVCode = Integer.parseInt(stringUserEnterInputCreditCardCVVCode);

            /*
        Long userEnterInCreditCardNumber = Long.valueOf(io.readString("Enter in your Credit Card Number"));
        int userEnterInputCreditCardNumberExpirationDateMonth = Integer.valueOf(io.readString("Please enter in the 2-digit Month"));
        int userEnterInputCreditCardNumberExpirationDateYear = Integer.valueOf(io.readString("Please enter in the 2-digit Year"));
        int userEnterInCreditCardCVVCode = Integer.valueOf(io.readString("Please enter in the 3-digit CVV Code that is on the back of your Credit Card"));
             */
            userInputCreditCardNumberCount = 0;
            while (userEnterInputCreditCardNumber != 0) {

                userEnterInputCreditCardNumber = userEnterInputCreditCardNumber / 10;
                ++userInputCreditCardNumberCount;
            }

            userInputCVVCodeCount = 0;
            while (userEnterInputCreditCardCVVCode != 0) {
                userEnterInputCreditCardCVVCode = userEnterInputCreditCardCVVCode / 10;
                ++userInputCVVCodeCount;
            }

            if (userInputCreditCardNumberCount != 16
                    || userEnterInputCreditCardNumberExpirationDateMonth > 12
                    || userEnterInputCreditCardNumberExpirationDateYear < 20) {
                io.print("===ERROR=== CREDIT CARD INFORMATION NOT-VALID");
                io.print("Please review your Credit Card Information below before resubmitting this it");
                io.print("Credit Card Number: " + stringUserEnterInputCreditCardNumber);
                io.print("Credit Card Expiration Date: " + userEnterInputCreditCardNumberExpirationDateMonth + "/" + userEnterInputCreditCardNumberExpirationDateYear);
                io.print("CVV Code: " + stringUserEnterInputCreditCardCVVCode);

            }
        } while (userInputCreditCardNumberCount != 16 || userEnterInputCreditCardNumberExpirationDateMonth > 12
                || userEnterInputCreditCardNumberExpirationDateYear < 20 || userInputCVVCodeCount != 3);

        io.print("===ALL OF YOUR CREDIT CARD INFORMATION HAS BEEN VERIFIED===");
        int accountNumber = random.nextInt(10000) + 99999;
        io.print("Below is your Account Number");
        io.print("Account Number: " + accountNumber);
    }

    public void createAndVerifyPassword() {
        int userInputPasswordForUserNameToUpperCase = 0;
        int userInputPasswordForUserNameToLowerCase = 0;
        int userInputPasswordForUserNameIsNumber = 0;
        int userInputPasswordForUserNameSpecialCharacter = 0;
        int accountNumber;
        long userInputCreditCardNumber;
        int userInputCreidtCardNumberExpirationMonth;
        int userInputEnterInCreidtCardNumberExpirationYear;
        int userInputEnterInCreditCardCVVCode;
        String userInputPassword = "";
        String userInputPasswordToVerify = "";
        int creditCardNumberCount = 0;
        int creditCardCVVCode = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please enter in your password.");
            System.out.println("It needs to be at least 6 Characters");
            System.out.println("With at least One Uppercase Letter and One Lowercase Letter");
            System.out.println("Along with at least one Number and at least one Special Character(#, $ % &, !).");
            userInputPassword = scanner.nextLine();
            System.out.println("Please enter in your password again for verification purposes");
            userInputPasswordToVerify = scanner.nextLine();

            char[] userInputPasswordForUserNameToCharArray = userInputPasswordToVerify.toCharArray();
            for (int i = 0; i < userInputPassword.length(); i++) {
                if (Character.isUpperCase(userInputPasswordForUserNameToCharArray[i])) {
                    userInputPasswordForUserNameToUpperCase++;
                } else if (Character.isLowerCase(userInputPasswordForUserNameToCharArray[i])) {
                    userInputPasswordForUserNameToLowerCase++;
                } else if (Character.isDigit(userInputPasswordForUserNameToCharArray[i])) {
                    userInputPasswordForUserNameIsNumber++;
                } else {
                    userInputPasswordForUserNameSpecialCharacter++;
                }
            }
            if (userInputPassword.length() <= 5
                    || userInputPasswordForUserNameIsNumber == 0
                    || userInputPasswordForUserNameSpecialCharacter == 0
                    || userInputPasswordForUserNameToLowerCase == 0
                    || userInputPasswordForUserNameToUpperCase == 0) {
                System.out.println("===INVALID PASSWORD===");
            }
            if (!userInputPassword.equals(userInputPasswordToVerify)) {
                System.out.println("===INVALID PASSWORD===");
                System.out.println("===YOUR PASSWORDS DO NOT MATCH===");
            }
        } while (userInputPasswordForUserNameIsNumber == 0
                || userInputPasswordForUserNameToLowerCase == 0
                || userInputPasswordForUserNameToUpperCase == 0
                || userInputPasswordForUserNameSpecialCharacter == 0
                || userInputPassword.length() < 5
                || !userInputPassword.equals(userInputPasswordToVerify));
        System.out.println(
                "===VALID PASSWORD===");

    }

    public void checkUserNameForDuplicateUsersAndAskForNewUserName() {
        String userInputUsername = "";
        String userInputUsernameToVerify = "";
        String userNameOnFile = "Josh2141";
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Enter in your Username");
            userInputUsername = scanner.nextLine();

            System.out.println("Enter in your Username again for verification purposes");
            userInputUsernameToVerify = scanner.nextLine();

            io.print("userNameOnFile = " + userNameOnFile);
            io.print("userInputToVerify = " + userInputUsernameToVerify);
            io.print("userInputUsername = " + userInputUsername);

            if (userInputUsername.equals(userNameOnFile)
                    || userInputUsernameToVerify.equals(userNameOnFile)) {
                io.print("===The Username you entered is already on file===");
            }

            if (!userInputUsername.equals(userInputUsernameToVerify)) {
                io.print("=== ERRROR = The Username === DOES NOT MATCH === The Username to Verify");
            }

        } while (userInputUsername.equals(userNameOnFile)
                || userInputUsernameToVerify.equals(userNameOnFile)
                || !userInputUsername.equals(userInputUsernameToVerify));

        io.print("=== SUCCESS ===");
    }

    public void loginAsANewUser() {
        Scanner scanner = new Scanner(System.in);
        String userInputUsername = "";
        String userInputPassword = "";
        String userInputUsernameToVerify = "Josh123";
        String userInputPasswordToVerify = "Summer$1";
        int accountBalance = 0;

        do {
            io.print("=== ENTER IN YOUR USERNAME ===");
            userInputUsername = scanner.nextLine();

            io.print("=== ENTER IN YOUR USERNAME AGAIN TO VERIFY ===");
            userInputUsernameToVerify = scanner.nextLine();

            io.print("=== ENTER IN YOUR PASSWORD ===");
            userInputPassword = scanner.nextLine();

            io.print("=== ENTER IN YOUR PASSWORD TO AGAIN TO VERIFY ===");
            userInputPasswordToVerify = scanner.nextLine();

            if (!userInputUsername.equals(userInputUsernameToVerify)) {
                io.print("=== Your Username is not on File ===");
                io.print("=== Please review your Login Information and Re-Login ===");
            }

            if (!userInputPassword.equals(userInputPasswordToVerify)) {
                io.print("=== Your Password is Incorrect ===");
                io.print("=== Please review your Login Information and Re-Login ===");
            }

        } while (!userInputUsername.equals(userInputUsernameToVerify)
                || !userInputPassword.equals(userInputPasswordToVerify));

        io.print("=== WELCOME ===");
        io.print("=== CURRENT ACCOUNT BALANCE $" + accountBalance + " ===");

        /*    public void getExistingUserInformation() {

        if (userName.setUserName().equals(userName.getUser())
                && userInputPasswordForUserName.getUserInputPasswordForUserName.equals(userInputPasswordForUserName.setUserInputPasswordForUserName())) {
            io.print("===WELCOME===");
            io.print("===CURRENT ACCOUNT BALANCE $" + accountBalance.getAccountBalance() + "===");
        }*/
    }

    public void getNewPassword() {
        Scanner scanner = new Scanner(System.in);
        String userInputUsername = "";
        String userInputPassword = "";
        String userInputEmailAddress = "";
        String userInputEmailAddressToVerify = "wegnerjosh@gmail.com";
        String userInputUsernameToVerify = "Josh123";
        String userInputPasswordToVerify = "Summer$1";
        Random random = new Random();
        int accountNumber = random.nextInt(10000) + 99999;
        int accountNumberToVerify = accountNumber;
        int temporaryPasswordToVerify = 0;
        String stringAccountNumber = "";
        String stringTemporaryPassword = "";
        double accountBalance = 0;
        int temporaryPassword = 0;

        io.print("=== YOUR PASSWORD IS INCORRECT ===");
        io.print("=== ACCOUNT NUMBER === " + accountNumber + " ===");

        do {
            io.print("Please enter in your Username");
            userInputUsername = scanner.nextLine();

            io.print("Please enter in your Account Number");
            stringAccountNumber = scanner.nextLine();
            accountNumber = Integer.parseInt(stringAccountNumber);

            io.print("Please enter in your Email Address");
            userInputEmailAddress = scanner.nextLine();

            if (userInputUsername.equals(userInputUsernameToVerify)
                    && accountNumber == accountNumberToVerify
                    && userInputEmailAddress.equals(userInputEmailAddressToVerify)) {
                temporaryPassword = random.nextInt(10000) + 99999;
                io.print("===TEMPORARY PASSWORD=== " + temporaryPassword);

                io.print("Please enter in your Username");
                userInputUsername = scanner.nextLine();

                io.print("Enter your Temporary Password");
                stringTemporaryPassword = scanner.nextLine();
                temporaryPassword = Integer.parseInt(stringTemporaryPassword);

                temporaryPasswordToVerify = temporaryPassword;
            }
            if (!userInputUsername.equals(userInputUsernameToVerify)
                    || accountNumber != accountNumberToVerify
                    || !userInputEmailAddress.equals(userInputEmailAddressToVerify)) {
                io.print("===KINDLY REVIEW YOUR INFORMATION AND RE-LOGIN===");
            }
        } while (!userInputUsername.equals(userInputUsernameToVerify)
                || temporaryPassword != temporaryPasswordToVerify
                || accountNumber != accountNumberToVerify
                || !userInputEmailAddress.equals(userInputEmailAddressToVerify));

        io.print("=== WELCOME ===");
        io.print("=== CURRENT ACCOUNT BALANCE $" + accountBalance + " ===");
    }

    public void loginToAccount() {
        Scanner scanner = new Scanner(System.in);
        String userInputUsername = "";
        String userInputPassword = "";
        String userInputUsernameToVerify = "Josh123";
        String userInputPasswordToVerify = "Summer$1";
        double accountBalance = 0;

        do {
            io.print("=== USERNAME ===");
            userInputUsername = scanner.nextLine();

            io.print("=== PASSWORD ===");
            userInputPassword = scanner.nextLine();

            io.print(userInputUsername);
            io.print(userInputPassword);

            if (!userInputUsername.equals(userInputUsernameToVerify)
                    || !userInputPassword.equals(userInputPasswordToVerify)) {
                io.print("=== ERROR ===");
                io.print("Your Username and/or Password are not correct");
                io.print("Please review your information and try logging in again");
            }

        } while (!userInputUsername.equals(userInputUsernameToVerify)
                || !userInputPassword.equals(userInputPasswordToVerify));

        io.print("=== WELCOME ===");
        io.print("=== CURRENT ACCOUNT BALANCE $" + accountBalance + " ===");
    }

    public void depositMoneyIntoAccount() {
        String action = "";
        double userInputDepositIntoAccount = 0;
        String stringUserInputDepositIntoAccount = "";
        Scanner scanner = new Scanner(System.in);
        double accountBalance = 0;
        double currentAccountBalance;

        io.print("deposit");
        action = scanner.nextLine();

        if (action.equalsIgnoreCase("deposit")) {

            do {
                io.print("Enter in the amount of money you want to deposit into your account");
                stringUserInputDepositIntoAccount = scanner.nextLine();
                userInputDepositIntoAccount = Double.parseDouble(stringUserInputDepositIntoAccount);

                if (userInputDepositIntoAccount > 50000) {
                    io.print("The amount of money you enter in exceeds the maximum deposited amount");
                    io.print("Please enter in a new dollar amount");
                }

            } while (userInputDepositIntoAccount > 50000);

            currentAccountBalance = accountBalance + userInputDepositIntoAccount;
            io.print("===Thank you for your deposit===");
            io.print("===YOUR CURRENT ACCOUNT BALANCE=== $" + currentAccountBalance);
        }
    }

    public void withdrawalMoneyFromAccount() {
        double accountBalance = 1000;
        Scanner scanner = new Scanner(System.in);
        String action = "";
        String userInputEmailAddress = "wegnerjosh@gmail.com";
        double currentAccountBalance;
        double withdrawalAmountFromUser = 0;
        String stringWithdrawalAmountFromUser = "";
        String userInputAddressStreetNumberAndName = "5444 Logan Ave So";
        String userInputAddressCity = "Minneapolis";
        String userInputAddressState = "MN";
        int userInputAddressZipCode = 55419;

        io.print("withdrawal");
        action = scanner.nextLine();
        if (action.equalsIgnoreCase("withdrawal")) {
            if (accountBalance <= 0) {
                io.print("=== ERROR ===");
                io.print("=== THERE IS NO MONEY IN YOUR ACCOUNT ===");
                io.print("==== SELECT DEPOSIT TO PUT MONEY INTO YOUR ACCOUNT ===");
            }
            if (accountBalance > 0) {
                io.print("===ACCOUNT BALANCE=== " + accountBalance);

                io.print("Enter in the Withdrawl Amount below");
                stringWithdrawalAmountFromUser = scanner.nextLine();
                withdrawalAmountFromUser = Double.parseDouble(stringWithdrawalAmountFromUser);

                currentAccountBalance = accountBalance - withdrawalAmountFromUser;
                System.out.println(currentAccountBalance);
                io.print("The withdrawl of $" + withdrawalAmountFromUser + " === COULD TAKE 2-3 BUSINESS DAYS TO PROCESS ===");
                io.print("===CURRENT ACCOUNT BALANCE=== $" + currentAccountBalance);
                io.print("Once your withdrawl has been successfully processed you will recieve an email at === " + userInputEmailAddress + " ===");
                io.print("=== YOUR CHECK SHOULD BE RECIEVED AT THE ADDRESS BELOW WITHIN 5-7 BUSINESS DAYS ===");
                io.print(userInputAddressStreetNumberAndName);
                io.print(userInputAddressCity + ", " + userInputAddressState + " " + userInputAddressZipCode);
            }
        } else {
            io.print("=== POOP ===");
        }

    }
}
