package at.kaindorf.plf1.booksdb.pojos;

import at.kaindorf.plf1.booksdb.pojos.Bookauthor;
import at.kaindorf.plf1.booksdb.pojos.Publisher;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-24T12:25:17")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile ListAttribute<Book, Bookauthor> bookAuthors;
    public static volatile SingularAttribute<Book, Publisher> publisherId;
    public static volatile SingularAttribute<Book, BigDecimal> price;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Integer> bookId;

}