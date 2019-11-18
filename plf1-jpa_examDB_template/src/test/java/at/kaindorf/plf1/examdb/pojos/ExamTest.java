/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class ExamTest {

    private Exam exam = new Exam();

    public ExamTest() {
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
        System.out.print("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = exam.getClass().isAnnotationPresent(Entity.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.print("@Id-Annotation");
        Boolean expResult = true;
        Boolean result = exam.getClass().getDeclaredField("examId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGenValAnnotation() throws NoSuchFieldException {
        System.out.print("@GeneratedValue-Annotation");
        Boolean expResult = true;
        Boolean result = exam.getClass().getDeclaredField("examId").isAnnotationPresent(GeneratedValue.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationID() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-examId");
        Boolean expResult = true;
        Boolean result = exam.getClass().getDeclaredField("examId").getAnnotation(Column.class).name().equals("exam_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testManyToOneAnnotationStudent() throws NoSuchFieldException {
        System.out.print("@ManyToOne-Annotation-student");
        Boolean expResult = true;
        Boolean result = exam.getClass().getDeclaredField("student").isAnnotationPresent(ManyToOne.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testJoinColumnAnnotationStudent() throws NoSuchFieldException {
        System.out.println("@JoinColumn-Annotation-student");
        Boolean expResult = true;
        Boolean result = exam.getClass().getDeclaredField("student").getAnnotation(JoinColumn.class).name().equals("student");
        assertEquals(expResult, result);
    }

        @org.junit.jupiter.api.Test
    public void testManyToOneAnnotationSubject() throws NoSuchFieldException {
        System.out.print("@ManyToOne-Annotation-subject");
        Boolean expResult = true;
        Boolean result = exam.getClass().getDeclaredField("subject").isAnnotationPresent(ManyToOne.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testJoinColumnAnnotationSubject() throws NoSuchFieldException {
        System.out.println("@JoinColumn-Annotation-subject");
        Boolean expResult = true;
        Boolean result = exam.getClass().getDeclaredField("subject").getAnnotation(JoinColumn.class).name().equals("subject");
        assertEquals(expResult, result);
    }

}
