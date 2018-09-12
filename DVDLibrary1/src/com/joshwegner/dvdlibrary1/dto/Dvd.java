/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary1.dto;

import java.util.Objects;

/**
 *
 * @author softwareguild
 */
public class Dvd {

    private String movieTitle;
    private int movieYear;
    private String additionalComments;
    private String directorsName;
    private String releaseDate;
    private String MPAARating;
    private String studioName;
    private String audienceComments;

    public Dvd(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getAudienceComments() {
        return audienceComments;
    }

    public void setAudienceComments(String audienceComments) {
        this.audienceComments = audienceComments;

    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String extraComments) {
        this.additionalComments = extraComments;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.movieTitle);
        hash = 71 * hash + Objects.hashCode(this.directorsName);
        hash = 71 * hash + Objects.hashCode(this.releaseDate);
        hash = 71 * hash + Objects.hashCode(this.MPAARating);
        hash = 71 * hash + Objects.hashCode(this.studioName);
        hash = 71 * hash + Objects.hashCode(this.audienceComments);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.movieTitle, other.movieTitle)) {
            return false;
        }
        if (!Objects.equals(this.directorsName, other.directorsName)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.MPAARating, other.MPAARating)) {
            return false;
        }
        if (!Objects.equals(this.studioName, other.studioName)) {
            return false;
        }
        if (!Objects.equals(this.audienceComments, other.audienceComments)) {
            return false;
        }
        return true;
    }

}
