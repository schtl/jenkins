/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author SF <htlkaindorf.at>
 */
public class ClassnameTest {

    private Classname classname = new Classname();

    public ClassnameTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        classname = new Classname();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.println("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = classname.getClass().isAnnotationPresent(Entity.class);
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.println("@Id-Annotation");
        Boolean expResult = true;
        Boolean result = classname.getClass().getDeclaredField("classId").isAnnotationPresent(Id.class);
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGenValAnnotation() throws NoSuchFieldException {
        System.out.println("@GeneratedValue-Annotation");
        Boolean expResult = true;
        Boolean result = classname.getClass().getDeclaredField("classId").isAnnotationPresent(GeneratedValue.class);
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotation1() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classId");
        Boolean expResult = true;
        Boolean result = classname.getClass().getDeclaredField("classId").getAnnotation(Column.class).name().equals("class_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotation2() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classname");
        Boolean expResult = true;
        Boolean result = classname.getClass().getDeclaredField("classname").getAnnotation(Column.class).length() == 10;
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testOneToManyAnnotation() throws NoSuchFieldException {
        System.out.println("@OneToMany-Annotation");
        Boolean expResult = true;
        Boolean result = classname.getClass().getDeclaredField("students").isAnnotationPresent(OneToMany.class);
        if (result) {
            result = result && classname.getClass().getDeclaredField("students").getAnnotation(OneToMany.class).mappedBy().equals("classname");
        }
        if (result) {
            result = result && classname.getClass().getDeclaredField("students").getAnnotation(OneToMany.class).cascade()[0].equals(CascadeType.PERSIST);
        }
        assertEquals(expResult, result);
    }

}
