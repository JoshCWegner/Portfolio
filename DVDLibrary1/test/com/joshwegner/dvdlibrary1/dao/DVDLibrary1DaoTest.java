/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshwegner.dvdlibrary1.dao;

import com.joshwegner.dvdlibrary1.dto.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author softwareguild
 */
public class DVDLibrary1DaoTest {

    private DVDLibrary1Dao dao = new DVDLibrary1DaoFileImpl();

    public DVDLibrary1DaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Dvd> dvdList = dao.getAllDvds();
        for (Dvd dvd : dvdList) {
            dao.removeDvd(dvd.getMovieTitle());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DVDLibrary1Dao.
     */
    @Test
    public void testAddGetDvd() throws Exception {
        Dvd dvd = new Dvd("Hitch");
        dvd.setDirectorsName("Will Smith");
        dvd.setReleaseDate("December 22 1999");
        dvd.setStudioName("Sony");
        dvd.setMPAARating("PG-13");
        dvd.setAudienceComments("Date Movie");

        dao.addDvd(dvd.getMovieTitle(), dvd);

        Dvd fromDao = dao.listAllDvdInformation(dvd.getMovieTitle());

        assertEquals(dvd, fromDao);
    }

    /**
     * Test of removeDvd method, of class DVDLibrary1Dao.
     */
    @Test
    public void testRemoveDvd() throws Exception {
        Dvd dvd1 = new Dvd("Hitch");
        dvd1.setDirectorsName("Will Smith");
        dvd1.setReleaseDate("December 22 1999");
        dvd1.setStudioName("Sony");
        dvd1.setMPAARating("PG-13");
        dvd1.setAudienceComments("Date Movie");

        dao.addDvd(dvd1.getMovieTitle(), dvd1);

        Dvd dvd2 = new Dvd("Father of the Bride");
        dvd2.setDirectorsName("Martin Short");
        dvd2.setReleaseDate("May 22 1990");
        dvd2.setStudioName("Warner Bros.");
        dvd2.setMPAARating("PG");
        dvd2.setAudienceComments("Famil Movie");

        dao.addDvd(dvd2.getMovieTitle(), dvd2);

        dao.removeDvd(dvd1.getMovieTitle());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.listAllDvdInformation(dvd1.getMovieTitle()));

        dao.removeDvd(dvd2.getMovieTitle());
        assertEquals(0, dao.getAllDvds().size());
        assertNull(dao.listAllDvdInformation(dvd2.getMovieTitle()));
    }

    /**
     * Test of getAllDvds method, of class DVDLibrary1Dao.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        Dvd dvd1 = new Dvd("Hitch");
        dvd1.setDirectorsName("Will Smith");
        dvd1.setReleaseDate("December 22 1999");
        dvd1.setStudioName("Sony");
        dvd1.setMPAARating("PG-13");
        dvd1.setAudienceComments("Date Movie");

        dao.addDvd(dvd1.getMovieTitle(), dvd1);

        Dvd dvd2 = new Dvd("Father of the Bride");
        dvd2.setDirectorsName("Martin Short");
        dvd2.setReleaseDate("May 22 1990");
        dvd2.setStudioName("Warner Bros.");
        dvd2.setMPAARating("PG");
        dvd2.setAudienceComments("Famil Movie");

        dao.addDvd(dvd2.getMovieTitle(), dvd2);

        assertEquals(2, dao.getAllDvds().size());
    }

    /**
     * Test of editDvdInformation method, of class DVDLibrary1Dao.
     */
    @Test
    public void testEditDvdInformation() throws Exception {
    }

    /**
     * Test of listAllDvdInformation method, of class DVDLibrary1Dao.
     */
    @Test
    public void testListAllDvdInformation() throws Exception {
    }
}
