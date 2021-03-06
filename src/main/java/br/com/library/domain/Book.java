package br.com.library.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = -06072017001L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long idBook;

    private String titleBook;
    private String authorBook;
    private String publisherBook;
    private String editionBook;

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public String getPublisherBook() {
        return publisherBook;
    }

    public void setPublisherBook(String publisherBook) {
        this.publisherBook = publisherBook;
    }

    public String getEditionBook() {
        return editionBook;
    }

    public void setEditionBook(String editionBook) {
        this.editionBook = editionBook;
    }

    @Override
    public String toString() {
        return "Book [idBook=" + idBook + ", titleBook=" + titleBook + ", authorBook=" + authorBook + ", publisherBook="
                + publisherBook + ", editionBook=" + editionBook + ", loan=" + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authorBook == null) ? 0 : authorBook.hashCode());
        result = prime * result + ((editionBook == null) ? 0 : editionBook.hashCode());
        result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
        result = prime * result + ((publisherBook == null) ? 0 : publisherBook.hashCode());
        result = prime * result + ((titleBook == null) ? 0 : titleBook.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (authorBook == null) {
            if (other.authorBook != null)
                return false;
        } else if (!authorBook.equals(other.authorBook))
            return false;
        if (editionBook == null) {
            if (other.editionBook != null)
                return false;
        } else if (!editionBook.equals(other.editionBook))
            return false;
        if (idBook == null) {
            if (other.idBook != null)
                return false;
        } else if (!idBook.equals(other.idBook))
            return false;
        if (publisherBook == null) {
            if (other.publisherBook != null)
                return false;
        } else if (!publisherBook.equals(other.publisherBook))
            return false;
        if (titleBook == null) {
            if (other.titleBook != null)
                return false;
        } else if (!titleBook.equals(other.titleBook))
            return false;
        return true;
    }
}
