/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author softwareguild
 */
public class UserInformationPasswordCreditCardInformationView {

    UserInterface io = new ConsoleImplementationUserInterface();

    public int printMenuAndGetSelection() {

        io.print("=== MAIN MENU ===");
        io.print("1. New User");
        io.print("2. Existing User");
        io.print("3. Forgot Username and/or Password");
        io.print("4. Exit");

        return io.readInt("Please select from the above choices ", 1, 4);
    }

    public UserInformation getUserInformation() {

        String userInputFirstName = io.readString("First Name");
        String userInputLastName = io.readString("Last Name");
        String userInputStreetAddress = io.readString("Street Address");
        String userInputCity = io.readString("City").toUpperCase();
        String userInputState = io.readString("State");
        int userInputZipCode = Integer.valueOf(io.readString("Zip Code"));
        String userInputEmailAddress = io.readString("Email Address").toLowerCase();
        UserInformation currentUserInformation = new UserInformation();

        return currentUserInformation;
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
}
