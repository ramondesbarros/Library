package br.com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Book;
import br.com.library.integration.BookRepository;
import br.com.library.service.BookService;
import br.com.library.validation.BookValidation;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookValidation bookValidation;

    @Override
    public Iterable<Book> listAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public String saveBook(Book book) {
        boolean result = bookValidation.dataValidation(book);
        if (result == false) {
            return "Error! Todos os dados devem estar preenchidos";
        }

        bookRepository.save(book);

        return "redirect:/book/" + book.getIdBook();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }

}
