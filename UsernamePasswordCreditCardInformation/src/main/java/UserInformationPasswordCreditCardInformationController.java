

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author softwareguild
 */
public class UserInformationPasswordCreditCardInformationController {

    UserInterface io = new ConsoleImplementationUserInterface();
    UserInformationPasswordCreditCardInformationView view = new UserInformationPasswordCreditCardInformationView();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    newUser();
                    break;
                case 2:
                    existingUser();
                    break;
                case 3:
                    forgotUsernameAndOrPassword();
                case 4:
                    exitMessage();
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
    }

    private void newUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void existingUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void forgotUsernameAndOrPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
