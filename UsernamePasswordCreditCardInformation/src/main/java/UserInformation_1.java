

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author softwareguild
 */
public class UserInformation_1 {

    private String userInputFirstName;
    private String userInputLastName;
    private String userInputStreetAddress;
    private String userInputCity;
    private String userInputState;
    private int userInputZipCode;
    private String userInputUserName;
    private String userInputEmailAddress;
    private String userInputPassword;
    private String userInputPasswordToVerify;
    private double accountBalance;
    private int accountNumber;
    private long userInputCreditCardNumber;
    private int userInputCreidtCardNumberExpirationYear;
    private int userInputCreidtCardNumberExpirationMonth;
    private int userUserEnterInCreidtCardCVVCode;
    private double withdrawalAmountFromUser;
    private double depositAmountFromUser;
    private double currentAccountBalance;

    public UserInformation_1(String userInputFirstName,
            String userInputLastName,
            String userInputStreetAddress,
            String userInputCity,
            String userInputState,
            int userInputZipCode,
            String userInputUserName,
            String userInputEmailAddress) {
        this.userInputFirstName = userInputFirstName;
        this.userInputLastName = userInputLastName;
        this.userInputStreetAddress = userInputStreetAddress;
        this.userInputCity = userInputCity;
        this.userInputState = userInputState;
        this.userInputZipCode = userInputZipCode;
        this.userInputEmailAddress = userInputEmailAddress;
    }

    public String getUserInputFirstName() {
        return userInputFirstName;
    }

    public void setUserInputFirstName(String userInputFirstName) {
        this.userInputFirstName = userInputFirstName;
    }

    public String getUserInputLastName() {
        return userInputLastName;
    }

    public void setUserInputLastName(String userInputLastName) {
        this.userInputLastName = userInputLastName;
    }

    public String getUserInputStreetAddress() {
        return userInputStreetAddress;
    }

    public void setUserInputStreetAddress(String userInputStreetAddress) {
        this.userInputStreetAddress = userInputStreetAddress;
    }

    public String getUserInputCity() {
        return userInputCity;
    }

    public void setUserInputCity(String userInputCity) {
        this.userInputCity = userInputCity;
    }

    public String getUserInputState() {
        return userInputState;
    }

    public void setUserInputState(String userInputState) {
        this.userInputState = userInputState;
    }

    public int getUserInputZipCode() {
        return userInputZipCode;
    }

    public void setUserInputZipCode(int userInputZipCode) {
        this.userInputZipCode = userInputZipCode;
    }

    public String getUserInputUserName() {
        return userInputUserName;
    }

    public void setUserInputUserName(String userInputUserName) {
        this.userInputUserName = userInputUserName;
    }

    public String getUserInputEmailAddress() {
        return userInputEmailAddress;
    }

    public void setUserInputEmailAddress(String userInputEmailAddress) {
        this.userInputEmailAddress = userInputEmailAddress;
    }

    public String getUserInputPassword() {
        return userInputPassword;
    }

    public void setUserInputPassword(String userInputPassword) {
        this.userInputPassword = userInputPassword;
    }

    public String getUserInputPasswordToVerify() {
        return userInputPasswordToVerify;
    }

    public void setUserInputPasswordToVerify(String userInputPasswordToVerify) {
        this.userInputPasswordToVerify = userInputPasswordToVerify;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getUserInputCreditCardNumber() {
        return userInputCreditCardNumber;
    }

    public void setUserInputCreditCardNumber(long userInputCreditCardNumber) {
        this.userInputCreditCardNumber = userInputCreditCardNumber;
    }

    public int getUserUserEnterInCreidtCardCVVCode() {
        return userUserEnterInCreidtCardCVVCode;
    }

    public void setUserUserEnterInCreidtCardCVVCode(int userUserEnterInCreidtCardCVVCode) {
        this.userUserEnterInCreidtCardCVVCode = userUserEnterInCreidtCardCVVCode;
    }

    public int getUserInputCreidtCardNumberExpirationYear() {
        return userInputCreidtCardNumberExpirationYear;
    }

    public void setUserInputCreidtCardNumberExpirationYear(int userInputCreidtCardNumberExpirationYear) {
        this.userInputCreidtCardNumberExpirationYear = userInputCreidtCardNumberExpirationYear;
    }

    public int getUserInputCreidtCardNumberExpirationMonth() {
        return userInputCreidtCardNumberExpirationMonth;
    }

    public void setUserInputCreidtCardNumberExpirationMonth(int userInputCreidtCardNumberExpirationMonth) {
        this.userInputCreidtCardNumberExpirationMonth = userInputCreidtCardNumberExpirationMonth;
    }

    public double getWithdrawalAmountFromUser() {
        return withdrawalAmountFromUser;
    }

    public void setWithdrawalAmountFromUser(double withdrawalAmountFromUser) {
        this.withdrawalAmountFromUser = withdrawalAmountFromUser;
    }

    public double getDepositAmountFromUser() {
        return depositAmountFromUser;
    }

    public void setDepositAmountFromUser(double depositAmountFromUser) {
        this.depositAmountFromUser = depositAmountFromUser;
    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public void setCurrentAccountBalance(double currentAccountBalance) {
        this.currentAccountBalance = currentAccountBalance;
    }

}
