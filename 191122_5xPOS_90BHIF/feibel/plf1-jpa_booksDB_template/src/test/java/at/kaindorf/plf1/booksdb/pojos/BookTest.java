/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
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
public class BookTest {

    public BookTest() {
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
    private Book book = new Book();

    @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.print("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = book.getClass().isAnnotationPresent(Entity.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.print("@Id-Annotation");
        Boolean expResult = true;
        Boolean result = book.getClass().getDeclaredField("bookId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGenValAnnotation() throws NoSuchFieldException {
        System.out.print("@GeneratedValue-Annotation");
        Boolean expResult = true;
        Boolean result = book.getClass().getDeclaredField("bookId").isAnnotationPresent(GeneratedValue.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationID() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classId");
        Boolean expResult = true;
        Boolean result = book.getClass().getDeclaredField("bookId").getAnnotation(Column.class).name().equals("book_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testOneToManyAnnotation() throws NoSuchFieldException {
        System.out.print("@OneToMany-Annotation");
        Boolean expResult = true;
        Boolean result = book.getClass().getDeclaredField("bookAuthors").isAnnotationPresent(OneToMany.class);
        if (result) {
            result = result && book.getClass().getDeclaredField("bookAuthors").getAnnotation(OneToMany.class).mappedBy().equals("bookId");
        }
        if (result) {
            result = result && book.getClass().getDeclaredField("bookAuthors").getAnnotation(OneToMany.class).cascade()[0].equals(CascadeType.PERSIST);
        }

        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testManyToOneAnnotation() throws NoSuchFieldException {
        System.out.print("@ManyToOne-Annotation");
        Boolean expResult = true;
        Boolean result = book.getClass().getDeclaredField("publisherId").isAnnotationPresent(ManyToOne.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testJoinColumnAnnotation() throws NoSuchFieldException {
        System.out.print("@JoinColumn-Annotation");
        Boolean expResult = true;
        Boolean result = book.getClass().getDeclaredField("publisherId").getAnnotation(JoinColumn.class).name().equals("publisher_id");
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

}
