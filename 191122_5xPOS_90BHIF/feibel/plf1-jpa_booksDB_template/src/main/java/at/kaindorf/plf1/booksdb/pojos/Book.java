/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Sebastian Feibel
 */
@Entity
// Publisher.getAnzPublishers macht hier keinen Sinn vor allem dann nicht wenn es zweimal implementiert werden soll
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(length = 255)
    private String title;
    @Column(length = 30)
    private BigDecimal price;
    @Column(length = 255)
    private String isbn;

    @ManyToOne
    private Publisher publisherId;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.bookId);
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.price);
        hash = 53 * hash + Objects.hashCode(this.isbn);
        hash = 53 * hash + Objects.hashCode(this.publisherId);
        hash = 53 * hash + Objects.hashCode(this.bookAuthors);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.bookId, other.bookId)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.publisherId, other.publisherId)) {
            return false;
        }
        if (!Objects.equals(this.bookAuthors, other.bookAuthors)) {
            return false;
        }
        return true;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Bookauthor> bookAuthors;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public List<Bookauthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<Bookauthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public Book(Integer bookId, String title, BigDecimal price, String isbn, Publisher publisherId, List<Bookauthor> bookAuthors) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
        this.publisherId = publisherId;
        this.bookAuthors = bookAuthors;
    }

    public Book() {
    }

}
