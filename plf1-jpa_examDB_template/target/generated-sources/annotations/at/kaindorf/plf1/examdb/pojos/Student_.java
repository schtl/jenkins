package at.kaindorf.plf1.examdb.pojos;

import at.kaindorf.plf1.examdb.pojos.Classname;
import at.kaindorf.plf1.examdb.pojos.Exam;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-18T10:31:27")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Long> studentId;
    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile ListAttribute<Student, Exam> exams;
    public static volatile SingularAttribute<Student, Classname> classname;
    public static volatile SingularAttribute<Student, String> lastname;

}