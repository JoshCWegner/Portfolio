/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wegnerjosh.fizzbuzzandfizzbuzzinteractive.dto;

/**
 *
 * @author softwareguild
 */
public class FizzBuzzandFizzBuzzInteractive {

    private int userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    private int userInputMinNumberForInteractiveFizzBuzz;
    private int userInputMaxNumberForInteractiveFizzBuzz;

    public FizzBuzzandFizzBuzzInteractive(int userInputMinNumberForInteractiveFizzBuzz, int userInputMaxNumberForInteractiveFizzBuzz) {
        this.userInputMaxNumberForInteractiveFizzBuzz = userInputMaxNumberForInteractiveFizzBuzz;
        this.userInputMinNumberForInteractiveFizzBuzz = userInputMinNumberForInteractiveFizzBuzz;
    }

    public int getUserInputSelectionFizzBuzzOfInteractiveFizzBuzz() {
        return userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    }

    public void setUserInputSelectionFizzBuzzOfInteractiveFizzBuzz(int userInputSelectionFizzBuzzOfInteractiveFizzBuzz) {
        this.userInputSelectionFizzBuzzOfInteractiveFizzBuzz = userInputSelectionFizzBuzzOfInteractiveFizzBuzz;
    }

    public int getUserInputMinNumberForInteractiveFizzBuzz() {
        return userInputMinNumberForInteractiveFizzBuzz;
    }

    public void setUserInputMinNumberForInteractiveFizzBuzz(int userInputMinNumberForInteractiveFizzBuzz) {
        this.userInputMinNumberForInteractiveFizzBuzz = userInputMinNumberForInteractiveFizzBuzz;
    }

    public int getUserInputMaxNumberForInteractiveFizzBuzz() {
        return userInputMaxNumberForInteractiveFizzBuzz;
    }

    public void setUserInputMaxNumberForInteractiveFizzBuzz(int userInputMaxNumberForInteractiveFizzBuzz) {
        this.userInputMaxNumberForInteractiveFizzBuzz = userInputMaxNumberForInteractiveFizzBuzz;
    }

}
