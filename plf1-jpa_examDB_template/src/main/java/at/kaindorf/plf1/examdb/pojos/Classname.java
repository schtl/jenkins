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
public class Classname {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long classId;
  @Column(length = 10)
  private String classname;
  private Collection<Student> students;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Student> studentsList = new LinkedList<>();
  
    public Classname(String classname) {
        this.classname = classname;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
  
}
