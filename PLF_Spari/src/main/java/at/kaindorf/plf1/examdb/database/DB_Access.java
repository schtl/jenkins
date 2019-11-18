/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.database;

import at.kaindorf.plf1.examdb.pojos.Classname;
import at.kaindorf.plf1.examdb.pojos.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author spamac15
 */
public final class DB_Access {

    // ToDo: insert singleton-code here
    private static DB_Access theInstance;
    private EntityManager em;
    private EntityManagerFactory emf;

    private DB_Access() {
    }

    public static DB_Access getInstance() {
        // ToDo: insert code here
        if (theInstance == null) {
            theInstance = new DB_Access();
        }
        return theInstance;
    }

    public void connect() {
        // ToDo: insert code here
        emf = Persistence.createEntityManagerFactory("ExamDB_PU");
        em = emf.createEntityManager();
    }

    public void disconnect() {
        // ToDo: insert code here
        if (em != null && em.isOpen()) {
            em.close();
            em = null;
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }

    /**
     * read the classnames from csv-file and persist values pathname of
     * csv-file:
     * \home\student\NetBeansProjects\plf1-jpa_examDB_template\src\main\resources\res\classnames.csv
     * Classname-objects in database
     *
     * @throws IOException
     */
    public void importClassnames() throws IOException {
        // ToDo: insert code here
        final String path = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + "res"
                + File.separator + "classnames.csv";
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        while ((line = br.readLine()) != null) {
            Classname classname = new Classname(line);
            em.persist(classname);
        }
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    /**
     * use named query "Student.getStudentsByClassnameAndSubject" to get a list
     * containing all students of a specific class that have an exam in a
     * specific subject identified by the shortname. The students are sorted by
     * lastname.
     *
     * @param classname for selection
     * @param subject shortname of subject for selection
     * @return list of students
     */
    public List<Student> getStudentsByClassnameAndSubject(String classname, String subject) {
        // ToDo: insert code here
        List<Student> studentlist;
        TypedQuery<Student> tqStudent = em.createNamedQuery("Student.getStudentsByClassnameAndSubject", Student.class);
        tqStudent.setParameter("classname", classname);
        tqStudent.setParameter("subject", subject);
        studentlist = tqStudent.getResultList();
        return studentlist;
    }

    /**
     * use named query Student.countStudentsFromGradeWithExamInTimePeriod to get
     * the number of all students of a specific grade (1-5) within a specific
     * time-period
     *
     * @return number of students
     */
    public Long countStudentsFromGradeWithExamInTimePeriod(LocalDate startDate, LocalDate endDate, int grade) {
        // ToDo: insert code here
        Long value;
        TypedQuery<Long> tqCount = em.createNamedQuery("Student.countStudentsFromGradeWithExamInTimePeriod", Long.class);
        tqCount.setParameter("startdate", startDate);
        tqCount.setParameter("enddate", endDate);
        tqCount.setParameter("grade", grade + "");
        value = tqCount.getSingleResult();
        return value;
    }

    public static void main(String[] args) {
        try {
            DB_Access dba = DB_Access.getInstance();
            dba.connect();

            //dba.importClassnames();
            
            /*
            for (Student student : dba.getStudentsByClassnameAndSubject("1CHIF", "E")) 
            {
                System.out.println(student.getFirstname() + " " + student.getLastname());
            }*/
 /*
            System.out.println(dba.countStudentsFromGradeWithExamInTimePeriod(
                    LocalDate.of(2017, Month.OCTOBER, 1), 
                    LocalDate.of(2017, Month.OCTOBER, 31), 
                    1));
             */
 
            dba.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(DB_Access.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
