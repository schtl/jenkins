/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.examdb.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
public class Classname implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_id", nullable = false)
  private Long classId;
    @Column(length = 10)
  private String classname;
    @OneToMany(mappedBy = "classname", cascade = CascadeType.PERSIST)
  private Collection<Student> students;

    public void addStudent(Student student)
    {
        if (students != null)
        {
            students = new ArrayList<>();
        }
        students.add(student);
    }
    
    public Classname() {
    }

    public Classname(String classname) {
        this.classname = classname;
    }

    
  
    public Classname(String classname, Collection<Student> students) {
        this.classname = classname;
        this.students = students;
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
