/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.database;

import at.kaindorf.plf1.examdb.pojos.Student;
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
     * Test of importClassnames method, of class DB_Access.
     */
    @Test
    public void testImportClassnames() throws Exception {
        System.out.println("importClassnames");
        assertDoesNotThrow(() -> {
            dba.connect();
            dba.importClassnames();
            dba.disconnect();
        });
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStudentsByClassnameAndSubject method, of class DB_Access.
     */
    @Test
    public void testGetStudentsByClassnameAndSubject() {
        System.out.println("getStudentsByClassnameAndSubject");
        String classname = "1CHIF";
        String subject = "GGP";
        String expResult = "Bradtke Sydney (1CHIF)\n"
                + "Burchard Markos (1CHIF)\n"
                + "Erett Deane (1CHIF)\n"
                + "Guinan Arlee (1CHIF)\n"
                + "Wilkinson Sully (1CHIF)\n";
        dba.connect();
        List<Student> list = dba.getStudentsByClassnameAndSubject(classname, subject);
        dba.disconnect();
        String result = "";
        for (Student student : list) {
            result += student.toString()+"\n";
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of countStudentsFromGradeWithExamInTimePeriod method, of class
     * DB_Access.
     */
    @Test
    public void testCountStudentsFromGradeWithExamInTimePeriod1() {
        System.out.println("countStudentsFromGradeWithExamInTimePeriod");
        LocalDate startDate = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2018, Month.MARCH, 31);
        int grade = 1;
        Long expResult = 43L;
        dba.connect();
        Long result = dba.countStudentsFromGradeWithExamInTimePeriod(startDate, endDate, grade);
        dba.disconnect();
        assertEquals(expResult, result);
    }

        @Test
    public void testCountStudentsFromGradeWithExamInTimePeriod2() {
        System.out.println("countStudentsFromGradeWithExamInTimePeriod");
        LocalDate startDate = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2018, Month.JANUARY, 31);
        int grade = 4;
        Long expResult = 3L;
        dba.connect();
        Long result = dba.countStudentsFromGradeWithExamInTimePeriod(startDate, endDate, grade);
        dba.disconnect();
        assertEquals(expResult, result);
    }

}
