/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.pojos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Sebastian Feibel
 */
@Entity
public class Bookauthor implements Serializable {

    public Bookauthor(BookauthorPK bookauthorpk, Short rank) {
        this.bookauthorpk = bookauthorpk;
        this.rank = rank;
    }

    public Bookauthor() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.bookauthorpk);
        hash = 19 * hash + Objects.hashCode(this.rank);
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
        final Bookauthor other = (Bookauthor) obj;
        if (!Objects.equals(this.bookauthorpk, other.bookauthorpk)) {
            return false;
        }
        if (!Objects.equals(this.rank, other.rank)) {
            return false;
        }
        return true;
    }

    public BookauthorPK getBookauthorpk() {
        return bookauthorpk;
    }

    public void setBookauthorpk(BookauthorPK bookauthorpk) {
        this.bookauthorpk = bookauthorpk;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }
    @EmbeddedId
    private BookauthorPK bookauthorpk;
//    private Author authorId;
//    private Book bookId;
    private Short rank;

   
}
