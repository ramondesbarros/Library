package br.com.library.validation;

import org.springframework.stereotype.Component;

import br.com.library.domain.Book;

@Component
public class BookValidation {

    public boolean dataValidation(Book book) {

        if (book.getTitleBook() == null || book.getTitleBook().isEmpty()) {
            return false;
        }
        if (book.getAuthorBook() == null || book.getAuthorBook().isEmpty()) {
            return false;
        }
        if (book.getPublisherBook() == null || book.getPublisherBook().isEmpty()) {
            return false;
        }
        if (book.getEditionBook() == null || book.getEditionBook().isEmpty()) {
            return false;
        }
        return true;
    }
}
