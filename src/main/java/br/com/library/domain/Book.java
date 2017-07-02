package br.com.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private Long idBook;
	
	private String titleBook;
	private String authorBook;
	private String publisherBook;
	private String editionBook;
	private Boolean statusBook = false;

    @OneToOne
    private Loan loan;

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

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Boolean getStatusBook() {
		return statusBook;
	}

	public void setStatusBook(Boolean statusBook) {
		this.statusBook = statusBook;
	}

	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", titleBook=" + titleBook + ", authorBook=" + authorBook + ", publisherBook="
				+ publisherBook + ", editionBook=" + editionBook + ", statusBook=" + statusBook + ", loan=" + loan
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorBook == null) ? 0 : authorBook.hashCode());
		result = prime * result + ((editionBook == null) ? 0 : editionBook.hashCode());
		result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
		result = prime * result + ((loan == null) ? 0 : loan.hashCode());
		result = prime * result + ((publisherBook == null) ? 0 : publisherBook.hashCode());
		result = prime * result + ((statusBook == null) ? 0 : statusBook.hashCode());
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
		if (loan == null) {
			if (other.loan != null)
				return false;
		} else if (!loan.equals(other.loan))
			return false;
		if (publisherBook == null) {
			if (other.publisherBook != null)
				return false;
		} else if (!publisherBook.equals(other.publisherBook))
			return false;
		if (statusBook == null) {
			if (other.statusBook != null)
				return false;
		} else if (!statusBook.equals(other.statusBook))
			return false;
		if (titleBook == null) {
			if (other.titleBook != null)
				return false;
		} else if (!titleBook.equals(other.titleBook))
			return false;
		return true;
	}
}
