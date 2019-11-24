package at.kaindorf.plf1.booksdb.pojos;

import at.kaindorf.plf1.booksdb.pojos.Bookauthor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T12:25:17")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile ListAttribute<Author, Bookauthor> bookAuthors;
    public static volatile SingularAttribute<Author, String> firstname;
    public static volatile SingularAttribute<Author, Integer> authorId;
    public static volatile SingularAttribute<Author, String> lastname;

}