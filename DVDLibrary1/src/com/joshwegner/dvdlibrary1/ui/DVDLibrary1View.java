/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary1.ui;

import com.joshwegner.dvdlibrary1.dto.Dvd;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class DVDLibrary1View {

    private UserInterface io;

    public DVDLibrary1View(UserInterface io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add a DVD to the Library");
        io.print("2. Remove a DVD from the Library");
        io.print("3. List All of the DVDs in the Library");
        io.print("4. Edit Information on a DVD");
        io.print("5. List Information of a DVD by Title");
        io.print("6. Exit");

        return io.readInt("Please enter in a selection from the above choices.", 1, 6);
    }

    public Dvd getDvdInformation() {
        String movieTitle = io.readString("Please enter in the Movie Title.");
        String directorsName = io.readString("Please enter in the Director's Name for this Movie.");
        String releaseDate = io.readString("Please enter in the Release Date of this Movie. Example - May 4, 2001.");
        String MPAARating = io.readString("Please enter in the MPAA Rating for this Movie - G, PG, PG-13, R, NC-17");
        String studioName = io.readString("Please enter in the Name of the Studio that Released this Movie.");
        String audienceComments = io.readString("Please enter in you review for this movie. Example - 'Good Family Movie'.");
        Dvd currentDvd = new Dvd(movieTitle);
        LocalDate ld = LocalDate.now();
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMPAARating(MPAARating);
        currentDvd.setStudioName(studioName);
        currentDvd.setAudienceComments(audienceComments);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create New DVD in Library ===");
    }

    public void displayCreateDvdSuccessBanner() {
        io.readString("You have successfully created a new Dvd in your Library. Please it enter to continue.");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print(currentDvd.getMovieTitle());
        }

        io.readString("Please hit enter to continue.");
    }

    public void displayAllDvdsBanner() {
        io.print("=== Here is the current list of Dvds in the Dvd Library ===");
    }

    public void displayAllDvdInformationBanner() {
        io.print("=== Display Dvd Information ===");
    }

    public String getMovieTitleChoice() {
        return io.readString("Please enter in a Movie Title.");
    }

    public void displayMovieTitleInformation(Dvd dvd) {
        if (dvd != null) {
            io.print("Movie Title: " + dvd.getMovieTitle());
            io.print("Director's Name: " + dvd.getDirectorsName());
            io.print("Movie Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMPAARating());
            io.print("Studio Name: " + dvd.getStudioName());
        } else {
            io.print("That movie title does not exist in your Dvd Library.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Movie Title ===");
    }

    public void displayRemoveDvdSuccessBanner(Dvd dvd) {
        if (dvd != null) {
            io.readString("You have successfully removed a Dvd from you Dvd Library. Please hit enter to continue.");
        } else {
            io.print("That movie title does not exist in your Dvd Library.");
        }
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command!!!");
    }

    public void displayEditDvdInformationBanner() {
        io.print("=== Edit Dvds ===");
    }

    public Dvd getAndEditDvdInformation(String movieTitle, Dvd currentDvd) {
        Dvd editedDvd = currentDvd;
        boolean keepLooping = true;

        if (currentDvd != null) {
            do {
                String actions = io.readString("What Dvd Information do you want to edit? Director's Name / Release Date / "
                        + "MPAA Rating / Studio Name / Audience Comments / Exit");
                if (actions.equals("Director's Name")) {
                    io.print("The current Director's Name for this dvd is " + currentDvd.getDirectorsName());
                    String directorsName = io.readString("Enter in the new Director's Name");
                    editedDvd.setDirectorsName(directorsName);
                    io.print("You have changed the Director's Name to: " + editedDvd.getDirectorsName());
                } else if (actions.equals("Release Date")) {
                    io.print("The current Release Date for this dvd is " + currentDvd.getReleaseDate());
                    String releaseDate = io.readString("Enter in the new Release Date. Example - May 4, 2014");
                    editedDvd.setReleaseDate(releaseDate);
                    io.print("You have changed the Release Date to: " + editedDvd.getReleaseDate());
                } else if (actions.equals("MPAA Rating")) {
                    io.print("The current MPAA Rating for this dvd is " + currentDvd.getMPAARating());
                    String MPAARating = io.readString("Enter in the new MPAA Rating - G, PG, PG-13, R, NC-17");
                    editedDvd.setMPAARating(MPAARating);
                    io.print("You have changed the MPAA Rating to: " + editedDvd.getMPAARating());
                } else if (actions.equals("Studio Name")) {
                    io.print("The current Studio Name for this dvd is " + currentDvd.getStudioName());
                    String studioName = io.readString("Enter in the new Studio Name.");
                    editedDvd.setStudioName(studioName);
                    io.print("You have changed the Studio Name to: " + editedDvd.getStudioName());
                } else if (actions.equals("Audience Comments")) {
                    io.print("The current Audience Comments for this dvd are " + currentDvd.getAudienceComments());
                    String audienceComments = io.readString("Enter in new Comments. Example - 'Good Family Movie'.");
                    editedDvd.setAudienceComments(audienceComments);
                    io.print("You have changed the Audience Comments to: " + editedDvd.getAudienceComments());
                } else if (actions.equals("Exit")) {
                    keepLooping = false;
                }
            } while (keepLooping);
        }
        return editedDvd;
    }

    public void displayEditedDvdSuccessBanner() {
        io.print("You have successfully edited your Dvd. Please hit enter to continue.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);

    }

}
