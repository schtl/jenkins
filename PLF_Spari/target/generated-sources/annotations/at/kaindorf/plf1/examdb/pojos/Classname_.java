package at.kaindorf.plf1.examdb.pojos;

import at.kaindorf.plf1.examdb.pojos.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-14T09:26:36")
@StaticMetamodel(Classname.class)
public class Classname_ { 

    public static volatile SingularAttribute<Classname, Long> classId;
    public static volatile SingularAttribute<Classname, String> classname;
    public static volatile CollectionAttribute<Classname, Student> students;

}