package at.kaindorf.plf1.examdb.pojos;

import at.kaindorf.plf1.examdb.pojos.Exam;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-14T09:26:36")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile SingularAttribute<Subject, String> longname;
    public static volatile CollectionAttribute<Subject, Exam> exams;
    public static volatile SingularAttribute<Subject, Boolean> written;
    public static volatile SingularAttribute<Subject, String> shortname;
    public static volatile SingularAttribute<Subject, Long> subjectId;

}