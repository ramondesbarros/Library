package br.com.library.integration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
}
