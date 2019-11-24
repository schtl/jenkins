/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class BookauthorPKTest {

    public BookauthorPKTest() {
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

    private BookauthorPK ba = new BookauthorPK();

    @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.print("@Entity-Annotation-not present");
        Boolean expResult = false;
        Boolean result = ba.getClass().isAnnotationPresent(Entity.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.print("@Id-Annotation-not-present");
        Boolean expResult = false;
        Boolean result = ba.getClass().getDeclaredField("authorId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation2() throws NoSuchFieldException {
        System.out.print("@Id-Annotation-not-present");
        Boolean expResult = false;
        Boolean result = ba.getClass().getDeclaredField("bookId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

}
