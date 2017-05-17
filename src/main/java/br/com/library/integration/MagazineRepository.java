package br.com.library.integration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Magazine;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long>{

}
