package br.com.library.integration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    Long countByUserIdUser(Long id);
}
