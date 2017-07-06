package br.com.library.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "magazine")
public class Magazine implements Serializable {

    private static final long serialVersionUID = -06072017001L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "magazine_id")
    private Long idMagazine;

    private String titleMagazine;
    private String numberMagazine;
    private String publicationMagazineDate;
    private String publisherMagazine;

    @OneToOne(mappedBy = "magazine", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Loan loan;

    public Long getIdMagazine() {
        return idMagazine;
    }

    public void setIdMagazine(Long idMagazine) {
        this.idMagazine = idMagazine;
    }

    public String getTitleMagazine() {
        return titleMagazine;
    }

    public void setTitleMagazine(String titleMagazine) {
        this.titleMagazine = titleMagazine;
    }

    public String getNumberMagazine() {
        return numberMagazine;
    }

    public void setNumberMagazine(String numberMagazine) {
        this.numberMagazine = numberMagazine;
    }

    public String getPublicationMagazineDate() {
        return publicationMagazineDate;
    }

    public void setPublicationMagazineDate(String publicationMagazineDate) {
        this.publicationMagazineDate = publicationMagazineDate;
    }

    public String getPublisherMagazine() {
        return publisherMagazine;
    }

    public void setPublisherMagazine(String publisherMagazine) {
        this.publisherMagazine = publisherMagazine;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Magazine [idMagazine=" + idMagazine + ", titleMagazine=" + titleMagazine + ", numberMagazine="
                + numberMagazine + ", publicationMagazineDate=" + publicationMagazineDate + ", publisherMagazine="
                + publisherMagazine + ", loan=" + loan + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMagazine == null) ? 0 : idMagazine.hashCode());
        result = prime * result + ((loan == null) ? 0 : loan.hashCode());
        result = prime * result + ((numberMagazine == null) ? 0 : numberMagazine.hashCode());
        result = prime * result + ((publicationMagazineDate == null) ? 0 : publicationMagazineDate.hashCode());
        result = prime * result + ((publisherMagazine == null) ? 0 : publisherMagazine.hashCode());
        result = prime * result + ((titleMagazine == null) ? 0 : titleMagazine.hashCode());
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
        Magazine other = (Magazine) obj;
        if (idMagazine == null) {
            if (other.idMagazine != null)
                return false;
        } else if (!idMagazine.equals(other.idMagazine))
            return false;
        if (loan == null) {
            if (other.loan != null)
                return false;
        } else if (!loan.equals(other.loan))
            return false;
        if (numberMagazine == null) {
            if (other.numberMagazine != null)
                return false;
        } else if (!numberMagazine.equals(other.numberMagazine))
            return false;
        if (publicationMagazineDate == null) {
            if (other.publicationMagazineDate != null)
                return false;
        } else if (!publicationMagazineDate.equals(other.publicationMagazineDate))
            return false;
        if (publisherMagazine == null) {
            if (other.publisherMagazine != null)
                return false;
        } else if (!publisherMagazine.equals(other.publisherMagazine))
            return false;
        if (titleMagazine == null) {
            if (other.titleMagazine != null)
                return false;
        } else if (!titleMagazine.equals(other.titleMagazine))
            return false;
        return true;
    }
}
