/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class BookauthorTest {

    public BookauthorTest() {
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

    private Bookauthor bookauthor = new Bookauthor();

    @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.print("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = bookauthor.getClass().isAnnotationPresent(Entity.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.print("@Id-Annotation-authorId");
        Boolean expResult = true;
        Boolean result = bookauthor.getClass().getDeclaredField("authorId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationID() throws NoSuchFieldException {
        System.out.println("@JoinColumn-Annotation-authorId");
        Boolean expResult = true;
        Boolean result = bookauthor.getClass().getDeclaredField("authorId").getAnnotation(JoinColumn.class).name().equals("author_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testManyToOneAnnotation() throws NoSuchFieldException {
        System.out.print("@ManyToOne-Annotation-authorId");
        Boolean expResult = true;
        Boolean result = bookauthor.getClass().getDeclaredField("authorId").isAnnotationPresent(ManyToOne.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation2() throws NoSuchFieldException {
        System.out.print("@Id-Annotation-bookId");
        Boolean expResult = true;
        Boolean result = bookauthor.getClass().getDeclaredField("bookId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationID2() throws NoSuchFieldException {
        System.out.println("@JoinColumn-Annotation-bookId");
        Boolean expResult = true;
        Boolean result = bookauthor.getClass().getDeclaredField("bookId").getAnnotation(JoinColumn.class).name().equals("book_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testManyToOneAnnotation2() throws NoSuchFieldException {
        System.out.print("@ManyToOne-Annotation-bookId");
        Boolean expResult = true;
        Boolean result = bookauthor.getClass().getDeclaredField("bookId").isAnnotationPresent(ManyToOne.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

}
