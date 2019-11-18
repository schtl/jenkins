/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author spamac15
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Student.getStudentsByClassnameAndSubject",
            query = "SELECT s FROM Student s JOIN s.exams e WHERE s.classname.classname = :classname AND e.subject.shortname = :subject ORDER BY s.lastname"),
    @NamedQuery(name = "Student.countStudentsFromGradeWithExamInTimePeriod",
            query = "SELECT count(s) FROM Student s JOIN s.exams e WHERE e.dateofexam >= :startdate AND e.dateofexam <= :enddate AND SUBSTRING(s.classname.classname, 1, 1) = :grade")
})
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
  private Long studentId;
    @Column(length = 80)
  private String firstname;
    @Column(length = 80)
  private String lastname;
    @OneToMany(mappedBy = "student")
  private Collection<Exam> exams;
  @ManyToOne
  @JoinColumn(name = "classname", nullable = false)
  private Classname classname;

  public void addExam(Exam exam)
  {
      if (exams == null)
      {
          exams = new ArrayList<>();
      }
      exams.add(exam);
  }
  
    public Student() {
    }

    public Student(String firstname, String lastname, Collection<Exam> exams, Classname classname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.exams = exams;
        this.classname = classname;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Collection<Exam> getExams() {
        return exams;
    }

    public void setExams(Collection<Exam> exams) {
        this.exams = exams;
    }

    public Classname getClassname() {
        return classname;
    }

    public void setClassname(Classname classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", lastname, firstname, classname.getClassname());
    }
  
    
  
}
