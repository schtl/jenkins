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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SF <htlkaindorf.at>
 */
public class PublisherTest {

    public PublisherTest() {
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

    private Publisher publisher = new Publisher();

    @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.print("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = publisher.getClass().isAnnotationPresent(Entity.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.print("@Id-Annotation");
        Boolean expResult = true;
        Boolean result = publisher.getClass().getDeclaredField("publisherId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGenValAnnotation() throws NoSuchFieldException {
        System.out.print("@GeneratedValue-Annotation");
        Boolean expResult = false;
        Boolean result = publisher.getClass().getDeclaredField("publisherId").isAnnotationPresent(GeneratedValue.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testOneToManyAnnotation() throws NoSuchFieldException {
        System.out.print("@OneToMany-Annotation");
        Boolean expResult = true;
        Boolean result = publisher.getClass().getDeclaredField("books").isAnnotationPresent(OneToMany.class);
        if (result) {
            result = result && publisher.getClass().getDeclaredField("books").getAnnotation(OneToMany.class).mappedBy().equals("publisherId");
        }
        if (result) {
            result = result && publisher.getClass().getDeclaredField("books").getAnnotation(OneToMany.class).cascade()[0].equals(CascadeType.PERSIST);
        }
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }
    
}
