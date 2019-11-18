/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas Fellner
 */
@Entity
@NamedQueries({
@NamedQuery(name ="Student.getStudentsByClassnameAndSubject",query="SELECT s FROM Student s WHERE s.classname = :classname AND s.subject = :subject"),
@NamedQuery(name="Student.countStudentsFromGradeWithExamInTimePeriod",query="SELECT COUNT(s) FROM Student s WHERE s.grade = :grade AND s.dateofexam BETWEEN :begin AND :end")
})
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long studentId;
  @Column(length= 80)
  private String firstname;
  @Column(length = 80)
  private String lastname;

  
  @ManyToOne
  @JoinColumn(name ="classname")
  private Classname classname;
  
  @OneToMany(mappedBy ="exam")
  private List<Exam> exams = new LinkedList<>();
  
    public Student(String firstname, String lastname, Classname classname) {
        this.firstname = firstname;
        this.lastname = lastname;
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



    public Classname getClassname() {
        return classname;
    }

    public void setClassname(Classname classname) {
        this.classname = classname;
    }
  
}
