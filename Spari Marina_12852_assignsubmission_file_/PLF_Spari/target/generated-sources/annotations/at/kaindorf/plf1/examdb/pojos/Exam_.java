package at.kaindorf.plf1.examdb.pojos;

import at.kaindorf.plf1.examdb.pojos.Student;
import at.kaindorf.plf1.examdb.pojos.Subject;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-14T09:26:36")
@StaticMetamodel(Exam.class)
public class Exam_ { 

    public static volatile SingularAttribute<Exam, Integer> duration;
    public static volatile SingularAttribute<Exam, Student> student;
    public static volatile SingularAttribute<Exam, LocalDate> dateofexam;
    public static volatile SingularAttribute<Exam, Subject> subject;
    public static volatile SingularAttribute<Exam, Long> examId;

}