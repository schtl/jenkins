/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class SubjectTest {
    
    private Subject subject = new Subject();
    
    public SubjectTest() {
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

     @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.println("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = subject.getClass().isAnnotationPresent(Entity.class);
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.println("@Id-Annotation");
        Boolean expResult = true;
        Boolean result = subject.getClass().getDeclaredField("subjectId").isAnnotationPresent(Id.class);
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGenValAnnotation() throws NoSuchFieldException {
        System.out.println("@GeneratedValue-Annotation");
        Boolean expResult = true;
        Boolean result = subject.getClass().getDeclaredField("subjectId").isAnnotationPresent(GeneratedValue.class);
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationClassId() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classId");
        Boolean expResult = true;
        Boolean result = subject.getClass().getDeclaredField("subjectId").getAnnotation(Column.class).name().equals("subject_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationLongname() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classname");
        Boolean expResult = true;
        Boolean result = subject.getClass().getDeclaredField("longname").getAnnotation(Column.class).length() == 100;
        assertEquals(expResult, result);
    }

        @org.junit.jupiter.api.Test
    public void testColumnAnnotationShortname() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classname");
        Boolean expResult = true;
        Boolean result = subject.getClass().getDeclaredField("shortname").getAnnotation(Column.class).length() == 10;
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testOneToManyAnnotation() throws NoSuchFieldException {
        System.out.println("@OneToMany-Annotation");
        Boolean expResult = true;
        Boolean result = subject.getClass().getDeclaredField("exams").isAnnotationPresent(OneToMany.class);
        if (result) {
            result = result && subject.getClass().getDeclaredField("exams").getAnnotation(OneToMany.class).mappedBy().equals("subject");
        }
        if (result) {
            result = result && subject.getClass().getDeclaredField("exams").getAnnotation(OneToMany.class).cascade()[0].equals(CascadeType.PERSIST);
        }
        assertEquals(expResult, result);
    }

}
