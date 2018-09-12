/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author softwareguild
 */
public class StateCapitals4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userInputMinimumPopulationGuess;
        String stringUserInputMinimumPopulationGuess = "";
        Scanner scanner = new Scanner(System.in);

        displayStateCapitalStatePopulationAndSquareMiles(0);

        System.out.println("Enter in a number for the minimum population");
        stringUserInputMinimumPopulationGuess = scanner.nextLine();
        userInputMinimumPopulationGuess = Integer.parseInt(stringUserInputMinimumPopulationGuess);

        System.out.println("The capitals with the popualtion of " + userInputMinimumPopulationGuess + " or greater are listed below.");

        displayStateCapitalStatePopulationAndSquareMiles(userInputMinimumPopulationGuess);
    }

    public static void displayStateCapitalStatePopulationAndSquareMiles(int minPopulation) {
        Map<String, Capital> stateCapitalStateAndPopulation = new HashMap<>();
        stateCapitalStateAndPopulation.put("Alabama", new Capital("Alabama - Mongomery", 201332, 156.2));
        stateCapitalStateAndPopulation.put("Alaska", new Capital("Alaska - Juneau", 32660, 3255));
        stateCapitalStateAndPopulation.put("Arizona", new Capital("Arizona - Pheonix", 1513000, 517));
        stateCapitalStateAndPopulation.put("Arkansas", new Capital("Arkansas - Little Rock", 197357, 116.8));
        stateCapitalStateAndPopulation.put("California", new Capital("California - Sacramento", 479686, 100.1));
        stateCapitalStateAndPopulation.put("Colorado", new Capital("Colorado - Denver", 649495, 155));
        stateCapitalStateAndPopulation.put("Connecticut", new Capital("Connecticut - Denver", 125017, 17.95));
        stateCapitalStateAndPopulation.put("Delaware", new Capital("Delaware - Dover", 37366, 22.7));
        stateCapitalStateAndPopulation.put("Florida", new Capital("Florida - Tallahassee", 186411, 103.1));
        stateCapitalStateAndPopulation.put("Georgia", new Capital("Georgia - Atlanta", 447841, 132.4));
        stateCapitalStateAndPopulation.put("Hawaii", new Capital("Hawaii - Honolulu", 374658, 68.42));
        stateCapitalStateAndPopulation.put("Idaho", new Capital("Idaho - Boise", 214237, 80.05));
        stateCapitalStateAndPopulation.put("Illinois", new Capital("Illinois - Springfield", 117006, 65.764));
        stateCapitalStateAndPopulation.put("Indiana", new Capital("Indiana - Indianapolis", 852866, 372));
        stateCapitalStateAndPopulation.put("Iowa", new Capital("Iowa - Des Moinse", 207510, 82.6));
        stateCapitalStateAndPopulation.put("Kansas", new Capital("Kansas - Topeka", 127679, 61.47));
        stateCapitalStateAndPopulation.put("Kentucky", new Capital("Kentucky - Frankfort", 27453, 14.59));
        stateCapitalStateAndPopulation.put("Louisiana", new Capital("Louisiana - Baton Rouge", 229426, 79.07));
        stateCapitalStateAndPopulation.put("Maine", new Capital("Maine - Austuga", 18793, 58.03));
        stateCapitalStateAndPopulation.put("MaryLand", new Capital("MaryLand - Annapolis", 38722, 8.1));
        stateCapitalStateAndPopulation.put("Massachusetts", new Capital("Massachusetts - Boston", 645966, 89.63));
        stateCapitalStateAndPopulation.put("Michigan", new Capital("Michigan - Lansing", 113972, 36.68));
        stateCapitalStateAndPopulation.put("Minnesota", new Capital("Minnesota St. Paul", 294873, 56.18));
        stateCapitalStateAndPopulation.put("Mississippi", new Capital("Mississippi - Jackson", 172638, 106.8));
        stateCapitalStateAndPopulation.put("Missouri", new Capital("Missouri - Jefferson City", 43330, 664));
        stateCapitalStateAndPopulation.put("Montana", new Capital("Montana - Helena", 29596, 16.39));
        stateCapitalStateAndPopulation.put("Nebraska", new Capital("Nebraska - Lincoln", 268738, 90.36));
        stateCapitalStateAndPopulation.put("Nevada", new Capital("Nevada - Carson City", 54080, 157));
        stateCapitalStateAndPopulation.put("New Hampshire", new Capital("New Hampshire - Concord", 42419, 67.49));
        stateCapitalStateAndPopulation.put("New Jersey", new Capital("New Jersey - Trenton", 84308, 8.155));
        stateCapitalStateAndPopulation.put("New Mexico", new Capital("New Mexico - Santa Fe", 69976, 37.41));
        stateCapitalStateAndPopulation.put("New York", new Capital("New York - Albany", 98424, 21.85));
        stateCapitalStateAndPopulation.put("North Carolina", new Capital("North Carolina - Religh", 431746, 144.8));
        stateCapitalStateAndPopulation.put("North Dakota", new Capital("North Dakota - Bismark", 67034, 31.23));
        stateCapitalStateAndPopulation.put("Ohio", new Capital("Ohio - Columbus", 822553, 223.1));
        stateCapitalStateAndPopulation.put("Oklahoma", new Capital("Oklahoma - Oklahoma City", 610613, 620));
        stateCapitalStateAndPopulation.put("Oregon", new Capital("Oregon - Salem", 160614, 48.45));
        stateCapitalStateAndPopulation.put("Pennsylvania", new Capital("Pennsylvania - Hattisburg", 49188, 10.39));
        stateCapitalStateAndPopulation.put("Rhode Island", new Capital("Rhode Island - Providence", 177994, 20.6));
        stateCapitalStateAndPopulation.put("South Carolina", new Capital("South Carolina - Columbia", 133358, 134.9));
        stateCapitalStateAndPopulation.put("South Dakota", new Capital("South Dakota - Pierre", 13984, 13.07));
        stateCapitalStateAndPopulation.put("Tenneessee", new Capital("Tenneessee - Nashville", 678889, 526));
        stateCapitalStateAndPopulation.put("Texas", new Capital("Texas - Austin", 885400, 271.8));
        stateCapitalStateAndPopulation.put("Utah", new Capital("Utah - Salt Lake City", 191180, 110.4));
        stateCapitalStateAndPopulation.put("Vermont", new Capital("Vermont - Montpeiler", 7755, 10.27));
        stateCapitalStateAndPopulation.put("Virginia", new Capital("Virginia - Richmond", 214114, 62.51));
        stateCapitalStateAndPopulation.put("Washington", new Capital("Washington - Olympia", 46478, 19.68));
        stateCapitalStateAndPopulation.put("West Virginia", new Capital("West Virginia - Charleston", 50821, 32.66));
        stateCapitalStateAndPopulation.put("Wisconsin", new Capital("Wisconsin - Madison", 248951, 94.03));
        stateCapitalStateAndPopulation.put("Wyoming", new Capital("Wyoming - Cheyenne", 62448, 24.63));
        Set<String> stateCapitalStateAndPopulationKeys = stateCapitalStateAndPopulation.keySet();
        for (String currentStateCapitalStateAndPopulationKeys : stateCapitalStateAndPopulationKeys) {
            String stateName = stateCapitalStateAndPopulation.get(currentStateCapitalStateAndPopulationKeys).getStateName();
            Integer stateCapitalPopulation = stateCapitalStateAndPopulation.get(currentStateCapitalStateAndPopulationKeys).getStateCapitalPopulation();
            Double stateCapitalSqaureMilage = stateCapitalStateAndPopulation.get(currentStateCapitalStateAndPopulationKeys).getStateCapitalSqaureMilage();
            //  if (stateCapitalPopulation > minPopulation) {
            System.out.println(currentStateCapitalStateAndPopulationKeys + " | Population: " + stateCapitalPopulation + " | Area: " + stateCapitalSqaureMilage + " square miles");
            // }
        }
    }
}
