package br.com.library.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.domain.Book;
import br.com.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Book>> list() {

        return new ResponseEntity<List<Book>>((List<Book>) bookService.listAllBook(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Book> showBook(@PathVariable Long id) {

        return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public String saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
