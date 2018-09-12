

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author softwareguild
 */
public class BinearySearchAlgorithm {

    public static void main(String[] args) {

        int primeNumbers[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
            41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int primeNumbersGuess = 73;
        int firstPrimeNumber = 0;
        int lastPrimeNumber = primeNumbers.length - 1;

        binearySearch(primeNumbers, firstPrimeNumber, lastPrimeNumber, primeNumbersGuess);

    }

    public static void binearySearch(int primeNumbers[], int firstPrimeNumber, int lastPrimeNumber, int primeNumbersGuess) {
        int middlePrimeNumber = (firstPrimeNumber + lastPrimeNumber) / 2;

        while (firstPrimeNumber <= lastPrimeNumber) {

            if (primeNumbers[middlePrimeNumber] < primeNumbersGuess) {
                firstPrimeNumber = middlePrimeNumber + 1;
            } else if (primeNumbers[middlePrimeNumber] == primeNumbersGuess) {
                System.out.println("The " + primeNumbersGuess + " was found at index " + middlePrimeNumber);
                break;
            } else {
                lastPrimeNumber = middlePrimeNumber - 1;
            }
            middlePrimeNumber = (firstPrimeNumber + lastPrimeNumber) / 2;
        }
        if (firstPrimeNumber > lastPrimeNumber) {
            System.out.println("The element was not found");
        }
    }
}
