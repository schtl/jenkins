/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sebastian Feibel
 */
@Embeddable
public class BookauthorPK implements Serializable {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.authorId;
        hash = 17 * hash + this.bookId;
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
        final BookauthorPK other = (BookauthorPK) obj;
        if (this.authorId != other.authorId) {
            return false;
        }
        if (this.bookId != other.bookId) {
            return false;
        }
        return true;
    }

    public BookauthorPK(int authorId, int bookId) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public BookauthorPK() {
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    @Column(name = "author_id")
    private int authorId;
    @Column(name = "book_id")
    private int bookId;

}
