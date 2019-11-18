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
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andreas Fellner
 */
public final class DB_Access {
    EntityManagerFactory emf;
    EntityManager em;
    // ToDo: insert singleton-code here
    
    public static DB_Access getInstance() {
        // ToDo: insert code here
        return null;
    }

    public void connect() {
        // ToDo: insert code here
        emf = Persistence.createEntityManagerFactory("ExamDB_PU");
        em = emf.createEntityManager();
    }

    public void disconnect() {
        // ToDo: insert code here
        em.close();
        emf.close();
    }

    /**
     * read the classnames from csv-file and persist values
     * pathname of csv-file: \home\student\NetBeansProjects\plf1-jpa_examDB_template\src\main\resources\res\classnames.csv
     * Classname-objects in database
     *
     * @throws IOException
     */
    public void importClassnames() throws IOException {
        // ToDo: insert code here
        File file = System.getProperty("user.dir")+File.separator+"res"
                +File.separator+"main"+File.separator+"resources"
                +File.separator+"res"+File.separator+"classnames.csv";
        List<Classname> classes = new LinkedList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine())!=null)
        {
        em.getTransaction().begin();
        
        em.persist(line);
        em.getTransaction().commit();
        }
        
        
        

        
        
        
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
        TypedQuery query = (TypedQuery) em.createNamedQuery("Student.getStudentsByClassnameAndSubject");
        query.setParameter("classname", classname);
        query.setParameter("subject", subject);
        return query.getResultList();
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
        TypedQuery query = (TypedQuery) em.createNamedQuery("Student.countStudentsFromGradeWithExamInTimePeriod");
        query.setParameter("grade", grade);
        query.setParameter("start", startDate);
        query.setParameter("end",endDate);
        return (Long) query.getSingleResult();
    }

}
