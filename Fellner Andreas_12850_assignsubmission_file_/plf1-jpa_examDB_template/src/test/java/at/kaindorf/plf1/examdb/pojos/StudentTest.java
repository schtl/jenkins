/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

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
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SF <htlkaindorf.at>
 */
public class StudentTest {

    private Student student = new Student();

    public StudentTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        student = new Student();
    }

    @AfterEach
    public void tearDown() {
    }

    @org.junit.jupiter.api.Test
    public void testClassAnnotation() {
        System.out.print("@Entity-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().isAnnotationPresent(Entity.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testIdAnnotation() throws NoSuchFieldException {
        System.out.print("@Id-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("studentId").isAnnotationPresent(Id.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGenValAnnotation() throws NoSuchFieldException {
        System.out.print("@GeneratedValue-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("studentId").isAnnotationPresent(GeneratedValue.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationID() throws NoSuchFieldException {
        System.out.println("@Column-Annotation-classId");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("studentId").getAnnotation(Column.class).name().equals("student_id");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationFirstname() throws NoSuchFieldException {
        System.out.print("@Column-Annotation firstanme");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("firstname").getAnnotation(Column.class).length() == 80;
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testColumnAnnotationLastname() throws NoSuchFieldException {
        System.out.print("@Column-Annotation lastanme");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("lastname").getAnnotation(Column.class).length() == 80;
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testOneToManyAnnotation() throws NoSuchFieldException {
        System.out.print("@OneToMany-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("exams").isAnnotationPresent(OneToMany.class);
        if (result) {
            result = result && student.getClass().getDeclaredField("exams").getAnnotation(OneToMany.class).mappedBy().equals("student");
        }
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testManyToOneAnnotation() throws NoSuchFieldException {
        System.out.print("@ManyToOne-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("classname").isAnnotationPresent(ManyToOne.class);
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testJoinColumnAnnotation() throws NoSuchFieldException {
        System.out.print("@JoinColumn-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().getDeclaredField("classname").getAnnotation(JoinColumn.class).name().equals("classname");
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testNamedQueryAnnotation1() throws NoSuchFieldException {
        System.out.print("@NamedQuery1-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().getAnnotation(NamedQueries.class).value()[0].name().equals("Student.getStudentsByClassnameAndSubject");
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testNamedQueryAnnotation2() throws NoSuchFieldException {
        System.out.print("@NamedQuery2-Annotation");
        Boolean expResult = true;
        Boolean result = student.getClass().getAnnotation(NamedQueries.class).value()[1].name().equals("Student.countStudentsFromGradeWithExamInTimePeriod");
        System.out.println(expResult == result ? " ok" : " failed <<<<<");
        assertEquals(expResult, result);
    }

}
