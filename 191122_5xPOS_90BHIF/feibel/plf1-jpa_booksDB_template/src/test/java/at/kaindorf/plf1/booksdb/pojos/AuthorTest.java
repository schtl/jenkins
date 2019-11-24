/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SF <htlkaindorf.at>
 */
public class AuthorTest {

    public AuthorTest() {
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

    private Author author = new Author();

    @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.print("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = author.getClass().isAnnotationPresent(Entity.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.print("@Id-Annotation");
        Boolean expResult = true;
        Boolean result = author.getClass().getDeclaredField("authorId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGenValAnnotation() throws NoSuchFieldException {
        System.out.print("@GeneratedValue-Annotation");
        Boolean expResult = true;
        Boolean result = author.getClass().getDeclaredField("authorId").isAnnotationPresent(GeneratedValue.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationID() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classId");
        Boolean expResult = true;
        Boolean result = author.getClass().getDeclaredField("authorId").getAnnotation(Column.class).name().equals("author_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationFirstname() throws NoSuchFieldException {
        System.out.print("@Column-Annotation firstanme");
        Boolean expResult = true;
        Boolean result = author.getClass().getDeclaredField("firstname").getAnnotation(Column.class).length() == 100;
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testOneToManyAnnotation() throws NoSuchFieldException {
        System.out.print("@OneToMany-Annotation");
        Boolean expResult = true;
        Boolean result = author.getClass().getDeclaredField("bookAuthors").isAnnotationPresent(OneToMany.class);
        if (result) {
            result = result && author.getClass().getDeclaredField("bookAuthors").getAnnotation(OneToMany.class).mappedBy().equals("authorId");
        }
        if (result) {
            result = result && author.getClass().getDeclaredField("bookAuthors").getAnnotation(OneToMany.class).cascade()[0].equals(CascadeType.PERSIST);
        }

        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testNamedQueryAnnotation1() throws NoSuchFieldException {
        System.out.print("@NamedQuery1-Annotation");
        Boolean expResult = true;
        Boolean result = author.getClass().getAnnotation(NamedQueries.class).value()[0].name().equals("Author.getAllAuthorsOfPublisher");
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testNamedQueryAnnotation2() throws NoSuchFieldException {
        System.out.print("@NamedQuery2-Annotation");
        Boolean expResult = true;
        Boolean result = author.getClass().getAnnotation(NamedQueries.class).value()[1].name().equals("Author.countBooksOfAuthor");
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

}
