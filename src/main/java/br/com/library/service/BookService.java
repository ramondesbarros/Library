package br.com.library.service;

import br.com.library.domain.Book;

public interface BookService {
	
    Iterable <Book> listAllBook();
    
    Book getBookById(Long id);
    
    Book saveBook(Book book);
    
    void deleteBook(Long id);
}
