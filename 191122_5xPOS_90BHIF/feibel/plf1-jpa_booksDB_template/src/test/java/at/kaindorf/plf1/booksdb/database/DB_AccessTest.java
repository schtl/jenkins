/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.database;

import at.kaindorf.plf1.booksdb.pojos.Author;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SF <htlkaindorf.at>
 */
public class DB_AccessTest {

    private DB_Access dba = DB_Access.getInstance();

    public DB_AccessTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class DB_Access.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DB_Access result = DB_Access.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of connect method, of class DB_Access.
     */
    //@Test(expected = Test.None.class /* no exception expected */)
    @Test
    public void testConnect() {
        System.out.println("connect/disconnect test");
        assertDoesNotThrow(() -> {
            dba.connect();
            dba.disconnect();
        });
    }

    /**
     * Test of importPublisher method, of class DB_Access.
     */
    @Test
    public void importPublisher() throws Exception {
        System.out.println("importPublisher");
        assertDoesNotThrow(() -> {
            dba.connect();
            dba.importPublisher();
            dba.disconnect();
        });
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllAuthorsOfPublisher method, of class DB_Access.
     */
    @Test
    public void testGetAllAuthorsOfPublisher() {
        System.out.println("getAllAuthorsOfPublisher");
        String publishername = "IDG Books";
        String expResult = "Bebak Arthur\n"
                + "Erwin Mike\n"
                + "Gaither Mark\n"
                + "Hassinger Sebastian\n"
                + "James Steve\n"
                + "Ray Deborah\n"
                + "Ray Eric\n"
                + "Smith Bud\n"
                + "Taylor Dave\n"
                + "Tittel Ed\n";
        dba.connect();
        List<Author> list = dba.getAllAuthorsOfPublisher(publishername);
        dba.disconnect();
        String result = "";
        for (Author author : list) {
            result += author.toString() + "\n";
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of countBooksOfAuthor method, of class DB_Access.
     */
    @Test
    public void testCountBooksOfAuthor() {
        System.out.println("countBooksOfAuthor");
        String lastname = "Tittel";
        int rank = 1;
        Long expResult = 3L;
        dba.connect();
        Long result = dba.countBooksOfAuthor(lastname, rank);
        dba.disconnect();
        assertEquals(expResult, result);
    }

    /**
     * Test of countBooksOfAuthor method, of class DB_Access.
     */
    @Test
    public void testCountBooksOfAuthor2() {
        System.out.println("countBooksOfAuthor");
        String lastname = "Gaither";
        int rank = 2;
        Long expResult = 1L;
        dba.connect();
        Long result = dba.countBooksOfAuthor(lastname, rank);
        dba.disconnect();
        assertEquals(expResult, result);
    }

}
