/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Andreas Fellner
 */
@Entity
public class Exam {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
  private Long examId;
  private LocalDate dateofexam;
  private Integer duration;
  private Subject subject;

  @ManyToOne
  @JoinColumn(name="student")
  private Student student;
  

    public Exam(LocalDate dateofexam, Integer duration, Student student, Subject subject) {
        this.dateofexam = dateofexam;
        this.duration = duration;
        this.student = student;
        this.subject = subject;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public LocalDate getDateofexam() {
        return dateofexam;
    }

    public void setDateofexam(LocalDate dateofexam) {
        this.dateofexam = dateofexam;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
  
}
