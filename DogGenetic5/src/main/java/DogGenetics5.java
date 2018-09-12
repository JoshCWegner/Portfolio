
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
public class DogGenetics5 {

    public static void main(String[] args) {
        int englishBulldogBreedPercentage;
        int frenchBulldogBreedPercentage;
        int germanShepardDogBreedPercentage;
        int chihuahanaDogBreedPercentage;
        int goldenRetrieverDogBreedPercentage;
        String userInputDogName;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your dog's name?");
        userInputDogName = scanner.nextLine();

        System.out.println("Well then, I have this highly reliable report on " + userInputDogName + " prestigious background right here.");

        englishBulldogBreedPercentage = random.nextInt(26) + 1;
        frenchBulldogBreedPercentage = random.nextInt(26) + 1;
        germanShepardDogBreedPercentage = random.nextInt(26) + 1;
        chihuahanaDogBreedPercentage = random.nextInt(26) + 1;

        goldenRetrieverDogBreedPercentage = 100 - (englishBulldogBreedPercentage + frenchBulldogBreedPercentage + germanShepardDogBreedPercentage + chihuahanaDogBreedPercentage);

        System.out.println(userInputDogName + " is:");

        System.out.println(englishBulldogBreedPercentage + "% English Bulldog");
        System.out.println(frenchBulldogBreedPercentage + "% French Bulldog");
        System.out.println(germanShepardDogBreedPercentage + "% German Shepard");
        System.out.println(chihuahanaDogBreedPercentage + "% Chihuahana");
        System.out.println(goldenRetrieverDogBreedPercentage + "% Golden Retriever");
        System.out.println("Wow, " + userInputDogName + " is quite the dog!");
    }
}
//test
