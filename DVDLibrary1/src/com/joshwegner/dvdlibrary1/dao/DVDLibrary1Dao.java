/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary1.dao;

import com.joshwegner.dvdlibrary1.dto.Dvd;
import java.util.List;
import java.util.Map;

/**
 * @author softwareguild
 */
public interface DVDLibrary1Dao {

    Dvd addDvd(String movieTitle, Dvd dvd)
            throws DVDLibrary1DaoException;

    Dvd removeDvd(String movieTitle)
            throws DVDLibrary1DaoException;

    List<Dvd> getAllDvds()
            throws DVDLibrary1DaoException;

    Dvd editDvdInformation(String movieTitle, Dvd dvd)
            throws DVDLibrary1DaoException;

    Dvd listAllDvdInformation(String movieTitle)
            throws DVDLibrary1DaoException;

    public List<Dvd> getAllMoviesWithTheSameMPAARating(String MPAARating);

    public List<Dvd> gellAllMoviesWithTheSameDirectorsName(String directorsName);

    public List<Dvd> getAllMoviesFromTheSameStudio(String studioName);

    public double getAverageAgeOfMoviesInDvdLibrary();

    public List<Dvd> getMoviesInThePastYears(int ageInYears);

    public Map<String, List<Dvd>> getMoviesByDirectorsNameAndSortByMPAARating(String MPAARating);

    public List<Dvd> getNewestMovieInDvdLibrary(int ageInYears);

    public List<Dvd> getOldestMovieInDvdLibrary(int ageInYears);
}
