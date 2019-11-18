/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author spamac15
 */

@Entity
public class Subject implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
  private Long subjectId;
    @Column(length = 100)
  private String longname;
    @Column(length = 10)
  private String shortname;
    @Column(nullable = false)
  private boolean written;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.PERSIST)
  private Collection<Exam> exams;

    public void addExam(Exam exam)
  {
      if (exams == null)
      {
          exams = new ArrayList<>();
      }
      exams.add(exam);
  } 
    
    public Subject() {
    }

    public Subject(String longname, String shortname, boolean written, Collection<Exam> exams) {
        this.longname = longname;
        this.shortname = shortname;
        this.written = written;
        this.exams = exams;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public boolean isWritten() {
        return written;
    }

    public void setWritten(boolean written) {
        this.written = written;
    }

    public Collection<Exam> getExams() {
        return exams;
    }

    public void setExams(Collection<Exam> exams) {
        this.exams = exams;
    }
  
  
  
}
