/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary1.dao;

import com.joshwegner.dvdlibrary1.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author softwareguild
 */
public class DVDLibrary1DaoFileImpl implements DVDLibrary1Dao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    private Map<String, Dvd> dvds = new HashMap<>();

    private void loadRoster() throws DVDLibrary1DaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibrary1DaoException("-_- Could not load Dvd into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Dvd currentDvd = new Dvd(currentTokens[0]);
            currentDvd.setDirectorsName(currentTokens[1]);
            currentDvd.setReleaseDate(currentTokens[2]);
            currentDvd.setStudioName(currentTokens[3]);
            currentDvd.setMPAARating(currentTokens[4]);
            currentDvd.setAudienceComments(currentTokens[5]);
            currentDvd.setAdditionalComments(currentTokens[6]);
            //    currentDvd.setMovieYear(currentTokens[7]);

            dvds.put(currentDvd.getMovieTitle(), currentDvd);
        }

        scanner.close();
    }

    private void writeRoster() throws DVDLibrary1DaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DVDLibrary1DaoException("Could not save Dvd Data to the Dvd Library.", e);
        }

        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            out.println(currentDvd.getMovieTitle() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getStudioName() + DELIMITER
                    + currentDvd.getMPAARating() + DELIMITER
                    + currentDvd.getAudienceComments() + DELIMITER
                    + currentDvd.getAdditionalComments() + DELIMITER
                    + currentDvd.getMovieYear());

            out.flush();
        }

        out.close();
    }

    @Override
    public Dvd addDvd(String movieTitle, Dvd dvd) throws DVDLibrary1DaoException {
        Dvd newDvdLibrary = dvds.put(movieTitle, dvd);
        writeRoster();
        return newDvdLibrary;
    }

    @Override
    public Dvd removeDvd(String movieTitle) throws DVDLibrary1DaoException {
        Dvd removedMovieTitle = dvds.remove(movieTitle);
        writeRoster();
        return removedMovieTitle;
    }

    @Override
    public List<Dvd> getAllDvds() throws DVDLibrary1DaoException {
        loadRoster();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd listAllDvdInformation(String movieTitle) throws DVDLibrary1DaoException {
        loadRoster();
        return dvds.get(movieTitle);
    }

    @Override
    public Dvd editDvdInformation(String movieTitle, Dvd dvd) throws DVDLibrary1DaoException {
        writeRoster();
        return dvds.get(movieTitle);
    }

    @Override
    public List<Dvd> getAllMoviesWithTheSameMPAARating(String MPAARating) {
        return dvds.values()
                .stream()
                .filter(d -> d.getMPAARating().equalsIgnoreCase(MPAARating))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> gellAllMoviesWithTheSameDirectorsName(String directorsName) {
        return dvds.values()
                .stream()
                .filter(d -> d.getDirectorsName().equalsIgnoreCase(directorsName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getAllMoviesFromTheSameStudio(String studioName) {
        return dvds.values()
                .stream()
                .filter(d -> d.getStudioName().equalsIgnoreCase(studioName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getMoviesInThePastYears(int ageInYears) {
        return dvds.values()
                .stream()
                .filter(d -> d.getReleaseDate().equals(ageInYears))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getMoviesByDirectorsNameAndSortByMPAARating(String directorsName) {
        return dvds.values()
                .stream()
                .filter(d -> d.getDirectorsName().equalsIgnoreCase(directorsName))
                .collect(Collectors.groupingBy(Dvd::getMPAARating));
    }

    @Override
    public List<Dvd> getNewestMovieInDvdLibrary(int ageInYears) {
        return dvds.values()
                .stream()
                .filter(d -> d.getMovieYear() >= ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getOldestMovieInDvdLibrary(int ageInYears) {
        return dvds.values()
                .stream()
                .filter(d -> d.getMovieYear() <= ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageAgeOfMoviesInDvdLibrary() {
        return dvds.values()
                .stream()
                .mapToLong(Dvd::getMovieYear)
                .average()
                .getAsDouble();
    }
}
