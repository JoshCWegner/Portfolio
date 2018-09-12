
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

        UserInformationPasswordCreditCardInformationView view = new UserInformationPasswordCreditCardInformationView();
        UserInformationPasswordCreditCardInformationController controller = new UserInformationPasswordCreditCardInformationController();
        UserInterface io = new ConsoleImplementationUserInterface();
        controller.run();
    }

}
