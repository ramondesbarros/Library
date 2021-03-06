package br.com.library.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {

    private static final long serialVersionUID = -06072017001L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private Long idLoan;

    private Calendar loanDate;
    private Calendar returnDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "magazine_id")
    private Magazine magazine;

    public Long getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Long idLoan) {
        this.idLoan = idLoan;
    }

    public Calendar getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Calendar loanDate) {
        this.loanDate = loanDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDay) {
        this.returnDate = returnDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    @Override
    public String toString() {
        return "Loan [idLoan=" + idLoan + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", user=" + user
                + ", book=" + book + ", magazine=" + magazine + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        result = prime * result + ((idLoan == null) ? 0 : idLoan.hashCode());
        result = prime * result + ((loanDate == null) ? 0 : loanDate.hashCode());
        result = prime * result + ((magazine == null) ? 0 : magazine.hashCode());
        result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        Loan other = (Loan) obj;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        if (idLoan == null) {
            if (other.idLoan != null)
                return false;
        } else if (!idLoan.equals(other.idLoan))
            return false;
        if (loanDate == null) {
            if (other.loanDate != null)
                return false;
        } else if (!loanDate.equals(other.loanDate))
            return false;
        if (magazine == null) {
            if (other.magazine != null)
                return false;
        } else if (!magazine.equals(other.magazine))
            return false;
        if (returnDate == null) {
            if (other.returnDate != null)
                return false;
        } else if (!returnDate.equals(other.returnDate))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}
