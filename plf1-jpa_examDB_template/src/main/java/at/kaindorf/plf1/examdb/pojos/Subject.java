/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas Fellner
 */
@Entity
public class Subject {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
  private Long subjectId;
  @Column(length = 100)
  private String longname;
  @Column(length = 10)
  private String shortname;
  private boolean written;


  @OneToMany(cascade = CascadeType.ALL)
  private List<Exam> exams = new LinkedList<>();
  
  
    public Subject(String longname, String shortname) {
        this.longname = longname;
        this.shortname = shortname;
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



}
