package at.kaindorf.plf1.booksdb.pojos;

import at.kaindorf.plf1.booksdb.pojos.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T12:25:17")
@StaticMetamodel(Publisher.class)
public class Publisher_ { 

    public static volatile SingularAttribute<Publisher, Integer> publisherId;
    public static volatile ListAttribute<Publisher, Book> books;
    public static volatile SingularAttribute<Publisher, String> name;

}