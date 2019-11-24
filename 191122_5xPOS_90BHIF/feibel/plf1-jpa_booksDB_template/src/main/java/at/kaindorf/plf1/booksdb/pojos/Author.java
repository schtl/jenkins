/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

//import com.sun.istack.internal.Nullable;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Sebastian Feibel
 */
@Entity
@NamedQueries
({
    @NamedQuery(name = "Author.getAllAuthorsOfPublisher", query = "SELECT a.authorId, a.firstname, a.lastname FROM Author a"),
    @NamedQuery(name = "Author.countBooksOfAuthor", query = "SELECT COUNT(*) FROM Bookauthor WHERE author_id = :authorid AND rank = :rank")
})
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(length = 100)
    private String firstname;
    @Column(length = 255)
    private String lastname;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "bookauthor.author_id")
    private List<Bookauthor> bookAuthors;

    public Author() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.authorId);
        hash = 61 * hash + Objects.hashCode(this.firstname);
        hash = 61 * hash + Objects.hashCode(this.lastname);
        hash = 61 * hash + Objects.hashCode(this.bookAuthors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.authorId, other.authorId)) {
            return false;
        }
        if (!Objects.equals(this.bookAuthors, other.bookAuthors)) {
            return false;
        }
        return true;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Bookauthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<Bookauthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public Author(Integer authorId, String firstname, String lastname, List<Bookauthor> bookAuthors) {
        this.authorId = authorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bookAuthors = bookAuthors;
    }

    @Override
    public String toString() {
        return String.format("%s %s", lastname, firstname);
    }

}
