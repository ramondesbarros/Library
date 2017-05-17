package br.com.library.integration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
