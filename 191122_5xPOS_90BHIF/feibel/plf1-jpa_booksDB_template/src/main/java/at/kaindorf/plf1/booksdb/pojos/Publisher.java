/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Publisher.getAnzPublishers", query = "SELECT COUNT(*) FROM Publisher")
})
public class Publisher implements Serializable {
    @Id
    @Column(name = "publisher_id")
    private Integer publisherId;
    @Column(length = 255)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book.publisherId")
    private List<Book> books;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Publisher() {
    }

    public Publisher(Integer publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Publisher(Integer publisherId, String name, List<Book> books) {
        this.publisherId = publisherId;
        this.name = name;
        this.books = books;
    }

}
